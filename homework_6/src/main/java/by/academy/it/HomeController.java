package by.academy.it;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping( "/home.html")
    public String homePage(Model model) {
        return "home";
    }
}
