package com.example.Book.my.show.Backend.project.Repository;

import com.example.Book.my.show.Backend.project.Models.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatEntity,Integer> {
}
