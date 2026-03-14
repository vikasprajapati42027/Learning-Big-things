package com.example.multipart;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/batch")
public class BatchUploadController {

    @PostMapping("/upload")
    public List<String> uploadMultiple(@RequestParam("files") List<MultipartFile> files) {
        return files.stream()
            .map(f -> "Received: " + f.getOriginalFilename() + " (" + f.getSize() + " bytes)")
            .collect(Collectors.toList());
    }

    @PostMapping("/process-list")
    public List<String> processList(@RequestBody List<String> items) {
        return items.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }
}
