package com.example.springApp.api;

import com.example.springApp.exceptions.EmailTakenException;
import com.example.springApp.exceptions.UsernameTakenException;
import com.example.springApp.model.Bird;
import com.example.springApp.model.RegistrationUser;
import com.example.springApp.service.AuthenticationService;
import com.example.springApp.service.RegistrationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @PostMapping(path= "/register")
    public String userRegistration(RegistrationUser user, BindingResult bindingResult, ModelMap model){
        if(bindingResult.hasErrors()){
            return "login";
        }
        try {
            registrationService.register(user);
        }catch (EmailTakenException e){
            bindingResult.rejectValue("email", "userData.email","An account already exists for this email.");
        }catch (UsernameTakenException e){
            bindingResult.rejectValue("username", "userData.username","An account already exists for this username.");
        }

        return "login";
    }
}
