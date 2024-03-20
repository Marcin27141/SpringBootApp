package com.example.springApp.api;

import com.example.springApp.exceptions.EmailTakenException;
import com.example.springApp.exceptions.PasswordsNotEqualException;
import com.example.springApp.exceptions.UsernameTakenException;
import com.example.springApp.model.Bird;
import com.example.springApp.model.RegistrationUser;
import com.example.springApp.service.AuthenticationService;
import com.example.springApp.service.RegistrationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("username")
public class LoginController {
    private final RegistrationService registrationService;
    private final AuthenticationService authService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public LoginController(RegistrationService registrationService, AuthenticationService authService) {
        this.registrationService = registrationService;
        this.authService = authService;
    }

    @GetMapping("login")
    public String onGetLogin(ModelMap model) {
        model.put("registrationUser", new RegistrationUser());
        return "login";
    }

    @GetMapping("/login-error")
    public String login(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            AuthenticationException ex = (AuthenticationException) session
                    .getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (ex != null) {
                model.addAttribute("loginFailed", "Username or password are incorrect");
            }
        }
        model.put("registrationUser", new RegistrationUser());
        return "login";
    }

    @PostMapping(path= "/register")
    public String userRegistration(RegistrationUser user, BindingResult bindingResult, ModelMap model){
        if(bindingResult.hasErrors()){
            model.addAttribute("registrationFailed", "Registration failed");
        } else {
            try {
                registrationService.register(user);
                model.addAttribute("registrationSuccessful", "Registration was successful. You can now log in.");
            }catch (EmailTakenException e){
                model.addAttribute("registrationError", "Registration failed: this email is already taken");
            }catch (UsernameTakenException e){
                model.addAttribute("registrationError", "Registration failed: this username is already taken");
            } catch (PasswordsNotEqualException e){
                model.addAttribute("registrationError", "Registration failed: passwords were not equal");
            }

        }

        model.put("registrationUser", new RegistrationUser());
        return "login";
    }
}
