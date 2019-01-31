package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Fabric;
import Model.Products.Sewing;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WeavingFactory extends WorkShop {
    // sewing --> Fabric
    Depot depot = Depot.getDepot() ;
    Fabric fabric = new Fabric() ;
    private static WeavingFactory weavingFactory = new WeavingFactory();
    private int levelOfWeaning=1 ;

    public int getLevelOfWeaning() {
        return levelOfWeaning;
    }

    public void setLevelOfWeaning(int levelOfWeaning) {
        this.levelOfWeaning = levelOfWeaning;
    }

    public WeavingFactory() {
    }
    Image weavingImage1;

    {
        try {
            weavingImage1 = new Image(new FileInputStream("Workshops\\Weaving (Weaving Factory)\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image weavingImage2;

    {
        try {
            weavingImage2 = new Image(new FileInputStream("Workshops\\Weaving (Weaving Factory)\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image weavingImage3;

    {
        try {
            weavingImage3 = new Image(new FileInputStream("Workshops\\Weaving (Weaving Factory)\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image weavingImage4;

    {
        try {
            weavingImage4 = new Image(new FileInputStream("Workshops\\Weaving (Weaving Factory)\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView weavingView = new ImageView();
    public void checkLevelOfWeaving()
    {
        if (levelOfWeaning==1)
            weavingView.setImage(weavingImage1);
        if (levelOfWeaning==2)
            weavingView.setImage(weavingImage2);
        if (levelOfWeaning==3)
            weavingView.setImage(weavingImage3);
        if (levelOfWeaning==4)
            weavingView.setImage(weavingImage4);
    }

    public ImageView getWeavingView() {
        return weavingView;
    }

    public void setWeavingView(ImageView weavingView) {
        this.weavingView = weavingView;
    }
        public Animation wavingAnimation()
        {
           // if (levelOfWeaning==1)
            {
                return new SpriteAnimation(weavingView , Duration.millis(2000) , 16 , 4 , 0,
                        (int) 0 , (int)(weavingView.getImage().getWidth()/4) ,(int)(weavingView.getImage().getHeight()/4)  );
            }
            //if (levelOfWeaning==2)
          //  {

           // }
           // if (levelOfWeaning==3)
           // {

//            }
//            if (levelOfWeaning==4)
//            {
//
//            }
        }
    public static WeavingFactory getWeavingFactory() {
        return weavingFactory;
    }

    public void makeFabric(){
        if (ourFarm.getInPutsOfWeavingFactory().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = ourFarm.getInPutsOfWeavingFactory().size()-1 ; i>=0 ; i--)
            {
                if (ourFarm.getInPutsOfWeavingFactory().get(i) instanceof Sewing) {
                    ourFarm.getOutPutsOfWeavingFactory().add(new Fabric());
                    ourFarm.getInPutsOfWeavingFactory().remove(i);
                }


            }
        }
    }

}
