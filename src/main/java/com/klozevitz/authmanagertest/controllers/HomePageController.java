package com.klozevitz.authmanagertest;

import com.klozevitz.authmanagertest.dao.RoleDAO;
import com.klozevitz.authmanagertest.model.Role;
import com.klozevitz.authmanagertest.model.User;
import com.klozevitz.authmanagertest.service.securityService.SecurityServiceImplementation;
import com.klozevitz.authmanagertest.service.userService.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {
    @Autowired
    UserServiceImplementation userServiceImplementation;
    @Autowired
    SecurityServiceImplementation securityServiceImplementation;
    @Autowired
    RoleDAO roleDAO;

    @GetMapping("/")
    public String homePage() {
        baseInit();
        return "index";
    }

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        model.addAttribute("isAuth", securityServiceImplementation.login(username, password));
        return "index";
    }

    @GetMapping("/admin")
    public String admin_page() {
        return "admin_page";
    }

    @GetMapping("/user")
    public String user_page() {
        return "user_page";
    }

    @GetMapping("/loser")
    public String loser_page() {
        return "loser_page";
    }

    private void baseInit() {
        rolesTableInit();
        usersTableInit();
    }


    @GetMapping("/tupichok")
    public String tupichok() {
        return "tupichok";
    }

    private void usersTableInit() {
        if (userServiceImplementation.findByUserName("admin") == null) {
            userServiceImplementation.save(new User("admin", "admin", null), 1L);
            userServiceImplementation.save(new User("user", "user", null), 2L);
            userServiceImplementation.save(new User("loser", "loser", null), 3L);
        }
    }

    private void rolesTableInit() {
        if(roleDAO.findById(1L).orElse(null) == null){
            roleDAO.save(new Role(1L, "ROLE_ADMIN"));
            roleDAO.save(new Role(2L, "ROLE_USER"));
            roleDAO.save(new Role(3L, "ROLE_LOSER"));
        }
    }
}
