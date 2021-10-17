import java.util.Iterator;
import java.util.List;

public class ProductRefund implements Refund {
    @Override
    public boolean refund(String nameProduct, List<Product> groceryBasket, int cash) {
        Iterator<Product> productIterator = groceryBasket.iterator();
        while(productIterator.hasNext()) {
            Product nextProduct = productIterator.next();
            if (nextProduct.getName().equals(nameProduct)) {
                cash += Integer.parseInt(nextProduct.getPrice());
                productIterator.remove();
                return false;
            }
        }
        return true;
    }
}
