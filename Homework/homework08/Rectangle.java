package homework08;

public class Rectangle extends Shape{
    //attributes:
    private double width;
    private double length;

    //constructor:
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    //methods:
    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public String toString() {
        String dummy = "Rectangle: widht="+width+", length="+length+", area="+getArea()+".";
        return dummy;
    }

    //getter & setter:
    public double getWidth() {
        return width;
    }
    public void setRadius(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
}

