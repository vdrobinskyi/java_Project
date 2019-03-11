package software.jevera.dao;

import software.jevera.domain.Assortment;
import software.jevera.domain.User;

import java.util.List;

public interface AssortmentRepository {

    Assortment save(Assortment assortment);
    List<Assortment> findAll();
    List<Assortment> findByUser(User user);
    Assortment findById(Long id);
}
