package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRep) {
        this.spittleRepository = spittleRep;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Map model) {
        model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = "100") long max,
            @RequestParam(value = "count", defaultValue = "20") int count){
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show/{spittleId}", method = RequestMethod.GET)
    public String showSpittle(@PathVariable long spittleId, Map model) {
        model.put("spittle", spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
