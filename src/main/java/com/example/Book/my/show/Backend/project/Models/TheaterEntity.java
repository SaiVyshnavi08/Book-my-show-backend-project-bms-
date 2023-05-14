package com.example.Book.my.show.Backend.project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "theater")
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor

public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true,nullable = false)
    private String name;
    private String address;
    private String city;
    //      list of Theater seats
    @OneToMany(mappedBy = "theaterEntity",cascade = CascadeType.ALL)
    private List<TheaterSeatsEntity> theaterSeatsEntity;


    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<ShowEntity> listOfSeats;
}
