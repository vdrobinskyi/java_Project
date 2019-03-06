package configuration;

import impl.AssortmentImplRepository;
import impl.UserImplRepository;
import service.AssortmentService;
import service.UserService;
import assortment.*;

import static java.util.Arrays.asList;

public class ApplicationFactory {
    public static UserService userService;
    public static AssortmentService assortmentService;

    static {
        userService = new UserService(new UserImplRepository());
        StateMachine stateMachine = new StateMachine(asList(
           new New(),
           new Favorites(),
           new InTheBasket(),
           new Sales(),
           new Remove(),
           new Upload()
        ));
        assortmentService = new AssortmentService(new AssortmentImplRepository(), stateMachine);
    }

}
