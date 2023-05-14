package com.example.Book.my.show.Backend.project.Dtos;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class userDTO {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String mobile;
}
