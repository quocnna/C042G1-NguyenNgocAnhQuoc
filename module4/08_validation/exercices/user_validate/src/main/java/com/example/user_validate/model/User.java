package com.example.user_validate.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Data
public class User {
    @Length(min = 5, max= 45, message = "length from 5 to 45")
    private String firstName;
    @Length(min = 3, max= 45, message = "length from 3 to 25")
    private String lastName;
    @Pattern(regexp = "\\d{10}", message = "must be of 10 digit")
    private String phone;

    @Min(value = 18, message = "min 18")
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "must be email")
    private String email;
}
