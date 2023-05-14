package com.example.Book.my.show.Backend.project.Repository;

import com.example.Book.my.show.Backend.project.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository  extends JpaRepository<TicketEntity,Integer> {
}
