package com.example.codeexec.service;

import com.example.codeexec.model.ExecutionRequest;
import com.example.codeexec.model.ExecutionResponse;

public interface CodeRunner {
    ExecutionResponse run(ExecutionRequest request);
}
