package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    List<Movie> movies = new ArrayList<>();
    HashMap<String, Movie> movieHashMap = new HashMap<>();

    public List<Movie> getAllMovies() {
        return movies;
    }

    public void postMovie(Movie movie) {
        if(movieHashMap.containsKey(movie.getId())) throw new IdAlreadyExist("Movie already exist");
        movies.add(movie);
        movieHashMap.put(movie.getId(), movie);
    }

    public Movie getById(String id) {
        if (!movieHashMap.containsKey(id)) throw new IdNotFound("Movie with id not found");
//        if (ObjectUtils.isEmpty(movieHashMap.get(id))) throw new IdNotFound("Movie donot found");
        return movieHashMap.get(id);
    }

    public void putById(String id, Movie movie) {
        if (!movieHashMap.containsKey(id)) throw new IdNotFound();
        Movie oldMovi = movieHashMap.get(id);

        movies.remove(oldMovi);
        movies.add(movie);
        movieHashMap.put(id,movie);

    }

    public void deleteMovie(String id) {
        if (!movieHashMap.containsKey(id)) throw new IdNotFound();
        Movie movie = movieHashMap.get(id);
        movies.remove(movie);
        movieHashMap.remove(id);
    }
}



