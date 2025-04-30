package homework06.task01;

public class MatrixMultMain {
    public static void main(String[] args) throws MatrixDimensionMismatchException {
        int[][] a1 = new int[][] {
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3}
        };
        printMatrixGrid(a1);
        int[][] a2 = new int[][] {
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3},
                {0,1,2,3}
        };
        printMatrixGrid(a2);

        int[][] p1 = multiplyMatricesStartVariant(a1, a2);
        printMatrixGrid(p1);
    }

    public static int[][] multiplyMatricesStartVariant(int[][] m1, int[][] m2) throws MatrixDimensionMismatchException { //order matters with multiplyMatrices multiplication so beware! (#rows of m1 and #columns has to match).
        //checks:
        if (m1 == null || m2 == null) { //null check
            throw new MatrixDimensionMismatchException("Both matrices cannot be null.");
        }
        if (m1.length == 0 || m2.length == 0) { //empty matrices check
            throw new MatrixDimensionMismatchException("Matrices must not be empty.");
        }
        if (m1.length != m2[0].length) { //multiplyMatrices 1 #column equal multiplyMatrices 2 #row check
            throw new MatrixDimensionMismatchException("Column count of the first multiplyMatrices must match the row count of the second multiplyMatrices.");
        }
        //multiplyMatrices multiplication: (with thread start and join
        int[][] product = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) { //These two for-loops go through the entries of the new product multiplyMatrices
                //This for-loop calculates the dot product of each row and column for the respective product multiplyMatrices entry
                int sum = 0;
                for (int k = 0; k < m1[0].length; k++) { //k < #columns m1 or #rows m2 because they have to be the same anyway
                    DotProductThread t = new DotProductThread(m1[i][k], m2[k][j]);
                    t.run();
                    sum += t.getDotProduct();
                }
                product[i][j] = sum;
            }
        }
        return product;
    }

    //with run:
    public static int[][] multiplyMatricesRunVariant(int[][] m1, int[][] m2) throws MatrixDimensionMismatchException { //order matters with multiplyMatrices multiplication so beware! (#rows of m1 and #columns has to match).
        //checks:
        if (m1 == null || m2 == null) { //null check
            throw new MatrixDimensionMismatchException("Both matrices cannot be null.");
        }
        if (m1.length == 0 || m2.length == 0) { //empty matrices check
            throw new MatrixDimensionMismatchException("Matrices must not be empty.");
        }
        if (m1.length != m2[0].length) { //multiplyMatrices 1 #column equal multiplyMatrices 2 #row check
            throw new MatrixDimensionMismatchException("Column count of the first multiplyMatrices must match the row count of the second multiplyMatrices.");
        }
        //multiplyMatrices multiplication: (with thread start and join
        int[][] product = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) { //These two for-loops go through the entries of the new product multiplyMatrices
                //This for-loop calculates the dot product of each row and column for the respective product multiplyMatrices entry
                int sum = 0;
                for (int k = 0; k < m1[0].length; k++) { //k < #columns m1 or #rows m2 because they have to be the same anyway
                    DotProductThread t = new DotProductThread(m1[i][k], m2[k][j]);
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new RuntimeException(e);
                    }
                    sum += t.getDotProduct();
                }
                product[i][j] = sum;
            }
        }
        return product;
    }


    public static void printMatrixGrid(int[][] m) {
        // 1) Find the widest number (as String) so we know how much padding each column needs
        int maxWidth = 0;
        for (int[] row : m) {
            for (int val : row) {
                maxWidth = Math.max(maxWidth, String.valueOf(val).length());
            }
        }

        // 2) Print each row
        for (int[] row : m) {
            for (int val : row) {
                // %-Nd would be left-justified; %Nd is right-justified.
                System.out.printf("%" + maxWidth + "d ", val);
            }
            System.out.println();
        }
        System.out.println();

    }
    //Full credit: I copied this^ matrix print method from ChatGPT

}
