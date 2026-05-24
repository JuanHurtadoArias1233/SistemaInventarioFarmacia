import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;
    private double presupuestoMaximo;
    private int capacidadMaxima;

    public Inventario(double presupuestoMaximo,
                      int capacidadMaxima) {

        productos = new ArrayList<>();
        this.presupuestoMaximo = presupuestoMaximo;
        this.capacidadMaxima = capacidadMaxima;
    }

    public String registrarProducto(Producto producto) {

        if (producto.getCodigo().isEmpty()
                || producto.getNombre().isEmpty()) {

            return "Error: campos vacíos.";
        }

        if (producto.getCantidad() <= 0) {
            return "Error: cantidad inválida.";
        }

        if (producto.getPrecioCompra() <= 0) {
            return "Error: precio inválido.";
        }

        if (productos.size() >= capacidadMaxima) {
            return "Error: inventario lleno.";
        }

        if (calcularValorTotal()
                + producto.calcularValorInventario()
                > presupuestoMaximo) {

            return "Error: presupuesto excedido.";
        }

        if (producto instanceof ProductoPerecedero) {

            ProductoPerecedero perecedero =
                    (ProductoPerecedero) producto;

            if (perecedero.estaVencido()) {
                return "Error: producto vencido.";
            }
        }

        productos.add(producto);

        return "Producto registrado correctamente.";
    }

    public Producto buscarProducto(String codigo) {

        for (Producto producto : productos) {

            if (producto.getCodigo()
                    .equalsIgnoreCase(codigo)) {

                return producto;
            }
        }

        return null;
    }

    public String actualizarStock(String codigo,
                                  int nuevaCantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return "Producto no encontrado.";
        }

        if (nuevaCantidad < 0) {
            return "Cantidad inválida.";
        }

        producto.setCantidad(nuevaCantidad);

        return "Stock actualizado.";
    }

    public String eliminarProducto(String codigo) {

        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            return "Producto no encontrado.";
        }

        productos.remove(producto);

        return "Producto eliminado.";
    }

    public String mostrarInventario() {

        if (productos.isEmpty()) {
            return "Inventario vacío.";
        }

        String texto = "";

        for (Producto producto : productos) {

            texto += producto.mostrarInfo()
                    + "\n----------------------\n";
        }

        return texto;
    }

    public String mostrarAlertas() {

        if (productos.isEmpty()) {
            return "No existen productos.";
        }

        String alertas = "";

        for (Producto producto : productos) {

            alertas += producto.getNombre()
                    + ": "
                    + producto.generarAlerta()
                    + "\n";
        }

        return alertas;
    }

    public double calcularValorTotal() {

        double total = 0;

        for (Producto producto : productos) {

            total += producto.calcularValorInventario();
        }

        return total;
    }
}