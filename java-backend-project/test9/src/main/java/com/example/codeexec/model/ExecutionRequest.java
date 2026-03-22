package com.example.codeexec.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExecutionRequest {
    @NotBlank
    private String language; // java, python
    @NotBlank
    private String source;
    private String stdin = "";
    @NotNull
    private Integer timeLimitSeconds = 5;

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }
    public String getStdin() { return stdin; }
    public void setStdin(String stdin) { this.stdin = stdin; }
    public Integer getTimeLimitSeconds() { return timeLimitSeconds; }
    public void setTimeLimitSeconds(Integer timeLimitSeconds) { this.timeLimitSeconds = timeLimitSeconds; }
}
