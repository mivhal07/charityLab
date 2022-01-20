package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dao.CategoryDao;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.Donation;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping(value = "/add")
    private String addDonationResult(@Valid Donation donation, BindingResult result, Model model) {

        if (result.hasErrors()) {
            for (ObjectError allError : result.getAllErrors()) {
                System.out.println(allError);
            }
            return "donation/error";
        }
        donationDao.save(donation);
        return "donation/success";
    }

}
