package pl.madison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.madison.domain.Odcinek;

import java.util.Map;

@Controller
public class TestController {

    @RequestMapping(value = "/wstaw")
    public String wstaw(Map<String, Object> model) {
        model.put("wpisz", new Odcinek());
        return "wpiszLiczby";
    }

    @RequestMapping(value = "/sprawdzamyTrojkat", method = RequestMethod.POST)
    public String trojkat(Odcinek odcinek, Map<String, Object> model) {
        boolean czyTrojkat = false;

        if (odcinek.getWymiar1() + odcinek.getWymiar2() > odcinek.getWymiar3() &&
                odcinek.getWymiar2() + odcinek.getWymiar3() > odcinek.getWymiar1() &&
                odcinek.getWymiar1() + odcinek.getWymiar3() > odcinek.getWymiar2()) {
            czyTrojkat = true;
        } else {
            czyTrojkat = false;
        }

        model.put("sprawdz", czyTrojkat);

        return "czyTroj";

    }
}
