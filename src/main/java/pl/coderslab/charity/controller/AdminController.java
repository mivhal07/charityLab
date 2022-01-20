package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.InstitutionDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final InstitutionDao institutionDao;

    public AdminController(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    @GetMapping("/")
    public String homeAdmin() {
        return "admin/index";
    }

    @GetMapping("/institutions")
    public String allInstitutions(Model model) {
        model.addAttribute("institutions", institutionDao.getAll());
        return "admin/institutions/readAll";
    }

    @GetMapping("/institutions/add")
    public String addInstitution(Model model) {
        model.addAttribute("institutions", institutionDao.getAll());
        return "admin/institutions/readAll";
    }


}
