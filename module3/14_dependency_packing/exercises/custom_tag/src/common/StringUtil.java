package common;

import java.util.Optional;
import java.util.regex.Pattern;

public class StringUtil {
    public static String insert_query = "insert into %s (%s) values (%s)";
    public static String select_query = "select id,%s from %s";
    public static String delete_query = "delete from %s where id = ?";
    public static String update_query = "update %s set %s where id = ?";
    public static String search_by_query = "select id, %s from %s where ?by regexp binary '?value'";
    public static String create_tbl_query= "create table if not exists %s(id int primary key auto_increment %s)";
    public static String[] tmpCols;
    public static String tmpTblName;
    private static final Pattern patternIsNumber = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static int parseIntegerOrDefault(String val){
        return Optional.ofNullable(val).filter(i->!i.isEmpty() && patternIsNumber.matcher(val).matches()).map(Integer::valueOf).orElse(0);
    }
}
