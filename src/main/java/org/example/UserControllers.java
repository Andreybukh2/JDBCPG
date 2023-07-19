package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllers {
    private final PersonDao personDao;

    @Autowired
    public UserControllers(PersonDao personDao) {
        this.personDao = personDao;
    }
    @GetMapping()
    public String getPeople(Model model) {
        model.addAttribute("allUsers", personDao.getAllUsers());
        return "allUsers/get-all-some";
    }
}
