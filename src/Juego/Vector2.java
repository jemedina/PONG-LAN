package Juego;
public class Vector2 {
    private float x,y;
    private float magnitude;
    private float angle;
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
        this.calculateAngle();
        this.calculateMagnitude();
    }
    public void setAngleAndMagnitude(float angle, float magnitude) {
        this.angle = angle;
        this.magnitude = magnitude;        
        this.calculateComponents();
    }
    private void calculateMagnitude() {
        magnitude = (float) Math.sqrt(Math.pow(x,2)+Math.pow(y, 2));
    }
    
    private void calculateAngle() {
        angle = (float) Math.toDegrees(Math.atan(y/x));    
        if(x < 0 && y > 0) {
            angle=Math.abs(angle)+ 90;
        } else if(x < 0 && y < 0) {
            angle = Math.abs(angle)+180;
        } else if(x > 0 && y < 0) {
            angle = Math.abs(angle)+ 270;
        }
    }
    private void calculateComponents() {
        x = (float) (magnitude*Math.cos(Math.toRadians(angle)));
        y = (float) (magnitude*Math.sin(Math.toRadians(angle)));
    }
    public Vector2() {
        this(0,0);
    }
    
    public void set(float x, float y ){
        this.x = x;
        this.y = y;
        this.calculateAngle();
        this.calculateMagnitude();
    }
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void invertXComponent() {
        x = -x;
        this.calculateAngle();
    }
    
    public void invertYComponent() {
        y = -y;
        this.calculateAngle();
    }
    public float getAngle() {
        return angle;
    }
    public float getMagnitude() {
        return magnitude;
    }
    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
        this.calculateComponents();
    }
    public void setAngle(float angle) {
        this.angle = angle;
        this.calculateComponents();
    }
}
