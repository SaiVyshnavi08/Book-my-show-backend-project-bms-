package com.example.Book.my.show.Backend.project.Repository;

import com.example.Book.my.show.Backend.project.Models.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
