package buyer;

import product.Product;

public interface Buy { //здесь выполнен принцип сегрегации (разделения) интерфейса, на интерфейсы Buy и Refund
    boolean buy(Product product);
}
