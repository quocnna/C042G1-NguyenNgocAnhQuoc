package _07_Abstract_Interface.Exercises;
import _04_Class_Object.Practices.Rectangle;
import _06_Inherittance.Exercises.Circle;
import _06_Inherittance.Practices.*;
public interface Resizeable {
    void Resize(double percent);
}
class ResizeableTest{
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
//        shapes[0] = new Circle(5);
//        shapes[1] = new Recta(2, 5);
//        shapes[2] = new Circle(20);
//        System.out.println("Before resize: ");
//        for (Shape shape: shapes ) {
//            System.out.println(shape);
//        }
//        for (Shape shape: shapes) {
//            if(shape instanceof Circle) {
//                Circle c1 = (Circle)shape;
//                c1.resize(50);
//            } else if(shape instanceof Rectangle) {
//                Rectangle r1 = (Rectangle)shape;
//                r1.resize(50);
//            } else {
//                Square s1 = (Square)shape;
//                s1.resize(50);
//            }
//        }
//        System.out.println("After resize: ");
//        for (Shape shape: shapes ) {
//            System.out.println(shape);
//        }
    }
}
