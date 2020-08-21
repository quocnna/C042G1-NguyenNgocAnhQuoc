package _04_Class_Object.Exercises;

import java.util.LinkedList;

public class a {
    public void M1(){
        System.out.println("m1");
    }
    public void M2(){
        System.out.println("m2");
    }
}

class aa extends a{
    @Override
    public final void M1() {

    }
}

class aaa extends aa{ }

class test{
    public static void main(String[] args) {
        aaa t = new aaa();
        t.M1();
    }
}
