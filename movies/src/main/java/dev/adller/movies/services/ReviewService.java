package dev.adller.movies.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.adller.movies.Model.Movie;
import dev.adller.movies.Model.Review;
import dev.adller.movies.repository.ReviewRepository;

@Service
public class ReviewService {
  
  @Autowired
  private ReviewRepository reviewRepository;

  //As vezes terá queries tão complexas que será necessário usar templates
  //também as vezes é o modo mais adequado para fazer inserções dependendo do caso
  @Autowired
  private MongoTemplate mongoTemplate;


  public Review createReview(String reviewBody, String imdbId){
    Review review = new Review(reviewBody);

    reviewRepository.insert(review);

    //Aqui está sendo feito uma verificação se o imdbId é o imdbId do banco
    //assim ele insere dentro do array vazio chamado reviewIds
    //sempre dando update e atualizando este array
    mongoTemplate.update(Movie.class)
      .matching(Criteria.where("imdbId").is(imdbId))
      .apply(new Update().push("reviewIds").value(review))
      .first(); //para dizer ques tamos recebendo um único filme

    return review;
      

  }
}
