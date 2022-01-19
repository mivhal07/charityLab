package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.User;


@Controller
public class HomeController {
    private final InstitutionDao institutionDao;
    private final DonationDao donationDao;

    public HomeController(InstitutionDao institutionDao, DonationDao donationDao) {
        this.institutionDao = institutionDao;
        this.donationDao = donationDao;
    }


    @RequestMapping("/")
    public String homeAction(Model model, User user){
        model.addAttribute("institutions", institutionDao.getAll());
        model.addAttribute("donationsWorki", donationDao.allWorki().get(0));
        model.addAttribute("donationsDary", donationDao.allDonations().get(0));
        return "index";
    }

}
