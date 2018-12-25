package Model.Workshop;

import Model.Cake;
import Model.Egg;
import Model.Flour;
import Model.WorkShop;

public class CakeBakery extends WorkShop {
    // flour & cookie --> cake

    public Cake cookBakery(Flour flour, Egg egg){
        return new Cake() ;
    }
}
