package com.example.Book.my.show.Backend.project.Converters;

import com.example.Book.my.show.Backend.project.Dtos.TheaterDTO;
import com.example.Book.my.show.Backend.project.Models.TheaterEntity;

public class TheaterDtoToEntity {
    public  static TheaterEntity converterDtoTOEntity(TheaterDTO theaterDTO){
        TheaterEntity theater= TheaterEntity.builder()
                .name(theaterDTO.getName())
                .address(theaterDTO.getAddress())
                .city(theaterDTO.getCity())
                .build();
        return theater;
    }
}
