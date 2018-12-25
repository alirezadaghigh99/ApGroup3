package Model.Workshop;

import Model.Products.Cake;
import Model.Products.Egg;
import Model.Products.Flour;

public class CakeBakery extends WorkShop {
    // flour & cookie --> cake

    public Cake cookBakery(Flour flour, Egg egg){
        return new Cake() ;
    }
}
