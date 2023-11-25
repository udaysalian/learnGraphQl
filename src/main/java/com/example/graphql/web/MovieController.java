package com.example.graphql.web;

import com.example.graphql.domain.Movie;
import com.example.graphql.repository.MovieRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieController {

    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @QueryMapping(name = "movieById")
    public Movie getMovieById(@Argument Long id){

        return movieRepository.getById(id);

    }
    @QueryMapping(name = "movies")
    public List<Movie> getAllMovies(){

        return movieRepository.getMovieList();


    }

    //Movie(Long id, String title, Integer year, List<String> genres, String director)
    @MutationMapping
    public Movie addMovie(@Argument Long id, @Argument String title, @Argument Integer year, @Argument List<String> genres,
                          @Argument String director) {

        Movie newMovie = new Movie(id,title,year,genres,director);

        movieRepository.addMovie(newMovie);

        return  newMovie;
    }
}
