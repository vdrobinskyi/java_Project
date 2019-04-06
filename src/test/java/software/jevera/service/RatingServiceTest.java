package software.jevera.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.dao.AssortmentRepository;
import software.jevera.dao.RatingRepository;
import software.jevera.domain.Assortment;
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
    private AssortmentRepository assortmentRepository;

    @Test
    public void addRating(){
        Assortment mockAssortment = new Assortment();
        when(assortmentRepository.findById(1L)).thenReturn(java.util.Optional.of(mockAssortment));
        User mockUser = new User("mockLogin", "mockPassword");
        ratingService.addRating(1L,"Probuy chto-to", mockUser);
        verify(assortmentRepository).findById(1L);
        verify(ratingRepository).save(new Rating(mockUser,"Poputka nomer 2",mockAssortment));
        verifyNoMoreInteractions(assortmentRepository,ratingRepository);
    }

    @Test (expected = EntityNotFound.class)
    public void ratingNotFound(){
        when(assortmentRepository.findById(1L)).thenReturn(Optional.empty());
        ratingService.addRating(1L,"test text",new User());
    }

    @Test
    public void assortmentGetRating(){
        Assortment assortment = new Assortment();
        assortment.setId(1L);
        User firstUser = new User("First login", "pass1");
        User secondUser = new User("Second login", "pass2");
        List<Rating> ratingList = asList(new Rating(firstUser,"Good rating", assortment), new Rating(secondUser,"Better rating",assortment));
        when(ratingRepository.findByAssortmentId(1L)).thenReturn(ratingList);
        List<Rating> ratings = ratingService.getAssortmentRating(1L);
        assertEquals(ratings, ratingList);
    }
    @Test
    public void getUserRating(){
        Assortment firstAssortment = new Assortment();
        firstAssortment.setId(1L);
        Assortment secondAssortment= new Assortment();
        secondAssortment.setId(2L);
        User user = new User("First login", "pass1");
        List<Rating> ratingList = asList(new Rating(user,"Good rating", firstAssortment), new Rating(user,"Better rating",secondAssortment));
        when(ratingRepository.findByUser(user)).thenReturn(ratingList);
        List<Rating> ratings = ratingService.getUserRating(user);
        assertEquals(ratings, ratingList);
    }


    @Test
    public void delete(){
        ratingService.delete(1L);
        verify(ratingRepository).delete(1L);
        verifyNoMoreInteractions(ratingRepository, assortmentRepository);
    }
}
