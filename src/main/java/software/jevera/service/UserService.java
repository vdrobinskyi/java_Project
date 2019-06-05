package software.jevera.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import software.jevera.dao.UserRepository;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;
import software.jevera.exceptions.UncorrectPassword;
import software.jevera.exceptions.UserWithLogin;

import java.math.BigInteger;
import java.security.MessageDigest;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User registrationUser(UserDto userDto){
        if (userRepository.UserWithLogin(userDto.getLogin())){
            throw new UserWithLogin(userDto.getLogin());
        }

        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPasswordHash(encodePassword(userDto.getPassword()));
        return userRepository.save(user);
    }

    @SneakyThrows
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

    public boolean checkPassword(UserDto userDto, User user){
        String encodePassword = encodePassword(userDto.getPassword());
        return encodePassword.equals(user.getPasswordHash());
    }

    public User loginIn(UserDto userDto) {
        return userRepository.findUserByLogin(userDto.getLogin())
                .filter(user -> checkPassword(userDto, user))
                .orElseThrow(UncorrectPassword::new);
    }

}
