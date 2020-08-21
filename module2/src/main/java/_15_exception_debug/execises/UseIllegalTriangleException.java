package _15_exception_debug.execises;

public class UseIllegalTriangleException {
    public static void main(String[] args) {
        try{
            Triangle t= new Triangle(-1,2,3);
        }
        catch (IllegalTriangleException e){
            System.out.println(e.getMessage());
        }
    }
}
class Triangle{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        if(side1<0 || side2<0 || side3<0)
            throw new IllegalTriangleException("side <0");
        else if(side1>side2+side3 || side2>side1+side3 || side3>side1+side2)
            throw new IllegalTriangleException("sum 2 side< 1side");
    }
}
class IllegalTriangleException extends Exception{
//    public IllegalTriangleException(){
//        super("My message triangle exception: side smaller 0");
//        System.out.println("My message triangle exception: side smaller 0");
//    }
    public IllegalTriangleException(String message){
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
