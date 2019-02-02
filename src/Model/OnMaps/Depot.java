package Model.OnMaps;

import Model.Animals.Animal;
import Model.Animals.Bear;
import Model.Animals.Lion;
import Model.Products.*;
import Model.Upgradable;
import Model.Utils;
import Model.Workshop.Building;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Depot extends Building implements Upgradable {
    private int capacity;
    private int level = 1 ;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int depotStorage ;
    private int maxLevel;
    private static Depot depot = new Depot();
  Image image1;

    {
        try {
            image1 = new Image(new FileInputStream("Service\\Depot\\01.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image2;

    {
        try {
            image2 = new Image(new FileInputStream("Service\\Depot\\02.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image3;

    {
        try {
            image3 = new Image(new FileInputStream("Service\\Depot\\03.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image image14;

    {
        try {
            image14 = new Image(new FileInputStream("Service\\Depot\\04.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image behindImage;

    {
        try {
            behindImage = new Image(new FileInputStream("pictures\\secondMenu.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image backImage;

    {
        try {
            backImage = new Image(new FileInputStream("pictures\\backbutton2.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image eggImageIcon;

    {
        try {
            eggImageIcon = new Image(new FileInputStream("Products\\Egg\\normal.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image plumeImageIcon;

    {
        try {
            plumeImageIcon = new Image(new FileInputStream("Products\\Plume\\normal.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image woolImageIcon;

    {
        try {
            woolImageIcon = new Image(new FileInputStream("Products\\Wool\\normal.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image cakeImageIcon;

    {
        try {
            cakeImageIcon = new Image(new FileInputStream("Products\\Cake.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image eggPowderImageIcon;

    {
        try {
            eggPowderImageIcon = new Image(new FileInputStream("Products\\EggPowder.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image flouryCakeImageIcon;

    {
        try {
            flouryCakeImageIcon = new Image(new FileInputStream("Products\\FlouryCake.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image carnivalDressIcon;

    {
        try {
            carnivalDressIcon = new Image(new FileInputStream("Products\\CarnivalDress.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image fabricImageIcon;

    {
        try {
            fabricImageIcon = new Image(new FileInputStream("Products\\Fabric.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image milKImageIcon;

    {
        try {
            milKImageIcon = new Image(new FileInputStream("Products\\Milk.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image sewingIconImage;

    {
        try {
            sewingIconImage = new Image(new FileInputStream("Products\\Sewing.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    Image MilkIconImage;

    {
        try {
            sewingIconImage = new Image(new FileInputStream("Products\\Milk.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image flourImageIcon;

    {
        try {
            flourImageIcon = new Image(new FileInputStream("Products\\Flour.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    ImageView imageView = new ImageView();
public void checkDepotLevel()
    {
        if (level==1)
            imageView.setImage(image1);
        if (level==2)
            imageView.setImage(image2);
        if (level ==3)
            imageView.setImage(image3);
        else if (level==4)
            imageView.setImage(image14);
    }
    ImageView backView  = new ImageView(backImage);
    ImageView behindView = new ImageView(behindImage);
    ImageView EggView = new ImageView(eggImageIcon);
    ImageView FlourView = new ImageView(flourImageIcon);

    ImageView fabricView = new ImageView(fabricImageIcon);
    ImageView cakeView = new ImageView(cakeImageIcon);
    ImageView EggPowderView = new ImageView(eggPowderImageIcon);
    ImageView flouryCakeView = new ImageView(flouryCakeImageIcon);
    ImageView sewingView = new ImageView(sewingIconImage);
    ImageView carnivalView = new ImageView(carnivalDressIcon);
    ImageView milkView = new ImageView(milKImageIcon);

    public ImageView getMilkView() {
        return milkView;
    }

    public ImageView getEggView() {
        return EggView;
    }

    public ImageView getFlourView() {
        return FlourView;
    }

    public ImageView getFabricView() {
        return fabricView;
    }

    public ImageView getCakeView() {
        return cakeView;
    }

    public ImageView getEggPowderView() {
        return EggPowderView;
    }

    public ImageView getFlouryCakeView() {
        return flouryCakeView;
    }

    public ImageView getSewingView() {
        return sewingView;
    }

    public ImageView getCarnivalView() {
        return carnivalView;
    }

    public ImageView getBackView() {
        return backView;
    }

    public void setBackView(ImageView backView) {
        this.backView = backView;
    }

    public ImageView getBehindView() {
        return behindView;
    }

    public void setBehindView(ImageView behindView) {
        this.behindView = behindView;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    private Depot() {

    }

    public static Depot getDepot() {
        return depot;
    }

    public ArrayList<Animal> getStoredAnimal() {
        return storedAnimal;
    }

    public void setStoredAnimal(ArrayList<Animal> storedAnimal) {
        this.storedAnimal = storedAnimal;
    }

    @Override
    public void upgrade() {
        depot.setCapacity(depot.getCapacity()+20);
        level++;

    }

    private boolean isFull = true;
    private ArrayList<Product> storedProducts = new ArrayList<>();
    private ArrayList<Animal> storedAnimal = new ArrayList<>();

    public void pickUp(int index) {
        storedProducts.remove(index);
    }

    public boolean isFull() {
        if (getDepotStorage()>=capacity)
            return true ;
        else return false;
    }

    public ArrayList<Product> getStoredProducts() {
        return storedProducts;
    }

    public void setStoredProducts(ArrayList<Product> storedProducts) {
        this.storedProducts = storedProducts;
    }

    public void addStoredProducts(Product product){
        this.storedProducts.add(product);
    }
    public void setFull(boolean full) {
        isFull = full;
    }
    private int getDepotStorage()
    {
        for (int i = 0 ; i<storedAnimal.size() ; i++)
        {
            if (storedAnimal.get(i) instanceof Lion)
                depotStorage+= Utils.DEPOT_SIZE_FOR_CAGED_LION;
            if (storedAnimal.get(i) instanceof Bear)
                depotStorage+=Utils.DEPOT_SIZE_FOR_CAGED_BROWN_BEAR;

        }
        for (int i = 0 ; i<storedProducts.size() ; i++) {
            if (storedProducts.get(i) instanceof Egg) {
                depotStorage += Utils.DEPOT_SIZE_FOR_EGG;
            if (storedProducts.get(i) instanceof Milk)
                depotStorage+=Utils.DEPOT_SIZE_FOR_MILK;
            if (storedProducts.get(i) instanceof Wool)
                depotStorage+=Utils.DEPOT_SIZE_FOR_WOOL ;
            }
            if (storedProducts.get(i) instanceof Flour) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FLOUR;
            }
            if (storedProducts.get(i) instanceof Cake) {
                depotStorage += Utils.DEPOT_SIZE_FOR_CAKE;
            }
            if (storedProducts.get(i) instanceof Cookie) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FLOURY_CAKE;
            }
            if (storedProducts.get(i) instanceof Fabric) {
                depotStorage += Utils.DEPOT_SIZE_FOR_FABRIC;
            }
            if (storedProducts.get(i) instanceof Sewing) {
                depotStorage += Utils.DEPOT_SIZE_FOR_SEWING;
            }
            if (storedProducts.get(i) instanceof Clothe) {
                depotStorage += Utils.DEPOT_SIZE_FOR_CARNIVAL_DRESS;
            }
        }
        return depotStorage ;
    }

}


