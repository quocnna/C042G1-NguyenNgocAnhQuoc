package com.example.exam_second.common;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

@Configurable
public class DateValidImpl implements ConstraintValidator<DateValid, LocalDate> {
    @Override
    public void initialize(DateValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        LocalDate firstDate = LocalDate.of(1000, 01, 01);
        return !value.equals(firstDate);
    }
}
