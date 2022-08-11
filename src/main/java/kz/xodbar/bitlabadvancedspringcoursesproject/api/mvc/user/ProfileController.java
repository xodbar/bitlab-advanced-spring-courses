package kz.xodbar.bitlabadvancedspringcoursesproject.api.mvc.user;

import kz.xodbar.bitlabadvancedspringcoursesproject.entity.user.User;
import kz.xodbar.bitlabadvancedspringcoursesproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/profile/")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getProfile(Model model) {
        if (getCurrentUser() != null) {
            model.addAttribute("CURRENT_USER", getCurrentUser());
            return "profile";
        } else return "index";
    }

    @PostMapping("/edit")
    public String getProfile(@RequestParam("new_full_name") String fullName,
                             @RequestParam("new_email") String email,
                             @RequestParam("new_password_repeat") String passwordRepeat,
                             @RequestParam("new_password") String password) {

        if (getCurrentUser() != null && password.equals(passwordRepeat)) {
            User currentUser = getCurrentUser();
            currentUser.setFullName(fullName);
            currentUser.setPassword(password);
            currentUser.setEmail(email);

            userService.updateUser(currentUser);
        }

        return "redirect:/api/profile/";
    }

    public static User getCurrentUser() {
        Object userDetail = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDetail instanceof User)
            return (User) userDetail;
        else return null;
    }

}
