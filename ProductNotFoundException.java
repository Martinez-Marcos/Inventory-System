// Excepción personalizada para cuando un producto no se encuentra en el sistema
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int id) {
        super("No se encontró ningún producto con el ID: " + id);
    }
}