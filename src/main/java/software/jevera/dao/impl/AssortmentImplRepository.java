package software.jevera.dao.impl;

import org.springframework.stereotype.Repository;
import software.jevera.dao.AssortmentRepository;
import software.jevera.domain.Assortment;
import software.jevera.domain.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static software.jevera.service.assortment.AssortmentStateEnum.*;
@Repository
public class AssortmentImplRepository implements AssortmentRepository {

    private Set<Assortment> assortments = new HashSet<>();
//    private Stream<AssortmentStateEnum> stateEnumStream = Stream.of(NEW, UPLOAD, IN_THE_BASKET, FAVORITES, SALES, REMOVE);
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Assortment save(Assortment assortment) {
        if(assortment.getId() == null){
            assortment.setId((long) Math.toIntExact(counter.incrementAndGet()));
        }
        assortments.add(assortment);
        return assortment;
    }

    @Override
    public List<Assortment> findAll() {
        return new ArrayList<>(assortments);
    }

    @Override
    public List<Assortment> findAvailableAssortment() {
        return assortments.stream().filter(it -> it.getStatus().equals(UPLOAD)).collect(Collectors.toList());
    }

    @Override
    public List<Assortment> findSalesAssortment() {
        return assortments.stream().filter(it -> it.getStatus().equals(SALES)).collect(Collectors.toList());
    }

    @Override
    public List<Assortment> findFavoritesAssortment() {
        return assortments.stream().filter(it -> it.getStatus().equals(FAVORITES)).collect(Collectors.toList());
    }

    @Override
    public List<Assortment> findInTheBasketAssortment() {
        return assortments.stream().filter(it -> it.getStatus().equals(IN_THE_BASKET)).collect(Collectors.toList());
    }

    @Override
    public List<Assortment> findByUser(User user) {
        return assortments.stream().filter(assortment -> assortment.getSaler().equals(user)).collect(Collectors.toList());
    }

    @Override
    public Optional<Assortment> findById(Long id) {
        return assortments.stream().filter(assortment -> assortment.getId().equals(id)).findAny();
    }
}
