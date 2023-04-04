package com.victa.victawebsite.controller;

import com.victa.victawebsite.EmailSenderService;
import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.UserSignup;
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
public class Consultation {
	@Autowired
	UserRepository userRepository;
	UserRepo userRepo;

	@Autowired
	EmailSenderService emailSenderService;

	@RequestMapping("/cons/{id}")
	public String cons( @ModelAttribute("userConsul") userConsul userConsul ,@PathVariable("id") int id, HttpSession session , HttpServletRequest request, Model model) {
		Object USER_SESSION = session.getAttribute("USER_SESSION");
		if (USER_SESSION == null) {
			session.setAttribute("message", "You need to login to access the Consultation page");
			return "redirect:/login";
		}
		model.addAttribute("patient",userRepository.findByID(id));
		model.addAttribute("consultationData",userRepository.getConData());
		model.addAttribute("userConsul",new userConsul());
		System.out.println(userRepository.getConData());
		return "consultation";
	}

	@RequestMapping("/saveConsultation/{id}")
	public String saveConsultation(@ModelAttribute("userConsul") userConsul userConsul,HttpSession session,Model model,@PathVariable("id") int patientID,HttpServletRequest servletRequest){
		Object USER_SESSION = session.getAttribute("USER_SESSION");
		if (USER_SESSION == null) {
			session.setAttribute("message", "You need to login to access the Consultation page");
			return "redirect:/login";
		}
		User OldUser = (User) USER_SESSION;

		int userId = OldUser.getID();

		emailSenderService.sendEmail("joshuacampbell49@yahoo.co.uk","New Test to grade","Please login to Victa and go to manage cases. There is a new student case to mark.");
		userRepository.insertIntoUserCase(userConsul.getEpidemiology(),userConsul.getComplaints(),userConsul.getExamination(),userConsul.getDiagnosis1(),userConsul.getDiagnosis2(),userConsul.getDiagnosis3(),patientID,userId,userConsul.getMessage());

		servletRequest.getSession().setAttribute("mailMessage", "Case submitted. Check back in a few days as the teacher needs to mark it.");
		return "redirect:/dashboard";

	}
	

}
