package software.jevera.dao.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.domain.Assortment;
import software.jevera.domain.User;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AssortmentImplRepositoryTest {

    private AssortmentImplRepository repository = new AssortmentImplRepository();

    @Test
    public void save(){
        Assortment assortment = createAssortment("Soap", 15, "David", 1L);
        repository.save(assortment);
        Optional<Assortment> byId = repository.findById(assortment.getId());
        assertEquals(byId.get(), assortment);
    }

    private Assortment createAssortment(String name, Integer price, String saler, Long id) {
        Assortment assortment = new Assortment();
        assortment.setName(name);
        assortment.setPrice(price);
        assortment.setSaler(new User(saler, "saler"));
        assortment.setId(id);
        return assortment;
    }

    @Test
    public void findByUSer() {
        List<Assortment> assortments = asList(
                createAssortment("First", 20, "User1", 1L),
                createAssortment("Second",30,"User2", 2L),
                createAssortment("Third", 100, "User1", 3L)
        );
        assortments.forEach(repository::save);

        List<Assortment> coming = asList(
                createAssortment("First", 20, "User1", 1L),
                createAssortment("Third", 100, "User1", 3L)
        );

        assertEquals(coming, repository.findByUser(new User("User1", "saler")));
    }
}
