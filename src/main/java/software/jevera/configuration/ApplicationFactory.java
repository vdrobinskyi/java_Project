package software.jevera.configuration;

import software.jevera.dao.impl.AssortmentImplRepository;
import software.jevera.dao.impl.UserImplRepository;
import software.jevera.service.AssortmentService;
import software.jevera.service.UserService;
import software.jevera.service.assortment.*;

import static java.util.Arrays.asList;

public class ApplicationFactory {
    public static UserService userService;
    public static AssortmentService assortmentService;

    static {
        userService = new UserService(new UserImplRepository());
        StateMachine stateMachine;
        stateMachine = new StateMachine(asList(
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
