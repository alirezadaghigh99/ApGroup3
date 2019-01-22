package Model.OnMaps;

import Model.SpriteAnimation;
import Model.Upgradable;
import Model.Workshop.Building;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Well extends Building implements Upgradable {
    private int capacity = 50 ;
    private int storage = 50 ;
    private int level ;
    private ImageView imageView ;
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

    {
        if (level==1)
            imageView.setImage(imageOfWell1);
        else if (level==2)
            imageView.setImage(imageOfWell2);
        else if (level==3)
            imageView.setImage(imageOfWell3);
        else if (level == 4)
            imageView.setImage(imageOfWell4);
    }

    Animation animation1 = new SpriteAnimation(imageView , Duration.millis(1000) , 16 , 4 , 0 , 0 ,
            600 , 544);


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
