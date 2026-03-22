package com.example.codeexec.model;

public class ExecutionResponse {
    private boolean success;
    private int exitCode;
    private String stdout;
    private String stderr;
    private String message;

    public ExecutionResponse() {}

    public ExecutionResponse(boolean success, int exitCode, String stdout, String stderr, String message) {
        this.success = success;
        this.exitCode = exitCode;
        this.stdout = stdout;
        this.stderr = stderr;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public int getExitCode() { return exitCode; }
    public void setExitCode(int exitCode) { this.exitCode = exitCode; }
    public String getStdout() { return stdout; }
    public void setStdout(String stdout) { this.stdout = stdout; }
    public String getStderr() { return stderr; }
    public void setStderr(String stderr) { this.stderr = stderr; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
