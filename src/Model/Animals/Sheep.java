package Model.Animals;

import Model.ProducerAnimal;
import Model.Products.Wool;

public class Sheep extends ProducerAnimal {
    private Wool wool = new Wool();

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