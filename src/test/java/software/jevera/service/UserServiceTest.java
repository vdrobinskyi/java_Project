package software.jevera.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.dao.UserRepository;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;
import software.jevera.exceptions.UncorrectPassword;
import software.jevera.exceptions.UserWithLogin;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void successLoginTest() {
        User user = new User("login", "passwd");
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));
//        User loginedUser = userService.loginIn(new UserDto("login", "passwd"));
//        assertEquals(loginedUser, user);
//        verify(userRepository).findUserByLogin("login");
//        verifyNoMoreInteractions(userRepository);
    }

    @Test(expected = UncorrectPassword.class)
    public void invalidLoginTest() {
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.empty());
        userService.loginIn(new UserDto("login", "passwd"));
    }

    @Test(expected = UncorrectPassword.class)
    public void invalidPassTest() {
        User user = new User("login", "passwd");
        when(userRepository.findUserByLogin("login")).thenReturn(Optional.of(user));
        userService.loginIn(new UserDto("login", "passwd"));
    }

    @Test
    public void registerUser() {
        UserDto userDto = new UserDto("login", "passwd");
        when(userRepository.UserWithLogin("login")).thenReturn(false);
        userService.registrationUser(userDto);
        verify(userRepository).UserWithLogin("login");
    }

    @Test(expected = UserWithLogin.class)
    public void userAlreadyExists() {
        UserDto userDto = new UserDto("login", "passwd");
        when(userRepository.UserWithLogin("login")).thenReturn(true);
        userService.registrationUser(userDto);
    }
}
