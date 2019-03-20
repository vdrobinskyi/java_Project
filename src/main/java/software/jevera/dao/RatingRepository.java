package software.jevera.dao;

import software.jevera.domain.Rating;
import software.jevera.domain.User;

import java.util.List;

public interface RatingRepository {
    Rating save(Rating rating);
    List<Rating> findByUser(User user);
    List<Rating> findByAssortmentId(Long assortment);
    void delete(Long id);
}
