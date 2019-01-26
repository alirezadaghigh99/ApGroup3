package Model.Animals;

import Model.SpriteAnimalAnimation;
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
            henImageOfDownLeft = new Image(new FileInputStream("Animals\\Africa\\GuineaFowl\\down_left.png"));
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

    @Override
    public void setToUp() {
        this.toUp = henImageOfUp;
    }

    @Override
    public void setToUpLeft() {
        this.toUpLeft = henImageOfUpLeft;
    }

    @Override
    public void setToLeft() {
        this.toLeft = henImageOfLeft;
    }

    @Override
    public void setToDownLeft() {
        this.toDownLeft = henImageOfDownLeft;
    }

    @Override
    public void setToDown() {
        this.toDown = henImageOfDown;
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

    public Image getHenImagesOfDeath() {
        return henImagesOfDeath;
    }

    public Image getHenImageOfDown() {
        return henImageOfDown;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public ImageView getDeathView() {
        return DeathView;
    }

    public ImageView getUpView() {
        return UpView;
    }

    public ImageView getEatView() {
        return eatView;
    }

    public ImageView getUpLeftView() {
        return UpLeftView;
    }

    public ImageView getDownView() {
        return DownView;
    }

    public ImageView getDownLeftView() {
        return DownLeftView;
    }

    public ImageView getLeftView() {
        return LeftView;
    }

    public Image getHenImageOfDownLeft() {
        return henImageOfDownLeft;
    }

    public Image getHenImageOfEat() {
        return henImageOfEat;
    }

    public Image getHenImageOfLeft() {
        return henImageOfLeft;
    }

    public Image getHenImageOfUp() {
        return henImageOfUp;
    }

    public Image getHenImageOfUpLeft() {
        return henImageOfUpLeft;
    }

    ImageView DeathView = new ImageView(henImagesOfDeath);
    ImageView UpView = new ImageView(henImageOfUp);
    ImageView eatView = new ImageView(henImageOfEat);
    ImageView UpLeftView = new ImageView(henImageOfUpLeft);
    ImageView DownView = new ImageView(henImageOfDown);
    ImageView DownLeftView = new ImageView(henImageOfDownLeft);
    ImageView LeftView =  new ImageView(henImageOfLeft);


    @Override
    public boolean isMoving() {
        if (cells[x][y].getGrass().isGrass())
        return false;
        return true;
    }

//    public Animation animationOfHen()
//    {
//     //   return new SpriteAnimalAnimation(Hen.getInstance() , 5);
//    }
    public Animation henAnimation()
    {
        return new SpriteAnimalAnimation(Hen.getInstance() , 3);
    }
    final Animation henAnimationOfDeath = new SpriteAnimation(DeathView , Duration.millis(2000) ,13 , 13 , 0 , 0 ,
    64 , 66);
    public Animation henEatAnimation()
    {
        return new SpriteAnimation(eatView , Duration.millis(2000) , 25 , 5 , 0 , 0 , 370/4 , 320/4);
    }
//    final Animation henAnimationOfLeft = new SpriteAnimation();
//    final Animation henAnimationOfDown = new SpriteAnimation();
//    final Animation henAnimationToEat = new SpriteAnimation();
//    final Animation henUpToLeft = new SpriteAnimation();
//    final Animation henAnimationToUp = new SpriteAnimation();




private static Hen instance = new Hen();

    public static Hen getInstance() {
        return instance;
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

}