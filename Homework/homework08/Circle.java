package homework08;

public class Circle extends Shape {
    //attributes:
    private double radius;

    //constructor:
    public Circle(double radius) {
        this.radius = radius;
    }

    //methods:
    @Override
    public double getArea() {
        return Math.PI*Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        String dummy = "Circle: radius="+radius+", area="+getArea()+".";
        return dummy;
    }

    //getter & setter:
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
