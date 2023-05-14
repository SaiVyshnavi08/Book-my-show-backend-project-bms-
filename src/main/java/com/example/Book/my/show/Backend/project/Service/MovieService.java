package com.example.Book.my.show.Backend.project.Service;

import com.example.Book.my.show.Backend.project.Converters.MovieDtoToEntity;
import com.example.Book.my.show.Backend.project.Dtos.MovieDTO;
import com.example.Book.my.show.Backend.project.Dtos.MovieResponseDto;
import com.example.Book.my.show.Backend.project.Models.MovieEntity;
import com.example.Book.my.show.Backend.project.Models.ShowEntity;
import com.example.Book.my.show.Backend.project.Models.TheaterEntity;
import com.example.Book.my.show.Backend.project.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepo;

    public String addMovie(MovieDTO movieDTO){
        MovieEntity movie= MovieDtoToEntity.converterDTOtoEntity(movieDTO);
        movieRepo.save(movie);
        return "Movie Added Successfully";
    }
    public MovieResponseDto getMovie(String mvName){
        MovieEntity movie=movieRepo.findByName(mvName);
        MovieResponseDto movies= MovieResponseDto.builder().name(movie.getName()).duration(movie.getDuration()).releasedate(movie.getReleasedate()).build();
        List<String> theaters=new ArrayList<>();   //creating a new ArrayList theaters of list of strings
        List<ShowEntity> shows=movie.getListOfShows();  //in the movie repo .... with a particular movie name we will fetch the list of shows ans store it in shows
        for(ShowEntity show:shows){             //iterate over the show and get theater , if that theater is not present in the list add it
            TheaterEntity theater=show.getTheater();
            if(!theaters.contains(theater)){
                theaters.add(theater.getName());
            }
        }
        movies.setTheaters(theaters);         // to the movie set the theaters and return the movie

        return movies;
    }
    public List<MovieResponseDto> getMovies(){
        List<MovieEntity> movies=movieRepo.findAll();
        List<MovieResponseDto> Allmovies=new ArrayList<>();     //to return the object movie responseDto which has attributes --> movie , releaseDate , duration and list of theaters
        for (MovieEntity movie:movies){
            MovieResponseDto responceDto= MovieResponseDto.builder().name(movie.getName()).releasedate(movie.getReleasedate()).duration(movie.getDuration()).build();
            List<ShowEntity> showEntities=movie.getListOfShows();
            List<String> theaters=new ArrayList<>();
            for (ShowEntity show:showEntities){
                if(!theaters.contains(show.getTheater())){
                    theaters.add(show.getTheater().getName());
                }
                responceDto.setTheaters(theaters);
            }
            Allmovies.add(responceDto);
        }
        return Allmovies;
    }
}

