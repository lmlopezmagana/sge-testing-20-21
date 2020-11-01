package com.salesianostriana.dam;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    /**
     * Método que obtiene el coste de todos los productos
     * añadidos al carrito hasta ahora
     * @return
     */
    public double getBalance() {
        double balance = 0.00;
        for (Iterator i = items.iterator(); i.hasNext();){
            Product item = (Product)i.next();
            balance += item.getPrice();
        }
        return balance;
    }

    /**
     * Método que añade un nuevo producto al carrito
     * @param item
     */
    public void addItem(Product item) {
        items.add(item);
    }

    /**
     * Método que elimina un producto del carrito
     * @param item Producto a eliminar
     * @throws ProductNotFoundException si el producto no se encuentra
     */
    public void removeItem(Product item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();}
    }

    /**
     * Número de productos en el carrito
     * @return
     */
    public int getItemCount() {
        return items.size();
    }

    /**
     * Método que vacía el carrito
     */
    public void empty() {
        items.clear();
    }
}


