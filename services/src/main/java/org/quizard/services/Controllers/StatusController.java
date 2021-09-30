package org.quizard.services.Controllers;

import org.quizard.services.Models.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/")
    public Status status() {
        return new Status();
    }
}
