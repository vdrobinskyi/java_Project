package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import software.jevera.domain.User;
import software.jevera.domain.dto.UserDto;
import software.jevera.service.UserService;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;


    // падают 500 на этих методах


    @PostMapping(value = "/register")
    public User register(UserDto userDto){
        return userService.registrationUser(userDto);
    }

    @PostMapping(value = "/login")
    public User login(UserDto userDto){
        User user = userService.loginIn(userDto);
        httpSession.setAttribute("user", user);
        return user;
    }
}
