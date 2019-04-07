package software.jevera.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import software.jevera.dao.AssortmentRepository;
import software.jevera.domain.Assortment;
import software.jevera.domain.User;
import software.jevera.service.assortment.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static software.jevera.configuration.ApplicationFactory.stateMachine;
import static software.jevera.service.assortment.AssortmentStateEnum.*;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AssortmentService.class, StateMachine.class, New.class, Upload.class, InTheBasket.class, Favorites.class, Sales.class, Remove.class})
public class AssortmentServiceTest {


    private static final Long ASSORTMENT_ID = 1234L;

    @Autowired
    private AssortmentService assortmentService;

    @MockBean
    private AssortmentRepository assortmentRepository;

    @Before
    public void before(){
        assortmentRepository = mock(AssortmentRepository.class);
        assortmentService = new AssortmentService(assortmentRepository, stateMachine);
    }

    @org.junit.Test
    public void createAssortment() {
        User user = new User("Test User", "Test Password");
        User badUser = new User("Bad User", "Bad Password");
        Assortment assortment = new Assortment(500,"Test Name", "Test Description", badUser);
        when(assortmentRepository.save(assortment)).thenReturn(assortment);
        Assortment assortmentResult = assortmentService.createAssortment(assortment, user);
        Assert.assertNotEquals(assortmentResult.getBuyer(), user);
        verify(assortmentRepository).save(refEq(assortment));
        verifyNoMoreInteractions(assortmentRepository);


    }

    @org.junit.Test
    public void allAssortment() {
        assertEquals(assortmentService.allAssortment(), assortmentRepository.findAll());
    }

//    @org.junit.Test
//    public void userAssortment() {
//        User user = new User();
//        User badUser = new User();
//        assertEquals(assortmentService.userAssortment(user), assortmentRepository.findByUser(user));
//    }

    @org.junit.Test
    public void upload() {
        Assortment assortment = new Assortment();
        assortment.setStatus(NEW);
        when(assortmentRepository.findById(ASSORTMENT_ID)).thenReturn(java.util.Optional.of(assortment));
        assortmentService.upload(ASSORTMENT_ID);
        Assortment removeAssortment = new Assortment();
        removeAssortment.setStatus(UPLOAD);
        verify(assortmentRepository).save(refEq(removeAssortment));
    }

    @org.junit.Test
    public void remove() {
        Assortment assortment = new Assortment();
        assortment.setStatus(UPLOAD);
        when(assortmentRepository.findById(ASSORTMENT_ID)).thenReturn(java.util.Optional.of(assortment));
        assortmentService.remove(ASSORTMENT_ID);
        Assortment removeAssortment = new Assortment();
        removeAssortment.setStatus(REMOVE);
        verify(assortmentRepository).save(refEq(removeAssortment));
    }

    @org.junit.Test
    public void sales() {
        Assortment assortment = new Assortment();
        assortment.setStatus(IN_THE_BASKET);
        when(assortmentRepository.findById(ASSORTMENT_ID)).thenReturn(java.util.Optional.of(assortment));
        assortmentService.sales(ASSORTMENT_ID);
        Assortment removeAssortment = new Assortment();
        removeAssortment.setStatus(SALES);
        verify(assortmentRepository).save(refEq(removeAssortment));
    }

    @org.junit.Test
    public void favorites() {
        Assortment assortment = new Assortment();
        assortment.setStatus(IN_THE_BASKET);
        when(assortmentRepository.findById(ASSORTMENT_ID)).thenReturn(java.util.Optional.of(assortment));
        assortmentService.favorites(ASSORTMENT_ID);
        Assortment removeAssortment = new Assortment();
        removeAssortment.setStatus(FAVORITES);
        verify(assortmentRepository).save(refEq(removeAssortment));
    }

    @org.junit.Test
    public void inTheBasket() {
        Assortment assortment = new Assortment();
        assortment.setStatus(UPLOAD);
        when(assortmentRepository.findById(ASSORTMENT_ID)).thenReturn(java.util.Optional.of(assortment));
        assortmentService.inTheBasket(ASSORTMENT_ID);
        Assortment removeAssortment = new Assortment();
        removeAssortment.setStatus(IN_THE_BASKET);
        verify(assortmentRepository).save(refEq(removeAssortment));
    }

}
