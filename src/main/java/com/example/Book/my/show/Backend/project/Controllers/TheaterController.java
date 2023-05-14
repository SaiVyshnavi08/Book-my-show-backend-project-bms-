package com.example.Book.my.show.Backend.project.Controllers;

import com.example.Book.my.show.Backend.project.Dtos.TheaterDTO;
import com.example.Book.my.show.Backend.project.Repository.TheaterRepository;
import com.example.Book.my.show.Backend.project.Repository.TheaterSeatsRepository;
import com.example.Book.my.show.Backend.project.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {
    @Autowired
    TheaterService theaterService;
    @Autowired
    private TheaterRepository theaterRepo;
    @Autowired
    private TheaterSeatsRepository theaterSeatsRepo;

    @PostMapping("/add")
    public ResponseEntity<String> addTheater(@RequestBody() TheaterDTO theaterDTO){
        String statement=theaterService.AddTheater(theaterDTO);
        return new ResponseEntity<>(statement, HttpStatus.CREATED);
    }

    //    get theaters by theaterId
    @GetMapping("/get_Theater_by-Id")
    public ResponseEntity<TheaterDTO> getTheaterById(@RequestParam("Id") int id){
        TheaterDTO theater= theaterService.getTheater(id);
        return new ResponseEntity<>(theater,HttpStatus.OK);
    }

    //    get all theaters
    @GetMapping("Get_All_Theaters")
    public ResponseEntity<List<TheaterDTO>> getAllTheaters(){
        List<TheaterDTO> theaters=theaterService.getAllTheares();
        return new ResponseEntity<>(theaters,HttpStatus.OK);
    }

    //    get theater by name
    @GetMapping("/get_theater_by_name")
    public ResponseEntity<TheaterDTO> getTheaterByName(@RequestParam("name") String name){
        TheaterDTO theaterDTO=theaterService.getTheaterByName(name);
        return new ResponseEntity<>(theaterDTO,HttpStatus.OK);
    }

    //    get theater by movieName
    @GetMapping("/get_TheatersByMovie")
    public ResponseEntity<List<TheaterDTO>> getTheaterByMovieName(@RequestParam("name") String name){
        List<TheaterDTO> theaterDTOS=theaterService.getTheatersByMovie(name);
        return new ResponseEntity<>(theaterDTOS,HttpStatus.OK);
    }

}