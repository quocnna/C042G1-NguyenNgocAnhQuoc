package common;

public class UsingAnotation {
    @MyAnotation(dateOfBirth = "1980-06-25")  //Gán trước một field
    private int myAge = 22;

    @MyAnotation(dateOfBirth = "1980-06-25")   //Gán trước một method
    public void aMethod(){

    }
}
