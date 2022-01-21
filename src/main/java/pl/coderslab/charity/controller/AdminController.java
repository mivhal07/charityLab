package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.Institution;

import javax.validation.Valid;

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
        model.addAttribute("institution", new Institution());
        return "admin/institutions/add";
    }

    @PostMapping("/institutions/add")
    public String addInstitutionResult(@Valid Institution institution, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/institutions/fail";
        }
        institutionDao.save(institution);
        return "admin/institutions/success";
    }

    @GetMapping("/institutions/update/{id}")
    public String updateInstitution(@PathVariable Long id, Model model) {
        model.addAttribute("institution", institutionDao.findById(id));
        return "admin/institutions/update";
    }

    @PostMapping("/institutions/update/{id}")
    public String updateInstitutionResult(@Valid Institution institution, BindingResult result){
        if (result.hasErrors()){
            return "admin/institutions/fail";
        }
        institutionDao.update(institution);
        return "admin/institutions/success";
    }

    @GetMapping("/institutions/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionDao.delete(institutionDao.findById(id));
        return "admin/institutions/success";
    }


}
