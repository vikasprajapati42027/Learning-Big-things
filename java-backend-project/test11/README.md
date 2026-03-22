# Distributed File Storage Demo (test11)

Spring Boot 3.2.x demo inspired by Dropbox fundamentals: file chunking + simple replication to multiple nodes.

## Features
- Upload file (multipart) → split into 256 KB chunks
- Store chunks in primary folder and replicate to two replica folders
- Download reconstructs file from ordered chunks
- Configurable storage paths via `application.yml`

## Prerequisites
- Java 17, Maven 3.9+

## Run
```bash
cd java-backend-project/test11
mvn spring-boot:run
```
Service on `http://localhost:8700`.

## API
- `POST /files/upload` (multipart `file`) → returns `{fileId, filename, size, chunks, replicationFactor}`
- `GET /files/{fileId}` → downloads reconstructed file

## Implementation notes
- Chunk size: 256 KB for demo; adjust `CHUNK_SIZE` in `StorageService`.
- Replication: copies chunk files to `storage/replica1` and `storage/replica2` (local dirs). Swap to remote nodes / object storage for real deployment.
- Metadata persistence omitted for brevity; add DB to track chunks, checksums, and replica health.
- No auth included; secure endpoints and storage paths for production.
