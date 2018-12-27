package Model.Workshop;

import Model.Depot;
import Model.Product;
import Model.Products.Cookie;
import Model.Products.Egg;
import Model.Products.EggPowder;
import Model.Products.Flour;

import java.util.ArrayList;

public class EggPowderPlantWorkShop extends WorkShop {
    // EGG --> eggpowder
    EggPowder eggPowder = new EggPowder() ;

    private static EggPowderPlantWorkShop eggPowderPlantWorkShop = new EggPowderPlantWorkShop();

    private EggPowderPlantWorkShop() {
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
