package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;


@Controller
public class HomeController {
    private final InstitutionDao institutionDao;
    private final DonationDao donationDao;

    public HomeController(InstitutionDao institutionDao, DonationDao donationDao) {
        this.institutionDao = institutionDao;
        this.donationDao = donationDao;
    }


    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionDao.getAll());
        model.addAttribute("donationsWorki", donationDao.allWorki().get(0));
        model.addAttribute("donationsDary", donationDao.allDonations().get(0));
        return "index";
    }
}
