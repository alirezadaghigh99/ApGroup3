package Model.Animals;

public class DomesticAnimal extends Animal {
    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {

    }
    @Override
    public void nextTurn() {

    }

    @Override
    public boolean isMoving() {
        return false;
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}