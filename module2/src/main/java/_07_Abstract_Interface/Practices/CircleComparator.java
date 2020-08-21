package _07_Abstract_Interface.Practices;
import _06_Inherittance.Exercises.Circle;

import java.util.*;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return o1.getRadius()>o2.getRadius()?1:o1.getRadius()<o2.getRadius()?-1:0;
    }
}
class CircleComparatorTest{
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "blue");

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle.getRadius());
        }
        Comparator c = Comparator.comparing(Circle::getRadius);
//        Comparator c = new CircleComparator();
        Arrays.sort(circles, c);
        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle.getRadius());
        }

        Comparator circleComparator = new CircleComparator();
        ArrayList<Circle> arc = new ArrayList<>(Arrays.asList(circles));
        double t = Collections.max(arc,circleComparator).getRadius();
        System.out.println("Max collection is: "+t);
        //IntStream.of
    }
}
