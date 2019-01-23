package Model.Workshop;

import Model.Products.Cake;
import Model.Products.Egg;
import Model.Products.Flour;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CakeBakery extends WorkShop {
    private static CakeBakery cakeBakery = new CakeBakery();
    // flour & cookie --> cake
    private boolean count1 = false;
    private boolean count2 = false;

    private CakeBakery() {
    }

    public static CakeBakery getCakeBakery() {
        return cakeBakery;
    }
Image cakeBakeryImage;

    {
        try {
            cakeBakeryImage = new Image(new FileInputStream("Workshops\\Cake (Cookie Bakery)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView viewOfCakeBakery = new ImageView(cakeBakeryImage);

    public ImageView getViewOfCakeBakery() {
        return viewOfCakeBakery;
    }

    public void setViewOfCakeBakery(ImageView viewOfCakeBakery) {
        this.viewOfCakeBakery = viewOfCakeBakery;
    }

    public Animation CakeAnimation() {
        return new SpriteAnimation(viewOfCakeBakery, Duration.millis(1000), 16, 4, 0, 0,
                536/4, 568/4);
    }

    public void makeCake() {
        if (ourFarm.getInPutsOfCakeBakery().isEmpty()) {
            System.out.println("there is nothing to create");
        } else {
            for (int k = ourFarm.getInPutsOfCakeBakery().size() - 1; k >= 0; k--) {
                if (ourFarm.getInPutsOfCakeBakery().get(k) instanceof Egg)
                    count1 = true;
                if (ourFarm.getInPutsOfCakeBakery().get(k) instanceof Flour)
                    count2 = true;
                if (count1 && count2)
                    ourFarm.getOutPutsOfCakeBakery().add(new Cake());

            }

            if (!(count2 && count1))
                System.out.println("there is nothing to create");
        }

    }


    //public Cake cookBakery(Flour flour, Egg egg){
    //   return new Cake() ;
    // }

}
