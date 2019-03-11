package software.jevera.service;

import software.jevera.dao.UserRepository;
import software.jevera.domain.User;
import software.jevera.exceptions.UncorrectPassword;
import software.jevera.exceptions.UserWithLogin;

import java.math.BigInteger;
import java.security.MessageDigest;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registrationUser(User user){
        if (userRepository.UserWithLogin(user.getLogin())){
            throw new UserWithLogin(user.getLogin());
        }

        User user1 = new User();
        user1.setLogin(user1.getLogin());
        user1.setPassword(user1.getPassword());
        return userRepository.save(user1);
    }

    private static String encodePassword(String password){
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(password.getBytes());
            return new BigInteger(1,messageDigest.digest()).toString(16);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(User user1, User user){
        String encodePassword = encodePassword(user1.getPassword());
        return encodePassword.equals(user.getPassword());
    }

    public User loginIn(User user){
        return userRepository.findUserByLogin(user.getLogin()).filter(user1 -> checkPassword(user, user1)).orElseThrow(UncorrectPassword::new);
    }

}
