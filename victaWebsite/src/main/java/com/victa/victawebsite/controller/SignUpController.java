package com.victa.victawebsite.controller;

import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.UserSignup;
import com.victa.victawebsite.repository.UserRepo;
import com.victa.victawebsite.validator.SignUpValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class SignUpController {
    @Autowired
    private UserRepo userRepo;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new SignUpValidator(userRepo));}



    @GetMapping ("/signup")
    public String SignUpForm(@ModelAttribute UserSignup userSignup, Model model) {
        model.addAttribute("userSignup",new UserSignup());
        return "user/sign";

    }

    @PostMapping("/createAccount")
    public String CreateCustomer(@Valid @ModelAttribute("userSignup") UserSignup userSignup, BindingResult result, HttpServletRequest request, Model model){
        if(result.hasErrors()) {
            model.addAttribute("message","Please fix errors");
            return "user/sign";
        }

            User user = new User();
            user.setFirstName(userSignup.getFirstname());
            user.setLastName(userSignup.getLastname());
            user.setUsername(userSignup.getUsername());
            user.setEmail(userSignup.getEmail());
            user.setHashPassword(userSignup.getPassword());
            User save = userRepo.save(user);

            HttpSession theSession = request.getSession();
            theSession.setAttribute("USER_SESSION", user);
            return "redirect:/dashboard";
        }

    }

