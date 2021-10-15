import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter implements Filter {//здесь выполнен принцип единственной ответственности, класс выполняет одну фукцию для которой он был создан
    Product[] productArray;
    int filterCategory;
    String valueFilter;

    public ProductFilter(Product[] productArray, int filterCategory, String valueFilter) {
        this.productArray = productArray;
        this.filterCategory = filterCategory;
        this.valueFilter = valueFilter;
    }

    @Override
    public List <Product> filter() {
        switch (filterCategory) {
            case 1 :
              return Arrays.stream(productArray).filter(product -> product.getName().equals(valueFilter))
                      .collect(Collectors.toList());
            case 2 :
               return Arrays.stream(productArray).filter(product -> product.getPrice().equals(valueFilter))
                       .collect(Collectors.toList());
            case 3 :
                return Arrays.stream(productArray).filter(product -> product.getCategory().equals(valueFilter))
                        .collect(Collectors.toList());
            case 4 :
                return Arrays.stream(productArray).filter(product -> product.getManufacturer().equals(valueFilter))
                        .collect(Collectors.toList());
            case 5 :
                return Arrays.stream(productArray).filter(product -> product.getRating().equals(valueFilter))
                        .collect(Collectors.toList());
        }
        return null;
    }
}
