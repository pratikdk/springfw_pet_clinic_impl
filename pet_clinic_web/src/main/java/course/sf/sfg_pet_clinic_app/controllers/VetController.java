package course.sf.sfg_pet_clinic_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/vets", "/vets/", "/vets/index", "/vets/index.html"})
    public String listVets() {
        return "vet/index";
    }
}
