package software.jevera.dao.impl;

import software.jevera.dao.AssortmentRepository;
import software.jevera.domain.Assortment;
import software.jevera.domain.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class AssortmentImplRepository implements AssortmentRepository {

    private Set<Assortment> assortments = new HashSet<>();
    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Assortment save(Assortment assortment) {
        if(assortment.getId() == null){
            assortment.setId(Math.toIntExact(counter.incrementAndGet()));
        }
        assortments.add(assortment);
        return assortment;
    }

    @Override
    public List<Assortment> findAll() {
        return new ArrayList<>(assortments);
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
