package com.example.filestore;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileStorageController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        // In production: upload to AWS S3, GCS, or MinIO  
        String filename = file.getOriginalFilename();
        File dest = new File("/tmp/" + filename);
        file.transferTo(dest);
        return "File uploaded: " + filename + " (" + file.getSize() + " bytes)";
    }

    @GetMapping("/info/{name}")
    public String fileInfo(@PathVariable String name) {
        File f = new File("/tmp/" + name);
        return f.exists()
            ? "File exists: " + name + " | Size: " + f.length() + " bytes"
            : "File not found";
    }
}
