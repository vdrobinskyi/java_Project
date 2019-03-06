package dao;

import domain.User;

import java.util.Optional;

public interface UserRepository {
    boolean UserWithLogin(String login);
    User save(User user);
    Optional<User> findUserByLogin(String login);
}
