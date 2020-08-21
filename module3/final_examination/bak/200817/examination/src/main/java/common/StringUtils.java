package common;

import java.util.Optional;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern patternIsNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static int parseIntegerOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsNumber.matcher(val).matches()).map(Integer::valueOf).orElse(0);
    }
}
