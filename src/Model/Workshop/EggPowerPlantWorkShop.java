package Model.Workshop;

import Model.Products.Egg;
import Model.Products.Flour;

public class EggPowerPlantWorkShop extends WorkShop {
    // EGG --> eggpowder
    public Flour eggCopnvertToFlour(Egg egg){
        return  new Flour();
    }

}
