package dao;

import domain.Assortment;
import domain.User;

import java.util.List;

public interface AssortmentRepository {

    Assortment save(Assortment assortment);
    List<Assortment> findAll();
    List<Assortment> findByUser(User user);
    Assortment findById(Long id);
}
