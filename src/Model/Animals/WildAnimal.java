package Model.Animals;

import Model.OnMaps.Cell;
import Model.OnMaps.Map;
import Model.OurFarm;
import Model.Utils;

public class WildAnimal extends Animal {
    OurFarm ourFarm =OurFarm.getOurFarm();
    private boolean isCaged = false ;
    @Override
    public boolean isCaged() {
        return isCaged;
    }

    public void setCaged(boolean caged) {
        isCaged = caged;
    }

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
        Map map = ourFarm.getMap();
        Cell[][] cells = map.getCells();
        for (int k = 1; k < Utils.mapSize; k++) {
            for (int i = x - k; i < x + k; i++) {
                for (int j = x - k; j < x + k; j++) {
                    if (i >= 0 && i < Utils.mapSize && j >= 0 && j < Utils.mapSize &&
                            !cells[i][j].getCellAnimals().isEmpty()) {
                        for (int z = 0; z < cells[i][j].getCellAnimals().size(); z++) {
                            if (cells[i][j].getCellAnimals().get(z) instanceof ProducerAnimal) {
                                if (isMoved()) {
                                    if (i > x)
                                        x++;
                                    else if (i < x)
                                        x--;
                                    if (j > y)
                                        y++;
                                    else if (j < y)
                                        y--;
                                }
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
            this.randomWalk();
           // this.smartWalk();
        }
        setOnMap();
    }

    @Override
    public boolean isMoving() {
        return isMoved();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}