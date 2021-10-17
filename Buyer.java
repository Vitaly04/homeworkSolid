import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private String name;
    private int cash;
    private final int BASKET = 3; // здесь выполнен подход по избеганию магических чисел
    private List<Product> groceryBasket;
    private Buy buy;
    private Refund refund;


    public int getCash() {
        return cash;
    }

    public List<Product> getGroceryBasket() {
        return groceryBasket;
    }

    public Buyer(String name, int cash, Buy buy, Refund refund) { // Здесь выполнен принцип инверсии зависимостей, класс зависит от абстракций, а не от конкретной реализации
        this.name = name;
        this.cash = cash;
        this.groceryBasket = new ArrayList<>();
        this.buy = buy;
        this.refund = refund;

    }

    public boolean buyProduct (Product product) {
        return buy.buy(product, cash,  BASKET, groceryBasket);
    }

    public boolean refundProduct(String nameProduct) {
        return refund.refund(nameProduct, groceryBasket, cash);
    }
}
