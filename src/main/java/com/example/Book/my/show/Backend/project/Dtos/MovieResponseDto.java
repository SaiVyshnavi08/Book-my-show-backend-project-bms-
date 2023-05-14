package com.example.Book.my.show.Backend.project.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Builder
public class MovieResponseDto {

    private String name;
    private Date releasedate;
    private double duration;
    private List<String> theaters=new ArrayList<>();
}
