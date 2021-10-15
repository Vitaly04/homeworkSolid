import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Buyer implements Buy, Refund {//здесь выполнен принцип сегрегации (разделения) интерфейса, на интерфейсы Buy и Refund
    private String name;
    private int cash;
    private final int BASKET = 3; // здесь выполнен подход по избеганию магических чисел
    private List<Product> groceryBasket;

    public int getCash() {
        return cash;
    }

    public List<Product> getGroceryBasket() {
        return groceryBasket;
    }

    public Buyer(String name, int cash) {
        this.name = name;
        this.cash = cash;
        this.groceryBasket = new ArrayList<>();

    }

    @Override
    public boolean buy(Product product) {
        if (groceryBasket.size() < BASKET) {
            cash -= Integer.parseInt(product.getPrice());
            groceryBasket.add(product);
            return false;
        }
        return true;
    }

    @Override
    public boolean refund(String name) {
        Iterator<Product> productIterator = groceryBasket.iterator();
        while(productIterator.hasNext()) {
            Product nextProduct = productIterator.next();
            if (nextProduct.getName().equals(name)) {
                cash += Integer.parseInt(nextProduct.getPrice());
                productIterator.remove();
                return false;
            }
        }
        return true;
    }
}
