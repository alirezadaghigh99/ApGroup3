package Model;

import Model.Animals.DomesticAnimal;

public class ProducerAnimal extends DomesticAnimal {
    private int energy=Utils.FULL_ENERGY_AMOUNT;
    Cell cell;
    Product product;

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

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public boolean isDead() {
        return this.energy == 0;
    }

    public void produce() {

    }

    @Override
    public void nextTurn() {
        if (isFullEnergy()) {
            this.randomWalk();
            this.setEnergy(this.getEnergy() - 1);
        } else if (isAverageEnergy()) {
            if (this.getCell().getGrass().isGrass()) {
                this.getCell().getGrass().setGrass(false);
            } else {
                this.setEnergy(this.getEnergy() - 1);
            }
            this.randomWalk();
            if (this.energy == Utils.LOW_ENERGY_AMOUNT + 1) {
                this.produce();
                this.getCell().getCellProducts().add(this.getProduct());
            }
        } else if (isWeak()) {
            if (this.getCell().getGrass().isGrass()) {
                this.getCell().getGrass().setGrass(false);
            } else {
                this.setEnergy(this.getEnergy() - 1);
            }
            this.smartWalk();
        } else if (isDead()) {
            this.getCell().getCellAnimals().remove(this);
        }
    }
}
