package test_package;

public class Main {
    public static void main(String[] args) {
        Greeter greeter= new HelloWorld();
        String actual= greeter.geeter();
        String expected= "Hello Quoc";
        String assertResult = expected.equals(actual) ? "PASS" : "FAIL";
        String message = String.format("testGreet: %s, expected: <%s>, actual: <%s>", assertResult, expected, actual);
        System.out.println(message);
    }
}
