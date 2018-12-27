package Model;

import Model.Animals.Animal;
import Model.Animals.DomesticAnimal;

import java.util.ArrayList;
import java.util.Arrays;

public class OurFarm implements java.io.Serializable{
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList <Product> products = new ArrayList<>();
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
    private ArrayList<Product>inPutsOfCakeBakery = new ArrayList<>();
    private ArrayList<Product>outPutsOfCakeBakery = new ArrayList<>();
    private ArrayList<Product>inPutsOfCookieBakery = new ArrayList<>();
    private ArrayList<Product>outPutsOfCookieBakery = new ArrayList<>();
    private ArrayList<Product>inPutsOfSpinnery = new ArrayList<>();
    private ArrayList<Product>outPutsOfSpinnery = new ArrayList<>();
    private ArrayList<Product>inPutsOfWeavingFactory = new ArrayList<>();
    private ArrayList<Product>outPutsOfWeavingFactory = new ArrayList<>();
    private ArrayList<Product>inPutsOfSewingFactory = new ArrayList<>();
    private ArrayList<Product>outPutsOfSewingFactory = new ArrayList<>();
    private ArrayList<Product>inPutsOfEggPowderPlantWorkshop = new ArrayList<>();
    private ArrayList<Product>outPutsOfEggPowderPlantWorkshop = new ArrayList<>();

    public ArrayList<Product> getInPutsOfCakeBakery() {
        return inPutsOfCakeBakery;
    }

    public void setInPutsOfCakeBakery(ArrayList<Product> inPutsOfCakeBakery) {
        this.inPutsOfCakeBakery = inPutsOfCakeBakery;
    }

    public ArrayList<Product> getOutPutsOfCakeBakery() {
        return outPutsOfCakeBakery;
    }

    public void setOutPutsOfCakeBakery(ArrayList<Product> outPutsOfCakeBakery) {
        this.outPutsOfCakeBakery = outPutsOfCakeBakery;
    }

    public ArrayList<Product> getInPutsOfCookieBakery() {
        return inPutsOfCookieBakery;
    }

    public void setInPutsOfCookieBakery(ArrayList<Product> inPutsOfCookieBakery) {
        this.inPutsOfCookieBakery = inPutsOfCookieBakery;
    }

    public ArrayList<Product> getOutPutsOfCookieBakery() {
        return outPutsOfCookieBakery;
    }

    public void setOutPutsOfCookieBakery(ArrayList<Product> outPutsOfCookieBakery) {
        this.outPutsOfCookieBakery = outPutsOfCookieBakery;
    }

    public ArrayList<Product> getInPutsOfSpinnery() {
        return inPutsOfSpinnery;
    }

    public void setInPutsOfSpinnery(ArrayList<Product> inPutsOfSpinnery) {
        this.inPutsOfSpinnery = inPutsOfSpinnery;
    }

    public ArrayList<Product> getOutPutsOfSpinnery() {
        return outPutsOfSpinnery;
    }

    public void setOutPutsOfSpinnery(ArrayList<Product> outPutsOfSpinnery) {
        this.outPutsOfSpinnery = outPutsOfSpinnery;
    }

    public ArrayList<Product> getInPutsOfWeavingFactory() {
        return inPutsOfWeavingFactory;
    }

    public void setInPutsOfWeavingFactory(ArrayList<Product> inPutsOfWeavingFactory) {
        this.inPutsOfWeavingFactory = inPutsOfWeavingFactory;
    }

    public ArrayList<Product> getOutPutsOfWeavingFactory() {
        return outPutsOfWeavingFactory;
    }

    public void setOutPutsOfWeavingFactory(ArrayList<Product> outPutsOfWeavingFactory) {
        this.outPutsOfWeavingFactory = outPutsOfWeavingFactory;
    }

    public ArrayList<Product> getInPutsOfSewingFactory() {
        return inPutsOfSewingFactory;
    }

    public void setInPutsOfSewingFactory(ArrayList<Product> inPutsOfSewingFactory) {
        this.inPutsOfSewingFactory = inPutsOfSewingFactory;
    }

    public ArrayList<Product> getOutPutsOfSewingFactory() {
        return outPutsOfSewingFactory;
    }

    public void setOutPutsOfSewingFactory(ArrayList<Product> outPutsOfSewingFactory) {
        this.outPutsOfSewingFactory = outPutsOfSewingFactory;
    }

    public ArrayList<Product> getInPutsOfEggPowderPlantWorkshop() {
        return inPutsOfEggPowderPlantWorkshop;
    }

    public void setInPutsOfEggPowderPlantWorkshop(ArrayList<Product> inPutsOfEggPowderPlantWorkshop) {
        this.inPutsOfEggPowderPlantWorkshop = inPutsOfEggPowderPlantWorkshop;
    }

    public ArrayList<Product> getOutPutsOfEggPowderPlantWorkshop() {
        return outPutsOfEggPowderPlantWorkshop;
    }

    public void setOutPutsOfEggPowderPlantWorkshop(ArrayList<Product> outPutsOfEggPowderPlantWorkshop) {
        this.outPutsOfEggPowderPlantWorkshop = outPutsOfEggPowderPlantWorkshop;
    }
}
