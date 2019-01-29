package Model.Animals;

import Controller.FarmController;
import Model.OnMaps.Cell;
import Model.OnMaps.Entity;
import Model.Utils;
import javafx.scene.image.Image;


public abstract class Animal extends Entity {
    protected Cell cell;
    double xDirection;
    double yDirection  ;



    public void randomWalk() {
        double rand = Math.random() * 8;

        int random = (int) rand;
        if (random == 0) {
            this.x--;
            xDirection = -1 ;
            yDirection = 0;
        }
        if (random == 1) {
            this.x--;
            this.y++;
            xDirection = -1 ;
            yDirection = 1;

        }
        if (random == 2) {
            this.y++;
            xDirection = 0 ;
            yDirection = 1;
        }
        if (random == 3) {
            this.x++;
            this.y++;
            xDirection = 1 ;
            yDirection = 1;
        }
        if (random == 4) {
            this.x++;
            xDirection = 1 ;
            yDirection = 0;
        }
        if (random == 5) {
            this.x++;
            this.y--;
            xDirection = 1 ;
            yDirection = -1;
        }
        if (random == 6) {
            this.y--;
            xDirection = 0 ;
            yDirection = -1;
        }
        if (random == 7) {
            this.x--;
            this.y--;
            xDirection = -1 ;
            yDirection = -1;
        }
        setOnMap();
    }
    public double getxDirection() {
        return xDirection;
    }

    public void setxDirection(double xDirection) {
        this.xDirection = xDirection;
    }

    public double getyDirection() {
        return yDirection;
    }

    public void setyDirection(double yDirection) {
        this.yDirection = yDirection;
    }


    public void smartWalk() {
    }

    public void nextTurn() {

    }
    public  boolean isMoving(){
        return true;
    }
    protected Image toLeft  ;
    protected Image toDownLeft  ;
    protected Image toDown  ;
    protected Image toUp ;
    protected Image toUpLeft ;
    Cell[][] cells = FarmController.getInstance().getMap().getCells();


    public Image getToLeft() {
        return toLeft;
    }

    public Image getToDownLeft() {
        return toDownLeft;
    }

    public Image getToDown() {
        return toDown;
    }

    public Image getToUp() {
        return toUp;
    }

    public Image getToUpLeft() {
        return toUpLeft;
    }

    public void setToLeft() {

    }

    public void setToDownLeft() {

    }

    public void setToDown() {

    }

    public void setToUp() {

    }

    public void setToUpLeft() {

    }

    public void setOnMap() {
        if (this.x < 0)
            this.x = 0;
        if (this.x >= Utils.mapSize)
            this.x = Utils.mapSize - 1;
        if (this.y < 0)
            this.y = 0;
        if (this.y >= Utils.mapSize)
            this.y = Utils.mapSize - 1;
    }


    public int getSpeed() {
        return 1;
    }
}