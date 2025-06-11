package homework08;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersistentShapeManager {

    public static void saveShapesToFile(Collection<? extends Shape> shapes, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (Shape current : shapes) {
                writer.write(current.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error has occured while writing to the file: " + filename);
            e.printStackTrace();
        }
    }

    public static List<Shape> loadShapesFromFile(String filename) {
        List<Shape> listOfShapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                try {
                    Shape shape;
                    shape = ShapeFactory.fromString(currentLine);
                    listOfShapes.add(shape);
                } catch (IllegalArgumentException e) {
                    System.err.println("Invalid line: " + currentLine + " is being skipped.");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("The file: " + filename + " could not be found.");
        } catch (IOException e) {
            System.err.println("An exception occured while reading the file " + filename + ".");
        }
        return listOfShapes;
    }

    static void clearFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) { //opens in overwrite mode and with no new input effectively empties the file.
        } catch (IOException e) {
            System.err.println("Expection while emptying the file: "+filename+".");
            e.printStackTrace();
        }
    }
}

