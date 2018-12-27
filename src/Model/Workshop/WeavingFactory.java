package Model.Workshop;

import Model.Depot;
import Model.Products.Fabric;
import Model.Products.Sewing;

public class WeavingFactory extends WorkShop {
    // sewing --> Fabric
    Depot depot = Depot.getDepot() ;
    Fabric fabric = new Fabric() ;

    public void makeFabric(){
        for(int i=0 ; i<depot.getCapacity() ; i++){
            if(depot.getStoredProducts().get(i) instanceof Sewing){
                depot.pickUp(i);
                depot.addStoredProducts(fabric);
            }
        }
    }

}
