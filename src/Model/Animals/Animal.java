package Model.Animals;

import Model.OnMaps.Cell;
import Model.OnMaps.Entity;
import Model.Utils;
import javafx.scene.image.Image;


public class Animal extends Entity {
    protected Cell cell;


    public void randomWalk() {
        double rand = Math.random() * 8;
        int random = (int) rand;
        if (random == 0) {
            this.x--;
        }
        if (random == 1) {
            this.x--;
            this.y++;
        }
        if (random == 2) {
            this.y++;
        }
        if (random == 3) {
            this.x++;
            this.y++;
        }
        if (random == 4) {
            this.x++;
        }
        if (random == 5) {
            this.x++;
            this.y--;
        }
        if (random == 6) {
            this.y--;
        }
        if (random == 7) {
            this.x--;
            this.y--;
        }
        setOnMap();
    }

    public void smartWalk() {
    }

    public void nextTurn() {

    }
    protected Image toLeft  ;
    protected Image toDownLeft  ;
    protected Image toDown  ;
    protected Image toUp ;
    protected Image toUpLeft ;

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
}