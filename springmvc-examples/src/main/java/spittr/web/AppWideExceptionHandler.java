package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class AppWideExceptionHandler {

    /**
     * 映射到所有的RequestMapping
     * @return
     */
    @ExceptionHandler(IOException.class)
    public String exception(String name) {
        String redirect = "redirect:{name}";
        String forward = "forward:";
        return redirect+forward;
    }

}
