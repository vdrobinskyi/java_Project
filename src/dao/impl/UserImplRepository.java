package dao.impl;

import dao.UserRepository;
import domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserImplRepository implements UserRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public boolean UserWithLogin(String login) {
        return users.stream().anyMatch(user -> user.getLogin().equals(login));
    }

    @Override
    public User save(User user) {
    users.add(user);
    return user;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return users.stream().filter(user -> user.getLogin().equals(login)).findAny();
    }
}
