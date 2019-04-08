package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
@AllArgsConstructor
public class UserDto{

    private String login;
    private String password;

//    public UserDto(String loginDto, String password) {
//        this.loginDto = loginDto;
//        this.password = password;
//    }
//
//    public String getLoginDto() {
//        return loginDto;
//    }
//
//    public void setLoginDto(String loginDto) {
//        this.loginDto = loginDto;
//    }
//
//    public String getpassword() {
//        return password;
//    }
//
//    public void setpassword(String password) {
//        this.password = password;
//    }
}
