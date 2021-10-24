package buyer;

public interface Refund {//здесь выполнен принцип сегрегации (разделения) интерфейса, на интерфейсы Buy и Refund
    boolean refund(String name);
}
