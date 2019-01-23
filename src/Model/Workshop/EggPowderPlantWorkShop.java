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

    private static EggPowderPlantWorkShop eggPowderPlantWorkShop = new EggPowderPlantWorkShop();

    public EggPowderPlantWorkShop() {
    }

    public static EggPowderPlantWorkShop getEggPowderPlantWorkShop() {
        return eggPowderPlantWorkShop;
    }

    Depot depot = Depot.getDepot() ;
    Image EggPowderWorkshop;

    {
        try {
            EggPowderWorkshop = new Image(new FileInputStream("Workshops\\DriedEggs (Egg Powder Plant)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView imageView1  = new ImageView(EggPowderWorkshop);

    public ImageView getImageView1() {
        return imageView1;
    }
    public Animation eggPowderAnimation() {
        return new SpriteAnimation(imageView1, Duration.millis(1000), 16, 4, 0, 0,
                512/4, 456/4);
    }

    public void setImageView1(ImageView imageView1) {
        this.imageView1 = imageView1;
    }

    public void makeEggPowder(){
        if (ourFarm.getInPutsOfEggPowderPlantWorkshop().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = ourFarm.getInPutsOfEggPowderPlantWorkshop().size()-1 ; i>=0 ; i--)
            {
                if (ourFarm.getInPutsOfEggPowderPlantWorkshop().get(i) instanceof Egg) {
                    ourFarm.getOutPutsOfEggPowderPlantWorkshop().add(new EggPowder());
                    ourFarm.getInPutsOfEggPowderPlantWorkshop().remove(i);
                }
            }
        }
    }



}
