package be.ehb.demo_form_handeling_internationalisatie.controllers;

import be.ehb.demo_form_handeling_internationalisatie.model.Snack;
import be.ehb.demo_form_handeling_internationalisatie.model.SnackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @Autowired
    SnackDAO dao;

    @ModelAttribute(value = "alleSnacks")
    public Iterable<Snack> getAllSnacks(){
        return dao.findAll();
    }
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }
}
