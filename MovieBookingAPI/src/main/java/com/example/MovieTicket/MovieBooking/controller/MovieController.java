package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAll() {
        return movieService.getAllMovies();
    }

    @PostMapping("/movie")
    public void postMovie(@Valid @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            throw new IdAlreadyExist();
            throw new RuntimeException("Movie not valid");
        }
        movieService.postMovie(movie);
    }

    @GetMapping("/movie/{id}")
    public Movie getById(@PathVariable String id) {
//        Todo: Exception handled in Service also (what is the use of binding result here
//        if (bindingResult.hasErrors()) throw new IdNotFound();
        return movieService.getById(id);
    }

    @PutMapping("/update/{id}")
    public void putById(@PathVariable String id, @RequestBody Movie movie) {
        movieService.putById(id, movie);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteById(@PathVariable String id) {
        movieService.deleteById(id);
    }
}
