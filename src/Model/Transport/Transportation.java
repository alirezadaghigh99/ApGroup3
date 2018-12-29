package Model.Transport;

import Model.Animals.Animal;
import Model.OnMaps.Depot;
import Model.Products.Product;

import java.util.ArrayList;

public class Transportation {
    private Depot depot ;
    protected ArrayList<Animal>animalsInTransportation = new ArrayList<>();
    protected ArrayList<Product>productsInTransportation = new ArrayList<>();
    private static Transportation transportation = new Transportation();

    public Transportation() {
    }

    public static Transportation getTransportation() {
        return transportation;
    }

    public ArrayList<Animal> getAnimalsInTransportation() {
        return animalsInTransportation;
    }

    public void setAnimalsInTransportation(ArrayList<Animal> animalsInTransportation) {
        this.animalsInTransportation = animalsInTransportation;
    }

    public ArrayList<Product> getProductsInTransportation() {
        return productsInTransportation;
    }

    public void setProductsInTransportation(ArrayList<Product> productsInTransportation) {
        this.productsInTransportation = productsInTransportation;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}
