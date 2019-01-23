package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Sewing;
import Model.Products.Wool;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SpinneryFactory extends WorkShop {
    //wool --> sewing
    Sewing sewing = new Sewing();
    Depot depot = Depot.getDepot() ;
    private static SpinneryFactory spinneryFactory  = new SpinneryFactory();
    Image spinneryImage;

    {
        try {
            spinneryImage = new Image(new FileInputStream("Workshops\\Spinnery (Spinnery)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView viewOfSpinnery = new ImageView(spinneryImage);

    public ImageView getViewOfSpinnery() {
        return viewOfSpinnery;
    }
    public Animation spinneryAnimation() {
        return new SpriteAnimation(viewOfSpinnery, Duration.millis(1000), 16, 4, 0, 0,
                520/4, 424/4);
    }

    public void setViewOfSpinnery(ImageView viewOfSpinnery) {
        this.viewOfSpinnery = viewOfSpinnery;
    }

    public SpinneryFactory() {
    }

    public static SpinneryFactory getSpinneryFactory() {
        return spinneryFactory;
    }

    public void makeSewing(){
        {
            if (ourFarm.getInPutsOfSpinnery().isEmpty())
                System.out.println("there is nothing to create");
            else
            {
                for (int i = ourFarm.getInPutsOfSpinnery().size()-1 ; i>=0 ; i--)
                {
                    if (ourFarm.getInPutsOfSpinnery().get(i) instanceof Wool) {
                        ourFarm.getOutPutsOfSpinnery().add(new Sewing());
                        ourFarm.getInPutsOfSpinnery().remove(i);
                    }


                }
            }
        }}
}
