package Model.Animals;

import Model.Products.Wool;

public class Sheep extends ProducerAnimal {
    private Wool wool;
    @Override
    public boolean isMoving() {
        if (cells[x][y].getGrass().isGrass())
            return false;
        return true;
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