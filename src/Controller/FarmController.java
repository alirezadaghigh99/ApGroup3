package Controller;

import Model.*;
import Requests.*;
import Requests.Request;
import View.View;

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
            int x = (int) Math.random() * 30;
            int y = (int) Math.random() * 30;
            hen.setX(x);
            hen.setY((y));
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(hen);
        } else if (input.equals("sheep")) {
            Sheep sheep = new Sheep();
            int x = (int) Math.random() * 30;
            int y = (int) Math.random() * 30;
            sheep.setX(x);
            sheep.setY((y));
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(sheep);
        } else if (input.equals("cow")) {
            Cow cow = new Cow();
            int x = (int) Math.random() * 30;
            int y = (int) Math.random() * 30;
            cow.setX(x);
            cow.setY((y));
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(cow);
        } else if (input.equals("cat")) {
            Cat cat = new Cat();
            int x = (int) Math.random() * 30;
            int y = (int) Math.random() * 30;
            cat.setX(x);
            cat.setY((y));
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(cat);
        } else if (input.equals("dog")) {
            Dog dog = new Dog();
            int x = (int) Math.random() * 30;
            int y = (int) Math.random() * 30;
            dog.setX(x);
            dog.setY((y));
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(dog);
        } else
            throw new Exception("buy exception");
    }

    public void wildEatDomesticAction() {

    }

    public void pickUpAction() {

    }

    public void collision() {

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
