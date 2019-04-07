package software.jevera.service;

import lombok.RequiredArgsConstructor;
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
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registrationUser(UserDto userDto){
        if (userRepository.UserWithLogin(userDto.getLoginDto())){
            throw new UserWithLogin(userDto.getLoginDto());
        }

        User user = new User();
        user.setLogin(user.getLogin());
        user.setPassword(encodePassword(userDto.getPasswordDto()));
        return userRepository.save(user);
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

    public boolean checkPassword(UserDto userDto, User user){
        String encodePassword = encodePassword(userDto.getPasswordDto());
        return encodePassword.equals(user.getPassword());
    }

    public User loginIn(UserDto userDto) {
        return userRepository.findUserByLogin(userDto.getLoginDto())
                .filter(user -> checkPassword(userDto, user))
                .orElseThrow(UncorrectPassword::new);
    }

}
