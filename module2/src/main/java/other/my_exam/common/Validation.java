package other.my_exam.common;

import com.opencsv.exceptions.CsvException;
import other.my_exam.exception.NotFoundProductException;
import other.my_exam.service.ProductExportManager;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    private static final String PRICE = "\\d+(\\.\\d+)?";
    public static boolean Check(String fieldName, String value) throws NotFoundProductException, IOException, CsvException {
        if(fieldName.equals("CodeProduct")){
            if(value.isEmpty())
                throw new NotFoundProductException("Not found this code");
            ProductExportManager productExportManager = new ProductExportManager();
            List<String[]> list = productExportManager.Read();
            boolean res=false;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i)[1].equals(value)){
                    res= true;
                    break;
                }
            }
            if(!res)
                throw new NotFoundProductException("Not found this code");
        }

        final String regex= fieldName.equals("Price") || fieldName.equals("Quantity") || fieldName.equals("Price Export") ||
                fieldName.equals("Price Import")? PRICE:"";
        if (!regex.equals(""))
            return validate(regex,value);
        return true;
    }

    private static boolean validate(String regex,String input){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
