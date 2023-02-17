package dev.adller.movies.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.adller.movies.Model.Movie;


import dev.adller.movies.repository.MovieRepository;

import java.util.*;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;


  public List<Movie> allMovies(){
    return movieRepository.findAll();
  }
  public Optional<Movie> singleMovie(String imdbId){
    return movieRepository.findMovieByImdbId(imdbId);
  }
}
