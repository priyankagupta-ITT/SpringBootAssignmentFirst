package com.springboot.jpa.SpringBootAssignmentFirst.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValid,String> {

    Logger logger = LoggerFactory.getLogger(NameValidator.class);
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.isBlank())
        return false;
        else
            return true;
    }
}
