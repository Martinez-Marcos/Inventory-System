import java.util.Scanner;

public class Main {

    // Variable para controlar el tiempo de retardo antes de volver al menú (en milisegundos)
    private static final int DELAY_TIME_MS = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int option = -1;

        System.out.println("*************************");
        System.out.println("**   Inventory System  **");
        System.out.println("*************************");

        while (option != 0) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Actualizar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            // Validación de entrada numérica para el menú
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
                System.out.print("Opción: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                // Solicitar nombre con validación y reintento
                String name = "";
                while (true) {
                    System.out.print("Nombre: ");
                    name = scanner.nextLine().trim();

                    if (!name.isEmpty()) {
                        break;
                    }
                    System.out.println("Error: El nombre no puede estar vacío. Inténtelo de nuevo.");
                }

                // Solicitar precio con validación y reintento
                double price = -1;
                while (true) {
                    System.out.print("Precio: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Error: El precio debe ser un valor numérico. Inténtelo de nuevo.");
                        scanner.next();
                        continue;
                    }
                    price = scanner.nextDouble();
                    scanner.nextLine();

                    if (price > 0) {
                        break;
                    }
                    System.out.println("Error: El precio debe ser mayor a cero. Inténtelo de nuevo.");
                }

                // Solicitar stock con validación y reintento
                int stock = -1;
                while (true) {
                    System.out.print("Stock: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Error: El stock debe ser un número entero. Inténtelo de nuevo.");
                        scanner.next();
                        continue;
                    }
                    stock = scanner.nextInt();
                    scanner.nextLine();

                    if (stock >= 0) {
                        break;
                    }
                    System.out.println("Error: El stock no puede ser negativo. Inténtelo de nuevo.");
                }

                productService.addProduct(name, price, stock);
                waitBeforeReturn();

            } else if (option == 2) {
                productService.listProducts();
                // listProducts maneja su propia pausa al presionar Enter

            } else if (option == 3) {
                int id = -1;
                while (true) {
                    System.out.print("ID a buscar: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un ID válido. Inténtelo de nuevo.");
                        scanner.next();
                        continue;
                    }
                    id = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }

                try {
                    Product product = productService.findById(id);
                    System.out.println("Encontrado: " + product);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                waitBeforeReturn();

            } else if (option == 4) {
                // Opción 4: Actualizar producto
                int id = -1;
                while (true) {
                    System.out.print("ID del producto a actualizar: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un ID válido. Inténtelo de nuevo.");
                        scanner.next();
                        continue;
                    }
                    id = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }

                try {
                    productService.findById(id);

                    double newPrice = -1;
                    while (true) {
                        System.out.print("Nuevo precio: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Error: El precio debe ser un valor numérico. Inténtelo de nuevo.");
                            scanner.next();
                            continue;
                        }
                        newPrice = scanner.nextDouble();
                        scanner.nextLine();

                        if (newPrice > 0) {
                            break;
                        }
                        System.out.println("Error: El precio debe ser mayor a cero. Inténtelo de nuevo.");
                    }

                    int newStock = -1;
                    while (true) {
                        System.out.print("Nuevo stock: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Error: El stock debe ser un número entero. Inténtelo de nuevo.");
                            scanner.next();
                            continue;
                        }
                        newStock = scanner.nextInt();
                        scanner.nextLine();

                        if (newStock >= 0) {
                            break;
                        }
                        System.out.println("Error: El stock no puede ser negativo. Inténtelo de nuevo.");
                    }

                    productService.updateProduct(id, newPrice, newStock);
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                waitBeforeReturn();

            } else if (option == 5) {
                // Opción 5: Eliminar producto
                int id = -1;
                while (true) {
                    System.out.print("ID a eliminar: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese un ID válido. Inténtelo de nuevo.");
                        scanner.next();
                        continue;
                    }
                    id = scanner.nextInt();
                    scanner.nextLine();
                    break;
                }

                try {
                    productService.deleteProduct(id);
                    System.out.println("Producto eliminado correctamente.");
                } catch (ProductNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                waitBeforeReturn();

            } else if (option != 0) {
                System.out.println("Opción no válida. Elija un número entre 0 y 5.");
                waitBeforeReturn();
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();
    }

    // Aplicar el retardo antes de regresar al menú
    private static void waitBeforeReturn() {
        try {
            Thread.sleep(DELAY_TIME_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}