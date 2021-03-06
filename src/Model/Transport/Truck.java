package Model.Transport;

import Model.Upgradable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Truck extends Transportation implements Upgradable {
    Image imageOfTruck1;

    {
        try {
            imageOfTruck1 = new Image(new FileInputStream("Service\\Truck\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfTruck2;

    {
        try {
            imageOfTruck2 = new Image(new FileInputStream("Service\\Truck\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfTruck3;

    {
        try {
            imageOfTruck3 = new Image(new FileInputStream("Service\\Truck\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfTruck4;

    {
        try {
            imageOfTruck4 = new Image(new FileInputStream("Service\\Truck\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
ImageView imageView = new ImageView();



    private int capacity = 50 ;
    private int speed  = 2 ;
    private int stored = 0;
    private int level = 1 ;
    private int maxLevel = 4 ; //Alaki meqdaaar dadim
    private int upgradeCost = 50 ;
    {
        if (level == 1)
        {
            imageView.setImage(imageOfTruck1);
        }
        else if (level ==2)
        {
            imageView.setImage(imageOfTruck2);
        }
        else if (level == 3)
        {
            imageView.setImage(imageOfTruck3);
        }
        else
        {
            imageView.setImage(imageOfTruck4);
        }
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStored() {
        return stored;
    }


    public void setStored(int stored) {
        this.stored = stored;
    }
    public boolean isFullTruck()
    {
        if (animalsInTransportation.size() + productsInTransportation.size() >= capacity)
            return true ;
        else
            return false ;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    private static Truck truck = new Truck();

    private Truck() {
    }

    public static Truck getTruck() {
        return truck;
    }

    public void upgrade() throws Exception{
        int money = 100 ;
        if(this.level == maxLevel)
            throw new Exception("Level exceeded!!") ;
        if(money < upgradeCost)
            throw new Exception("Money is not enough!!") ;
        setLevel(getLevel() + 1 );
        setSpeed(getSpeed() + 2 );
        setCapacity(getCapacity() + 20 );
        money -= upgradeCost ;
    }
}
