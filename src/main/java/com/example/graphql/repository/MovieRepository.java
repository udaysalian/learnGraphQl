package com.example.graphql.repository;

import com.example.graphql.domain.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private List<Movie> movieList;

    public MovieRepository() {
    }

    @PostConstruct
    private void initMovieList() {
        movieList = new ArrayList<>();

        movieList.add(new Movie( 1L, "Movie 1",1980, List.of("Genra1","Genra2"), "director1"));
        movieList.add(new Movie( 2L, "Movie 2",1980, List.of("Genra1","Genra2","Genra3"), "director2"));
        movieList.add(new Movie( 3L, "Movie 3",1980, List.of("Genra1","Genra2"), "director3"));
        movieList.add(new Movie( 4L, "Movie 4",1980, List.of("Genra1","Genra2"), "director4"));
    }

    public Movie getById(Long id){
        return movieList.stream().filter(movie -> movie.id().equals(id)).findFirst().orElse(null);

    }

    public void addMovie( Movie newMovie) {
        movieList.add(newMovie);
    }
}
