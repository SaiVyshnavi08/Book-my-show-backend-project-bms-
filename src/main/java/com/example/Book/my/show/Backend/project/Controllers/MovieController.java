package com.example.Book.my.show.Backend.project.Controllers;

import com.example.Book.my.show.Backend.project.Dtos.MovieDTO;
import com.example.Book.my.show.Backend.project.Dtos.MovieResponseDto;
import com.example.Book.my.show.Backend.project.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Movie")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody() MovieDTO movieDTO){
        String res=movieService.addMovie(movieDTO);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
    @GetMapping("/Get_movie")
    public ResponseEntity<MovieResponseDto> getMovieByName(@RequestParam("MovieName") String MvName){
        MovieResponseDto movie=movieService.getMovie(MvName);
        return new ResponseEntity<>(movie,HttpStatus.OK);
    }


    @GetMapping("Get_All_Movies")
    public ResponseEntity<List<MovieResponseDto>> getMovies(){
        List<MovieResponseDto> movies=movieService.getMovies();
        return new ResponseEntity<>(movies,HttpStatus.OK);
    }




}

