package common;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
//Nó tồn tại trên mã nguồi và trình biên dịch không nhận ra
@Target(value = {ElementType.METHOD, ElementType.FIELD})
//Nó sẽ được dùng chú thích tren mot method
public @interface MyAnotation {
    public String name() default "aaa";
    public String dateOfBirth();
}
