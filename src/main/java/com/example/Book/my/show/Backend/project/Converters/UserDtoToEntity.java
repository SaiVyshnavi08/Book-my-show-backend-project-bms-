package com.example.Book.my.show.Backend.project.Converters;

import com.example.Book.my.show.Backend.project.Dtos.userDTO;
import com.example.Book.my.show.Backend.project.Models.userEntity;

public class UserDtoToEntity {

    public static userEntity converterUserDtoToEntity(userDTO userDTO){
        userEntity user= userEntity.builder()
                .name(userDTO.getName())
                .mobile(userDTO.getMobile())
                .build();
        return user;
    }
}
