package qtag;

import model.User;
import service.GeneralService;
import service.GeneralServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static common.StringUtil.*;

public class TableCRUD extends TagSupport {
    GeneralService users= new GeneralServiceImpl();
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    private String colums_display;

    public void setColums_display(String colums_display) {
        this.colums_display = colums_display;
    }

    @Override
    public int doStartTag() throws JspException {
        JspWriter out= pageContext.getOut();
        try {
            String className= "model."+name.replaceAll("(^.)", name.substring(0,1).toUpperCase());
            List<Field> fields= GetAllFields(Class.forName(className));

            String[] strings= colums_display.split(",");
            String paramCreateTable= "";
            for (int i = 0; i < strings.length; i++)
                paramCreateTable+=String.format(",%s varchar(50)",strings[i]);
            create_tbl_query= String.format(create_tbl_query,name,paramCreateTable);


            select_query= String.format(select_query,colums_display,name);

            String paramForInsert="?";
            for (int i = 0; i < strings.length-1; i++)
                paramForInsert +=",?";
            insert_query= String.format(insert_query,name,colums_display,paramForInsert);

            delete_query= String.format(delete_query,name);

            String paramForUpdate="";
            for (int i = 0; i < strings.length; i++)
                paramForUpdate+= strings[i]+"=?,";
            update_query= String.format(update_query,name,paramForUpdate.substring(0,paramForUpdate.length()-1));

            search_by_query= String.format(search_by_query,colums_display,name);

            List<User> list = users.getAll();
            ServletRequest request= pageContext.getRequest();
            tmpCols= strings;
            tmpTblName= name;
            request.setAttribute("tblName", name);
            request.setAttribute("columns", tmpCols);
            request.setAttribute("list", list);
            request.getRequestDispatcher("general.jsp");
            pageContext.include("general.jsp");

        } catch (IOException |ClassNotFoundException | ServletException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    private static List<Field> GetAllFields(Class clazz) {
        if (clazz == null) {
            return Collections.emptyList();
        }
        List<Field> result = new ArrayList<>(GetAllFields(clazz.getSuperclass()));
        List<Field> filteredFields = Arrays.stream(clazz.getDeclaredFields())
                .collect(Collectors.toList());
        result.addAll(filteredFields);
        return result;
    }
}
