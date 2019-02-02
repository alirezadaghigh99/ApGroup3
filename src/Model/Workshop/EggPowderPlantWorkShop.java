package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Egg;
import Model.Products.EggPowder;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EggPowderPlantWorkShop extends WorkShop {
    // EGG --> eggpowder
    EggPowder eggPowder = new EggPowder() ;
    int level  = 1 ;

    private static EggPowderPlantWorkShop eggPowderPlantWorkShop = new EggPowderPlantWorkShop();

    public EggPowderPlantWorkShop() {
    }

    public static EggPowderPlantWorkShop getEggPowderPlantWorkShop() {
        return eggPowderPlantWorkShop;
    }

    Depot depot = Depot.getDepot() ;
    Image EggPowderWorkshop1;

    {
        try {
            EggPowderWorkshop1 = new Image(new FileInputStream("Workshops\\DriedEggs (Egg Powder Plant)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image EggPowderWorkshop2;

    {
        try {
            EggPowderWorkshop1 = new Image(new FileInputStream("Workshops\\DriedEggs (Egg Powder Plant)\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image EggPowderWorkshop3;

    {
        try {
            EggPowderWorkshop1 = new Image(new FileInputStream("Workshops\\DriedEggs (Egg Powder Plant)\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image EggPowderWorkshop4;

    {
        try {
            EggPowderWorkshop1 = new Image(new FileInputStream("Workshops\\DriedEggs (Egg Powder Plant)\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView imageView1  = new ImageView();
    public void checkLevelOfEggPowder()
    {
        if (level==1)
        {
            imageView1.setImage(EggPowderWorkshop1);
        }
        if (level==2)
        {
            imageView1.setImage(EggPowderWorkshop2);

        }
        if (level==3)
        {
            imageView1.setImage(EggPowderWorkshop3);

        }
        if (level==4)
        {
            imageView1.setImage(EggPowderWorkshop4);

        }
    }

    public ImageView getImageView1() {
        return imageView1;
    }
    public Animation eggPowderAnimation() {
        return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0,
                (int)(imageView1.getImage().getWidth()/4), (int)imageView1.getImage().getHeight()/4);
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }

    public void makeEggPowder(){
        if (Depot.getDepot().getStoredProducts().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = Depot.getDepot().getStoredProducts().size()-1 ; i>=0 ; i--)
            {
                if (Depot.getDepot().getStoredProducts().get(i) instanceof Egg) {
                    Depot.getDepot().getStoredProducts().add(new EggPowder());
                    Depot.getDepot().getStoredProducts().remove(i);
                }
            }
        }
    }
    public void upgrade()
    {
        this.level++;
    }



}
