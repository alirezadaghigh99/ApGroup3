package Model;

import Model.Animals.Animal;
import Model.Animals.DomesticAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class OurFarm implements java.io.Serializable{
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList <Product>products = new ArrayList<>();
    private ArrayList <Building> buildings = new ArrayList<>();
    private static OurFarm ourFarm = new OurFarm();
    Map map = Map.getMap();
    Cell[][] cells = map.getCells();
    public Map getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "OurFarm{" +
                "animals=" + animals +
                ", products=" + products +
                ", buildings=" + buildings +
                ", map=" + map +
                ", cells=" + Arrays.toString(cells) +
                '}';
    }

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
