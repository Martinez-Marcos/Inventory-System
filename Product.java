public class Product {

    private static int idCounter = 1;

    private int id;
    private String name;
    private double price;
    private int stock;

    // Constructor principal para inicializar un nuevo producto
    public Product(String name, double price, int stock) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void setPrice(double price) { this.price = price; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "[ID: " + id + "] " + name +
               " | Precio: $" + price +
               " | Stock: " + stock;
    }
}