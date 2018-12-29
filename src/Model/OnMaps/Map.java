package Model.OnMaps;

import Model.Transport.Helicopter;
import Model.Transport.Truck;
import Model.Utils;
import Model.Workshop.*;

import java.util.ArrayList;

public class Map {

    private Cell[][] cells = new Cell[Utils.mapSize][Utils.mapSize];
    private Depot depot ;
    private Truck truck ;
    private Helicopter helicopter ;
    private ArrayList<WorkShop> workShops = new ArrayList<>();
    {
        workShops.add(CakeBakery.getCakeBakery());
        workShops.add(CookieBakery.getCookieBakery());
        workShops.add(SpinneryFactory.getSpinneryFactory());
        workShops.add(WeavingFactory.getWeavingFactory());
        workShops.add(SewingFactory.getSewingFactory());
        workShops.add(EggPowderPlantWorkShop.getEggPowderPlantWorkShop());
    }

    public ArrayList<WorkShop> getWorkShops() {
        return workShops;
    }

    public void setWorkShops(ArrayList<WorkShop> workShops) {
        this.workShops = workShops;
    }

    public Depot getDepot() {
        return depot;
    }

    public Map() {
        for (int i = 0; i < Utils.mapSize ; i++) {
            for (int j = 0; j < Utils.mapSize ; j++) {
                cells[i][j] = new Cell();
            }
        }
        well = Well.getWell();
        depot = Depot.getDepot();
        truck = Truck.getTruck();
        helicopter = Helicopter.getHelicopter();

    }

    public Truck getTruck() {
        return truck;
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public Cell[][] getCells() {
        return cells;
    }
   private Well well = Well.getWell();

    public Well getWell() {
        return well;
    }
}
