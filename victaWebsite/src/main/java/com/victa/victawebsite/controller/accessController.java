package com.victa.victawebsite.controller;


import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.userConsul;
import com.victa.victawebsite.repository.UserRepo;
import com.victa.victawebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class accessController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/view/accessgrade")
    public String accessGrade(Model Model, HttpSession session , HttpServletRequest request) {
        Object USER_SESSION = session.getAttribute("USER_SESSION");
        if (USER_SESSION == null) {
            session.setAttribute("message", "You need to login to access the dashboard");
            return "redirect:/login";
        }

        User OldUser = (User) USER_SESSION;
        Optional<User> theUser = userRepo.findById(OldUser.getID());

        if (OldUser.getRole().getRole().equals("Lecturer")) {

            return "manageCases";
        }

        System.out.println(OldUser.getRole().getID());
        request.getSession().setAttribute("mailMessage", "You do not have clearance to access this. ");
        return "redirect:/dashboard";
    }
    @RequestMapping("/view/unmarked")
    public String unmarked(Model model, HttpSession session , HttpServletRequest request) {

        model.addAttribute("findunMarked",userRepository.findunMarked());

        return "unmarked";
    }

    @RequestMapping("/view/marked")
    public String marked(Model model, HttpSession session , HttpServletRequest request) {
        if(userRepository.findMarked().isEmpty()){
            request.getSession().setAttribute("mailMessage", "No Cases have been marked ");
            return "redirect:/dashboard";
        }

        model.addAttribute("findMarked",userRepository.findMarked());
        return "marked";
    }

    @RequestMapping("/view/unmarked/usercase/{usercaseid}")
    public String unmarkedCases(@ModelAttribute("userConsul") userConsul userConsul,Model model, HttpSession session , HttpServletRequest request,@PathVariable("usercaseid") int usercaseid) {

        model.addAttribute("userCase",userRepository.findunmarkedByID(usercaseid));
        model.addAttribute("patient",userRepository.findByID(userRepository.findunmarkedByID(usercaseid).getPatientid()));
        return "unmarkedUserCase";

    }

    @RequestMapping("/view/marked/usercase/{usercaseid}")
    public String markedCases(@ModelAttribute("userConsul") userConsul userConsul,Model model, HttpSession session , HttpServletRequest request,@PathVariable("usercaseid") int usercaseid){
        model.addAttribute("userCase",userRepository.findunmarkedByID(usercaseid));
        model.addAttribute("patient",userRepository.findByID(userRepository.findunmarkedByID(usercaseid).getPatientid()));
        return "markedUserCase";
    }
}
