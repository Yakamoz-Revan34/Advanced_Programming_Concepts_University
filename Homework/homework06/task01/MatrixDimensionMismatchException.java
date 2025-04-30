package homework06.task01;

public class MatrixDimensionMismatchException extends Exception {

    public MatrixDimensionMismatchException() {
        super("Invalid matrices input.");
    }

    public MatrixDimensionMismatchException(String message) {
        super(message);
    }
}
