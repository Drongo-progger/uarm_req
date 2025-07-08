package com.example.UARMS.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class ApplicationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Имя клиента не может быть пустым")
    private String customerName;

    private String companyName;

    @NotBlank(message = "Телефон не может быть пустым")
    private String phone;

    @Email(message = "Некорректный формат email")
    @NotBlank(message = "Email не может быть пустым")
    private String email;


    @Column()
    @NotBlank(message = "Название продукта не должно быть пустым")
    private String interestedProduct;

    @Column(length = 2000)
    private String message;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
