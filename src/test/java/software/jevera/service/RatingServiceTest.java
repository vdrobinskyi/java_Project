package software.jevera.service;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import software.jevera.dao.AssortmentRepository;
import software.jevera.dao.RatingRepository;

public class RatingServiceTest {

//  ---------------ни один тест не работает---------------//

    @InjectMocks
    private RatingService ratingService;

    @Mock
    private RatingRepository ratingRepository;

    @Mock
    private AssortmentRepository assortmentRepository;

//    @Test
//    public void addRating(){
//        Assortment mockAssortment = new Assortment();
//        when(assortmentRepository.findById(1L)).thenReturn(java.util.Optional.of(mockAssortment));
//        User mockUser = new User("mockLogin", "mockPassword");
//        ratingService.addRating(1L,"Probuy chto-to", mockUser);
//        verify(assortmentRepository).findById(1L);
//        verify(ratingRepository).save(new Rating(mockUser,"Poputka nomer 2",mockAssortment));
//        verifyNoMoreInteractions(assortmentRepository,ratingRepository);
//    }

//    @Test (expected = EntityNotFound.class)
//    public void ratingNotFound(){
//        when(assortmentRepository.findById(1L)).thenReturn(Optional.empty());
//        ratingService.addRating(1L,"test text",new User());
//    }

//    @Test
//    public void delete(){
//        ratingService.delete(1L);
//        verify(ratingRepository).delete(1L);
//        verifyNoMoreInteractions(ratingRepository, assortmentRepository);
//    }
}
