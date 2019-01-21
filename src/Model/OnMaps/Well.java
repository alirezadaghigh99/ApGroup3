package Model.OnMaps;

import Model.Upgradable;
import Model.Workshop.Building;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Well extends Building implements Upgradable {
    private int capacity = 50 ;
    private int storage = 50 ;
    private int level ;
    Image imageOfWell1;

    {
        try {
            imageOfWell1 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Well"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell2;

    {
        try {
            imageOfWell2 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Well"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell3;

    {
        try {
            imageOfWell3 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Well"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell4;

    {
        try {
            imageOfWell4 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Well"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static Well well  = new Well();
    private Well() {
    }

    public static Well getWell() {
        return well;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public void pickUpWater(int litre){
        well.setStorage(well.getStorage()-litre);
    }
    public void addWater()
    {
        if (well.getCapacity() != well.getStorage()) {

            well.setStorage(well.getCapacity());
        }
    }



    @Override
    public void upgrade() {
        level = level + 1 ;
        capacity = capacity + 10 ;
    }
}
