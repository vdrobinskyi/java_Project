package software.jevera.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import software.jevera.dao.UserRepository;
import software.jevera.domain.User;
import software.jevera.exceptions.UncorrectPassword;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void before(){
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void GoodLoginTest() {
        User user = new User();
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));
        User loginUser = userService.loginIn(new User("login", "passwd"));
        assertEquals(loginUser, user);
        verify(userRepository).findUserByLogin("login");
        verifyNoMoreInteractions(userRepository);
    }

    @Test(expected = UncorrectPassword.class)
    public void BadLoginTest() {
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.empty());
        userService.loginIn(new User("login","passwd"));
    }

//   еще не закончил, скоро все доделаю
}
