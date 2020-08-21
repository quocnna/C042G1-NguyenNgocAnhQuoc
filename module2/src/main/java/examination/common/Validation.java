package examination.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String PHONE = "^\\d{10}$";
    private static final String EMAIL = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$";
    private static final String NUMBER= "^[0-7]$";
    public static boolean Check(String fieldName,String value){
        if(value.isEmpty())
            return false;
        String regex = fieldName.equals("Email")?EMAIL:fieldName.equals("Number")?NUMBER:fieldName.equals("Phone Number")?PHONE:"";
        if(!regex.isEmpty())
            return validate(regex,value);
        return true;
    }
    private static boolean validate(String regex,String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
