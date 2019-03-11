package software.jevera.exceptions;

public class UserWithLogin extends RuntimeException {
    private String login;

    public UserWithLogin(String login){this.login = login;}
}
