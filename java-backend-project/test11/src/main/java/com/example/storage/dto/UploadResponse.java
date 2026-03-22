package com.example.storage.dto;

public record UploadResponse(String fileId, String filename, long size, int chunks, int replicationFactor) {
}
