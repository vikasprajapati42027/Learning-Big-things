package com.example.storage.service;

import com.example.storage.dto.UploadResponse;
import com.example.storage.model.FileInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.OffsetDateTime;
import java.util.*;

@Service
public class StorageService {

    @Value("${storage.primary:storage/primary}")
    private String primaryDir;

    @Value("${storage.replicas:storage/replica1,storage/replica2}")
    private String replicasCsv;

    private static final int CHUNK_SIZE = 1024 * 256; // 256 KB for demo

    public UploadResponse upload(MultipartFile file) throws IOException {
        String fileId = UUID.randomUUID().toString();
        Path primary = Path.of(primaryDir, fileId);
        Files.createDirectories(primary);
        List<String> replicaDirs = parseReplicaDirs();
        for (String r : replicaDirs) {
            Files.createDirectories(Path.of(r, fileId));
        }

        int chunkIndex = 0;
        List<String> chunkPaths = new ArrayList<>();
        try (InputStream in = file.getInputStream()) {
            byte[] buffer = new byte[CHUNK_SIZE];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                String chunkName = "chunk-" + chunkIndex;
                Path primaryChunk = primary.resolve(chunkName);
                Files.write(primaryChunk, Arrays.copyOf(buffer, bytesRead));
                chunkPaths.add(primaryChunk.toString());
                // replicate
                for (String r : replicaDirs) {
                    Path replicaChunk = Path.of(r, fileId, chunkName);
                    Files.write(replicaChunk, Arrays.copyOf(buffer, bytesRead));
                }
                chunkIndex++;
            }
        }

        FileInfo info = new FileInfo();
        info.setFileId(fileId);
        info.setFilename(file.getOriginalFilename());
        info.setSize(file.getSize());
        info.setChunks(chunkIndex);
        info.setReplicationFactor(replicaDirs.size() + 1);
        info.setCreatedAt(OffsetDateTime.now());
        info.setChunkPaths(chunkPaths);
        // In a real system persist metadata to DB; here we keep it transient.

        return new UploadResponse(fileId, info.getFilename(), info.getSize(), info.getChunks(), info.getReplicationFactor());
    }

    public byte[] download(String fileId) throws IOException {
        Path primary = Path.of(primaryDir, fileId);
        if (!Files.exists(primary)) {
            throw new IOException("File not found");
        }
        List<Path> chunks = Files.list(primary)
                .sorted()
                .toList();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (Path c : chunks) {
            baos.write(Files.readAllBytes(c));
        }
        return baos.toByteArray();
    }

    private List<String> parseReplicaDirs() {
        if (replicasCsv == null || replicasCsv.isBlank()) return List.of();
        String[] arr = replicasCsv.split(",");
        List<String> dirs = new ArrayList<>();
        for (String a : arr) {
            dirs.add(a.trim());
        }
        return dirs;
    }
}
