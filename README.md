# Inventory System

Pequeña aplicación desarrollada en Java para la gestión básica de productos en memoria.

## Estructura de Archivos

- **`Main.java`**: Clase principal que maneja la interfaz de consola, la interacción con el usuario mediante `Scanner` y las validaciones de entrada.
- **`Product.java`**: Modelo de datos que representa un producto, incluyendo la lógica de autoincremento para los identificadores (`ID`).
- **`ProductService.java`**: Clase de servicio que encapsula la lógica de negocio y el almacenamiento temporal en memoria utilizando un `ArrayList`.
- **`ProductNotFoundException.java`**: Excepción personalizada en tiempo de ejecución (`RuntimeException`) que se lanza al intentar buscar o eliminar un producto inexistente.