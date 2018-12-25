package Model.Workshop;

import Model.Cookie;
import Model.Egg;
import Model.Flour;
import Model.WorkShop;

public class CookieBakery extends WorkShop {
    // eggpowder --> cookie
    public Cookie cookCookie(Egg egg, Flour flour){
        return new Cookie();
    }
}
