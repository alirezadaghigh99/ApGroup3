package Model.Workshop;

import Model.Products.Cookie;
import Model.Products.Egg;
import Model.Products.Flour;

public class CookieBakery extends WorkShop {
    // eggpowder --> cookie
    public Cookie cookCookie(Egg egg, Flour flour){
        return new Cookie();
    }
}
