package dev.adller.movies.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.adller.movies.Model.Movie;
import java.util.*;
import dev.adller.movies.services.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
   
  @Autowired
  private MovieService movieService;

  @GetMapping("")
  public ResponseEntity<List<Movie>> allMovies(){
    List<Movie> movieList = movieService.allMovies();
    return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
  }
  @GetMapping("/{imdbId}")
  public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
    return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
  }
}
