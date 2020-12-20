package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.data.SpittleRepository;
import spittr.model.Spitter;
import spittr.model.Spittle;

import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public String showRegistrationForm(Map model) {
        model.put("spitter", new Spitter());
        return "registerForm";
    }

    //@Valid,校验
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@RequestPart("profilePicture") byte[] profilePicture, @Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(""));
            fileInputStream.read(profilePicture);

            FileOutputStream fileOutputStream = new FileOutputStream(new File(""));
            fileOutputStream.write(profilePicture);

            try (FileOutputStream fileOutputStream1 = new FileOutputStream(new File(""))) {
                fileOutputStream1.write(profilePicture);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Path path = Paths.get("");
            Files.write(path, profilePicture);

        } catch (IOException e) {
            e.printStackTrace();
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

    @RequestMapping(value = "/saveImage", method = RequestMethod.POST)
    public String processRegistrationSaveImage(@RequestPart("profilePicture") Part part) {
        try {
            part.write("/data/spitter/"+part.getName());
        } catch (IOException e) {
            //非检查行异常 500
            throw new SpittleNotFoundException();
        }
        return "/spitter";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(Spitter from, RedirectAttributes model) {
        if(model.containsAttribute("spitter")){
            model.addAttribute(spittleRepository.findByUsername(""));
        }
        model.addFlashAttribute("spitter", from);
        return "redirect:/spitter/{username}";
    }

    private void saveImage(MultipartFile image) {
        try {
            String suffixName = image.getOriginalFilename().substring(image.getOriginalFilename().lastIndexOf("."));
            image.transferTo(new File("/upload/"+image.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 当抛出IOException异常时委托handleDuplicateSpittle处理
     * @return
     */
    @ExceptionHandler(IOException.class)
    public String handleDuplicateSpittle() {
        return "";
    }
}
