package org.jorgetuma.clases;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;

        if(cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad del item debe ser mayor a 0");
        }

        if(producto == null) {
            throw new IllegalArgumentException("Producto del item no puede ser nulo");
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
