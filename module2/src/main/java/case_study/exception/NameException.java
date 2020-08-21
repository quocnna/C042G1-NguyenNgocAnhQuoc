package case_study.exception;

import case_study.common.Validation;

public class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public static void check(String input) throws NameException {
        final String outerSpaceRegex = "^\\s+([A-Za-z]+\\s*)+\\s*$";
        final String nameRegex = "^([A-Z][a-z]+\\s?)+$";
        // check outer space

//        if(Validation.(outerSpaceRegex, input)) {
//            throw new NameException("Not valid Name, please try again.");
//        } else {
//            //check valid name
//            input = input.trim();
//            if(!Validation.validate(nameRegex, input)) {
//                throw new NameException("Not valid Name, please try again.!");
//            }
//        }
    }
}
