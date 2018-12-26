package Model.Workshop;

import Model.Depot;
import Model.Product;
import Model.Products.Cake;
import Model.Products.Egg;
import Model.Products.Flour;

import java.util.ArrayList;

public class CakeBakery extends WorkShop {
    // flour & cookie --> cake

    private ArrayList<Product> products = new ArrayList<>();
    Depot depot = Depot.getDepot();

    public void makeCake() {
        for (int i = 0; i < 6; i++) {
            if (depot.getStoredProducts().get(i) instanceof Egg) {
            }
        }

    }
}
