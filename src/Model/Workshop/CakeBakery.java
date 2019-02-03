package Model.Workshop;

import Model.OnMaps.Depot;
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
    Image startOfCakeBakery;

    {
        try {
            startOfCakeBakery = new Image(new FileInputStream("pictures\\start1.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView startViewOfCakeBakery = new ImageView(startOfCakeBakery);

    public ImageView getStartViewOfCakeBakery() {
        return startViewOfCakeBakery;
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
    Image StartImage;

    {
        try {
            StartImage = new Image(new FileInputStream("pictures\\go.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView startView = new ImageView(StartImage);

    public ImageView getStartView() {
        return startView;
    }

    public void makeCake() {
        if (Depot.getDepot().getStoredProducts().isEmpty()) {
            System.out.println("there is nothing to create");
        } else {
            for (int k = ourFarm.getInPutsOfCakeBakery().size() - 1; k >= 0; k--) {
                if (Depot.getDepot().getStoredProducts().get(k) instanceof Egg)
                    Depot.getDepot().getStoredProducts().add(new Cake());

            }

            if (!(count2 && count1))
                System.out.println("there is nothing to create");
        }

    }


    //public Cake cookBakery(Flour flour, Egg egg){
    //   return new Cake() ;
    // }

}
