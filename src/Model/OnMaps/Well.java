
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
    private int capacity = 50;
    private int storage = 0;
    private int level = 1;
    private ImageView imageView;
    Image imageOfWell1;

    {
        try {
            imageOfWell1 = new Image(new FileInputStream("Service\\Well\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell2;

    {
        try {
            imageOfWell2 = new Image(new FileInputStream("Service\\Well\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell3;

    {
        try {
            imageOfWell3 = new Image(new FileInputStream("Service\\Well\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image imageOfWell4;

    {
        try {
            imageOfWell4 = new Image(new FileInputStream("Service\\Well\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

//    {
//        if (level==1)
//            imageView.setImage(imageOfWell1);
//        else if (level==2)
//            imageView.setImage(imageOfWell2);
//        else if (level==3)
//            imageView.setImage(imageOfWell3);
//        else if (level == 4)
//            imageView.setImage(imageOfWell4);
//    }

    ImageView imageView1 = new ImageView();

    public void checkLevel() {
        if (getLevel() == 1) {
            imageView1.setImage(imageOfWell1);

        } else if (getLevel() == 2) {
            System.out.println("lebas");
            imageView1.setImage(imageOfWell2);
        } else if (getLevel() == 3)
            imageView1.setImage(imageOfWell3);
        else if (getLevel() == 4)
            imageView1.setImage(imageOfWell4);
    }
//ImageView imageView2 = new ImageView(imageOfWell2) ;
//    ImageView imageView3 = new ImageView(imageOfWell3) ;
    // ImageView imageView4 = new ImageView(imageOfWell4) ;

    ImageView ourview = new ImageView(imageOfWell1);

    public Image getImageOfWell1() {
        return imageOfWell1;
    }

    public void setImageOfWell1(Image imageOfWell1) {
        this.imageOfWell1 = imageOfWell1;
    }

    public Animation wellAnimation(ImageView imageViewOfFuck) {
        if (getLevel() == 1)
            return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0,
                    150, 136);
        else if (getLevel() == 2)
            return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0, 592 / 4, 600 / 4);
        else if (getLevel() == 3)
            return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0, 576 / 4, 632 / 4);
        else
            return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0, 592 / 4, 536 / 4);

    }

    public Animation wellBoardAnimation(ImageView imageViewa, int a) {
        return new SpriteAnimation(imageViewa, Duration.millis(1000), 16, 4, 0, 0, 592 / 4, 600 / 4);

    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static Well well = new Well();

    private Well() {
    }

    public ImageView getImageView1() {
        return imageView1;
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
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

    public void pickUpWater(int litre) {
        well.setStorage(well.getStorage() - litre);
    }

    public void addWater() {
        if (well.getCapacity() != well.getStorage()) {

            well.setStorage(well.getCapacity());
        }

    }

    public boolean isfull() {
        if (storage == capacity)
            return true;
        else return false;
    }


    @Override
    public void upgrade() {
        Well.getWell().setLevel(level + 1);
        System.out.println("mamad");
        setCapacity(getCapacity() + 10);
    }
}
