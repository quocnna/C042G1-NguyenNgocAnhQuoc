package com.example.exam_second.common;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class StringValidImpl implements ConstraintValidator<StringValid,String> {
    @Override
    public void initialize(StringValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return "0708230984".equals(value);
    }
}
