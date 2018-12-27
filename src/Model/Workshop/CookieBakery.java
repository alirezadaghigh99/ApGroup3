package Model.Workshop;

import Model.Depot;
import Model.Products.Cookie;
import Model.Products.Egg;
import Model.Products.EggPowder;
import Model.Products.Flour;

public class CookieBakery extends WorkShop {
    // eggpowder --> cookie

    Cookie cookie = new Cookie();

    Depot depot = Depot.getDepot();

    public void makeCookie(){
        for(int i=0 ; i<depot.getCapacity() ; i++){
            if(depot.getStoredProducts().get(i) instanceof EggPowder){
                depot.pickUp(i);
                depot.addStoredProducts(cookie);
            }
        }
    }
}
