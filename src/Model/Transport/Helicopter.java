package Model.Transport;

import Model.SpriteAnimation;
import Model.Upgradable;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sun.plugin2.liveconnect.JSExceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Helicopter extends Transportation implements Upgradable {
    private int capacity = 100 ;
    private int speed = 5 ;
    private static Helicopter helicopter = new Helicopter();
    private int stored = 0 ;
    private int upgradeCost = 100 ;
    private int level = 1 ;
    private int maxLevel = 4 ;
    Image heliImage1;

    {
        try {
            heliImage1 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Helicopter\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image heliImage2;

    {
        try {
            heliImage2 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Helicopter\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image heliImage3;

    {
        try {
            heliImage3 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Helicopter\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image heliImage4;

    {
        try {
            heliImage4 = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Service\\Helicopter\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private ImageView imageView ;
    {
        if (level==1)
            imageView.setImage(heliImage1);
        if (level==2)
            imageView.setImage(heliImage2);
        if (level==3)
            imageView.setImage(heliImage3);
        if (level==3)
            imageView.setImage(heliImage4);

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
    public boolean ifFullHelicopter()
    {
        if (animalsInTransportation.size() + productsInTransportation.size()>=capacity)
            return true ;
        else return false ;
    }

    private Helicopter() {
    }

    public static Helicopter getHelicopter() {
        return helicopter;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public void upgrade() throws Exception {
        int money = 100 ;
        if(money < upgradeCost)
            throw new Exception("Money is not enough!!");
        if(this.level == maxLevel)
            throw new Exception("Level exceeded!!");
        setLevel(getLevel() + 1 ) ;
        setSpeed(getSpeed() + 5 ) ;
        setCapacity(getCapacity() + 50 ) ;
        money -= upgradeCost ;


    }
}
