package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.validation.Valid;
import net.guides.springboot2.springboot2jpacrudexample.model.Movie;    
import net.guides.springboot2.springboot2jpacrudexample.model.Quotes;   
import net.guides.springboot2.springboot2jpacrudexample.service.MovieQuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieQuotesController {

	@Autowired
    private MovieQuotesService service;

    private Random random = new Random();

    @PostMapping("/api/addmovie")
    public Movie createMovie(@Valid @RequestBody Movie movie){
        return service.saveMovie(movie);
    }

    @PostMapping("/api/addquotes")
    public List<Quotes> createQuotes(@Valid @RequestBody List<Quotes> quotes){
        return service.saveQuotes(quotes);
    }


    @GetMapping("api/movies")
    public List<Movie> movies(){
        return service.findAllMovies();
    }

    @GetMapping("api/quotes")
    public List<Quotes> quoteList(){
        return service.findAllQuotes();
    }

}