package nl.marisabel.imReading.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    private UserRepository service;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/users/new")
    public ModelAndView newUser() {
        User user = new User();
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);

        List<Role> roles = (List<Role>) roleRepository.findAll();

        mav.addObject("allRoles", roles);

        return mav;
    }

    @GetMapping("/users/edit/{id}")
    public ModelAndView editUser(@PathVariable(name = "id") Integer id) {
        User user = service.getById(id);
        ModelAndView mav = new ModelAndView("user_form");
        mav.addObject("user", user);

        List<Role> roles = (List<Role>) roleRepository.findAll();

        mav.addObject("allRoles", roles);

        return mav;
    }
}

