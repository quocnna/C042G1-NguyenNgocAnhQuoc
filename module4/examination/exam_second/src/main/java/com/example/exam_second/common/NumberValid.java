package com.example.exam_second.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumberValidImpl.class)
public @interface NumberValid {
    String message() default "Price must be a number and greater than 100000";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
