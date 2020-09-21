package com.example.blog.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
//    @Autowired
//    private CategoryService categoryService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
//        List<Category> t= categoryService.getAll();
        return "0708230984".equals(value);
    }
}
