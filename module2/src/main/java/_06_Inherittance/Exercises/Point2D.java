package _06_Inherittance.Exercises;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void SetXY(float x,float y){
        this.x= x;
        this.y=y;
    }
    public float[] GetXY(){
        float[] res = {this.x,this.y};
        return res;
    }

    @Override
    public String toString() {
        return "(x,y)";
    }
}

class Point3D extends Point2D{
    private float z;
    public Point3D(float x,float y,float z) {
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x,float y,float z){
        SetXY(x,y);
        this.z= z;
    }
    public float[] getXYZ(){
        float[] res= Arrays.copyOf(GetXY(),GetXY().length+1);
        res[res.length-1] = this.z;
        return res;
    }

    @Override
    public String toString() {
        return "xyz";
    }
}
class TestPoint{
    public static void main(String[] args) {
        Point2D p2 = new Point2D(2,3);
        System.out.println(p2);
        System.out.println(Arrays.toString(p2.GetXY()));
        Point3D p3 = new Point3D(4,5,6);
        System.out.println(p3);
        System.out.println(Arrays.toString(p3.getXYZ()));
    }
}
