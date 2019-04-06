package software.jevera.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class UserDto{

    private String loginDto;
    private String passwordDto;

//    public UserDto(String loginDto, String passwordDto) {
//        this.loginDto = loginDto;
//        this.passwordDto = passwordDto;
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
//    public String getPasswordDto() {
//        return passwordDto;
//    }
//
//    public void setPasswordDto(String passwordDto) {
//        this.passwordDto = passwordDto;
//    }
}
