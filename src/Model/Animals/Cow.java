package Model.Animals;

import Controller.FarmController;
import Model.OnMaps.Cell;
import Model.Products.Milk;
import Model.SpriteAnimalAnimation;
import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cow extends ProducerAnimal {
    private Milk milk;

    @Override
    public boolean isMoving() {
        if (cells[x][y].getGrass().isGrass())
            return false ;
        else  return true ;
    }
//    public Animation cowAnimation()
//    {
//        return new SpriteAnimalAnimation(Cow.getInstance() , 3);
//    }

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
            CowToDownLeft = new Image(new FileInputStream("Animals\\Africa\\Buffalo\\down_left.png"));
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
    public Animation eatAnimationOfCow(ImageView imageView)
    {
        return new SpriteAnimation(imageView , Duration.millis(2000) , 22 , 6,0,0,960/6, 488/4);
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
    ImageView imageView1 = new ImageView();
//    public ImageView checkCowState()
//    {
//        if (isMoving())
//        {
//            if (xDirection==-1&&yDirection==-1)
//                imageView1.setImage(CowToUpLeft);
//            if (xDirection==-1&&yDirection==0)
//                imageView1.setImage(CowToDown);
////           if (xDirection==-1&&yDirection==1)
////               imageView1.setImage(henImageOfUpRight);
//            if (xDirection==0&&yDirection==-1)
//                imageView1.setImage(toLeft);
//            if (xDirection==0&&yDirection==1)
//                imageView1.setImage(CowToRight);
//            if (xDirection==1&&yDirection==1)
//                imageView1.setImage(CowToDownRight);
//            if (xDirection==1&&yDirection==0)
//                imageView1.setImage(CowToUp);
//            if (xDirection==1&&yDirection==-1)
//                imageView1.setImage(CowToUpLeft);
//        }
//        else if (cells[x][y].getGrass().isGrass())
//            imageView1.setImage(CowToEat);
//        else imageView1.setImage(Cow);
//        return imageView1;
//    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
//    public Animation CowAnimation(int State1 , double State2 , double State3)
//    {
//        if (State1==1&&State2==1&&State3==-1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 350/4 , 360/4);//downlef
//        if (State1==1&&State2==1&&State3==-1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 350/4 , 360/4);//downleft
//        if (State1==1&&State2==1&&State3==0)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 330/4 , 360/4);//down
//        if (State1==1&&State2==0&&State3==-1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 400/4 , 370/4);//left
//
//        if (State1==1&&State2==-1&&State3==0)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 320/4 , 420/4);//up
//        if (State1==1&&State2==-1&&State3==-1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 340/4 , 400/4);//upleft
//        if (State1==1&&State2==0&&State3==1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 350/4 , 360/4);//right
//        if (State1==1&&State2==-1&&State3==1)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 350/4 , 360/4);//rightup
//        if (State1==2)
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 370/4 , 320/4);//eat
//        else
//            return new SpriteAnimation(imageView1 , Duration.millis(2000) , 25 , 5 , 0 , 0 , 390/4 , 350/4);//death
//    }
}