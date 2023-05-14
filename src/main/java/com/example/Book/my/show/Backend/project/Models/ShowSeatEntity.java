package com.example.Book.my.show.Backend.project.Models;

import com.example.Book.my.show.Backend.project.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Show_seats")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ShowSeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private boolean booked;


    private Date bookedOn;

    @ManyToOne
    @JoinColumn
    private ShowEntity show;


    @ManyToOne
    @JoinColumn
    private TicketEntity tickets;


}
