package homework08;

import java.util.*;

public class ShapeAnalyzer {
    //methods:
    public static List<Shape> filterByMinArea(Collection<? extends Shape> shapes, double minArea) {
        List<Shape> filtered = new ArrayList<>();
        shapes.forEach(shape -> {
            if (shape.getArea() >= minArea) filtered.add(shape);
        });
        return filtered;
    }

    public static Shape findShapeWithMaxArea(Collection<? extends Shape> shapes) {
        if (shapes.isEmpty())
            return null; //If there are no shapes there can't be a shape with a largest area -> return null.
        Shape[] shapesArr = shapes.toArray(new Shape[0]);
        Shape max = shapesArr[0];
        for (Shape shape : shapesArr) {
            if (shape.getArea() > max.getArea()) max = shape;
        }
        return max;
    }

    public static <T extends Shape> Map<String, List<T>> groupByType(Collection<T> shapes) {
        Map<String, List<T>> shapesGrouped = new HashMap<>();
        for (T shape : shapes) {
            String type = shape.getClass().getSimpleName();
            shapesGrouped.putIfAbsent(type, new ArrayList<>());
            shapesGrouped.get(type).add(shape);
        }
        return shapesGrouped;
    }
}

/*
1) Utilising a  type parameter and specifically a wildcard allows for the processing of any kind of shape and shape-subclass while using a non-generic signature
   would bind us to a single object (e.g. circle, rectangle, shape) -- in other words: a non-generic signature would prevent us from being able to process
   collections with multiple shape types and additionally would require us to a) know which 'monochrome' collection we are dealing with and b) would have us
   overload the methods as to accomodate every single shape type that could 'come up'. In summary, the wildcard signature allows for a broader and therefor more
   generic ;) use of the method.
2) As the rule of thumb for the question "Wildcard or type parameter?" goes, utilise wildcards when reading from a (potentially mixed) collection and for writing
   use type parameters. Only by using a type parameter are we able to properly work with maps as they expect a concrete type; which we provide by using a type
   parameter.
3) As ShapeAnalyzer is a utility class we naturally want to use the provided methods on whatever whenever and to do this we need static methods as these can be
   called upon without first initialising an instance of the class and unlike non-static methods are not exclusive to the respective instance of the class.
 */
