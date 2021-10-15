import java.util.List;

public class PrintFilter {

    public void printFilter(Filter filter) {// здесь выполнен принцип открытости/закрытости, класс можно расширять новыми классами интерфейса Filter, не изменяя сам класс
        List<Product> printList;
        printList = filter.filter();
        System.out.println(printList);
    }
}
