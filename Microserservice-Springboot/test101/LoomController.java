package com.example.loom;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoomController {

    @GetMapping("/heavy-task")
    public String heavyTask() throws InterruptedException {
        // This would block a platform thread, but Virtual Threads 
        // will just unmount and let others run!
        Thread.sleep(1000); 
        return "Processed by Virtual Thread: " + Thread.currentThread();
    }
}
