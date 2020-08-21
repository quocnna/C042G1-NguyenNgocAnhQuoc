package _06_Inherittance.Exercises;
public class MoveablePoint extends Point2D{
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void SetSpeed(float xSpeed,float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed= ySpeed;
    }
    public float[] GetSpeed(){
        return new float[]{this.xSpeed,this.ySpeed};
    }
    public void Move(){
        setX(getX()+ this.xSpeed);
        setY(getY()+ this.ySpeed);
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x="+getX()+
                "xSpeed=" + xSpeed +
                "y="+getY()+
                ", ySpeed=" + ySpeed +
                '}';
    }
}
class TestMove{
    public static void main(String[] args) {
        MoveablePoint m= new MoveablePoint(1,2,3,4);
        m.Move();
        System.out.println(m);
    }
}
