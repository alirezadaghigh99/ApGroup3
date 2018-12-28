package Controller;

import Model.*;
import Model.Animals.*;
import Model.Animals.DomesticAnimal;
import Model.Products.*;
import Model.Requests.*;
import Model.Requests.SaveRequest;
import Model.Workshop.*;
import View.View;
import com.gilecode.yagson.YaGson;


import java.io.*;
import java.util.ArrayList;

public class FarmController {
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private Map map = Map.getMap();
    private View view = new View();
    private int Money;
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int money = 10000;
    private long time = 0;

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
                if (request instanceof LoadRequest) {
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
                if (request instanceof GoRequest) {
                    try {
                        goAction(((GoRequest) request).getTransName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof BuyProductRequest) {

                }
                if (request instanceof StartRequest) {
                    startAction(((StartRequest) request).getWorkshopName(), time);
                }
                if (request instanceof ClearFromTranRequest) {
                    try {
                        clearAction(((ClearFromTranRequest) request).getTransnName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof PickUpRequest) {
                    pickUpAction(((PickUpRequest) request).getX(), ((PickUpRequest) request).getY());
                }

                if (request instanceof SaleProductRequest) {
                    try {
                        saleAction(((SaleProductRequest) request).getTransName(), ((SaleProductRequest) request).getProdutName(), ((SaleProductRequest) request).getCount());
                    } catch (Exception e) {
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


    private void startAction(String workshopName, long start) {
        if (workshopName.equals("CakeBakery")) {
            CakeBakery cakeBakery = CakeBakery.getCakeBakery();
            if (this.time - start == 3)
                cakeBakery.makeCake();
        }
        if (workshopName.equals("CookieBakery")) {
            CookieBakery cookieBakery = CookieBakery.getCookieBakery();
            if (this.time - start == 3)
                cookieBakery.makeCookie();
        }
        if (workshopName.equals("EggPowderPlantWorkshop")) {
            EggPowderPlantWorkShop eggPowderPlantWorkShop = EggPowderPlantWorkShop.getEggPowderPlantWorkShop();
            if (this.time - start == 3)
                eggPowderPlantWorkShop.makeEggPowder();
        }
        if (workshopName.equals("SewingFactory")) {
            SewingFactory sewingFactory = SewingFactory.getSewingFactory();
            if (this.time - start == 3)
                sewingFactory.makeClothe();
        }
        if (workshopName.equals("WeavingFactory")) {
            WeavingFactory weavingFactory = WeavingFactory.getWeavingFactory();
            if (this.time - start == 3)
                weavingFactory.makeFabric();
        }
        if (workshopName.equals("SpinneryFactory")) {
            SpinneryFactory spinneryFactory = SpinneryFactory.getSpinneryFactory();
            if (this.time - start == 3)
                spinneryFactory.makeSewing();
        }
        if (workshopName.equals("custom")) {

        }
    }

    private void goAction(String transName) {
        if (transName.equals("truck")) {
            Truck truck = Truck.getTruck();
            for (int i = truck.getProductsInTransportation().size() - 1; i >= 0; i--) {
                if (truck.getProductsInTransportation().get(i) instanceof Egg) {
                    money += Utils.SALE_COST_FOR_EGG;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Milk) {
                    money += Utils.SALE_COST_FOR_MILK;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Wool) {
                    money += Utils.SALE_COST_FOR_WOOL;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Cake) {
                    money += Utils.SALE_COST_FOR_CAKE;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Cookie) {
                    money += Utils.SALE_COST_FOR_FLOURY_CAKE;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Fabric) {
                    money += Utils.SALE_COST_FOR_FABRIC;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Flour) {
                    money += Utils.SALE_COST_FOR_FLOUR;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Sewing) {
                    money += Utils.SALE_COST_FOR_SWING;
                }
                if (truck.getProductsInTransportation().get(i) instanceof Clothe) {
                    money += Utils.SALE_COST_FOR_CARNIVAL_DRESS;
                }
                truck.getProductsInTransportation().remove(i);
            }
            for (int i = 0; i < truck.getAnimalsInTransportation().size(); i++) {
                if (truck.getAnimalsInTransportation().get(i) instanceof Lion) {
                    money += Utils.SALE_COST_FOR_CAGED_LION;
                    truck.getAnimalsInTransportation().remove(i);
                }
                if (truck.getAnimalsInTransportation().get(i) instanceof Bear) {
                    money += Utils.SALE_COST_FOR_CAGED_BROWN_BEAR;
                    truck.getAnimalsInTransportation().remove(i);
                }
            }
        }
        if (transName.equals("helicopter")) {
            Helicopter helicopter = Helicopter.getHelicopter();
            for (int i = helicopter.getProductsInTransportation().size() - 1; i >= 0; i--) {
                if (helicopter.getProductsInTransportation().get(i) instanceof Egg) {
                    money += Utils.SALE_COST_FOR_EGG;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Milk) {
                    money += Utils.SALE_COST_FOR_MILK;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Wool) {
                    money += Utils.SALE_COST_FOR_WOOL;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Cake) {
                    money += Utils.SALE_COST_FOR_CAKE;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Cookie) {
                    money += Utils.SALE_COST_FOR_FLOURY_CAKE;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Fabric) {
                    money += Utils.SALE_COST_FOR_FABRIC;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Flour) {
                    money += Utils.SALE_COST_FOR_FLOUR;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Sewing) {
                    money += Utils.SALE_COST_FOR_SWING;
                    helicopter.getProductsInTransportation().remove(i);
                }
                if (helicopter.getProductsInTransportation().get(i) instanceof Clothe) {
                    money += Utils.SALE_COST_FOR_CARNIVAL_DRESS;
                    helicopter.getProductsInTransportation().remove(i);
                }
            }
            for (int i = 0; i < helicopter.getAnimalsInTransportation().size(); i++) {
                if (helicopter.getAnimalsInTransportation().get(i) instanceof Lion) {
                    money += Utils.SALE_COST_FOR_CAGED_LION;
                    helicopter.getAnimalsInTransportation().remove(i);

                }
                if (helicopter.getAnimalsInTransportation().get(i) instanceof Bear) {
                    money += Utils.SALE_COST_FOR_CAGED_BROWN_BEAR;
                    helicopter.getAnimalsInTransportation().remove(i);
                }
            }
        }
    }

    private void saleAction(String transName, String produtName, int count) {
        Depot depot = Depot.getDepot();
        if (transName.equals("truck")) {
            Truck truck = Truck.getTruck();
            if (produtName.equals("egg")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Egg)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_EGG);
                    }
                }
            }
            if (produtName.equals("milk")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Milk)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_MILK);
                    }
                }
            }
            if (produtName.equals("wool")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Wool)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_WOOL);
                    }
                }
            }
            if (produtName.equals("flour")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Flour)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored((int) (truck.getStored() + Utils.DEPOT_SIZE_FOR_FLOUR));

                    }
                }
            }
            if (produtName.equals("cake")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Cake)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_CAKE);

                    }
                }
            }
            if (produtName.equals("cookie")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Cookie)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_FLOURY_CAKE);

                    }
                }
            }
            if (produtName.equals("fabric")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Fabric)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_FABRIC);

                    }
                }
            }
            if (produtName.equals("sewing")) {
                while (!truck.isFullTruck()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Sewing)
                            truck.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        truck.setStored(truck.getStored() + Utils.DEPOT_SIZE_FOR_SEWING);

                    }
                }
            }

        }
        if (transName.equals("helicopter")) {
            Helicopter helicopter = Helicopter.getHelicopter();
            for (int i = 0; i < count; i++) {

            }

        }
    }


    private void addAnimalAction(String input) throws Exception {
        if (input.equals("hen")) {
            Hen hen = new Hen();
            int x = (int) (Math.random() * 30);
            int y = (int) (Math.random() * 30);
            hen.setX(x);
            hen.setY(y);
            Cell[][] cells = map.getCells();
            cells[x][y].getCellAnimals().add(hen);
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

    private void clearAction(String type) {
        Depot depot = Depot.getDepot();
        if (type.equals("truck")) {
            Truck truck = Truck.getTruck();
            while (!depot.isFull() && !truck.getProductsInTransportation().isEmpty() && !truck.getAnimalsInTransportation().isEmpty()) {
                for (int i = truck.getAnimalsInTransportation().size() - 1; i >= 0; i--) {
                    depot.getStoredAnimal().add(truck.getAnimalsInTransportation().get(i));
                    if (truck.getProductsInTransportation().get(i) instanceof Egg) {
                        money -= Utils.BUY_COST_FOR_EGG;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Milk) {
                        money -= Utils.BUY_COST_FOR_MILK;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Wool) {
                        money -= Utils.BUY_COST_FOR_WOOL;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Fabric) {
                        money -= Utils.BUY_COST_FOR_FABRIC;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Flour) {
                        money -= Utils.BUY_COST_FOR_FLOUR;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Cake) {
                        money -= Utils.BUY_COST_FOR_CAKE;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Cookie) {
                        money -= Utils.BUY_COST_FOR_FLOURY_CAKE;
                    }
                    if (truck.getProductsInTransportation().get(i) instanceof Sewing) {
                        money -= Utils.BUY_COST_FOR_SEWING;
                    }
                    truck.getAnimalsInTransportation().remove(i);
                }
                for (int i = truck.getAnimalsInTransportation().size() - 1; i >= 0; i--) {
                    depot.getStoredProducts().add(truck.getProductsInTransportation().get(i));
                    if (truck.getAnimalsInTransportation().get(i) instanceof Bear) {
                        money -= Utils.BUY_COST_FOR_SPRUCE_BROWN_BEAR;
                    }
                    if (truck.getAnimalsInTransportation().get(i) instanceof Lion)
                        money -= Utils.BUY_COST_FOR_CAGED_LION;
                    truck.getProductsInTransportation().remove(i);
                }
            }
        }
        if (type.equals("helicopter")) {
            Helicopter helicopter = Helicopter.getHelicopter();
            while (!helicopter.getProductsInTransportation().isEmpty() && !depot.isFull() && !helicopter.getAnimalsInTransportation().isEmpty()) {
                for (int i = helicopter.getAnimalsInTransportation().size() - 1; i >= 0; i--) {
                    depot.getStoredAnimal().add(helicopter.getAnimalsInTransportation().get(i));
                    if (helicopter.getProductsInTransportation().get(i) instanceof Egg) {
                        money -= Utils.BUY_COST_FOR_EGG;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Milk) {
                        money -= Utils.BUY_COST_FOR_MILK;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Wool) {
                        money -= Utils.BUY_COST_FOR_WOOL;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Fabric) {
                        money -= Utils.BUY_COST_FOR_FABRIC;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Flour) {
                        money -= Utils.BUY_COST_FOR_FLOUR;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Cake) {
                        money -= Utils.BUY_COST_FOR_CAKE;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Cookie) {
                        money -= Utils.BUY_COST_FOR_FLOURY_CAKE;
                    }
                    if (helicopter.getProductsInTransportation().get(i) instanceof Sewing) {
                        money -= Utils.BUY_COST_FOR_SEWING;
                    }

                    helicopter.getAnimalsInTransportation().remove(i);
                }
                for (int i = helicopter.getAnimalsInTransportation().size() - 1; i >= 0; i--) {
                    depot.getStoredProducts().add(helicopter.getProductsInTransportation().get(i));
                    if (helicopter.getAnimalsInTransportation().get(i) instanceof Bear) {
                        money -= Utils.BUY_COST_FOR_CAGED_BROWN_BEAR;
                    }
                    if (helicopter.getAnimalsInTransportation().get(i) instanceof Lion) {
                        money -= Utils.BUY_COST_FOR_CAGED_LION;
                    }
                    helicopter.getAnimalsInTransportation().remove(i);
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

        return new YaGson().fromJson(json.toString(), Map.class);
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


    private void passTurn(int numberOfTurns) {
        while (numberOfTurns != 0) {
            Cell[][] cells = map.getCells();
            ourFarm.getAnimals().clear();
            for (int i = 0; i < Utils.mapSize; i++) {
                for (int j = 0; j < Utils.mapSize; j++) {
                    ArrayList<Animal> animals = cells[i][j].getCellAnimals();
                    for (Animal animal : animals) {
                        ourFarm.getAnimals().add(animal);
                    }
                    cells[i][j].getCellAnimals().clear();
                }
            }
            for (Animal animal : ourFarm.getAnimals()) {
                animal.nextTurn();
                int x = animal.getX();
                int y = animal.getY();

                cells[x][y].getCellAnimals().add(animal);
            }
            collision();
            time++;
            numberOfTurns--;
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
                        && cell[i][j].getCellProducts().isEmpty()
                        && cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(1);
                else if (cell[i][j].getGrass().isGrass()
                        && !cell[i][j].getCellProducts().isEmpty()
                        && cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(2);
                else if (cell[i][j].getGrass().isGrass()
                        && cell[i][j].getCellProducts().isEmpty()
                        && !cell[i][j].getCellAnimals().isEmpty())
                    System.out.print(3);
                else if (cell[i][j].getGrass().isGrass()
                        && !cell[i][j].getCellProducts().isEmpty()
                        && !cell[i][j].getCellAnimals().isEmpty())
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
