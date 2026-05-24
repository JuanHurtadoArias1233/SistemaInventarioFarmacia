import javax.swing.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Inventario inventario =
                new Inventario(5000, 20);

        int opcion;

        do {

            opcion = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            """
                            ===== FARMACIA =====

                            1. Registrar producto perecedero
                            2. Registrar producto no perecedero
                            3. Mostrar inventario
                            4. Buscar producto
                            5. Actualizar stock
                            6. Eliminar producto
                            7. Mostrar alertas
                            8. Ver valor total
                            0. Salir
                            """
                    )
            );

            switch (opcion) {

                case 1:

                    try {

                        String codigo =
                                JOptionPane.showInputDialog("Código:");

                        String nombre =
                                JOptionPane.showInputDialog("Nombre:");

                        String categoria =
                                JOptionPane.showInputDialog("Categoría:");

                        int cantidad = Integer.parseInt(
                                JOptionPane.showInputDialog("Cantidad:")
                        );

                        double precioCompra = Double.parseDouble(
                                JOptionPane.showInputDialog("Precio compra:")
                        );

                        double precioVenta = Double.parseDouble(
                                JOptionPane.showInputDialog("Precio venta:")
                        );

                        int stockMinimo = Integer.parseInt(
                                JOptionPane.showInputDialog("Stock mínimo:")
                        );

                        int anio = Integer.parseInt(
                                JOptionPane.showInputDialog("Año vencimiento:")
                        );

                        int mes = Integer.parseInt(
                                JOptionPane.showInputDialog("Mes vencimiento:")
                        );

                        int dia = Integer.parseInt(
                                JOptionPane.showInputDialog("Día vencimiento:")
                        );

                        if (cantidad <= 0
                                || precioCompra <= 0
                                || precioVenta <= 0
                                || stockMinimo < 0) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Valores inválidos."
                            );

                            break;
                        }

                        LocalDate fecha =
                                LocalDate.of(anio, mes, dia);

                        ProductoPerecedero producto =
                                new ProductoPerecedero(
                                        codigo,
                                        nombre,
                                        categoria,
                                        cantidad,
                                        precioCompra,
                                        precioVenta,
                                        stockMinimo,
                                        fecha
                                );

                        JOptionPane.showMessageDialog(
                                null,
                                inventario.registrarProducto(producto)
                        );

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Error en los datos ingresados."
                        );
                    }

                    break;

                case 2:

                    try {

                        String codigo =
                                JOptionPane.showInputDialog("Código:");

                        String nombre =
                                JOptionPane.showInputDialog("Nombre:");

                        String categoria =
                                JOptionPane.showInputDialog("Categoría:");

                        int cantidad = Integer.parseInt(
                                JOptionPane.showInputDialog("Cantidad:")
                        );

                        double precioCompra = Double.parseDouble(
                                JOptionPane.showInputDialog("Precio compra:")
                        );

                        double precioVenta = Double.parseDouble(
                                JOptionPane.showInputDialog("Precio venta:")
                        );

                        int stockMinimo = Integer.parseInt(
                                JOptionPane.showInputDialog("Stock mínimo:")
                        );

                        if (cantidad <= 0
                                || precioCompra <= 0
                                || precioVenta <= 0
                                || stockMinimo < 0) {

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Valores inválidos."
                            );

                            break;
                        }

                        ProductoNoPerecedero producto =
                                new ProductoNoPerecedero(
                                        codigo,
                                        nombre,
                                        categoria,
                                        cantidad,
                                        precioCompra,
                                        precioVenta,
                                        stockMinimo
                                );

                        JOptionPane.showMessageDialog(
                                null,
                                inventario.registrarProducto(producto)
                        );

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Error en los datos ingresados."
                        );
                    }

                    break;

                case 3:

                    JOptionPane.showMessageDialog(
                            null,
                            inventario.mostrarInventario()
                    );

                    break;

                case 4:

                    String codigoBuscar =
                            JOptionPane.showInputDialog(
                                    "Ingrese código:"
                            );

                    Producto encontrado =
                            inventario.buscarProducto(codigoBuscar);

                    if (encontrado != null) {

                        JOptionPane.showMessageDialog(
                                null,
                                encontrado.mostrarInfo()
                        );

                    } else {

                        JOptionPane.showMessageDialog(
                                null,
                                "Producto no encontrado."
                        );
                    }

                    break;

                case 5:

                    try {

                        String codigoActualizar =
                                JOptionPane.showInputDialog(
                                        "Código producto:"
                                );

                        int nuevaCantidad =
                                Integer.parseInt(
                                        JOptionPane.showInputDialog(
                                                "Nueva cantidad:"
                                        )
                                );

                        JOptionPane.showMessageDialog(
                                null,
                                inventario.actualizarStock(
                                        codigoActualizar,
                                        nuevaCantidad
                                )
                        );

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Dato inválido."
                        );
                    }

                    break;

                case 6:

                    String codigoEliminar =
                            JOptionPane.showInputDialog(
                                    "Código a eliminar:"
                            );

                    JOptionPane.showMessageDialog(
                            null,
                            inventario.eliminarProducto(
                                    codigoEliminar
                            )
                    );

                    break;

                case 7:

                    JOptionPane.showMessageDialog(
                            null,
                            inventario.mostrarAlertas()
                    );

                    break;

                case 8:

                    JOptionPane.showMessageDialog(
                            null,
                            "Valor total: $"
                                    + inventario.calcularValorTotal()
                    );

                    break;

                case 0:

                    JOptionPane.showMessageDialog(
                            null,
                            "Saliendo..."
                    );

                    break;

                default:

                    JOptionPane.showMessageDialog(
                            null,
                            "Opción inválida."
                    );
            }

        } while (opcion != 0);
    }
}