package software.jevera.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.dao.ProductRepository;
import software.jevera.dao.RatingRepository;
import software.jevera.domain.Product;
import software.jevera.domain.Rating;
import software.jevera.domain.User;
import software.jevera.exceptions.EntityNotFound;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceTest {


    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void addRating(){
        Product mockProduct = new Product();
        when(productRepository.findById(1L)).thenReturn(java.util.Optional.of(mockProduct));
        User mockUser = new User("mockLogin", "mockPassword");
        ratingService.addRating(1L,"Probuy chto-to", mockUser);
        verify(productRepository).findById(1L);
        verify(ratingRepository).save(new Rating(mockUser,"Poputka nomer 2", mockProduct));
        verifyNoMoreInteractions(productRepository,ratingRepository);
    }

    @Test (expected = EntityNotFound.class)
    public void ratingNotFound(){
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        ratingService.addRating(1L,"test text",new User());
    }

    @Test
    public void ProductGetRating(){
        Product product = new Product();
        product.setId(1L);
        User firstUser = new User("First login", "pass1");
        User secondUser = new User("Second login", "pass2");
        List<Rating> ratingList = asList(new Rating(firstUser,"Good rating", product), new Rating(secondUser,"Better rating", product));
        when(ratingRepository.findByProductId(1L)).thenReturn(ratingList);
        List<Rating> ratings = ratingService.getProductRating(1L);
        assertEquals(ratings, ratingList);
    }
    @Test
    public void getUserRating(){
        Product firstProduct = new Product();
        firstProduct.setId(1L);
        Product secondProduct = new Product();
        secondProduct.setId(2L);
        User user = new User("First login", "pass1");
        List<Rating> ratingList = asList(new Rating(user,"Good rating", firstProduct), new Rating(user,"Better rating", secondProduct));
        when(ratingRepository.findByUser(user)).thenReturn(ratingList);
        List<Rating> ratings = ratingService.getUserRating(user);
        assertEquals(ratings, ratingList);
    }


    @Test
    public void delete(){
        ratingService.delete(1L);
        verify(ratingRepository).delete(1L);
        verifyNoMoreInteractions(ratingRepository, productRepository);
    }
}
