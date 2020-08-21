package other;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;

public class TestC {
    public static void main(String[] args) {
        Student st = new Student("abc");
        System.out.println(st);
//        if (!Pattern.matches("([A-Z][a-z]*)([\\s][A-Z][a-z]*)*", name)) {
//            throw new NameException("The first character in each word must be uppercase");
//        }
//        if (!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[-/.](19[0-9][0-9]|200[012])$",
//                dateOfBirth)) {
//            throw new BirthdayException("Date of birth must be dd/mm/yyyy. Year must be greater than 1900. " +
//                    "Your age must be at least 18.");
//        }
//
//        7:55
//        if (!Pattern.matches("Male|Female|Unknown", sex)) {
//            throw new GenderException("Sex must be Male, Female or Unknown");
//        }
//
//        7:56
//        if (!Pattern.matches(
//                "^[\\d]{9}$", identityNumber)) {
//            throw new IDCardException("ID must me 9 digits");
//        }
//        this.identityNumber = identityNumber;
//
//        7:57
//        if (!Pattern.matches("^\\w+@\\w+[.]\\w+([.]\\w+)?$", email)) {
//            throw new EmailException("Email must be ex: abc@abc.abc or abc@abc.abc.abc");
//        }
//        if (!Pattern.matches("^Diamond|Platinium|Gold|Silver|Member$", typeCustomer)) {
//            throw new TypeCustomerException("Type customer must be: Diamond, Platinium, Gold, Silver, Member");
//        }



//            System.out.println(i);
//        //assertThat(hashmap.keySet(), containsInAnyOrder(1, 2, 3));
//    }
//        Map<Integer, String> treemap = new TreeMap<>();
//        treemap.put(3, "TreeMap");
//        treemap.put(2, "vs");
//        treemap.put(1, "HashMap");
//        treemap.put(24, "Quoc");
//        for(Integer i : treemap.keySet())
//            System.out.println(i);
//        HashMap<String, Integer> a = new HashMap<>();
//        a.put("e", 20);
//        a.put("d", 2);
//        a.put("a", 3);
//        a.put("c", 1);
//        a.put("d", 5);
//        a.put("b", 2);
//        System.out.println(a);
//        Set<String> st = a.keySet();
//        for (Map.Entry<String, Integer> b : a.entrySet()) {
//            System.out.println(b.getKey() + " " + b.getValue());
//        }

//        for(String key : st)
//            System.out.println(key);

//        for (int i = 0; i < a.entrySet().size(); i++) {
//            System.out.println(a);
//        }

        //}


    }
}
class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "name"+ name;
    }
}
