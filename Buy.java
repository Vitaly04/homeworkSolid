import java.util.List;

public interface Buy { //здесь выполнен принцип сегрегации (разделения) интерфейсов
    boolean buy(Product product, int cash, int BASKET, List<Product> groceryBasket);
}
