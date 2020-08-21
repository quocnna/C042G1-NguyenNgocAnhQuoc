package _07_Abstract_Interface.Practices;
import _04_Class_Object.Practices.Rectangle;

import java.util.Arrays;

public class RectangleComparable extends Rectangle implements Comparable<Rectangle> {

    public RectangleComparable(double width, double height) {
        super(width, height);
    }

    @Override
    public int compareTo(Rectangle o) {
        if (getArea() > o.getArea()) return 1;
        else if (getArea() < o.getArea()) return -1;
        else return 1;
    }
}
class RectangleComparableTest{
    public static void main(String[] args) {
        RectangleComparable[] r = new RectangleComparable[3];
        r[0] = new RectangleComparable(3,4);
        r[1] = new RectangleComparable(1,2);
        r[2] = new RectangleComparable(5,6);

        System.out.println("Pre-sorted:");
        for (Rectangle e : r) {
            System.out.println(e);
        }

        Arrays.sort(r);

        System.out.println("After-sorted:");
        for (Rectangle e : r) {
            System.out.println(e);
        }
    }
}
