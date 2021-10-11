package org.quizard.services.controllers;

import org.quizard.services.domain.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @GetMapping("/")
    public Status status() {
        return new Status();
    }
}
