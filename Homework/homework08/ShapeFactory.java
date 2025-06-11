package homework08;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ShapeFactory {
    /*
    //register for assigning correct shape in fromString()
    private static final Map<String, Function<String, Shape>> registry = new HashMap<>();
    public static void register(String shapeName, Function<String, Shape> parser) {
        registry.put(shapeName, parser);
    }
    ^nvm. too difficult for me
     */

    public static Shape fromString(String input) throws IllegalArgumentException {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty.");
        }

        String[] parts = input.split(":", 2);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid format: Missing ':' separator. Input: " + input);
        }

        String shapeType = parts[0].trim();
        String shapeData = parts[1].trim();

        try {
            if (shapeType.equalsIgnoreCase("Circle")) {
                String[] dataParts = shapeData.split("=");
                if (dataParts.length < 2 || !dataParts[0].trim().equalsIgnoreCase("radius")) {
                    throw new IllegalArgumentException("Invalid format for Circle. Expected 'radius=value'. Input: " + input);
                }
                double radius = Double.parseDouble(dataParts[1].trim());
                return new Circle(radius);

            } else if (shapeType.equalsIgnoreCase("Rectangle")) {
                String[] dataParts = shapeData.split(",");
                if (dataParts.length < 2) {
                    throw new IllegalArgumentException("Invalid format for Rectangle. Expected 'width=value, length=value'. Input: " + input);
                }

                String[] widthPart = dataParts[0].trim().split("=");
                String[] lengthPart = dataParts[1].trim().split("=");

                if (widthPart.length < 2 || lengthPart.length < 2 || !widthPart[0].trim().equalsIgnoreCase("width") || !lengthPart[0].trim().equalsIgnoreCase("length")) {
                    throw new IllegalArgumentException("Invalid key names for Rectangle. Expected 'width' and 'length'. Input: " + input);
                }

                double width = Double.parseDouble(widthPart[1].trim());
                double length = Double.parseDouble(lengthPart[1].trim());
                return new Rectangle(width, length);

            } else {
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format in input: " + input, e);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Malformed data part in input: " + input, e);
        }
    }
}

