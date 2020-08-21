package _05_AccessModifier.Practices;

public class StaticMethod {
    private int rollno;
    private String name;
    static String change() {
        return "CODEGYM";
    }
}
final class TestStatic{
    public static void main(String[] args) {
        System.out.println(StaticMethod.change());
    }
}
