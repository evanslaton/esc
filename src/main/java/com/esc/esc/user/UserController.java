package com.esc.esc.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ApplicationUserRepository ApplicationUserRepo;

    // Serves the home page (which is also the login page)
    @GetMapping(value="/")
    public String serveHomePage() {
        return "index";
    }

    // Serves the signup page
    @GetMapping(value="/signup")
    public String serveSignUpPage() {
        return "signup";
    }

    // Creates a new user, logs the new user in and redirects the user to their profile page
    @PostMapping(value="/signup")
    public RedirectView createNewUser(@RequestParam String username,
                                @RequestParam String password,
                                @RequestParam String phoneNumber) {

        // Create a new user and saves the new user to the database
        ApplicationUser newUser = new ApplicationUser(username, bCryptPasswordEncoder.encode(password), phoneNumber);
        ApplicationUserRepo.save(newUser);


        // Logs new users in immediately after creating an account
        Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");
    }

    // Serves the user's profile page
    @GetMapping(value="/profile")
    public String serveProfilePage() {
        return "profile";
    }
}
