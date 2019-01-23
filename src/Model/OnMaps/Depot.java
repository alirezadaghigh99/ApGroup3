package Model.OnMaps;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.Lion;
import Model.Products.*;
import Model.Upgradable;
import Model.Utils;
import Model.Workshop.Building;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Depot extends Building implements Upgradable {
    private int capacity;
    private int level = 1 ;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int depotStorage ;
    private int maxLevel;
    private static Depot depot = new Depot();
  Image image1;

    {
        try {
            image1 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Depot\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image2;

    {
        try {
            image2 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Depot\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image3;

    {
        try {
            image3 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Depot\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image14;

    {
        try {
            image14 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Depot\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
  // private ImageView imageView ;
//    {
//        if (level==1)
//            imageView.setImage(image1);
//        if (level==2)
//            imageView.setImage(image2);
//        if (level ==3)
//            imageView.setImage(image3);
//        else if (level==4)
//            imageView.setImage(image14);
//    }
    ImageView imageView = new ImageView(image1);

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

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
        level++;

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
                depotStorage+= Utils.DEPOT_SIZE_FOR_CAGED_LION;
            if (storedAnimal.get(i) instanceof Bear)
                depotStorage+=Utils.DEPOT_SIZE_FOR_CAGED_BROWN_BEAR;

        }
        for (int i = 0 ; i<storedProducts.size() ; i++) {
            if (storedProducts.get(i) instanceof Egg) {
                depotStorage += Utils.DEPOT_SIZE_FOR_EGG;
            if (storedProducts.get(i) instanceof Milk)
                depotStorage+=Utils.DEPOT_SIZE_FOR_MILK;
            if (storedProducts.get(i) instanceof Wool)
                depotStorage+=Utils.DEPOT_SIZE_FOR_WOOL ;
            }
            if (storedProducts.get(i) instanceof Flour) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FLOUR;
            }
            if (storedProducts.get(i) instanceof Cake) {
                depotStorage += Utils.DEPOT_SIZE_FOR_CAKE;
            }
            if (storedProducts.get(i) instanceof Cookie) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FLOURY_CAKE;
            }
            if (storedProducts.get(i) instanceof Fabric) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FABRIC;
            }
            if (storedProducts.get(i) instanceof Sewing) {
                depotStorage += Utils.DEPOT_SIZE_FOR_SEWING;
            }
            if (storedProducts.get(i) instanceof Clothe) {
                depotStorage += Utils.DEPOT_SIZE_FOR_CARNIVAL_DRESS;
            }
        }
        return depotStorage ;
    }

}


