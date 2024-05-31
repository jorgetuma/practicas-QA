package org.jorgetuma.clases;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        this.items = new ArrayList<>();
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public void setItems(List<ItemCarrito> items) {
        this.items = items;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId() == producto.getId()) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarProducto(int id) {
        items.removeIf(item -> item.getProducto().getId() == id);
    }

    public void modificarCantidad(int id, int nuevaCantidad) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId() == id) {
                if (nuevaCantidad <= 0) {
                    items.remove(item);
                } else {
                    item.setCantidad(nuevaCantidad);
                }
                return;
            }
        }
    }

    public float calcularTotal() {
        float total = 0;
        for (ItemCarrito item : items) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }
}
