package Model.Animals;

import Model.ProducerAnimal;
import Model.Wool;

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
}