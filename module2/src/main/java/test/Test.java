package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    private static int a = 1;


    public static void main(String[] args) {

    }
}
class Student {
    public static String testStatic = "hello";
    private int id;
    private String name;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

