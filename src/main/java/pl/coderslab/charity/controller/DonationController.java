package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.CategoryDao;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.Donation;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
public class DonationController {
    private final CategoryDao categoryDao;
    private final InstitutionDao institutionDao;
    private final DonationDao donationDao;

    public DonationController(CategoryDao categoryDao, InstitutionDao institutionDao, DonationDao donationDao) {
        this.categoryDao = categoryDao;
        this.institutionDao = institutionDao;
        this.donationDao = donationDao;
    }

    @GetMapping("/add")
    private String addDonation(Model model) {
        model.addAttribute("donation", new Donation());
        model.addAttribute("institutions", institutionDao.getAll());
        model.addAttribute("categories", categoryDao.getAll());
        return "donation/add2";
    }

    @PostMapping("/add")
    private String addDonationResult(@Valid Donation donation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "donation/error";
        }
        donationDao.save(donation);
        return "donation/success";
    }

}
