package software.jevera.configuration;

import software.jevera.dao.impl.AssortmentImplRepository;
import software.jevera.dao.impl.UserImplRepository;
import software.jevera.service.AssortmentService;
import software.jevera.service.UserService;
import software.jevera.service.assortment.*;

import static java.util.Arrays.asList;

public class ApplicationFactory {
    public static final UserService userService;
    public static final AssortmentService assortmentService;
    public static StateMachine stateMachine;

    static {
        userService = new UserService(new UserImplRepository());
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
