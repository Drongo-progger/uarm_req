package com.example.UARMS.service;

import com.example.UARMS.model.ApplicationRequest;
import com.example.UARMS.repository.ApplicationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationRequestService {

    @Autowired
    private ApplicationRequestRepository requestRepository;

    @Autowired
    private EmailService emailService;

    @Transactional
    public ApplicationRequest processRequest(ApplicationRequest request) {
        ApplicationRequest saved = requestRepository.save(request);
        emailService.sendNewRequestNotification(saved);
        return saved;
    }
}