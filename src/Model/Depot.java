package Model;

import Model.Animals.Animal;

import java.util.ArrayList;

public class Depot extends Building implements Upgradable {
    private int capacity;
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

    public ArrayList<Animal> getStoredAnimal() {
        return storedAnimal;
    }

    public void setStoredAnimal(ArrayList<Animal> storedAnimal) {
        this.storedAnimal = storedAnimal;
    }

    @Override
    public void upgrade() {
        depot.setCapacity(depot.getCapacity()+20);
    }

    private boolean isFull = false;
    private ArrayList<Product> storedProducts = new ArrayList<>();
    private ArrayList<Animal> storedAnimal = new ArrayList<>();

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


