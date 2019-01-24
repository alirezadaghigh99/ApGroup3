package Model.Animals;

import Model.OnMaps.Cell;
import Model.OnMaps.Map;
import Model.OurFarm;
import Model.Utils;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Dog extends Animal {
    Image DogToLeft = new Image(new FileInputStream("Animals\\Africa\\Dog"));
    Image DogToDown = new Image(new FileInputStream("Animals\\Africa\\Dog"));
    Image DogToDownLeft = new Image(new FileInputStream("Animals\\Africa\\Dog"));
    Image DogToUp = new Image(new FileInputStream("Africa\\Dog"));
    Image DogToUpLeft = new Image(new FileInputStream("Africa\\Dog"));

    public Dog() throws FileNotFoundException {
    }

    @Override
    public void smartWalk() {
        OurFarm ourFarm = OurFarm.getOurFarm();
        Map map = ourFarm.getMap();
        Cell[][] cells = map.getCells();
        for (int k = 1; k < Utils.mapSize; k++) {
            for (int i = x - k; i < x + k; i++) {
                for (int j = y - k; j < y + k; j++) {
                    if (i >= 0 && i < Utils.mapSize && j >= 0 && j < Utils.mapSize
                            && !cells[i][j].getCellAnimals().isEmpty()) {
                        for (int z = 0; z < cells[i][j].getCellAnimals().size(); z++) {
                            if (cells[i][j].getCellAnimals().get(z) instanceof WildAnimal) {
                                if (i > x)
                                    x = x + 1;
                                else
                                    x = x - 1;
                                if (j > y)
                                    y = y + 1;
                                else
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
        this.smartWalk();
        setOnMap();
    }

    @Override
    public void setOnMap() {
        super.setOnMap();
    }
}