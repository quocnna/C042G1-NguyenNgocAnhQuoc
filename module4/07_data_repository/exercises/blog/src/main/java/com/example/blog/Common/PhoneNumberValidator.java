package com.example.blog.Common;

import org.springframework.beans.factory.annotation.Configurable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "0708230984".equals(value);
    }
}
