package Model;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.Lion;
import Model.Products.Egg;
import Model.Products.Milk;
import Model.Products.Wool;

import java.util.ArrayList;

public class Depot extends Building implements Upgradable {
    private int capacity;
    private int depotStorage ;
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

    private boolean isFull = true;
    private ArrayList<Product> storedProducts = new ArrayList<>();
    private ArrayList<Animal> storedAnimal = new ArrayList<>();

    public void pickUp(int index) {
        storedProducts.remove(index);
    }

    public boolean isFull() {
        if (getDepotStorage()>=capacity)
            return true ;
        else return false;
    }

    public ArrayList<Product> getStoredProducts() {
        return storedProducts;
    }

    public void setStoredProducts(ArrayList<Product> storedProducts) {
        this.storedProducts = storedProducts;
    }

    public void addStoredProducts(Product product){
        this.storedProducts.add(product);
    }
    public void setFull(boolean full) {
        isFull = full;
    }
    private int getDepotStorage()
    {
        for (int i = 0 ; i<storedAnimal.size() ; i++)
        {
            if (storedAnimal.get(i) instanceof Lion)
                depotStorage+=Utils.DEPOT_SIZE_FOR_CAGED_LION;
            if (storedAnimal.get(i) instanceof Bear)
                depotStorage+=Utils.DEPOT_SIZE_FOR_CAGED_BROWN_BEAR;

        }
        for (int i = 0 ; i<storedProducts.size() ; i++) {
            if (storedProducts.get(i) instanceof Egg) {
                depotStorage += Utils.DEPOT_SIZE_FOR_EGG;
//<<<<<<< Updated upstream
            if (storedProducts.get(i) instanceof Milk)
                depotStorage+=Utils.DEPOT_SIZE_FOR_MILK;
            if (storedProducts.get(i) instanceof Wool)
                depotStorage+=Utils.DEPOT_SIZE_FOR_WOOL ;
//=======
            }
            if (storedProducts.get(i) instanceof Milk) {
                depotStorage += Utils.DEPOT_SIZE_FOR_MILK;
            }
            if (storedProducts.get(i) instanceof Wool) {
                depotStorage += Utils.DEPOT_SIZE_FOR_WOOL;
            }
//>>>>>>> Stashed changes
        }
        return depotStorage ;
    }
    {
        Egg egg = new Egg();
        storedProducts.add(egg);
    }

}


