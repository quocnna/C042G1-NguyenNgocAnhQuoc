package _05_AccessModifier.Exercises;

class AccessModifier {
    private double radius=1.0;
    private String color= "red";

    public double getRadius() {
        return radius;
    }
    public double getArea(){
        return radius*radius*3.14;
    }

    public AccessModifier(double radius) {
        this.radius = radius;
    }
    public AccessModifier(){

    }
}
class TestAccessModifier{
    public static void main(String[] args) {
        AccessModifier a = new AccessModifier(10);
        System.out.println(a.getArea());
    }
}
