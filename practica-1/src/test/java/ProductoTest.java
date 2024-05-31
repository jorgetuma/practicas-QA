import org.jorgetuma.clases.Producto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ProductoTest {

    /*Probando creación de un nuevo producto*/
    @Test
    public void testNuevoProducto() {
        Producto producto = new Producto(1, "Manzana", (float)10.0);
        assertEquals(1, producto.getId());
        assertEquals("Manzana", producto.getNombre());
        assertEquals((float)10.0, producto.getPrecio());
    }

    /*Probando exepción para precios negativos*/
    @Test
    public void testPrecioNegativo() {
        assertThrows(IllegalArgumentException.class,() -> new Producto(2, "Arroz", (float)-90.55));
        assertThrows(IllegalArgumentException.class,() -> new Producto(3, "Refresco", (float)-10000.77));
    }

    /*Probando exepción cuando se crea un producto sin nombre*/
    @Test
    public void testNombreProducto() {
        assertThrows(IllegalArgumentException.class,() -> new Producto(4, "", (float)20.11));
        assertThrows(IllegalArgumentException.class,() -> new Producto(5, "", (float)25.35));
        assertThrows(IllegalArgumentException.class,() -> new Producto(6, null, (float)50.35));
    }
}
