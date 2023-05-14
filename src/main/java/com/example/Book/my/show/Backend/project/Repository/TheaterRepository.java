package com.example.Book.my.show.Backend.project.Repository;

import com.example.Book.my.show.Backend.project.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {
    TheaterEntity findByNameAndCity(String name, String city);

    TheaterEntity findByName(String name);
}