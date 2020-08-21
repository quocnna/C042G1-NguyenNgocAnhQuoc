package common;

import java.util.Optional;
import java.util.regex.Pattern;

public class StringUtils {
    public static String jdbcURL;
    public static String jdbcUsername;
    public static String jdbcPassword;
    public static String filePath="C:\\";

    private static final Pattern patternIsNumber = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static int parseIntegerOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsNumber.matcher(val).matches()).map(Integer::valueOf).orElse(0);
    }
}
