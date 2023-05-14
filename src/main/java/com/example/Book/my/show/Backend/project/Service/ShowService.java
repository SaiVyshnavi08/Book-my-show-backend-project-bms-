package com.example.Book.my.show.Backend.project.Service;

import com.example.Book.my.show.Backend.project.Dtos.ShowDTO;
import com.example.Book.my.show.Backend.project.Models.*;
import com.example.Book.my.show.Backend.project.Repository.MovieRepository;
import com.example.Book.my.show.Backend.project.Repository.ShowRepository;
import com.example.Book.my.show.Backend.project.Repository.ShowSeatsRepository;
import com.example.Book.my.show.Backend.project.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepo;
    @Autowired
    TheaterRepository theaterRepo;
    @Autowired
    ShowRepository showRepo;

    @Autowired
    ShowSeatsRepository showSeatsRepo;


    public String addShow(ShowDTO showDTO){

//        convert  show dto to entity
        ShowEntity showEntity=ShowEntity.builder().showDate(showDTO.getShowDate()).showTime(showDTO.getShowTime()).multiplier(showDTO.getMultiplier()).build();
//        find the movie name in MovieRepo

        String name=showDTO.getMovieName();
        MovieEntity movie=movieRepo.findByName(name);
//
//        With the show id we have find by id in theater Repo
        TheaterEntity theater=theaterRepo.findById(showDTO.getTheaterId()).get();

        showEntity.setMovie(movie);
        showEntity.setTheater(theater);

        movie.getListOfShows().add(showEntity);
        theater.getListOfSeats().add(showEntity);
        List<ShowSeatEntity> seatEntityList=createShowSeats(theater.getTheaterSeatsEntity());
        showEntity.setListOfSeats(seatEntityList);
//        for each show seat : Need to mark to which show it belongs to
        for(ShowSeatEntity showSeat:seatEntityList){
            showSeat.setShow(showEntity);
        }
//        showRepo.save(showEntity);
        movieRepo.save(movie);
        theaterRepo.save(theater);
        return "Show Successfully added";
    }



    //show seats are a reflection/copy of the physical seats(TheaterSeats) The seat no should be fetched from theater Seats entity
    private List<ShowSeatEntity> createShowSeats(List<TheaterSeatsEntity> theaterSeatsEntity) {

        List<ShowSeatEntity> seats=new ArrayList<>();
        for(TheaterSeatsEntity theaterSeats:theaterSeatsEntity){
            ShowSeatEntity showSeatEntity=ShowSeatEntity.builder().seatNo(theaterSeats.getSeatNo()).seatType(theaterSeats.getSeatType()).build();
            seats.add(showSeatEntity);
        }
        showSeatsRepo.saveAll(seats);
        return seats;
    }




}

