package Model.Workshop;

import Model.Depot;
import Model.Products.Sewing;
import Model.Products.Wool;

public class SpinneryFactory extends WorkShop {
    //wool --> sewing
    Sewing sewing = new Sewing();
    Depot depot = Depot.getDepot() ;

    public void makeSewing(){
        for(int i=0 ; i<depot.getCapacity() ; i++ ){
            if(depot.getStoredProducts().get(i) instanceof Wool){
                depot.addStoredProducts(sewing);
            }
        }
    }
}
