package homework04.task01;

public abstract class Article {
    //attributes:
    protected int discountThreshold;
    protected int houseHoldLimit;

    //methods:
    public abstract int getBulkDiscount();
    public abstract boolean showWarning();
}
