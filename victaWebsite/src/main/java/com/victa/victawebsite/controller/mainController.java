package com.victa.victawebsite.controller;

import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.feedbackForm;
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
import java.util.Optional;

@Controller
public class mainController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/view/feedbackGiven/{usercaseid}")
    public String givenFeedback(@ModelAttribute("feedbackForm") feedbackForm feedbackForm, Model model, HttpSession session , HttpServletRequest request, @PathVariable("usercaseid") int usercaseid){

        userRepository.insertIntoFeedback(feedbackForm.getGrade(),feedbackForm.getMessage(),usercaseid,userRepository.findunmarkedByID(usercaseid).getUserid());
        userRepository.updateUnmarkedToMarked(usercaseid);

        return "redirect:/dashboard";
    }

    @RequestMapping("/view/feedbackhomepage/{userid}")
    public String viewfeedback(Model model, HttpSession session , HttpServletRequest request,@PathVariable("userid") int userid){

        Object USER_SESSION = session.getAttribute("USER_SESSION");
        if (USER_SESSION == null) {
            session.setAttribute("message", "You need to login to access the feedback");
            return "redirect:/login";
        }

        model.addAttribute("ListOfFeedback",userRepository.findFeedbackByID(userid));



        return "feedbackhomepage";
    }

    @RequestMapping("/view/feedbackreport/{usercaseid}")
    public String viewIndividualFeedback(Model model, HttpSession session , HttpServletRequest request,@PathVariable("usercaseid") int usercaseid){

        Object USER_SESSION = session.getAttribute("USER_SESSION");
        if (USER_SESSION == null) {
            session.setAttribute("message", "You need to login to access the feedback");
            return "redirect:/login";
        }

        model.addAttribute("feedback",userRepository.findIndividualFeedback(usercaseid));



        return "feedbackreport";
    }


    @RequestMapping("/view/feedback/{usercaseid}")
    public String feedback(@ModelAttribute("feedbackForm") feedbackForm feedbackForm, Model model, HttpSession session , HttpServletRequest request, @PathVariable("usercaseid") int usercaseid) {
        model.addAttribute("userCase",userRepository.findunmarkedByID(usercaseid));
        model.addAttribute("feedbackForm",new feedbackForm());
        return "feedback";
    }


    @RequestMapping("/dashboard")
    public String dashboard(Model model, HttpSession session , HttpServletRequest request) {

        Object USER_SESSION = session.getAttribute("USER_SESSION");
        if (USER_SESSION == null) {
            session.setAttribute("message", "You need to login to access the dashboard");
            return "redirect:/login";
        }
        User OldUser = (User) USER_SESSION;
        Optional<User> theUser = userRepo.findById(OldUser.getID());
        model.addAttribute("userid",theUser.get().getID());
        model.addAttribute("message",theUser.get().getFirstName());
        model.addAttribute("mailMessage",session.getAttribute("mailMessage"));
        session.removeAttribute("mailMessage");

        return "dashboard";
    }

    @RequestMapping("/patientList")
    public String test(Model model) {

        System.out.println(userRepository.findAllUsers());

        model.addAttribute("users",userRepository.findAllUsers());
        return "patientList";
    }



}
