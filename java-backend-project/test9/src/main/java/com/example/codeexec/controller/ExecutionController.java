package com.example.codeexec.controller;

import com.example.codeexec.model.ExecutionRequest;
import com.example.codeexec.model.ExecutionResponse;
import com.example.codeexec.service.CodeRunner;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/execute")
public class ExecutionController {
    private final CodeRunner codeRunner;

    public ExecutionController(CodeRunner codeRunner) {
        this.codeRunner = codeRunner;
    }

    @PostMapping
    public ResponseEntity<ExecutionResponse> execute(@RequestBody @Valid ExecutionRequest request) {
        ExecutionResponse resp = codeRunner.run(request);
        HttpStatus status = resp.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(resp, status);
    }
}
