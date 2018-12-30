package Model.Animals;

import Model.Animals.DomesticAnimal;
import Model.Animals.Hen;
import Model.Animals.Sheep;
import Model.OnMaps.Cell;
import Model.OnMaps.Map;
import Model.OurFarm;
import Model.Products.Egg;
import Model.Products.Milk;
import Model.Products.Product;
import Model.Products.Wool;
import Model.Utils;

public class ProducerAnimal extends DomesticAnimal {
    private int energy = Utils.FULL_ENERGY_AMOUNT;
    Product product;
    OurFarm ourFarm = OurFarm.getOurFarm();
    Map map = ourFarm.getMap();

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        OurFarm ourFarm = OurFarm.getOurFarm();
        Map map = ourFarm.getMap();
        Cell[][] cell = map.getCells();
        for (int k = 1; k < Utils.mapSize; k++) {
            for (int i = x - k; i < x + k; i++) {
                for (int j = y - k; j < y + k; j++) {
                    if (i < Utils.mapSize && i >= 0 && j < Utils.mapSize && j >= 0
                            && cell[i][j].getGrass().isGrass()) {
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
        this.randomWalk();
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

    public Product produced() {
        if (this instanceof Hen) {
            Egg egg = new Egg();
            egg.setX(this.x);
            egg.setY(this.y);
            return egg;
        } else if (this instanceof Sheep) {
            Wool wool = new Wool();
            wool.setX(this.x);
            wool.setY(this.y);
            return wool;
        } else {
            Milk milk = new Milk();
            milk.setX(this.x);
            milk.setY(this.y);
            return milk;
        }
    }

    @Override
    public void nextTurn() {
        Cell[][] cells = map.getCells();
        if (isFullEnergy()) {
            this.randomWalk();
            this.setEnergy(this.getEnergy() - 1);
        } else if (isAverageEnergy()) {
            if (cells[x][y].getGrass().isGrass()) {
                cells[x][y].getGrass().setGrass(false);
            } else {
                this.setEnergy(this.getEnergy() - 1);
            }
            this.randomWalk();
            if (this.energy == Utils.LOW_ENERGY_AMOUNT + 1) {
                cells[x][y].getCellProducts().add(this.produced());
            }
        } else if (isWeak()) {
            if (cells[x][y].getGrass().isGrass()) {
                cells[x][y].getGrass().setGrass(false);
                this.setEnergy(this.getEnergy() + 1);
            } else {
                this.setEnergy(this.getEnergy() - 1);
            }
            this.smartWalk();
        } else if (isDead()) {
            cells[x][y].getCellAnimals().remove(this);
            ourFarm.getAnimals().remove(this);
        }
        setOnMap();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}