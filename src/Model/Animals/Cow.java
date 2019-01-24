package Model.Animals;

import Model.Products.Milk;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cow extends ProducerAnimal {
    private Milk milk;
    Image CowToDown;

    {
        try {
            CowToDown = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\down.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image CowToDownLeft;

    {
        try {
            CowToDownLeft = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\Buffalo\\down_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image CowToUp;

    {
        try {
            CowToUp = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\up.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image CowToUpLeft;

    {
        try {
            CowToUpLeft = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\up_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image CowToEat;

    {
        try {
            CowToEat = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\eat.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image CowToLeft;

    {
        try {
            CowToLeft = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\up_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView eatView = new ImageView(CowToEat);
    ImageView downView = new ImageView(CowToDown);

    ImageView leftView = new ImageView(CowToLeft);
    ImageView downleftView = new ImageView(CowToDownLeft);
    ImageView upView = new ImageView(CowToUp);
    ImageView upleftView = new ImageView(CowToUpLeft);




    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        super.smartWalk();
    }

    @Override
    public void nextTurn() {
        super.nextTurn();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}