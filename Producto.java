public abstract class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precioCompra;
    private double precioVenta;
    private int stockMinimo;

    public Producto(String codigo, String nombre, String categoria,
                    int cantidad, double precioCompra,
                    double precioVenta, int stockMinimo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.stockMinimo = stockMinimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean tieneStockBajo() {
        return cantidad <= stockMinimo;
    }

    public double calcularValorInventario() {
        return cantidad * precioCompra;
    }

    public abstract String generarAlerta();

    public String mostrarInfo() {

        return "Código: " + codigo +
                "\nNombre: " + nombre +
                "\nCategoría: " + categoria +
                "\nCantidad: " + cantidad +
                "\nPrecio compra: $" + precioCompra +
                "\nPrecio venta: $" + precioVenta +
                "\nStock mínimo: " + stockMinimo;
    }
}