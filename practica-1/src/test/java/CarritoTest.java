import org.jorgetuma.clases.Carrito;
import org.jorgetuma.clases.ItemCarrito;
import org.jorgetuma.clases.Producto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarritoTest {

    /*Probar Agregar un nuevo producto*/
    @Test
    public void testAgregarProducto() {
        Carrito carrito = new Carrito();
        Producto producto = new Producto(1, "Producto A", (float)10.25);
        carrito.agregarProducto(producto, 2);

        List<ItemCarrito> items = carrito.getItems();
        assertEquals(1, items.size());
        assertEquals(2, items.get(0).getCantidad());
        assertEquals(producto, items.get(0).getProducto());
    }

    /*Probar la eliminación de un producto*/
    @Test
    public void testEliminarProducto() {
        Carrito carrito = new Carrito();
        Producto producto = new Producto(1, "Producto A", (float)10.22);
        carrito.agregarProducto(producto, 2);
        carrito.eliminarProducto(1);

        List<ItemCarrito> items = carrito.getItems();
        assertEquals(0, items.size());
    }

    /*Probar la modificación de la cantidad de un item*/
    @Test
    public void testModificarCantidad() {
        Carrito carrito = new Carrito();
        Producto producto = new Producto(1, "Producto A", (float)10.23);
        carrito.agregarProducto(producto, 2);
        carrito.modificarCantidad(1, 5);

        List<ItemCarrito> items = carrito.getItems();
        assertEquals(5, items.get(0).getCantidad());
    }

    /*Probar calcular el total para el carrito*/
    @Test
    public void testCalcularTotal() {
        Carrito carrito = new Carrito();
        Producto productoA = new Producto(1, "Producto A", (float)10.00);
        Producto productoB = new Producto(2, "Producto B", (float)20.00);
        carrito.agregarProducto(productoA, 2);
        carrito.agregarProducto(productoB, 1);

        float total = carrito.calcularTotal();
        assertEquals((float)40.00, total);
    }
}
