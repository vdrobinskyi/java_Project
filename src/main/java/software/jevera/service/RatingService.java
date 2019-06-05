package software.jevera.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.jevera.dao.ProductRepository;
import software.jevera.dao.RatingRepository;
import software.jevera.domain.Product;
import software.jevera.domain.Rating;
import software.jevera.domain.User;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    private final ProductRepository productRepository;
    private final RatingRepository ratingRepository;

    public Rating addRating(Long id, String text, User user){

        Product product = productRepository.findById(id).orElseThrow(EntityNotFound::new);
        Rating rating = new Rating( user, text, product);
        return ratingRepository.save(rating);
    }

    public List<Rating> getProductRating(Long assortmentId){
        return ratingRepository.findByProductId(assortmentId);
    }

    public List<Rating> getUserRating(User user){
        return ratingRepository.findByUser(user);
    }

    public void delete(Long id){
        ratingRepository.delete(id);
    }
}
