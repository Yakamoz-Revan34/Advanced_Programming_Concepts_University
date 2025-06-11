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
        List<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

        } catch (FileNotFoundException e) {
            System.err.println("The file: "+filename+" could not be found.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return shapes;
    }
}
