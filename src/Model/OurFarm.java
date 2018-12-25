package Model;

import Model.Animals.Animal;
import Model.Animals.DomesticAnimal;

import java.util.ArrayList;

public class OurFarm {
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList <Product> products = new ArrayList<>();
    private ArrayList <Building> buildings = new ArrayList<>();
    private static OurFarm ourFarm = new OurFarm();


    private OurFarm() {
        this.ourFarm = ourFarm;
    }

    public static OurFarm getOurFarm(){
        return ourFarm ;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
