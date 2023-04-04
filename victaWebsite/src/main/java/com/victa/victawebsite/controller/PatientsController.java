package com.victa.victawebsite.controller;

import com.victa.victawebsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PatientsController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/patientinfo/{id}")
    public String getPatientInfo(@PathVariable("id") int id, Model model) {
        System.out.println(userRepository.findByID(id));
        model.addAttribute("users",userRepository.findByID(id));

        return "patient_detail_view";
    }

    @GetMapping("/patienthistory/{id}")
    public String getPatientHistory(@PathVariable("id") int id,Model model) {
        model.addAttribute("allergies",userRepository.findAllergiesByID(id));
        model.addAttribute("past",userRepository.findHistoryByID(id));
        model.addAttribute("treatment",userRepository.findPastTreatmentByID(id));
        model.addAttribute("patientid",id);
        return "patient_history";
    }



}
