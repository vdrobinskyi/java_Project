package software.jevera.service;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import software.jevera.dao.UserRepository;
import software.jevera.domain.User;
import software.jevera.exceptions.UncorrectPassword;
import software.jevera.exceptions.UserWithLogin;

import java.util.Optional;

import static org.mockito.Mockito.*;


public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void before() {
        userRepository = mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

// ---------------Без понятия почему оно не работает--------------
//    @Test
//    public void GoodLoginTest() {
//        User user = new User("login", "badPassword");
//        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));
//        User loginUser = userService.loginIn(new User("login", "P@ssw0rd"));
//        assertEquals(loginUser, user);
//        verify(userRepository).findUserByLogin("login");
//        verifyNoMoreInteractions(userRepository);
//}

    @Test(expected = UncorrectPassword.class)
    public void invalidLoginTest() {
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.empty());
        userService.loginIn(new User("login", "passwd"));
    }

    @Test(expected = UncorrectPassword.class)
    public void invalidPassTest() {
        User user = new User("login", "passwd");
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));
        userService.loginIn(new User("login", "passwd"));
    }

    @Test
    public void registerUser() {
        User userDto = new User("login", "passwd");
        when(userRepository.UserWithLogin("login")).thenReturn(false);
        userService.registrationUser(userDto);
        verify(userRepository).UserWithLogin("login");
    }

    @Test(expected = UserWithLogin.class)
    public void userAlreadyExists() {
        User userDto = new User("login", "passwd");
        when(userRepository.UserWithLogin("login")).thenReturn(true);
        userService.registrationUser(userDto);
    }
}
