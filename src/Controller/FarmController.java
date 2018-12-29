package Controller;

import Model.*;
import Model.Animals.*;
import Model.Animals.DomesticAnimal;
import Model.OnMaps.Cell;
import Model.OnMaps.Depot;
import Model.OnMaps.Map;
import Model.OnMaps.Well;
import Model.Products.*;
import Model.Requests.*;
import Model.Requests.SaveRequest;
import Model.Transport.Helicopter;
import Model.Transport.Truck;
import Model.Workshop.*;
import View.View;
import com.gilecode.yagson.YaGson;


import java.io.*;
import java.util.ArrayList;

public class FarmController {
    CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private CheckGoal checkGoal = new CheckGoal();
    private Map map = ourFarm.getMap();
    private WorkShop workShopcu = new Costum();
    private View view = new View();
    private int Money;
    private int levelOfGame;
    private boolean isFinished = false;
    private int hens;
    private int sheeps;
    private int cows;
    private int eggs;
    private int milk;
    private int wool;


    public int getMoney() {
        return money;
    }

    public void setMoney() {
        if (checkGoal.getLevel() == 1)
            this.money = 100;
        if (checkGoal.getLevel() == 2)
            this.money = 150;
        if (checkGoal.getLevel() == 3)
            this.money = 190;
        if (checkGoal.getLevel() == 4)
            this.money = 300;
    }

    private int money;
    private long time = 0;

    public boolean isGameFinished() {
        return false;
    }

