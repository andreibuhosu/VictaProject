package com.victa.victawebsite.validator;

import com.victa.victawebsite.model.UserSignup;
import com.victa.victawebsite.repository.UserRepo;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;

import java.util.Objects;

public class SignUpValidator implements Validator {

    private final UserRepo userRepo;

    public SignUpValidator(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserSignup.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstname","","Firstname needed");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastname","","Lastname needed needed");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","","Username needed");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Password needed");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password2","Re enter password");

        if (errors.hasErrors()){
            return;
        }

        UserSignup user = (UserSignup) target;

        if (!Objects.equals(user.getPassword(),user.getPassword2())) {
            errors.rejectValue("password2","","Passwords do not match");

        }

    }
}
