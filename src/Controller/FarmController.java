package Controller;

import Model.*;
import Model.Animals.*;
import Model.Animals.DomesticAnimal;
import Model.Requests.*;
import Model.Requests.SaveRequest;
import View.View;
import com.gilecode.yagson.YaGson;
import com.gilecode.yagson.com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class FarmController {
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private Map map =Map.getMap();
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
                if (request instanceof LoadRequest)
                {
                    this.map = load();
                }
                if (request instanceof SaveRequest) {
                    try {
                        save();
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
                if (request instanceof ClearFromTranRequest) {
                    try{
                        clearAction(((ClearFromTranRequest) request).getTransnName());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof PickUpRequest) {
                    pickUpAction(((PickUpRequest) request).getX(), ((PickUpRequest) request).getY());
                }

                if (request instanceof SaleProductRequest) {
                    try{
                        saleAction(((SaleProductRequest) request).getTransName() , ((SaleProductRequest) request).getProdutName() , ((SaleProductRequest) request).getCount());
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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

    private void saleAction(String transName, String produtName, int count) {
        if (transName.equals("truck"))
        {
            Truck truck = Truck.getTruck();
            for (int i = 0 ;i<count ; i++)
            {

            }
        }
        if (transName.equals("helicopter"))
        {
            Helicopter helicopter = Helicopter.getHelicopter();
            for (int i = 0 ; i<count  ;i++)
            {

            }

        }
    }


    //    public boolean isFinished(CheckGoal checkgoal){
//
//    }
    private void addAnimalAction(String input) throws Exception {
        if (input.equals("hen")) {
            Hen hen = new Hen();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            hen.setX(x);
            hen.setY(y);
            Cell[][] cells = map.getCells();
            cells[0][0].getCellAnimals().add(hen);
        } else if (input.equals("sheep")) {
            Sheep sheep = new Sheep();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            sheep.setX(x);
            sheep.setY(y);
            Cell[][] cells = map.getCells();
            System.out.println(x);
            System.out.println(y);
            cells[x][y].getCellAnimals().add(sheep);
        } else if (input.equals("cow")) {
            Cow cow = new Cow();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            cow.setX(x);
            cow.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(cow);
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
            dog.setX(x);
            dog.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(dog);
        } else
            throw new Exception("buy exception");
    }

    private boolean isOnMap(int X, int Y) throws Exception {
        if (X >= 0 && Y >= 0 && X < Utils.mapSize && Y < Utils.mapSize)
            return true;
        else {
            throw new Exception("not on map!");
        }
    }
    private void clearAction(String type)
    {
        Depot depot = Depot.getDepot();
        if (type.equals("truck"))
        {
            Truck truck = Truck.getTruck();
            while (!depot.isFull()&&!truck.getProductsInTransportation().isEmpty()&&!truck.getAnimalsInTransportation().isEmpty()) {
                for (int i = 0; i < truck.getAnimalsInTransportation().size(); i++) {
                    depot.getStoredAnimal().add(truck.getAnimalsInTransportation().get(i));
                }
                for (int i = 0; i < truck.getProductsInTransportation().size(); i++) {
                    depot.getStoredProducts().add(truck.getProductsInTransportation().get(i));
                }
            }
        }
        if (type.equals("helicopter"))
        {
            Helicopter helicopter = Helicopter.getHelicopter();
            while (!helicopter.getProductsInTransportation().isEmpty()&&!depot.isFull()&&!helicopter.getAnimalsInTransportation().isEmpty())
            {
                for (int i = 0; i < helicopter.getAnimalsInTransportation().size(); i++) {
                    depot.getStoredAnimal().add(helicopter.getAnimalsInTransportation().get(i));
                }
                for (int i = 0; i < helicopter.getProductsInTransportation().size(); i++) {
                    depot.getStoredProducts().add(helicopter.getProductsInTransportation().get(i));
                }
            }
        }
    }

    public void addGrassAction(int xOfGrass, int yOfGrass) {
        Well well = Well.getWell();
        Cell[][] cells = map.getCells();
        if (well.getStorage() >= 18) {
            outer:
            for (int i = xOfGrass - 1; i <= xOfGrass + 1; i++) {
                for (int j = yOfGrass - 1; j <= yOfGrass + 1; j++) {
                    try {
                        if (isOnMap(i, j) && !cells[i][j].getGrass().isGrass()) {
                            cells[i][j].getGrass().setGrass(true);
                            well.pickUpWater(2);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break outer;
                    }
                }
            }
        }

    }

    public void addWaterAction() {
        Well well = Well.getWell();
        well.addWater();
        System.out.println(well.getStorage());
    }

    public void pickUpAction(int x, int y) {
        Cell[][] cells = map.getCells();
        Depot depot = Depot.getDepot();
        if (!cells[x][y].getCellProducts().isEmpty()) {
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

    public Map load() {
        File f = new File("OURFARM.json");
        InputStream stream = null;
        try {
            stream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder json = new StringBuilder();
        int byteCode = 0;
        try {
            byteCode = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (byteCode != -1) {
            json.append((char) byteCode);
            try {
                byteCode = stream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map map = new YaGson().fromJson(json.toString(), Map.class);

        return map;
    }

    public void save() {
        YaGson yaGson = new YaGson();
        String objToString = yaGson.toJson(map);

        //  parseSTRING.ourFarm
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("OURFARM.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.write(objToString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        Cell[][] cells = map.getCells();
        for (int i = 0; i < Utils.mapSize; i++) {
            for (int j = 0; j < Utils.mapSize; j++) {
                ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                for(Animal animal:animals){
                    ourFarm.getAnimals().clear();
                    ourFarm.getAnimals().add(animal);
                }
            }
        }
        for (Animal animal:ourFarm.getAnimals()){

        }
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
            depot.upgrade();

        }


    }

    public void printMapAction() {
        Cell[][] cell = map.getCells();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                if ((cell[i][j].getGrass() == null
                        || !cell[i][j].getGrass().isGrass())
                        && cell[i][j].getCellProducts().isEmpty()
                        && cell[i][j].getCellAnimals().isEmpty()) {
                    System.out.print(0);
                } else if (cell[i][j].getGrass().isGrass()
                        &&cell[i][j].getCellProducts().isEmpty()
                          &&cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(1);
                 else if (cell[i][j].getGrass().isGrass()
                        &&!cell[i][j].getCellProducts().isEmpty()
                        &&cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(2);
                 else if (cell[i][j].getGrass().isGrass()
                &&cell[i][j].getCellProducts().isEmpty()
                &&!cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(3);
                else if (cell[i][j].getGrass().isGrass()
                        &&!cell[i][j].getCellProducts().isEmpty()
                        &&!cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(4);
                else System.out.print(5);



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
