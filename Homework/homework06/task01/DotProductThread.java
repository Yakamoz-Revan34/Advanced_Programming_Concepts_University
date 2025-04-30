package homework06.task01;

public class DotProductThread extends Thread {
    //attributes:
    private int v1;
    private int v2;
    private int dot;

    //constructor:
    public DotProductThread(int v1, int v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    //run:
    @Override
    public void run() {
        dot = v1 * v2;
    }

    //getter & setter:
    public int getDotProduct() {
        return dot;
    }
}
