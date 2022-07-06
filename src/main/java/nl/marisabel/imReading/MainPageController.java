package nl.marisabel.imReading;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }

}
