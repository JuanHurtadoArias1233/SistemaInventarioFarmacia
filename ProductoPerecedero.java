import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ProductoPerecedero extends Producto {

    private LocalDate fechaVencimiento;

    public ProductoPerecedero(String codigo, String nombre,
                              String categoria, int cantidad,
                              double precioCompra,
                              double precioVenta,
                              int stockMinimo,
                              LocalDate fechaVencimiento) {

        super(codigo, nombre, categoria, cantidad,
                precioCompra, precioVenta, stockMinimo);

        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean estaVencido() {
        return fechaVencimiento.isBefore(LocalDate.now());
    }

    public boolean estaProximoAVencer() {

        long dias = ChronoUnit.DAYS.between(
                LocalDate.now(),
                fechaVencimiento
        );

        return dias >= 0 && dias <= 15;
    }

    @Override
    public String generarAlerta() {

        if (estaVencido()) {
            return "Producto vencido.";
        }

        if (estaProximoAVencer()) {
            return "Producto próximo a vencer.";
        }

        if (tieneStockBajo()) {
            return "Stock bajo.";
        }

        return "Sin alertas.";
    }

    @Override
    public String mostrarInfo() {

        return super.mostrarInfo() +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nAlerta: " + generarAlerta();
    }
}