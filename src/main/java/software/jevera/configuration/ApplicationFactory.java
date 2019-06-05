package software.jevera.configuration;

import software.jevera.dao.impl.ProductImplRepository;
import software.jevera.dao.impl.UserImplRepository;
import software.jevera.service.ProductService;
import software.jevera.service.UserService;
import software.jevera.service.product.*;

import static java.util.Arrays.asList;

public class ApplicationFactory {
    public static final UserService userService;
    public static final ProductService PRODUCT_SERVICE;
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
        PRODUCT_SERVICE = new ProductService(new ProductImplRepository(), stateMachine);
    }

}
