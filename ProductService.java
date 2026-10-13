import java.util.ArrayList;

public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    // Agrega un nuevo producto a la lista en memoria
    public void addProduct(String name, double price, int stock) {
        Product newProduct = new Product(name, price, stock);
        products.add(newProduct);
        System.out.println("Producto agregado con éxito: " + newProduct);
    }

// Muestra todos los productos registrados y pausa hasta que se presione una tecla
    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No hay productos cargados en el sistema.");
            return;
        }
        System.out.println("\n--- Listado de productos ---");
        for (Product product : products) {
            System.out.println(product);
        }

        System.out.println("\nPresione Enter para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

    // Busca un producto por su ID
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        throw new ProductNotFoundException(id);
    }

    // Actualiza el precio y el stock de un producto existente
    public void updateProduct(int id, double newPrice, int newStock) {
        Product product = findById(id); // Lanza ProductNotFoundException si no existe
        product.setPrice(newPrice);
        product.setStock(newStock);
        System.out.println("Producto actualizado correctamente: " + product);
    }

    // Elimina un producto por su ID
    public void deleteProduct(int id) {
        Product product = findById(id);
        products.remove(product);
    }
}