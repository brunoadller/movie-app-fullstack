package dev.adller.movies.repository;

import org.springframework.stereotype.Repository;

import dev.adller.movies.Model.Movie;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface MovieRepository extends MongoRepository<Movie,ObjectId> {
  
  Optional<Movie> findMovieByImdbId(String imdbId);
}
