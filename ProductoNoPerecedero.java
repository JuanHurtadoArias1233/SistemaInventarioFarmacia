public class ProductoNoPerecedero extends Producto {

    public ProductoNoPerecedero(String codigo,
                                String nombre,
                                String categoria,
                                int cantidad,
                                double precioCompra,
                                double precioVenta,
                                int stockMinimo) {

        super(codigo, nombre, categoria, cantidad,
                precioCompra, precioVenta, stockMinimo);
    }

    @Override
    public String generarAlerta() {

        if (tieneStockBajo()) {
            return "Stock bajo.";
        }

        return "Sin alertas.";
    }
}