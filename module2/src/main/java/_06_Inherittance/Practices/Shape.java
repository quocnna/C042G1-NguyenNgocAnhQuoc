package _06_Inherittance.Practices;
import _07_Abstract_Interface.Exercises.*;
public class Shape {
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    private String color;
    private boolean filled;

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {
        this.color = "green";
        this.filled = true;
    }

    @Override
    public String toString() {
        return "A Shape with color of xxx and filled/not filled";
    }
}

class Circle extends Shape implements Resizeable  {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void Resize(double percent) {
        radius*=percent/100;
    }
}

class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.height = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * this.height;
    }

    public double getPerimeter() {
        return 2 * (width + this.height);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void Resize(double percent) {
        width*=percent/100;
        height *=percent/100;
    }
}

class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void Resize(double percent) {
        super.Resize(percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}

class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);

        square = new Square(2.3);
        System.out.println(square);

        square = new Square(5.8, "yellow", true);
        System.out.println(square);
    }
}