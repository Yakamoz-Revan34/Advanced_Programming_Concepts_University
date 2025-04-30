package homework04.task01;

public abstract class PopularGrocery extends GroceryItem {
    //attributes:
   int popularityLevel;
   int quantity;

   //constructor:
   public PopularGrocery(int popularityLevel) {
       this.popularityLevel = popularityLevel;
       isPopular = true;
   }

   //methods:
   public boolean showWarning() {
       if (popularityLevel > quantity) {
           return true;
       } else {
           return false;
       }
   }
   
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
}
