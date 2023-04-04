package com.victa.victawebsite.validator;//package com.victa.victawebsite.validator;

import com.victa.victawebsite.model.User;
import com.victa.victawebsite.model.UserLogin;
import com.victa.victawebsite.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.List;
import java.util.Objects;

public class LoginValidator implements Validator {

    private final UserRepo userRepo;

    public LoginValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserLogin.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","","Username needed");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","","Password needed");

        if(errors.hasErrors()){
            return;
        }

        UserLogin user = (UserLogin) target;

        List<User> users = userRepo.findByUsername(user.getUsername());
        if(users.size() !=1){
            errors.rejectValue("password", "", "Invalid username and or password");
            return;
        }

        if(!Objects.equals(users.get(0).getHashPassword(), user.getPassword())) {
            errors.rejectValue("password", "", "Invalid username and or password");
            return;
        }

    }



}
