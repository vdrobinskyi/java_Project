package software.jevera.dao.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import software.jevera.domain.User;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserImplRepositoryTest {

    private UserImplRepository userImplRepository = new UserImplRepository();

    @Test
    public void isUserAlreadyExist() {
        List<User> users = asList(
                new User("Login", "Password"),
                new User("Login2", "Password2")
        );
        users.forEach(userImplRepository::save);
        assertTrue(userImplRepository.UserWithLogin("Login"));
        assertFalse(userImplRepository.UserWithLogin("NOOO"));
    }

    @Test
    public void save() {
        List<User> users = asList(
                new User("Login","Password"),
                new User("Login2","Password2")
        );
        users.forEach(userImplRepository::save);
        assertEquals(users, userImplRepository.findAll());
    }

    @Test
    public void findUserByLogin() {
        List<User> users = asList(
                new User("Login","Password"),
                new User("Login2","Password2")
        );
        users.forEach(userImplRepository::save);
        assertEquals(Optional.of(new User("Login","Password")),userImplRepository.findUserByLogin("Login"));
        assertEquals(Optional.empty(),userImplRepository.findUserByLogin("ASDASAS"));

    }
}
