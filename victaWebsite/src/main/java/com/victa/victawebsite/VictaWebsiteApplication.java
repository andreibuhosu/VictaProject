package com.victa.victawebsite;

import com.victa.victawebsite.model.Roles;
import com.victa.victawebsite.model.User;
import com.victa.victawebsite.repository.RolesRepo;
import com.victa.victawebsite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Set;

@SpringBootApplication
public class VictaWebsiteApplication implements ApplicationRunner {
    @Autowired
    private RolesRepo rolesRepo;
    @Autowired
    private UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(VictaWebsiteApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Roles SystAdmin = new Roles();
        SystAdmin.setRole("System Admin");
        rolesRepo.save(SystAdmin);

        Roles AdminAssistant = new Roles();
        AdminAssistant.setRole("Admin Assistant");
        rolesRepo.save(AdminAssistant);

        Roles SeniorDoctor = new Roles();
        SeniorDoctor.setRole("Senior Doctor");
        rolesRepo.save(SeniorDoctor);

        Roles Lecturer = new Roles();
        Lecturer.setRole("Lecturer");
        rolesRepo.save(Lecturer);

        Roles Clerk = new Roles();
        Clerk.setRole("Clerk");
        rolesRepo.save(Clerk);

        Roles Student = new Roles();
        Student.setRole("Student");
        rolesRepo.save(Student);

        Roles PublicVisitor = new Roles();
        PublicVisitor.setRole("Public Visitor");
        rolesRepo.save(PublicVisitor);

        User testdoctor = new User();
        testdoctor.setFirstName("test");
        testdoctor.setLastName("doctor");
        testdoctor.setHashPassword("test");
        testdoctor.setEmail("testdoctor@le.ac.uk");
        testdoctor.setUsername("testdoctor");
        testdoctor.setRole(Student);
        userRepo.save(testdoctor);

        User teacher = new User();
        teacher.setFirstName("Henry");
        teacher.setLastName("Smith");
        teacher.setHashPassword("teacher");
        teacher.setEmail("mrleftgamer@gmail.com");
        teacher.setUsername("Mr Henry");

        teacher.setRole(Lecturer);
        userRepo.save(teacher);




    }




}
