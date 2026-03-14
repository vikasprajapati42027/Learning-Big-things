# Test 124: Batch Requests & File Uploads

Handling multiple items or large files in one request.

## Key Files:
- `BatchUploadController.java`: Handles both multi-file upload and bulk JSON list processing.
- `EXPLANATION.md`: Performance benefits of batch vs individual calls.

## Concept:
Uploading 100 images one by one = 100 HTTP round trips (slow). Uploading all 100 at once with multipart = 1 HTTP round trip (fast). Batching reduces network overhead dramatically for high-volume operations.
