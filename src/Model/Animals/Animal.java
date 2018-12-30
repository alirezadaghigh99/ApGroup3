package Model.Animals;

import Model.OnMaps.Cell;
import Model.OnMaps.Entity;
import Model.Utils;


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