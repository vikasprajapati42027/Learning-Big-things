package com.example.codeexec.service;

import com.example.codeexec.model.ExecutionRequest;
import com.example.codeexec.model.ExecutionResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DockerCodeRunner implements CodeRunner {

    @Override
    public ExecutionResponse run(ExecutionRequest request) {
        try {
            Path tempDir = Files.createTempDirectory("code-run-");
            String fileName;
            String image;
            List<String> compile = new ArrayList<>();
            List<String> exec = new ArrayList<>();

            switch (request.getLanguage().toLowerCase()) {
                case "java" -> {
                    fileName = "Main.java";
                    image = "openjdk:17-slim";
                    writeFile(tempDir, fileName, request.getSource());
                    compile = List.of("javac", fileName);
                    exec = List.of("java", "Main");
                }
                case "python" -> {
                    fileName = "main.py";
                    image = "python:3.11-slim";
                    writeFile(tempDir, fileName, request.getSource());
                    exec = List.of("python", fileName);
                }
                default -> {
                    return new ExecutionResponse(false, -1, "", "", "Unsupported language");
                }
            }

            List<String> cmd = new ArrayList<>();
            cmd.add("docker");
            cmd.add("run");
            cmd.add("--rm");
            cmd.add("-m");
            cmd.add("256m");
            cmd.add("--network=none");
            cmd.add("--cpus=1");
            cmd.add("-v");
            cmd.add(tempDir.toAbsolutePath() + ":/workspace");
            cmd.add("-w");
            cmd.add("/workspace");
            cmd.add(image);
            cmd.add("/bin/sh");
            cmd.add("-c");

            StringBuilder script = new StringBuilder();
            if (!compile.isEmpty()) {
                script.append(String.join(" ", compile)).append(" && ");
            }
            script.append(String.join(" ", exec));

            cmd.add(script.toString());

            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.redirectErrorStream(true);
            Process process = pb.start();

            boolean finished = process.waitFor(Duration.ofSeconds(request.getTimeLimitSeconds()).toMillis(), java.util.concurrent.TimeUnit.MILLISECONDS);
            if (!finished) {
                process.destroyForcibly();
                return new ExecutionResponse(false, -1, "", "Timed out", "Timed out");
            }
            int exit = process.exitValue();
            String output = new String(process.getInputStream().readAllBytes());
            return new ExecutionResponse(exit == 0, exit, output, exit == 0 ? "" : output, "done");
        } catch (IOException e) {
            return new ExecutionResponse(false, -1, "", e.getMessage(), "IO error");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new ExecutionResponse(false, -1, "", "Interrupted", "Interrupted");
        }
    }

    private void writeFile(Path dir, String fileName, String content) throws IOException {
        try (FileWriter fw = new FileWriter(new File(dir.toFile(), fileName))) {
            fw.write(content);
        }
    }
}
