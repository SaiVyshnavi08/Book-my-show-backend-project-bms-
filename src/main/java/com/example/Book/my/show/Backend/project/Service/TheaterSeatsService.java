package com.example.Book.my.show.Backend.project.Service;

import com.example.Book.my.show.Backend.project.Enums.SeatType;
import com.example.Book.my.show.Backend.project.Models.TheaterSeatsEntity;
import com.example.Book.my.show.Backend.project.Repository.TheaterSeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterSeatsService {

    @Autowired
    TheaterSeatsRepository theaterSeatsRepo;

    public List<TheaterSeatsEntity> setTheaterSeats(){
        List<TheaterSeatsEntity> seats=new ArrayList<>();
//        TheaterSeatsEntity theaterSeatsEntity1=new TheaterSeatsEntity("1A", SeatType.GOLD,100);
//        TheaterSeatsEntity theaterSeatsEntity2=new TheaterSeatsEntity("1B", SeatType.GOLD,100);
//        TheaterSeatsEntity theaterSeatsEntity3=new TheaterSeatsEntity("1C", SeatType.GOLD,100);
//        TheaterSeatsEntity theaterSeatsEntity4=new TheaterSeatsEntity("1D", SeatType.GOLD,100);
//        seats.add(theaterSeatsEntity1);
//        seats.add(theaterSeatsEntity2);
//        seats.add(theaterSeatsEntity3);
//        seats.add(theaterSeatsEntity4);

        for(int i=0;i<5;i++){
            String s1="1"+(char)('A'+i);
            String s2="2"+(char)('A'+i);

            TheaterSeatsEntity seats1=new TheaterSeatsEntity(s1, SeatType.CLASSIC,100);
            TheaterSeatsEntity seats2=new TheaterSeatsEntity(s2,SeatType.PLATINUM,200);

            seats.add(seats1);
            seats.add(seats2);
        }

        theaterSeatsRepo.saveAll(seats);
        return seats;

    }
}
