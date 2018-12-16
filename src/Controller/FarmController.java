package Controller;

import Model.*;
import Requests.*;
import Requests.Request;
import View.View;

import java.util.ArrayList;

public class FarmController {
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private Map map = new Map();
    private View view = new View();
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();

    public boolean isGameFinished() {
        return false;
    }

    public void listenForCommand() {
        boolean isFinished = false;

        while (!isFinished) {
            String command = view.getCommand().trim();

            Request request = commandAnalyzer.getRequest(command);
            if (request instanceof AddAnimalRequest) {
                try {
                    addAnimalAction(((AddAnimalRequest) request).getAnimalName());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            if (request instanceof AddProductToWorkshopRequest) {

            }
            if (request instanceof CreateWorkShopRequest) {

            }
            if (request instanceof CageRequest) {

            }
            if (request instanceof AddGrassRequest) {

            }
            if (request instanceof AddWaterRequest) {

            }
            if (request instanceof BuyCageRequest) {

            }
            if (request instanceof BuyProductRequest) {

            }
            if (request instanceof BuyTransportationRequest) {

            }
            if (request instanceof PickUpRequest) {

            }
            if (request instanceof PutToCageRequest) {

            }
            if (request instanceof SaleProductRequest) {

            }
            if (request instanceof EndRequest) {
                isFinished = true;
            }
        }
    }

    public void newGame() {

    }

    //    public boolean isFinished(CheckGoal checkgoal){
//
//    }
    private void addAnimalAction(String input) throws Exception {
        if (input.equals("hen")) {
            Hen hen = new Hen();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            hen.setX(4);
            hen.setY(4);
            Cell[][] cells = map.getCells();
            cells[4][4].addCellAnimals(hen);
        } else if (input.equals("sheep")) {
            Sheep sheep = new Sheep();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            sheep.setX(x);
            sheep.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].addCellAnimals(sheep);
        } else if (input.equals("cow")) {
            Cow cow = new Cow();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            cow.setX(x);
            cow.setY(y);
            Lion lion = new Lion();
            lion.setX(4);
            lion.setY(4);
            Cell[][] cells = map.getCells();
            cells[x][y].addCellAnimals(cow);
            cells[4][4].addCellAnimals(lion);
        } else if (input.equals("cat")) {
            Cat cat = new Cat();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            cat.setX(x);
            cat.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].addCellAnimals(cat);
        } else if (input.equals("dog")) {
            Dog dog = new Dog();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            dog.setX(4);
            dog.setY(4);
            Cell[][] cells = map.getCells();
            cells[4][4].addCellAnimals(dog);
        } else
            throw new Exception("buy exception");
    }

    public void pickUpAction() {

    }

    public void collision() {
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                int temp = animals.size();
                for (int k = 0; k < temp - 1; k++) {
                    for (int l = k + 1; l < temp; l++) {
                        if (animals.get(k) instanceof Dog) {
                            if (animals.get(l) instanceof Lion || animals.get(l) instanceof Bear) {
                                cells[i][j].removeCellAnimals(animals.get(k));
                                cells[i][j].removeCellAnimals(animals.get(l));
                            }
                        }
                        if (animals.get(k) instanceof Lion || animals.get(k) instanceof Bear) {
                            if (animals.get(l) instanceof Dog) {
                                cells[i][j].removeCellAnimals(animals.get(k));
                                cells[i][j].removeCellAnimals(animals.get(l));
                            }
                            if (animals.get(l) instanceof Sheep || animals.get(l) instanceof Hen
                                    || animals.get(l) instanceof Cow) {
                                cells[i][j].removeCellAnimals(animals.get(l));
                            }
                        }
                        if (animals.get(k) instanceof Sheep || animals.get(k) instanceof Hen
                                || animals.get(k) instanceof Cow) {
                            if (animals.get(l) instanceof Lion || animals.get(l) instanceof Bear) {
                                cells[i][j].removeCellAnimals(animals.get(k));
                            }
                        }
                    }
                }
                for (Animal animal : animals) {
                    if (animal instanceof Cat && cells[i][j].getCellProducts().size() != 0) {
                        cells[i][j].getCellProducts().clear();
                    }
                }

            }
        }
    }

    public void test() {
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                for (Animal animal : cells[i][j].getCellAnimals()) {
                    System.out.printf("%d %d %s\n", i, j, "Dog");
                }
            }
        }
    }

    public void save() {

    }

    public void load() {

    }

    public void passTurn() {

    }

    public void buyRequest() {

    }

    public void upgradeRequest() {

    }
}
