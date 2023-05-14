package com.example.Book.my.show.Backend.project.Repository;

import com.example.Book.my.show.Backend.project.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    MovieEntity findByName(String name);

}
