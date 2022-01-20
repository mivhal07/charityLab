package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.dao.UserDao;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.user.CurrentUser;

import java.util.Arrays;


@Controller
public class HomeController {
    private final InstitutionDao institutionDao;
    private final DonationDao donationDao;
    private final UserDao userDao;
    private final UserRepository userRepository;

    public HomeController(InstitutionDao institutionDao, DonationDao donationDao, UserDao userDao, UserRepository userRepository) {
        this.institutionDao = institutionDao;
        this.donationDao = donationDao;
        this.userDao = userDao;
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String homeAction(Model model, @AuthenticationPrincipal CurrentUser customUser) {
        model.addAttribute("institutions", institutionDao.getAll());
        model.addAttribute("donationsWorki", donationDao.allWorki().get(0));
        model.addAttribute("donationsDary", donationDao.allDonations().get(0));
//        if (customUser.isEnabled()){
//            User user = customUser.getUser();
//            model.addAttribute("mmm", user.getName());
//        }
        return "index";
    }


}
