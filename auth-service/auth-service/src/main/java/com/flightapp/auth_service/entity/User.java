package com.flightapp.auth_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


    @Entity
    @Table(name="USERS")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class User{
        @Id
        @GeneratedValue(strategy=GenerationType.AUTO) // 👉 Let Hibernate decide how to generate ID (uses sequence internally for Oracle)
        private Long id;
        @Column(nullable=false,unique=true)
        private String username;
        @Column(nullable=false)
        private String password;
        private String role;
        
    }
