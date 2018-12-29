package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Egg;
import Model.Products.EggPowder;

public class EggPowderPlantWorkShop extends WorkShop {
    // EGG --> eggpowder
    EggPowder eggPowder = new EggPowder() ;

    private static EggPowderPlantWorkShop eggPowderPlantWorkShop = new EggPowderPlantWorkShop();

    public EggPowderPlantWorkShop() {
    }

    public static EggPowderPlantWorkShop getEggPowderPlantWorkShop() {
        return eggPowderPlantWorkShop;
    }

    Depot depot = Depot.getDepot() ;

    public void makeEggPowder(){
        if (ourFarm.getInPutsOfEggPowderPlantWorkshop().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = ourFarm.getInPutsOfEggPowderPlantWorkshop().size()-1 ; i>=0 ; i--)
            {
                if (ourFarm.getInPutsOfEggPowderPlantWorkshop().get(i) instanceof Egg) {
                    ourFarm.getOutPutsOfEggPowderPlantWorkshop().add(new EggPowder());
                    ourFarm.getInPutsOfEggPowderPlantWorkshop().remove(i);
                }
            }
        }
    }



}
