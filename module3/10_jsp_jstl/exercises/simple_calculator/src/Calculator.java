import java.util.Optional;
import java.util.regex.Pattern;

class Calculator {
    private static final Pattern patternIsDouble = Pattern.compile("-?\\d+(\\.\\d+)?");
    protected static double calculator(double f, double s, String o) throws DivisionException {
        double res = 0;
        switch (o) {
            case "Addition":
                res = f+s;
                break;
            case "Subtraction":
                res = f-s;
                break;
            case "Multiplication":
                res = f*s;
                break;
            case "Division":
                if(s==0)
                    throw new DivisionException("Division with denominator 0");
                res = f/s;
                break;
        }
        return res;
    }

    /* qg

    protected static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    protected boolean isNumericByRex(String strNum) {

        if (strNum == null) {
            return false;
        }
        return patternIsDouble.matcher(strNum).matches();
    }

    protected static double parseStringToDouble(String value, double defaultValue) {
        return value == null || value.isEmpty() ? defaultValue : Double.parseDouble(value);
    }

    // OptionalDouble
    protected static double parseStringToOptionalDouble(String value) {
        return Optional.ofNullable(value).filter(i->!i.isEmpty()).map(Double::valueOf).orElse(0.0);
//        return value == null || value.isEmpty() ? OptionalDouble.empty().empty() : OptionalDouble.of(Double.valueOf(value));
    }

     */

    protected static double parseDoubleOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsDouble.matcher(val).matches()).map(Double::valueOf).orElse(0.0);
    }
}
