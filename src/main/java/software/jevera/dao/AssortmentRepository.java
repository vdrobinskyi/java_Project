package software.jevera.dao;

import software.jevera.domain.Assortment;
import software.jevera.domain.User;

import java.util.List;
import java.util.Optional;

public interface AssortmentRepository {

    Assortment save(Assortment assortment);
    List<Assortment> findAll();
    List<Assortment> findAvailableAssortment();
    List<Assortment> findSalesAssortment();
    List<Assortment> findFavoritesAssortment();
    List<Assortment> findInTheBasketAssortment();
    List<Assortment> findByUser(User user);
    Optional<Assortment> findById(Long id);
}
