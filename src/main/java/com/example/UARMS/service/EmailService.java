package com.example.UARMS.service;

import com.example.UARMS.model.ApplicationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${zavod.sales-manager.email}")
    private String managerEmail;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendNewRequestNotification(ApplicationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(managerEmail);
        message.setSubject("Новая заявка: " + request.getInterestedProduct());

        String body = "Имя: " + request.getCustomerName() +
                "\nКомпания: " + (request.getCompanyName() != null ? request.getCompanyName() : "-") +
                "\nТелефон: " + request.getPhone() +
                "\nEmail: " + request.getEmail() +
                "\nПродукт: " + request.getInterestedProduct() +
                "\nСообщение: " + request.getMessage();

        message.setText(body);
        mailSender.send(message);
    }
}

