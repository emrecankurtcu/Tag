package com.example.tag.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "t_user_provider", schema = "public", catalog = "postgres")
public class UserProvider {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "provider")
    private String provider;
    @Basic
    @Column(name = "google_sub_id")
    private String googleSubId;
    @Basic
    @Column(name = "creation_date", insertable = false, updatable = false)
    private LocalDateTime creationDate;
}
