package Model;


public class Animal extends Entity {

    public void randomWalk() {
        double rand = Math.random()*8;
        int random  = (int) rand;
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
    }

    public void smartWalk() {
    }
    public void nextTurn(){

    }
}