import java.util.List;

public class ProductBuy implements Buy {
    @Override
    public boolean buy(Product product, int cash, int BASKET, List<Product> groceryBasket) {
        if (groceryBasket.size() < BASKET) {
            cash -= Integer.parseInt(product.getPrice());
            groceryBasket.add(product);
            return false;
        }
        return true;
    }
}
