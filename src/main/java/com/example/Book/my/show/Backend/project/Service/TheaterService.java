package com.example.Book.my.show.Backend.project.Service;

import com.example.Book.my.show.Backend.project.Dtos.TheaterDTO;
import com.example.Book.my.show.Backend.project.Models.MovieEntity;
import com.example.Book.my.show.Backend.project.Models.ShowEntity;
import com.example.Book.my.show.Backend.project.Models.TheaterEntity;
import com.example.Book.my.show.Backend.project.Models.TheaterSeatsEntity;
import com.example.Book.my.show.Backend.project.Repository.MovieRepository;
import com.example.Book.my.show.Backend.project.Repository.ShowRepository;
import com.example.Book.my.show.Backend.project.Repository.TheaterRepository;
import com.example.Book.my.show.Backend.project.Repository.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {


    @Autowired
    TheaterRepository theaterRepo;
    @Autowired
    TheaterSeatsRepository theaterSeatsRepo;
    @Autowired
    TheaterSeatsService theaterSeatsService;
    @Autowired
    private MovieRepository movieRepo;
    @Autowired
    private ShowRepository showRepo;


    public String AddTheater(TheaterDTO theaterDTO) {
        TheaterEntity theater = TheaterEntity.builder().name(theaterDTO.getName()).city(theaterDTO.getCity()).address(theaterDTO.getAddress()).build();
        List<TheaterSeatsEntity> list = theaterSeatsService.setTheaterSeats();
        theater.setTheaterSeatsEntity(list);//Bidirectional mapping
//        for each theater seat we need to set the theaterEntity
//        like foreign key
        for (TheaterSeatsEntity st : list) {
            st.setTheaterEntity(theater);
        }
        theaterRepo.save(theater);
        return "Theater has been added Successfully";
    }

    public TheaterDTO getTheater(int id) {
        TheaterEntity theater = theaterRepo.findById(id).get();
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setName(theater.getName());
        theaterDTO.setCity(theater.getCity());
        theaterDTO.setAddress(theater.getAddress());
        return theaterDTO;
    }

    public List<TheaterDTO> getAllTheares() {
        List<TheaterDTO> theaters = new ArrayList<>();
        List<TheaterEntity> theaterEntities = theaterRepo.findAll();
        for (TheaterEntity th : theaterEntities) {
            TheaterDTO theaterDTO = new TheaterDTO();
            theaterDTO.setAddress(th.getAddress());
            theaterDTO.setName(th.getName());
            theaterDTO.setCity((th.getCity()));

            theaters.add(theaterDTO);
        }
        return theaters;
    }

    public TheaterDTO getTheaterByName(String name) {
        TheaterEntity theater = theaterRepo.findByName(name);
        TheaterDTO theaterDTO = new TheaterDTO();
        theaterDTO.setName(theater.getName());
        theaterDTO.setCity(theater.getCity());
        theaterDTO.setAddress(theater.getAddress());
        return theaterDTO;
    }

    public List<TheaterDTO> getTheatersByMovie(String name) {
        List<TheaterDTO> theaterDTOList = new ArrayList<>();

        List<ShowEntity> showEntities = showRepo.findAll();

        for (ShowEntity show : showEntities) {
            MovieEntity movie = show.getMovie();
            if (movie.getName().equals(name)) {
                TheaterEntity theater = show.getTheater();
                TheaterDTO theaterDTO = new TheaterDTO();
                theaterDTO.setName(theater.getName());
                theaterDTO.setCity(theater.getCity());
                theaterDTO.setAddress(theater.getAddress());
                if (!theaterDTOList.contains(theaterDTO)) {
                    theaterDTOList.add(theaterDTO);

                }
            }
        }
        return theaterDTOList;
    }
}