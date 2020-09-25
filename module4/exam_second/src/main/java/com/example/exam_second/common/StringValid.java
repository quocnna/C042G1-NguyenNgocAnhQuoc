package com.example.exam_second.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringValidImpl.class)
public @interface StringValid {
    String message() default "doesn't seem to be a valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
