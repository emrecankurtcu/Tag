package com.example.tag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_service_and_price", schema = "public", catalog = "postgres")
public class ServiceAndPrice {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "service")
    private String service;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "currency")
    private String currency;
    @Basic
    @Column(name = "creation_date", insertable = false, updatable = false)
    private LocalDateTime creationDate;
    @Basic
    @Column(name = "is_negotiable")
    private boolean isNegotiable;
}

