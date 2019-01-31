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
    private int level ;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private static SewingFactory sewingFactory = new SewingFactory();
    Image sewingImage1;

    {
        try {
            sewingImage1 = new Image(new FileInputStream("Workshops\\CarnivalDress (Sewing Factory)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image sewingLevel2;

    {
        try {
            sewingLevel2 = new Image(new FileInputStream("Workshops\\CarnivalDress (Sewing Factory)\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image sewingLevel3;

    {
        try {
            sewingLevel3 = new Image(new FileInputStream("Workshops\\CarnivalDress (Sewing Factory)\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image sewingLevel4;

    {
        try {
            sewingLevel4 = new Image(new FileInputStream("Workshops\\CarnivalDress (Sewing Factory)\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ImageView viewOfSewing = new ImageView(sewingImage1);

    public ImageView getViewOfSewing() {
        return viewOfSewing;
    }


    public static SewingFactory getSewingFactory() {
        return sewingFactory;
    }

    public SewingFactory() {
    }
    public void checkLevelOfSwewingFactory()
    {
        if (level==1)
        {
            viewOfSewing.setImage(sewingImage1);
        }
        else if (level==2)
        {
            viewOfSewing.setImage(sewingLevel2);
        }
        else if (level==3)
        {
            viewOfSewing.setImage(sewingLevel3);
        }
        else if (level == 4)
        {
            viewOfSewing.setImage(sewingLevel4);
        }
    }

    public void setViewOfSewing(ImageView viewOfSewing) {
        this.viewOfSewing = viewOfSewing;
    }
        public Animation sewingAnimation()
        {
            return new SpriteAnimation(viewOfSewing , Duration.millis(2000) , 16 , 4 , 0 , 0 ,
                    (int)(viewOfSewing.getImage().getWidth()/4) , (int)(viewOfSewing.getImage().getHeight()/4));
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
    public void upgrade()
    {
        level++;
    }

}
