package Model.Workshop;

import Model.Depot;
import Model.Product;
import Model.Products.Cookie;
import Model.Products.Egg;
import Model.Products.EggPowder;
import Model.Products.Flour;

import java.util.ArrayList;

public class CookieBakery extends WorkShop {
    // eggpowder --> cookie

    Cookie cookie = new Cookie();

    private static CookieBakery cookieBakery = new CookieBakery();

    private CookieBakery() {
    }

    public static CookieBakery getCookieBakery() {
        return cookieBakery;
    }

    Depot depot = Depot.getDepot();

    public void makeCookie(){
        if (ourFarm.getInPutsOfCakeBakery().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = ourFarm.getInPutsOfCakeBakery().size()-1 ; i>=0 ; i--)
            {
                if (ourFarm.getInPutsOfCakeBakery().get(i) instanceof EggPowder) {
                    ourFarm.getOutPutsOfCakeBakery().add(new Cookie());
                    ourFarm.getInPutsOfCakeBakery().remove(i);
                }


            }
        }
    }
}
