package Model.Animals;

import Model.Upgradable;

import Controller.FarmController;
public class Cat extends DomesticAnimal implements Upgradable {
    private int level = 1;
    private int upgradeCost = 125;

    @Override
    public void upgrade() throws Exception {
        int money = 100;
        if(level == 2)
            throw new Exception("Level exceeded");
        if(money < upgradeCost)
            throw new Exception("Money is not enough");

        money -= upgradeCost;
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
        if (this.level == 1)
            this.randomWalk();
        else
            this.smartWalk();
        setOnMap();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}