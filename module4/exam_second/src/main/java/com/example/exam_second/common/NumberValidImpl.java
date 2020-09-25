package com.example.exam_second.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberValidImpl implements ConstraintValidator<NumberValid,Double> {
    @Override
    public void initialize(NumberValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
//        if(value<1000.0)
//            return false;
        return value!=-1.0 || value>1000.0;
    }
}
