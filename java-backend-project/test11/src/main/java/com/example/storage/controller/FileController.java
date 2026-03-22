package com.example.storage.controller;

import com.example.storage.dto.UploadResponse;
import com.example.storage.service.StorageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {
    private final StorageService storageService;

    public FileController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public UploadResponse upload(@RequestPart("file") MultipartFile file) throws IOException {
        return storageService.upload(file);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<byte[]> download(@PathVariable String fileId) throws IOException {
        byte[] bytes = storageService.download(fileId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileId + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(bytes);
    }
}
