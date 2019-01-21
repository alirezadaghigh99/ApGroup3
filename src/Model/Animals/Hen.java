package Model.Animals;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Hen extends ProducerAnimal {
    Image henImagesOfDeath ;
    Image henImageOfDown;

    {
        try {
            henImageOfDown = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfDownLeft;

    {
        try {
            henImageOfDownLeft = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfEat;

    {
        try {
            henImageOfEat = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfLeft;

    {
        try {
            henImageOfLeft = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfUp;

    {
        try {
            henImageOfUp = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Image henImageOfUpLeft;


    {
        try {
            henImageOfUpLeft = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            henImagesOfDeath = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Approject\\Animals\\Africa\\GuineaFowl"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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