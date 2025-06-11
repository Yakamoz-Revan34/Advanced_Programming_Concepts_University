package homework08;

import java.util.ArrayList;

public class ShapeStorage <T extends Shape> extends ArrayList<T> {
    //constructor:
    public ShapeStorage() {
        super();
    }

    //methods:
    public void addShape(Shape shape) {
        this.add((T) shape);
    }

    public double getTotalArea() {
        double totArea = 0;
        for (int i = 0; i < this.size(); i++) {
            totArea += this.get(i).getArea();
        }
        return totArea;
    }

    public void displayAllShapes() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println(this.get(i).toString());
        }
    }

    public <U extends T> void importLargeShapes(ShapeStorage<U> other, double minArea) {
        for (int i = 0; i < other.size(); i++) {
            if(other.get(i).getArea() >= minArea) this.add(other.get(i));
        }
    }
}
