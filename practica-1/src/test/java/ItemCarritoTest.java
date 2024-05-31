import org.jorgetuma.clases.ItemCarrito;
import org.jorgetuma.clases.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ItemCarritoTest {

    /*Probar la creación de un item nuevo*/
    @Test
    public void testNuevoItem() {
        Producto producto = new Producto(1, "Manzana", (float)10.0);
        ItemCarrito item = new ItemCarrito(producto,5);

        assertEquals(1, item.getProducto().getId());
        assertEquals("Manzana", item.getProducto().getNombre());
        assertEquals((float)10.0, item.getProducto().getPrecio());
        assertEquals(5, item.getCantidad());
    }

    /*Probar exepciones generadas por atributo cantidad*/
    @Test
    public void testCantidadItem() {
        assertThrows(IllegalArgumentException.class,() -> new ItemCarrito(new Producto(1, "Galletas", (float)30.44),-10));
        assertThrows(IllegalArgumentException.class,() -> new ItemCarrito(new Producto(2, "Miel", (float)15.12),0));
    }

    /*Probar exepción producto del item*/
    @Test
    public void testProductoItem() {
        assertThrows(IllegalArgumentException.class,() -> new ItemCarrito(null,25));
    }
}
