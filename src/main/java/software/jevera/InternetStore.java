package software.jevera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class InternetStore {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(InternetStore.class, args);

//        AssortmentService assortmentService = context.getBean(AssortmentService.class);
//        assortmentService.createAssortment(new Assortment(), new User());
//        System.out.println(assortmentService.allAssortment());
    }
}
