package com.example.springApp.api;

import com.example.springApp.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("username")
public class LoginController {
    private final AuthenticationService authService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    @GetMapping("login")
    public String onGetLogin() {
        return "login";
    }

    @PostMapping("login")
    public String onPostLogin(@RequestParam String username, @RequestParam String password, ModelMap model) {
        if (authService.authenticate(username, password))
            return "redirect:/";
        else {
            logger.warn("Username {} failed to log in", username);
            model.put("loginFailed", "Username or password are incorrect");
            return "login";
        }
    }
}
