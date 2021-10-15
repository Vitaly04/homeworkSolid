public class Product {
    private String name;
    private String price;
    private String category;
    private String manufacturer;
    private String rating;

    public Product(String name, String price, String category, String manufacturer, String rating) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.manufacturer = manufacturer;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name ='" + name + '\'' +
                ", price ='" + price + '\'' +
                ", category ='" + category + '\'' +
                ", manufacturer ='" + manufacturer + '\'' +
                ", rating ='" + rating + '\'' +
                '}' + '\n';
    }
}