    public void listenForCommand() {
        isFinished = false;
        this.setMoney();
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
                if (request instanceof CustomRequest) {
                    try {
                        this.workShopcu = startCustom(((CustomRequest) request).getPath());
                        map.getWorkShops().add(workShopcu);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                if (request instanceof FromWorkShopToDepot) {
                    try {
                        pickToDepot(((FromWorkShopToDepot) request).getProductName(), ((FromWorkShopToDepot) request).getWorkShopName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }
                if (request instanceof FromDepotToWorkShop) {
                    try {
                        pickToWorkShop(((FromDepotToWorkShop) request).getProductName(), ((FromDepotToWorkShop) request).getWorkShopName());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                }

                if (request instanceof AddGrassRequest) {
                    try {
                        addGrassAction(((AddGrassRequest) request).getX(), ((AddGrassRequest) request).getY());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }


                }
                if (request instanceof LoadRequest) {
                    this.map = load(((LoadRequest) request).getPath());
                    ourFarm.setMap(this.map);
                }
                if (request instanceof SaveRequest) {
                    try {
                        save(((SaveRequest) request).getPath());
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
                if (request instanceof PrintInfoRequest)
                    printInfoAction();
                if (request instanceof EndRequest) {
                    isFinished = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Costum startCustom(String path) {

        File F = new File(path);
        InputStream stream = null;
        try {
            stream = new FileInputStream(F);
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

        return new YaGson().fromJson(json.toString(), Costum.class);
    }

    private void pickToDepot(String productName, String workShopName) {
        Depot depot = Depot.getDepot();
        if (workShopName.equals("cakeBakery")) {
            CakeBakery cakeBakery = CakeBakery.getCakeBakery();
            for (int i = ourFarm.getOutPutsOfCakeBakery().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfCakeBakery().get(i));
            }
            ourFarm.getOutPutsOfCakeBakery().clear();

        }
        if (workShopName.equals("cookieBakery")) {
            CookieBakery cookieBakery = CookieBakery.getCookieBakery();
            for (int i = ourFarm.getOutPutsOfCookieBakery().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfCookieBakery().get(i));
            }
            ourFarm.getOutPutsOfCookieBakery().clear();

        }
        if (workShopName.equals("spinneryFactory")) {
            SpinneryFactory spinneryFactory = SpinneryFactory.getSpinneryFactory();
            for (int i = ourFarm.getOutPutsOfSpinnery().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfSpinnery().get(i));
            }
            ourFarm.getOutPutsOfSpinnery().clear();
        }
        if (workShopName.equals("sewingFactory")) {
            SewingFactory sewingFactory = SewingFactory.getSewingFactory();
            for (int i = ourFarm.getOutPutsOfSewingFactory().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfSewingFactory().get(i));
            }
            ourFarm.getOutPutsOfSewingFactory().clear();
        }
        if (workShopName.equals("weavingFactory")) {
            WeavingFactory weavingFactory = WeavingFactory.getWeavingFactory();
            for (int i = ourFarm.getOutPutsOfWeavingFactory().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfWeavingFactory().get(i));
            }
            ourFarm.getOutPutsOfWeavingFactory().clear();
        }
        if (workShopName.equals("eggPowderPlantWorkShop")) {
            EggPowderPlantWorkShop eggPowderPlantWorkShop = EggPowderPlantWorkShop.getEggPowderPlantWorkShop();
            for (int i = ourFarm.getOutPutsOfEggPowderPlantWorkshop().size() - 1; i >= 0; i--) {
                depot.addStoredProducts(ourFarm.getInPutsOfEggPowderPlantWorkshop().get(i));
            }
            ourFarm.getOutPutsOfEggPowderPlantWorkshop().clear();
        }
    }

    private void pickToWorkShop(String productName, String workShopName) {
        Depot depot = Depot.getDepot();
        if (workShopName.equals("cakeBakery") && true) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof Egg || depot.getStoredProducts().get(i) instanceof Flour) {
                    ourFarm.getInPutsOfCakeBakery().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);

                }
            }
        }
        if (workShopName.equals("cookieBakery")) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof EggPowder) {
                    ourFarm.getInPutsOfCookieBakery().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);

                }
            }
        }
        if (workShopName.equals("spinneryFactory")) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof Wool) {
                    ourFarm.getInPutsOfSpinnery().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);

                }
            }
        }
        if (workShopName.equals("sewingFactory")) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof Fabric) {
                    ourFarm.getInPutsOfSewingFactory().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);

                }
            }
        }
        if (workShopName.equals("weavingFactory")) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof Sewing) {
                    ourFarm.getInPutsOfSewingFactory().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);

                }
            }
        }
        if (workShopName.equals("eggPowderPlantWorkShop")) {
            for (int i = depot.getStoredProducts().size() - 1; i >= 0; i--) {
                if (depot.getStoredProducts().get(i) instanceof Egg) {
                    ourFarm.getInPutsOfEggPowderPlantWorkshop().add(depot.getStoredProducts().get(i));
                    depot.getStoredProducts().remove(i);
                }
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

    public void printInfoAction() {
        view.logSeeDomesticAnimals(hens, cows, sheeps);
        view.logViewMoney(money);
        view.logSeeTime(time);
        view.logSeeLevel(checkGoal.getLevel());
    }

    private void goAction(String transName) {
        if (transName.equals("truck")) {
            Truck truck = Truck.getTruck();
            for (int i = truck.getProductsInTransportation().size() - 1; i >= 0; i--) {
                if (truck.getProductsInTransportation().get(i) instanceof Egg && true) {
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
                if (helicopter.getAnimalsInTransportation().get(i) instanceof Lion && true) {
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
            if (produtName.equals("egg")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Egg)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_EGG);
                    }
                }
            }
            if (produtName.equals("milk")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Milk)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_MILK);
                    }
                }
            }
            if (produtName.equals("wool")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Wool)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_WOOL);
                    }
                }
            }
            if (produtName.equals("flour")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Flour)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored((int) (helicopter.getStored() + Utils.DEPOT_SIZE_FOR_FLOUR));

                    }
                }
            }
            if (produtName.equals("cake")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Cake)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_CAKE);

                    }
                }
            }
            if (produtName.equals("cookie")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Cookie)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_FLOURY_CAKE);

                    }
                }
            }
            if (produtName.equals("fabric")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Fabric)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_FABRIC);

                    }
                }
            }
            if (produtName.equals("sewing")) {
                while (!helicopter.ifFullHelicopter()) {
                    for (int i = 0; i < count; i++) {
                        if (depot.getStoredProducts().get(i) instanceof Sewing)
                            helicopter.getProductsInTransportation().add(depot.getStoredProducts().get(i));
                        helicopter.setStored(helicopter.getStored() + Utils.DEPOT_SIZE_FOR_SEWING);

                    }
                }
            }

        }
    }


    private void addAnimalAction(String input) throws Exception {
        if (input.equals("hen")) {
            if (money >= Utils.HEN_PRICE) {
                Hen hen = new Hen();
                int x = (int) (Math.random() * 30);
                int y = (int) (Math.random() * 30);
                hen.setX(x);
                hen.setY(y);
                Cell[][] cells = map.getCells();
                cells[x][y].getCellAnimals().add(hen);
                money -= Utils.HEN_PRICE;
            } else
                view.logNotEnoughMoney();
        } else if (input.equals("sheep")) {
            if (money >= Utils.SHEEP_PRICE) {
                Sheep sheep = new Sheep();
                int x = (int) (Math.random() * 30);
                int y = (int) (Math.random() * 30);
                sheep.setX(x);
                sheep.setY(y);
                Cell[][] cells = map.getCells();
                cells[x][y].getCellAnimals().add(sheep);
                money -= Utils.SHEEP_PRICE;
            } else
                view.logNotEnoughMoney();
        } else if (input.equals("cow")) {
            if (money >= Utils.COW_PRICE) {
                Cow cow = new Cow();
                int x = (int) (Math.random() * 30);
                int y = (int) (Math.random() * 30);
                cow.setX(x);
                cow.setY(y);
                Cell[][] cells = map.getCells();
                cells[x][y].getCellAnimals().add(cow);
                money -= Utils.COW_PRICE;
            } else
                view.logNotEnoughMoney();
        } else if (input.equals("cat")) {
            if (money >= Utils.CAT_PRICE) {
                Cat cat = new Cat();
                int x = (int) (Math.random() * 30);
                int y = (int) (Math.random() * 30);
                cat.setX(x);
                cat.setY(y);
                Cell[][] cells = map.getCells();
                cells[x][y].getCellAnimals().add(cat);
                money -= Utils.CAT_PRICE;
            } else
                view.logNotEnoughMoney();
        } else if (input.equals("dog")) {
            if (money >= Utils.DOG_PRICE) {
                Dog dog = new Dog();
                int x = (int) (Math.random() * 30);
                int y = (int) (Math.random() * 30);
                dog.setX(x);
                dog.setY(y);
                Cell[][] cells = map.getCells();
                cells[x][y].getCellAnimals().add(dog);
                money -= Utils.DOG_PRICE;
            } else
                view.logNotEnoughMoney();
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
            if (truck.getProductsInTransportation().isEmpty() && truck.getAnimalsInTransportation().isEmpty())
                System.out.println("nothing found!");
            else {
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
        }
        if (type.equals("helicopter")) {
            Helicopter helicopter = Helicopter.getHelicopter();
            while (!depot.isFull() && !helicopter.getProductsInTransportation().isEmpty() && !helicopter.getAnimalsInTransportation().isEmpty()) {
                for (int i = helicopter.getAnimalsInTransportation().size() - 1; i >= 0; i--) {
                    depot.getStoredAnimal().add(helicopter.getAnimalsInTransportation().get(i));
                    if (helicopter.getProductsInTransportation().get(i) instanceof Egg && true) {
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

    private void addGrassAction(int xOfGrass, int yOfGrass) {
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

    private void addWaterAction() {
        Well well = Well.getWell();
        if (money>=Utils.ADDWATRCOST) {
            well.addWater();
            money -= Utils.ADDWATRCOST;
        }
        else System.out.println("nemishavad ke nemishavad");
        System.out.println(well.getStorage());
    }

    private void pickUpAction(int x, int y) {
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

    public Map load(String path) {
        File f = new File(path);
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

    public void save(String path) {
        YaGson yaGson = new YaGson();
        String objToString = yaGson.toJson(map);

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path));
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
            hens = 0;
            sheeps = 0;
            cows = 0;
            eggs = 0;
            milk = 0;
            wool = 0;
            Cell[][] cells = map.getCells();
            if (time % 30 == 8) {
                Lion lion = new Lion();
                lion.setX((int) (Math.random() * 30));
                lion.setY((int) (Math.random() * 30));
                cells[lion.getX()][lion.getY()].addCellAnimals(lion);
            }
            if (time % 120 == 108) {
                Bear bear = new Bear();
                bear.setX((int) (Math.random() * 30));
                bear.setY((int) (Math.random() * 30));
                cells[bear.getX()][bear.getY()].addCellAnimals(bear);
            }
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
                if (animal instanceof ProducerAnimal && ((ProducerAnimal) animal).getEnergy() == 0)
                    cells[x][y].getCellAnimals().remove(animal);
                if (animal instanceof Hen)
                    hens++;
                if (animal instanceof Cow)
                    cows++;
                if (animal instanceof Sheep)
                    sheeps++;
            }
            for (Product product : Depot.getDepot().getStoredProducts()) {
                if (product instanceof Egg)
                    eggs++;
                if (product instanceof Wool)
                    wool++;
                if (product instanceof Milk)
                    milk++;
            }
            if (checkGoal.getRequirementOfCow() <= cows && checkGoal.getRequirementOfSheep() <= sheeps
                    && checkGoal.getRequirementOfHen() <= hens && checkGoal.getRequirementOfEgg() <= eggs
                    && checkGoal.getRequirementOfWool() <= wool && checkGoal.getRequirementOfMilk() <= milk
                    && checkGoal.getRequirementOfGold() <= money) {
                checkGoal.setLevel(checkGoal.getLevel() + 1);
                this.setMoney();
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
