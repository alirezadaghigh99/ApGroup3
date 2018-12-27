package Model.Workshop;

import Model.Depot;
import Model.Products.Egg;
import Model.Products.EggPowder;
import Model.Products.Flour;

public class EggPowderPlantWorkShop extends WorkShop {
    // EGG --> eggpowder
    EggPowder eggPowder = new EggPowder() ;

    Depot depot = Depot.getDepot() ;

    public void makeEggPowder(){
        for(int i=0 ; i<depot.getCapacity() ; i++ ){
            if(depot.getStoredProducts().get(i) instanceof Egg){
                depot.pickUp(i);
                depot.addStoredProducts(eggPowder);
            }
        }
    }



}
