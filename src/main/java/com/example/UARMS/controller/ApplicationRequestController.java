package com.example.UARMS.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UARMS.model.ApplicationRequest;
import com.example.UARMS.service.ApplicationRequestService;

import java.util.Map;

@RestController
@RequestMapping("/api/public/requests")
public class ApplicationRequestController {

    @Autowired
    private ApplicationRequestService requestService;

    @PostMapping
    public ResponseEntity<?> submitRequest(@Valid @RequestBody ApplicationRequest request) {
        requestService.processRequest(request);
        return ResponseEntity.ok(Map.of("message", "Ваша заявка успешно отправлена!"));
    }
}
