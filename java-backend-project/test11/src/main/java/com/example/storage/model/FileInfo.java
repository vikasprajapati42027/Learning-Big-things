package com.example.storage.model;

import java.time.OffsetDateTime;
import java.util.List;

public class FileInfo {
    private String fileId;
    private String filename;
    private long size;
    private int chunks;
    private int replicationFactor;
    private OffsetDateTime createdAt;
    private List<String> chunkPaths;

    public String getFileId() { return fileId; }
    public void setFileId(String fileId) { this.fileId = fileId; }
    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }
    public long getSize() { return size; }
    public void setSize(long size) { this.size = size; }
    public int getChunks() { return chunks; }
    public void setChunks(int chunks) { this.chunks = chunks; }
    public int getReplicationFactor() { return replicationFactor; }
    public void setReplicationFactor(int replicationFactor) { this.replicationFactor = replicationFactor; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
    public List<String> getChunkPaths() { return chunkPaths; }
    public void setChunkPaths(List<String> chunkPaths) { this.chunkPaths = chunkPaths; }
}
