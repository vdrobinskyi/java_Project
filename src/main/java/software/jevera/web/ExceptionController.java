package software.jevera.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import software.jevera.exceptions.UncorrectPassword;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handler(Exception e){
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @ExceptionHandler(UncorrectPassword.class)
    public ResponseEntity<CustomErrorResponse> customException(){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse();
        customErrorResponse.setMessage("Unauthorized");
        return new ResponseEntity<>(customErrorResponse, HttpStatus.UNAUTHORIZED);
    }
}
