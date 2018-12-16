package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Depot extends Building implements Upgradable {
    private int capacity;
    private int level;
    private int maxLevel;
    private static Depot depot = new Depot();

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private Depot() {

    }

    public static Depot getDepot() {
        return depot;
    }

    public ArrayList<WildAnimal> getStoredWildAnimal() {
        return storedWildAnimal;
    }

    public void setStoredWildAnimal(ArrayList<WildAnimal> storedWildAnimal) {
        this.storedWildAnimal = storedWildAnimal;
    }

    @Override
    public void upgrade() {
        depot.setCapacity(depot.getCapacity()+20);
    }

    private boolean isFull = false;


    private ArrayList<Product> storedProducts;
    private ArrayList<WildAnimal> storedWildAnimal ;

   // public void store(Product... products) {
   //     storedProducts.addAll(Arrays.asList(products));
   // }

    public Product pickUp(Product... products) {
        return null;
    }

    public boolean isFull() {
        return isFull;
    }

    public ArrayList<Product> getStoredProducts() {
        return storedProducts;
    }

    public void setStoredProducts(ArrayList<Product> storedProducts) {
        this.storedProducts = storedProducts;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

}


