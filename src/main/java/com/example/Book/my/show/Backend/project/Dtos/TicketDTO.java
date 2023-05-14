package com.example.Book.my.show.Backend.project.Dtos;

import lombok.Data;

import java.util.List;
@Data

public class TicketDTO {
    private List<String> requestedSeats;
    private int userId;
    private int showId;
}
