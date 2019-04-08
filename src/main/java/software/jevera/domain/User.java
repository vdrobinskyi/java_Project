package software.jevera.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter @Setter
@EqualsAndHashCode(of = "login")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String login;

    @JsonIgnore
    private String passwordHash;

//    public User(){}
//
//
//    public User(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//    public String getLogin() {
//        return login;
//    }
//

//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return login.equals(user.login);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(login);
//    }
}
