package Model.Animals;

import Model.Products.Milk;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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
private static Cow instance = new Cow();

    public static Cow getInstance() {
        return instance;
    }

    public ImageView getEatView() {
        return eatView;
    }

    public ImageView getDownView() {
        return downView;
    }

    public ImageView getLeftView() {
        return leftView;
    }

    public ImageView getDownleftView() {
        return downleftView;
    }

    public ImageView getUpView() {
        return upView;
    }

    public ImageView getUpleftView() {
        return upleftView;
    }
    public Animation eatAnimationOfCow()
    {
        return new SpriteAnimation(eatView , Duration.millis(2000) , 24 , 6,0,0,960/6 , 488/4);
    }
    @Override
    public Image getToLeft() {
        return this.toLeft;
    }

    @Override
    public Image getToDownLeft() {
        return this.toDownLeft;
    }

    @Override
    public Image getToDown() {
        return this.toDown;    }

    @Override
    public Image getToUp() {
        return this.toUp;
    }

    @Override
    public Image getToUpLeft() {
        return this.toUpLeft;
    }
    @Override
    public void setToLeft() {
        this.toLeft = CowToLeft;
    }

    @Override
    public void setToDownLeft() {
        this.toDownLeft = CowToDownLeft;
    }

    @Override
    public void setToDown() {
        this.toDown = CowToDown;
    }

    @Override
    public void setToUp() {
        this.toUp = CowToUp;
    }

    @Override
    public void setToUpLeft() {
        this.toUpLeft = CowToUpLeft;
    }

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