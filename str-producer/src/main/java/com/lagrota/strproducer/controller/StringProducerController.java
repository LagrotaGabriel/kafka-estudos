package com.lagrota.strproducer.controller;

import com.lagrota.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/producer")
public class StringProducerController {

    private final StringProducerService stringProducerService;

    @PostMapping
    public ResponseEntity<HttpStatus> sendMessage(@RequestBody String message) {

        stringProducerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
