package _06_Inherittance.Exercises;

public class Circle {
    private double radius;
    private String color;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Circle(){

    }
    public Circle(double radius){
        this.radius= radius;
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double GetArea(){
        return this.radius*2*3.14;
    }

    @Override
    public String toString() {
        return "Circle";
    }
}

class Cylinder extends Circle{
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double GetVolume(){
        return getRadius()*2*3.14*this.height;
    }

    @Override
    public String toString() {
        return "Cylinder";
    }
}

class Test{
    public static void main(String[] args) {
        Cylinder cyl = new Cylinder(2,"blue",5);
        System.out.println(cyl.GetVolume());
        System.out.println(cyl);
    }
}