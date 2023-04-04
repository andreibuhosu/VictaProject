package com.victa.victawebsite.controller;

import com.victa.victawebsite.model.UserLogin;
import com.victa.victawebsite.model.UserSignup;
import com.victa.victawebsite.repository.UserRepo;
import com.victa.victawebsite.validator.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new LoginValidator(userRepo));
    }



    @GetMapping("/login")
    public String LoginForm(@ModelAttribute UserLogin userLogin, Model model,HttpSession session) {

        model.addAttribute("message",session.getAttribute("message"));
        model.addAttribute("userLogin",new UserLogin());
        return "user/Login";

    }

    @PostMapping("/login")
    public String Login(@Valid @ModelAttribute("userLogin") UserLogin userLogin, BindingResult result, HttpServletRequest request, Model model){
        if (result.hasErrors()) {
            model.addAttribute("message","Please fix any errors");
            return "user/Login";
        }
        else{
            request.getSession().setAttribute("USER_SESSION",userRepo.findByUsername(userLogin.getUsername()).get(0));

            return "redirect:/dashboard";

        }

    }

    @GetMapping("/logout")
    public String destorySession(HttpServletRequest request){

        request.getSession().invalidate();
        return "redirect:/home";
    }


}
