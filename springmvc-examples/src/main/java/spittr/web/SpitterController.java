package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spittr.data.SpittleRepository;
import spittr.model.Spitter;
import spittr.model.Spittle;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpitterController(SpittleRepository repository) {
        this.spittleRepository = repository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        spittleRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/${username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Map model) {
        Spitter spitter = spittleRepository.findByUsername(username);
        model.put("spitter", spitter);
        return "profile";
    }

}
