package Model.Workshop;

import Model.Depot;
import Model.Products.Clothe;
import Model.Products.Fabric;

public class SewingFactory extends WorkShop {
    // fabric  --> clothe

    Depot depot = Depot.getDepot() ;

    Clothe clothe = new Clothe();

    public void makeClothe(){
        for(int i=0 ; i<depot.getCapacity() ; i++){
            if(depot.getStoredProducts().get(i) instanceof Fabric){
                depot.pickUp(i);
                depot.addStoredProducts(clothe);
            }
        }
    }

}
