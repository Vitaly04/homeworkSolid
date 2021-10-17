import java.util.List;

public interface Refund { //здесь выполнен принцип сегрегации (разделения) интерфейсов
    boolean refund(String nameProduct, List<Product> groceryBasket, int cash);
}
