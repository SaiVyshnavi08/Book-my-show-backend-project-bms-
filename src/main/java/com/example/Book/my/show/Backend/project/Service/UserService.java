package com.example.Book.my.show.Backend.project.Service;

import com.example.Book.my.show.Backend.project.Converters.UserDtoToEntity;
import com.example.Book.my.show.Backend.project.Dtos.userDTO;
import com.example.Book.my.show.Backend.project.Models.userEntity;
import com.example.Book.my.show.Backend.project.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String add_user(userDTO userDTO){

        userEntity user= UserDtoToEntity.converterUserDtoToEntity(userDTO);
        userRepository.save(user);
        return "The User has been added successfully";
    }

    public userEntity getUserByName(String name){

        return userRepository.findUserByName(name);

    }
}

