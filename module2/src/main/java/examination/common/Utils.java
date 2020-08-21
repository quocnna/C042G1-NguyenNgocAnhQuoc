package examination.common;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {
    private static Scanner scanner = new Scanner(System.in);
    public static HashMap<String, String> InputFields(Class cls, boolean isFirst) throws IOException, CsvException {
        HashMap result = new HashMap<String, String>();
        List<Field> fields = GetAllFields(cls);
        for (int i = 0; i < fields.size(); i++) {
            if(i==0 && isFirst)
                continue;
            String fieldName = fields.get(i).getName();
            Pattern pattern = Pattern.compile("(^.)");
            Matcher matcher = pattern.matcher(fieldName);
            if (matcher.find()) {
                String tmp = fieldName.replaceAll("(\\p{javaUpperCase})", " $1");
                String firstChar = matcher.group(1);
                fieldName = tmp.replaceAll("(^.)", firstChar.toUpperCase());
            }
            String value = "";
            int count = 0;
            do {
                System.out.print(count != 0 ? "Please input again " + fieldName + " with correct format: " : "Input " + fieldName + ": ");
                value = scanner.nextLine();
                count++;
            } while (!Validation.Check(fieldName, value));
            count = 0;

            result.put(fieldName, value);
        }
        return result;
    }

    public static List<Field> GetAllFields(Class clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }
        List<Field> result = new ArrayList<>(GetAllFields(clazz.getSuperclass()));
        List<Field> filteredFields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toList());
        result.addAll(filteredFields);
        return result;
    }

    public static String GetNumberChoice() {
        String result;
        int count = 0;
        do {
            System.out.print(count == 0 ? "Please input your choice: " : "Please input again your choice with correct format: ");
            result = scanner.nextLine();
            count++;
        } while (!Validation.Check("Number", result));

        return result;
    }
}
