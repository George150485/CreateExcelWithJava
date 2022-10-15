package control;

import java.util.List;

import model.AccessModifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import org.springframework.web.bind.annotation.RequestMethod;
import repository.ModifierRepo;

@Controller
public class ModifierController {
    @Autowired
    private ModifierRepo modifierRepo;

    public ModifierController(ModifierRepo modifierRepo) {
        this.modifierRepo = modifierRepo;
    }

    //Goto index Page
    @RequestMapping("/")
    public String view()
    {
        return "index";
    }
    //Goto insertPage
    @RequestMapping("/insert")
    public String view1()
    {
        return "insertPage";
    }
    //Save Record
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String view2(AccessModifier accessModifier, Model m)
    {
        modifierRepo.save(accessModifier);
        m.addAttribute("msg","Record insert successfully...");
        return "insertPage";
    }
    //Display Record
    @RequestMapping(value="/display", method = RequestMethod.GET)
    public String view3(Model m)
    {
        List list = modifierRepo.findAll();
        if(!list.isEmpty())
        {
            m.addAttribute("data", list);
        }
        else {
            m.addAttribute("msg","Sorry record not found!");
        }
        return "displayPage";
    }
}

