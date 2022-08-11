package kz.xodbar.bitlabadvancedspringcoursesproject.api.mvc.user;

import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam("email") String email,
                         @RequestParam("password") String password,
                         @RequestParam("full_name") String fullName) {

        userService.addNewUser(new User(null, email, password, fullName, null));
        return "redirect:/login";
    }

}
