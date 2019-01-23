package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Clothe;
import Model.Products.Fabric;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SewingFactory extends WorkShop {
    // fabric  --> clothe

    private static SewingFactory sewingFactory = new SewingFactory();
    Image sewingImage1;

    {
        try {
            sewingImage1 = new Image(new FileInputStream("Workshops\\CarnivalDress (Sewing Factory)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView viewOfSewing = new ImageView(sewingImage1);

    public ImageView getViewOfSewing() {
        return viewOfSewing;
    }
    public Animation sewingAnimation() {
        return new SpriteAnimation(viewOfSewing, Duration.millis(1000), 16, 4, 0, 0,
                680/4, 520/4);
    }

    public static SewingFactory getSewingFactory() {
        return sewingFactory;
    }

    public SewingFactory() {
    }

    Depot depot = Depot.getDepot() ;

    Clothe clothe = new Clothe();

    public void makeClothe(){
        if (ourFarm.getInPutsOfSewingFactory().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int j = ourFarm.getInPutsOfSewingFactory().size()-1 ; j>=0 ; j--)
            {
                if (ourFarm.getInPutsOfSewingFactory().get(j) instanceof Fabric)
                {
                    ourFarm.getOutPutsOfSewingFactory().add(new Clothe());
                    ourFarm.getInPutsOfSewingFactory().remove(j);
                }
            }
        }
    }

}
