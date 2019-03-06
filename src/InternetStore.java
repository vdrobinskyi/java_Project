import configuration.ApplicationFactory;
import domain.User;

public class InternetStore {
    public static void main(String[] args) {
        ApplicationFactory.userService.registrationUser(new User("login","Password"));
    }
}
