package software.jevera.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.jevera.domain.Assortment;
import software.jevera.domain.User;
import software.jevera.domain.dto.AssortmentDto;
import software.jevera.domain.dto.AssortmentMapper;
import software.jevera.service.AssortmentService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/products")
@RestController
@RequiredArgsConstructor
public class AssortmentController {

    private final AssortmentService assortmentService;
    private final HttpSession httpSession;
    private final AssortmentMapper mapper;

    @PostMapping
    public Assortment create(@Valid AssortmentDto assortment){
        return assortmentService.createAssortment(mapper.toAssortment(assortment), getUser());
    }

    //---------------не работает, падает 500, буду еще смотреть----------------//
    @GetMapping("/saler")
    public List<Assortment> salerAssortment(){
        return assortmentService.userAssortment(getUser());
    }
    //-------------------------------------------------------------------------//

    @GetMapping
    public List<Assortment> allAssortment(){
        return assortmentService.allAssortment();
    }

    private User getUser() {
        return (User) httpSession.getAttribute("name");
    }
}
