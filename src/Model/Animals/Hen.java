package Model.Animals;

import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hen extends ProducerAnimal {
    Image henImagesOfDeath ;
    Image henImageOfDown;
    private ImageView imageView = new ImageView();
    private SpriteAnimation spriteAnimation ;

    {
        try {
            henImageOfDown = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\down.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfDownLeft;

    {
        try {
            henImageOfDownLeft = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\down_left"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfEat;

    {
        try {
            henImageOfEat = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\eat.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfLeft;

    {
        try {
            henImageOfLeft = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfUp;

    {
        try {
            henImageOfUp = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\up.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfUpLeft;


    {
        try {
            henImageOfUpLeft = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\up_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            henImagesOfDeath = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\death.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    ImageView DeathView = new ImageView(henImagesOfDeath);
    ImageView UpView = new ImageView(henImageOfUp);
    ImageView eatView = new ImageView(henImageOfEat);
    ImageView UpLeftView = new ImageView(henImageOfUpLeft);
    ImageView DownView = new ImageView(henImageOfDown);
    ImageView DownLeftView = new ImageView(henImageOfDownLeft);
    ImageView LeftView =  new ImageView(henImageOfLeft);


    final Animation henAnimationOfDeath = new SpriteAnimation(DeathView , Duration.millis(2000) ,13 , 13 , 0 , 0 ,
    64 , 66);
//    final Animation henAnimationOfLeft = new SpriteAnimation();
//    final Animation henAnimationOfDown = new SpriteAnimation();
//    final Animation henAnimationToEat = new SpriteAnimation();
//    final Animation henUpToLeft = new SpriteAnimation();
//    final Animation henAnimationToUp = new SpriteAnimation();








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

}