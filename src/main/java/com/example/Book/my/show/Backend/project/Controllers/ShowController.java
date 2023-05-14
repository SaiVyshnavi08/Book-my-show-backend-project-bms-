package com.example.Book.my.show.Backend.project.Controllers;

import com.example.Book.my.show.Backend.project.Dtos.ShowDTO;
import com.example.Book.my.show.Backend.project.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {
    @Autowired
    ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<String> addShow(@RequestBody() ShowDTO showDTO) {
        String req = showService.addShow(showDTO);
        return new ResponseEntity<>(req, HttpStatus.ACCEPTED);
    }
}
