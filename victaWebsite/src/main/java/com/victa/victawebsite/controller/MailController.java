package com.victa.victawebsite.controller;

import com.victa.victawebsite.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MailController {

    @Autowired
    EmailSenderService emailSenderService;



    @RequestMapping("/mail")
    public String sendMail(HttpServletRequest session, Model model){
        emailSenderService.sendEmail("mrleftgamer@gmail.com","New Test to grade","Please login and grade a test");
        session.getSession().setAttribute("mailMessage", "Check your email");
        return "redirect:/dashboard";
    }
}
