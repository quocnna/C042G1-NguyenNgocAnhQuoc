package _05_AccessModifier.Practices;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AccessModifier {
    protected void msg(){System.out.println("Hello");}
}

final class Test extends AccessModifier {
    public static void main(String[] args) {
        AccessModifier a= new AccessModifier();
        a.msg();
    }
}
