import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Buyer buyer = new Buyer("Артем", 150);
        Product[] productArray = {new Product("колбаса докторская", "50", "колбаса", "завод", "5"),
                new Product("колбаса молочная", "70", "колбаса","фабрика", "7"),
                new Product("колбаса венская", "70", "колбаса","цех", "9"),
                new Product("говядина", "100", "мясо","цех", "9"),
        };
        System.out.println("Список продуктов: " + Arrays.toString(productArray));

        while (true) {
            System.out.println("Введите нужную команду: 1 - фильтрация товаров, 2 - покупка товара, " +
                    " 3 - возврат товара, 4 - список покупок, 5 - выход");
            int command = scanner.nextInt();
            if (command == 5) break;
            switch (command) {
                case 1 :
                    filterProduct(productArray); // здесь выполнено правило DRY, методы можно вызывать снова и не повторять код
                    break;
                case 2 :
                    buyProduct(productArray, buyer);
                    break;
                case 3 :
                    refundProduct(buyer);
                    break;
                case 4 :
                    System.out.println(buyer.getGroceryBasket());
                    break;
                default :
                    System.out.println("Несуществующая команда");
            }
        }
    }

    private static void filterProduct(Product[] productArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер категории для фильтрации: 1 - имя, 2 - цена, 3 - категория товара, 4 - производитель, 5 - рейтинг товара");
        int filterCategory = scanner.nextInt();
        System.out.println("Введите значение для фильтрации: ");
        scanner.nextLine();
        String valueFilter = scanner.nextLine();
        Filter filter = new ProductFilter(productArray, filterCategory, valueFilter); // Здесь выполнен принцип инверсии зависимостей, в дальнейшем есть возможность поменять на другой класс интерфейса Filter
        PrintFilter printFilter = new PrintFilter();
        printFilter.printFilter(filter);
    }

    private static void buyProduct(Product[] productArray, Buyer buyer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара: ");
        String name = scanner.nextLine();
        for (Product product : productArray) {
           if (name.equals(product.getName()) && buyer.getCash() - Integer.parseInt(product.getPrice()) > 0) {
               if (buyer.buy(product)) {
                   System.out.println("корзина покупателя полная");
               }
            }
        }
    }

    private static void refundProduct(Buyer buyer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название товара который необходимо вернуть: ");
        String name = scanner.nextLine();
        if (buyer.refund(name)) {
            System.out.println("Товар отсуствует");
        }
    }
}
