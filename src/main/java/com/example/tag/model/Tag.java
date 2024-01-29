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
@Table(name = "t_tag", schema = "public", catalog = "postgres")
public class Tag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tag")
    private String tag;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "creation_date", insertable = false, updatable = false)
    private LocalDateTime creationDate;
    @Basic
    @Column(name = "update_date", insertable = false, updatable = false)
    private LocalDateTime updateDate;
}
