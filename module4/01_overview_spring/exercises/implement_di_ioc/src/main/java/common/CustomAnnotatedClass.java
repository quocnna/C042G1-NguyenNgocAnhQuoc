package common;


public class CustomAnnotatedClass {
    @CustomAnnotation(dateOfBirth = "2020-05-05")
    public void testMT(){
        System.out.println("aaa");
    }
}