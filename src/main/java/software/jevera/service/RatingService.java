package software.jevera.service;

import software.jevera.dao.AssortmentRepository;
import software.jevera.dao.RatingRepository;
import software.jevera.domain.Assortment;
import software.jevera.domain.Rating;
import software.jevera.domain.User;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;


public class RatingService {
    private final AssortmentRepository assortmentRepository;
    private final RatingRepository ratingRepository;

    public RatingService(AssortmentRepository assortmentRepository, RatingRepository ratingRepository) {
        this.assortmentRepository = assortmentRepository;
        this.ratingRepository = ratingRepository;
    }

    public Rating addRating(Long id, String text, User user){

        Assortment assortment = assortmentRepository.findById(id).orElseThrow(EntityNotFound::new);
        Rating rating = new Rating(user, text, assortment);
        return ratingRepository.save(rating);
    }

    public List<Rating> getAssortmentRating(Long assortmentId){
        return ratingRepository.findByAssortmentId(assortmentId);
    }

    public List<Rating> getUserRating(User user){
        return ratingRepository.findByUser(user);
    }

    public void delete(Long id){
        ratingRepository.delete(id);
    }
}