package com.example.Book.my.show.Backend.project.Dtos;

import lombok.Data;

import java.util.Date;


@Data
public class MovieDTO {
    private String name;
    private Date releasedate;
    private double duration;
}
