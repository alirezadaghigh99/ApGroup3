package Model.Animals;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Lion extends WildAnimal {
    private int timeToNextHungry;
    Image LionToCage;

    {
        try {
            LionToCage = new Image(new FileInputStream("Animals\\Africa\\Lion\\caged.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image LionToUp;

    {
        try {
            LionToUp = new Image(new FileInputStream("Animals\\Africa\\Lion\\up.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image LionToDown;

    {
        try {
            LionToDown = new Image(new FileInputStream("Animals\\Africa\\Lion\\down.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image LionToDownLeft;

    {
        try {
            LionToDownLeft = new Image(new FileInputStream("Animals\\Africa\\Lion\\down_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image LionToLeft;

    {
        try {
            LionToLeft = new Image(new FileInputStream("Animals\\Africa\\Lion\\left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image LionToUpLeft;

    {
        try {
            LionToUpLeft = new Image(new FileInputStream("Animals\\Africa\\Lion\\up_left.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setToLeft() {
        this.toLeft = LionToLeft;
    }

    @Override
    public void setToDownLeft() {
        this.toDownLeft = LionToDownLeft;
    }

    @Override
    public void setToDown() {
        this.toDown = LionToDown;
    }

    @Override
    public void setToUp() {
this.toUp = LionToUp;    }

    @Override
    public void setToUpLeft() {
this.toUpLeft = LionToUpLeft;
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