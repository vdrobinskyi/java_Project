package software.jevera.dao.impl;

import software.jevera.dao.RatingRepository;
import software.jevera.domain.Rating;
import software.jevera.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class RatingImplRepository implements RatingRepository {

    private List<Rating> ratings = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Rating save(Rating rating) {
        rating.setId(counter.incrementAndGet());
        ratings.add(rating);
        return rating;
    }

    @Override
    public List<Rating> findByUser(User user) {
        return ratings.stream().filter(rating -> rating.getAuthor().equals(user)).collect(Collectors.toList());
    }

    @Override
    public List<Rating> findByAssortmentId(Long assortment) {
        return ratings.stream().filter(rating -> rating.getAssortment().getId().equals(assortment)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        ratings.removeIf(rating -> rating.getId().equals(id));
    }

    public List<Rating> findAll(){
        return new ArrayList<>(ratings);
    }
}
