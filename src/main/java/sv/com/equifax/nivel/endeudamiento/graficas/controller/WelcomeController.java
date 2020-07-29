package sv.com.equifax.nivel.endeudamiento.graficas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sv.com.equifax.nivel.endeudamiento.graficas.service.NivelEndeudamientoService;

@Controller
public class WelcomeController {

    @Autowired
    NivelEndeudamientoService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        model.put("name", "xtecuan");
        return "welcome";
    }

    @RequestMapping(value = "/grafica", method = RequestMethod.GET)
    public String grafica(ModelMap model) {
        model.put("dataModular", service.getData());
        return "grafica";
    }

    @RequestMapping(value = "/grafica1", method = RequestMethod.GET)
    public String grafica1(ModelMap model) {
        model.put("dataModular", service.getData1());
        return "grafica1";
    }
}
