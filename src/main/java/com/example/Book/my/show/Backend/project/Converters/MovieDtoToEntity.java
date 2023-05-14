package com.example.Book.my.show.Backend.project.Converters;

import com.example.Book.my.show.Backend.project.Dtos.MovieDTO;
import com.example.Book.my.show.Backend.project.Models.MovieEntity;

public class MovieDtoToEntity {
    public static MovieEntity converterDTOtoEntity(MovieDTO movieDTO){
        MovieEntity movie= MovieEntity.builder()
                .name(movieDTO.getName())
                .releasedate(movieDTO.getReleasedate())
                .duration(movieDTO.getDuration())
                .build();
        return movie;
    }
}
