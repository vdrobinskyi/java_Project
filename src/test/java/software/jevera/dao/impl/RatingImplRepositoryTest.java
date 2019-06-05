package software.jevera.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.domain.Product;
import software.jevera.domain.Rating;
import software.jevera.domain.User;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RatingImplRepositoryTest {

    private RatingImplRepository ratingImplRepository = new RatingImplRepository();

    private Product createAssortment(String name, Integer price, String saler, Long id) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setSaler(new User(saler, "saler"));
        product.setId(id);
        return product;
    }

    @Test
    public void save() {
        List<Rating> ratings = asList(
                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
                new Rating(new User("3", "33"), "Text3", createAssortment("name3", 3, "saler3", 3L))
        );
        ratings.forEach(ratingImplRepository::save);
        System.out.println(asList(ratings));
        assertEquals(ratings, ratingImplRepository.findAll());
    }

//    @Test
//    public void findRatingByAssortmentId() {
//        List<Rating> ratings = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("5", "55"), "Text5", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//        List<Rating> product = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//        List<Rating> assortment1 = asList(
//                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("5", "55"), "Text5", createAssortment("name2", 2, "saler2", 2L))
//        );
//
//        ratings.forEach(ratingImplRepository::save);
//        System.out.println(ratings);
//        System.out.println(assortment1);
//        assertEquals(product, ratingImplRepository.findByAssortmentId(1L));
//        assertEquals(assortment1, ratingImplRepository.findByAssortmentId(2L));
//    }
//
//    @Test
//    public void findRatingByUser() {
//        List<Rating> ratings = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("5", "55"), "Text5", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//        List<Rating> user = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//        List<Rating> user1 = asList(
//                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("5", "55"), "Text5", createAssortment("name2", 2, "saler2", 2L))
//        );
//
//        ratings.forEach(ratingImplRepository::save);
//        assertEquals(user, ratingImplRepository.findByUser(new User("1", "11")));
//        assertEquals(user1, ratingImplRepository.findByUser(new User("2", "22")));
//    }

//    @Test
//    public void findRatingByAssortmentId() {
//        List<Rating> ratings = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("2", "22"), "Text2", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("5", "55"), "Text5", createAssortment("name2", 2, "saler2", 2L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//        List<Rating> after = asList(
//                new Rating(new User("1", "11"), "Text", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("3", "33"), "Text3", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("4", "44"), "Text4", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("6", "66"), "Text6", createAssortment("name1", 1, "saler1", 1L)),
//                new Rating(new User("7", "77"), "Text7", createAssortment("name1", 1, "saler1", 1L))
//        );
//
//        ratings.forEach(ratingImplRepository::save);
//        ratingImplRepository.delete(1L);
//        ratingImplRepository.delete(2L);
//        assertEquals(after, ratingImplRepository.findAll());
//    }
}
