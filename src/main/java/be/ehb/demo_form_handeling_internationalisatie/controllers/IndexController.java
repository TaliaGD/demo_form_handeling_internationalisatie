package be.ehb.demo_form_handeling_internationalisatie.controllers;

import be.ehb.demo_form_handeling_internationalisatie.model.Snack;
import be.ehb.demo_form_handeling_internationalisatie.model.SnackDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {
    @Autowired
    SnackDAO dao;

    @ModelAttribute(value = "alleSnacks")
    public Iterable<Snack> getAllSnacks(){
        return dao.findAll();
    }
    // model atribute voor één snack
    @ModelAttribute(value = "nSnack")
    public Snack snaclToSave(){
        return new Snack();
    }
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }
    //opslaan snack
    @RequestMapping(value = {"","/","/index"}, method = RequestMethod.POST)
    public String saveSnack(@ModelAttribute("nSnack")@Valid Snack nSnack, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "index";
        dao.save(nSnack);
        //redirect is openen met een get
        return "redirect:/index";


    }
}
