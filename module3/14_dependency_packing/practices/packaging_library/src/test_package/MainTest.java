package test_package;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void testGreet() {
        Greeter greeter = new HelloWorld();
        String actual = greeter.geeter();
        String expected = "Hello world!";
//        String expected = "Welcome to the world";
        assertEquals(expected, actual);
    }
}
