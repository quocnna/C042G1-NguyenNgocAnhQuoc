package case_study.common;

import case_study.exception.BirthdayException;
import case_study.exception.EmailException;
import case_study.exception.NameException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

    public static boolean ValidateService(String fieldName, String input) {
        final String regexName = "^[A-Z][a-z]+$";
        final String regrexAreaUsed = "^([3-9]\\d)(\\.\\d+)?$|^([1-9][0-9]{2,})(\\.\\d+)?$";
        final String regexPrice = "^\\d+$";
        final String regexMaxPeople = "^(0?[1-9]|1\\d)$";
        final String regexId = "^SV(VL|HO|RO)-\\d{4}$";
        final String regexAccompaniedService = "^(massage[\\s]?|karaoke[\\s]?|food[\\s]?|drink[\\s]?|car[\\s]?|^no need$)+$";
        final String regex = fieldName.equals("Name") ? regexName : fieldName.equals("Area Used") ? regrexAreaUsed :
                fieldName.equals("Id")? regexId:fieldName.equals("Max People")?regexMaxPeople:fieldName.equals("Price")
                        ?regexPrice: fieldName.equals(regexAccompaniedService)?regexAccompaniedService:"";
        //note flag
        if (!regex.equals(""))
            return validate(regex,input);
        return true;
    }

    public static boolean ValidateCustomer(String type, String input) throws NameException, EmailException, BirthdayException {
        if("Full Name".equals(type)){
            final String outerSpaceRegex = "^\\s+([A-Za-z]+\\s*)+\\s*$";
            final String nameRegex = "^([A-Z][a-z]+\\s?)+$";
            if(!validate(outerSpaceRegex,input))
                throw new NameException("Wrong format space, please try again");
            else if(!validate(nameRegex,input))
                throw new NameException("Wrong format name, please try again");
        }
        else if("Email".equals(type)){
            final String emailRegex = "^([-\\w.])+[a-zA-Z\\d]@(\\w+\\.)+(\\w+)$";
            if(!Validation.validate(emailRegex, input))
                throw new EmailException("Wrong format email.");
        }
        else if("Birthday".equals(type)){
            final String birthdayRegex = "^((01|[0-2][2-9]|[1-3][01])\\/(0[13578]|1[02])|([0-2][1-9]|[1-3]0)\\/(11|0[469])|([0-2][1-9]|20|10)\\/(02))\\/((19\\d{2})|([2-9]\\d{3}))$";
            if(!Validation.validate(birthdayRegex, input))
                throw new BirthdayException("Wrong format date: dd/MM/yyyy and year must be > 1900");
        }

        return true;
    }
    private static boolean validate(String regex,String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
