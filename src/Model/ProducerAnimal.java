package Model;

import Model.Animals.DomesticAnimal;

public class ProducerAnimal extends DomesticAnimal {
    protected int timeTonextHungry;
    protected boolean isHungry;

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        super.smartWalk();
    }

    public int getTimeTonextHungry() {
        return timeTonextHungry;
    }

    public void setTimeTonextHungry(int timeTonextHungry) {
        this.timeTonextHungry = timeTonextHungry;
    }
}
