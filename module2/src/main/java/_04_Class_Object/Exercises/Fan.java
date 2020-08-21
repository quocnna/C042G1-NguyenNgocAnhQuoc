package _04_Class_Object.Exercises;

public class Fan {
    private final int SLOW= 1;
    private final int MEDIUM=2;
    private final int FAST=3;
    private int speed = SLOW;
    private boolean isOn= false;
    private double radius =5;
    private String color= "blue";

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxSpeed(){
        this.speed = this.FAST;
    }
    public void setMediumSpeed(){
        this.speed = this.MEDIUM;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

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

    @Override
    public String toString() {
        return this.isOn? String.format("Speed: %d, Color: %s, Radius: %.1f. Fan is On",speed,color,radius):String.format("Color: %s, Radius: %.1f. Fan is Off",color,radius);
    }

    public static void main(String[] args) {
        Fan f1 = new Fan();
        f1.setMaxSpeed();
        f1.radius=10;
        f1.color="yellow";
        f1.isOn=true;

        Fan f2= new Fan();
        f2.setMediumSpeed();
        f2.radius=5;
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
