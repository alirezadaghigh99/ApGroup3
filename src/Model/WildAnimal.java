package Model;

import Model.Animals.Animal;

public class WildAnimal extends Animal {
    private int energy = Utils.FULL_ENERGY_AMOUNT;

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        Map map = Map.getMap();
        Cell[][] cells = map.getCells();
        for (int k = 1; k < Utils.mapSize; k++) {
            for (int i = x - k; i < x + k; i++) {
                for (int j = x - k; j < x + k; j++) {
                    if (i >= 0 && i < Utils.mapSize && j >= 0 && j < Utils.mapSize &&
                            !cells[i][j].getCellAnimals().isEmpty()) {
                        for (int z = 0; z < cells[i][j].getCellAnimals().size(); z++) {
                            if (cells[i][j].getCellAnimals().get(z) instanceof ProducerAnimal) {
                                if (i > x)
                                    x = x + 1;
                                else if (i < x)
                                    x = x - 1;
                                if (j > y)
                                    y = y + 1;
                                else if (j < y)
                                    y = y - 1;
                                setOnMap();
                                return;
                            }
                        }
                    }
                }
            }
        }
        this.randomWalk();
    }

    @Override
    public void nextTurn() {
        if (this.energy > Utils.LOW_ENERGY_AMOUNT) {
            this.setEnergy(this.getEnergy() - 1);
            this.randomWalk();
        } else {
            this.setEnergy(this.getEnergy() - 1);
            this.smartWalk();
        }
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}