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
    private int speed ;
    private int level  ;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static SpinneryFactory spinneryFactory  = new SpinneryFactory();
    Image spinneryImage;
    Image spinneryImage2 ;
    Image spinneryImage3 ;
    Image spinneryImage4;

    {
        try {
            spinneryImage = new Image(new FileInputStream("Workshops\\Spinnery (Spinnery)\\01.png"));
            spinneryImage2 = new Image(new FileInputStream("Workshops\\Spinnery (Spinnery)\\02.png"));
            spinneryImage3 = new Image(new FileInputStream("Workshops\\Spinnery (Spinnery)\\03.png"));
            spinneryImage4 = new Image(new FileInputStream("Workshops\\Spinnery (Spinnery)\\04.png"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView viewOfSpinnery  = new ImageView();
    public void checkLevelOfSpinnery()
    {
        if (getLevel()==1)
            viewOfSpinnery.setImage(spinneryImage);
        if (getLevel()==2)
            viewOfSpinnery.setImage(spinneryImage2);
        if (getLevel()==3)
            viewOfSpinnery.setImage(spinneryImage3);
        if (getLevel()==4)
            viewOfSpinnery.setImage(spinneryImage4);

    }

    public ImageView getViewOfSpinnery() {
        return viewOfSpinnery;
    }
    public Animation spinneryAnimation() {
        if (getLevel()==1)
        return new SpriteAnimation(viewOfSpinnery, Duration.millis(1000), 16, 4, 0, 0,
                520/4, 424/4);
        else if (getLevel()==2)
            return new SpriteAnimation(viewOfSpinnery, Duration.millis(1000), 16, 4, 0, 0,
                    552/4, 600/4);
        else if (getLevel()==3)
            return new SpriteAnimation(viewOfSpinnery, Duration.millis(1000), 16, 4, 0, 0,
                    712/4, 584/4);
        else
            return new SpriteAnimation(viewOfSpinnery, Duration.millis(1000), 16, 4, 0, 0,
                    704/4, 728/4);

    }

    public void setViewOfSpinnery(ImageView viewOfSpinnery) {
        this.viewOfSpinnery = viewOfSpinnery;
    }

    public SpinneryFactory() {
    }

    public static SpinneryFactory getSpinneryFactory() {
        return spinneryFactory;
    }
    public void upgradeSpinnery()
    {
        speed++;
        setLevel(getLevel()+1);
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
