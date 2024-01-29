package com.example.tag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user", schema = "public", catalog = "postgres")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "firstname")
    private String firstname;
    @Basic
    @Column(name = "lastname")
    private String lastname;
    @Basic
    @Column(name = "username", unique = true)
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone_number")
    private String phoneNumber;
    @Basic
    @Column(name = "is_male")
    private boolean isMale;
    @Basic
    @Column(name = "enroll_date", insertable = false, updatable = false)
    private LocalDateTime enrollDate;
    @Basic
    @Column(name = "is_email_verified")
    private boolean isEmailVerified;
    @Basic
    @Column(name = "is_phone_verified")
    private boolean isPhoneVerified;
    @Basic
    @Column(name = "is_active_user")
    private boolean isActiveUser;
    @Basic
    @Column(name = "is_banned")
    private boolean isBanned;
}
