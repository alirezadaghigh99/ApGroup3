package Controller;

import Model.*;
import Model.Requests.*;
import View.View;

import java.util.ArrayList;

public class FarmController {
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private Map map = new Map();
    private View view = new View();

    public boolean isGameFinished() {
        return false;
    }

    public void listenForCommand() {
        boolean isFinished = false;

        while (!isFinished) {
            String command = view.getCommand().trim();
            try {
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

                if (request instanceof AddGrassRequest) {
                    try {
                        addGrassAction(((AddGrassRequest) request).getX(), ((AddGrassRequest) request).getY());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                if (request instanceof PrintMapRequest) {
                    try {
                        printMapAction();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof AddWaterRequest) {
                    try {
                        addWaterAction();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof CageRequest) {
                    try {
                        cageAction(((CageRequest) request).getX(), ((CageRequest) request).getY());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                if (request instanceof BuyProductRequest) {

                }
                if (request instanceof BuyTransportationRequest) {

                }
                if (request instanceof PickUpRequest) {
                    pickUpAction(((PickUpRequest) request).getX(), ((PickUpRequest) request).getY());

                }

                if (request instanceof SaleProductRequest) {

                }
                if (request instanceof NextTurnRequest) {
                    passTurn(((NextTurnRequest) request).getNumberOfTurn());
                }
                if (request instanceof UpgradeRequest) {
                    upgradeRequest(((UpgradeRequest) request).getThingWeWantUpgrade());
                }
                if (request instanceof EndRequest) {
                    isFinished = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
            hen.setX(10);
            hen.setY(8);
            Cell[][] cells = map.getCells();
            cells[10][8].getCellAnimals().add(hen);
        } else if (input.equals("sheep")) {
            Sheep sheep = new Sheep();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            sheep.setX(x);
            sheep.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(sheep);
        } else if (input.equals("cow")) {
            Lion lion = new Lion();
            lion.setX(10);
            lion.setY(8);
            Cow cow = new Cow();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            cow.setX(x);
            cow.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(cow);
            cells[10][8].getCellAnimals().add(lion);
        } else if (input.equals("cat")) {
            Cat cat = new Cat();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            cat.setX(x);
            cat.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(cat);
        } else if (input.equals("dog")) {
            Dog dog = new Dog();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            dog.setX(10);
            dog.setY((8));
            Cell[][] cells = map.getCells();
            cells[10][8].getCellAnimals().add(dog);
        } else
            throw new Exception("buy exception");
    }

    public void addGrassAction(int xOfGrass, int yOfGrass) {
        Grass grass = new Grass();
        Well well = Well.getWell();
        Cell[][] cells = map.getCells();
        if (well.getStorage() >= 18) {
            for (int i = xOfGrass - 1; i <= xOfGrass + 1; i++) {
                for (int j = xOfGrass - 1; j <= xOfGrass + 1; j++) {
                    if (!cells[i][j].getGrass().isGrass() && i >= 0 && i < 30 && j >= 0 && j < 30) {
                        cells[i][j].getGrass().setGrass(true);
                        well.pickUpWater(2);
                    }

                }
            }
            System.out.println(well.getStorage());
        }
        // else throw Exception ;

    }

    public void addWaterAction() {
        Well well = Well.getWell();
        well.addWater();
        System.out.println(well.getStorage());
    }

    public void pickUpAction(int x, int y) {
        Cell[][] cells = map.getCells();
        Depot depot = Depot.getDepot();
        if (cells[x][y].getCellProducts().size() != 0) {
            for (int i = 0; i < cells[x][y].getCellProducts().size(); i++) {
                depot.getStoredProducts().add(cells[x][y].getCellProducts().get(i));

            }
        }
        cells[x][y].getCellProducts().clear();
    }

    public void test() {
        Cell[][] cells = map.getCells();
        for (int i = 0; i < 30; i++)
            for (int j = 0; j < 30; j++) {
                ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                for (Animal animal : animals) {
                    System.out.printf("%d %d\n", i, j);

                }
            }
    }

    public void load() {

    }

    public void save() {
        //  parseSTRING.ourFarm
    }

    public void collision() {
        Depot depot = Depot.getDepot();
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                ArrayList<Product> products = cells[i][j].getCellProducts();
                if (animals.size() >= 2) {
                    for (int k = animals.size() - 1; k >= 1; k--) {
                        for (int l = k - 1; l >= 0; l--) {
                            if (animals.get(k) instanceof WildAnimal) {
                                if (animals.get(l) instanceof Dog) {
                                    animals.remove(animals.get(k));
                                    animals.remove(animals.get(l));
                                }
                                if (animals.get(l) instanceof DomesticAnimal) {
                                    animals.remove(animals.get(l));
                                }
                            }
                            if (animals.get(k) instanceof Dog) {
                                if (animals.get(l) instanceof WildAnimal) {
                                    animals.remove(animals.get(k));
                                    animals.remove(animals.get(l));
                                }
                            }
                            if (animals.get(k) instanceof DomesticAnimal) {
                                if (animals.get(l) instanceof WildAnimal) {
                                    animals.remove(animals.get(k));
                                }
                            }
                        }
                    }
                }
                for (Animal animal : animals) {
                    if (animal instanceof Cat) {
                        if (products.size() > 0) {
                            for (Product product : products) {
                                depot.getStoredProducts().add(product);
                            }
                            products.clear();
                        }
                    }
                }
            }
        }

    }


    public void passTurn(int numberOfTurn) {

    }

    public void buyRequest() {

    }

    public void upgradeRequest(String type) {

        if (type.equals("well")) {
            Well well = Well.getWell();
            well.upgrade();
        }
        if (type.equals("depot")) {
            Depot depot = Depot.getDepot();

        }


    }

    public void printMapAction() {
        Cell[][] cell = map.getCells();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if ((cell[i][j].getGrass() == null
                        || !cell[i][j].getGrass().isGrass())
                        && cell[i][j].getCellProducts().isEmpty()
                        && cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(0);
                else if (!cell[i][j].getCellAnimals().isEmpty() && !cell[i][j].getGrass().isGrass())
                    System.out.print(1);
                else if (cell[i][j].getCellAnimals().isEmpty() && cell[i][j].getGrass().isGrass())
                    System.out.println(2);
                else if (!cell[i][j].getCellAnimals().isEmpty() && cell[i][j].getGrass().isGrass())
                    System.out.println(3);
                else System.out.println(4);


            }
            System.out.print("\n");

        }

    }

    public void cageAction(int x, int y) throws Exception {
        Cell[][] cell = map.getCells();
        ArrayList<Animal> animals = cell[x][y].getCellAnimals();
        Depot depot = Depot.getDepot();
        for (int j = animals.size() - 1; j >= 0; j--) {
            if (animals.get(j) instanceof WildAnimal) {
                depot.getStoredAnimal().add((WildAnimal) animals.get(j));
                cell[x][y].getCellAnimals().remove(j);
            }
        }


    }


}
