package com.example.Book.my.show.Backend.project.Controllers;


import com.example.Book.my.show.Backend.project.Dtos.MovieDTO;
import com.example.Book.my.show.Backend.project.Dtos.MovieResponseDto;
import com.example.Book.my.show.Backend.project.Dtos.userDTO;
import com.example.Book.my.show.Backend.project.Models.userEntity;
import com.example.Book.my.show.Backend.project.Service.MovieService;
import com.example.Book.my.show.Backend.project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<String> AddUser(@RequestBody() userDTO userDTO){
        String statement=userService.add_user(userDTO);
        return new ResponseEntity<>(statement, HttpStatus.CREATED) ;
    }
    @GetMapping("/getUser")
    public userEntity getUser(@RequestParam String name) {
        return userService.getUserByName(name);
    }
}