package _06_Inherittance.Exercises;
import _06_Inherittance.Practices.*;
public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(){
        super();
        side1=1;
        side2=1;
        side3=1;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double GetArea(){
        double p = GetPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
    public double GetPerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                "color: "+getColor()+
                "Perimeter: "+GetPerimeter()+
                "Area: "+GetArea()+
                '}';
    }
}
class TestTriangle{
    public static void main(String[] args) {
        Triangle t= new Triangle(5,10,15);
        t.setColor("yellow");
        System.out.println(t);
    }
}
