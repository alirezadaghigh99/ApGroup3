package Model;

public class DomesticAnimal extends Animal implements EatForage {
    private int energy;
    private boolean weak;
    private boolean averageEnergy;
    private boolean fullEnergy;
    private boolean dead;

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        super.smartWalk();
    }

    @Override
    public void eatForage() {

    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean isWeak() {
        return this.energy <= Utils.LOW_ENERGY_AMOUNT && this.energy > 0;
    }

    public boolean isAverageEnergy() {
        return this.energy > Utils.LOW_ENERGY_AMOUNT && this.energy < Utils.FULL_ENERGY_AMOUNT;
    }

    public boolean isFullEnergy() {
        return this.energy == Utils.FULL_ENERGY_AMOUNT;
    }

    @Override
    public void nextTurn() {
        if ()
    }
}
