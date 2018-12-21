package Model.Animals;

import Model.Upgradable;

public class Cat extends DomesticAnimal implements Upgradable {
    private int level = 1;

    @Override
    public void upgrade() {
        this.setLevel(2);
    }

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {

    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void nextTurn() {
        if(this.level == 1)
            this.randomWalk();
        else
            this.smartWalk();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}