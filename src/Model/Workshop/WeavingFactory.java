package Model.Workshop;

import Model.Depot;
import Model.OurFarm;
import Model.Product;
import Model.Products.Cookie;
import Model.Products.EggPowder;
import Model.Products.Fabric;
import Model.Products.Sewing;

import java.util.ArrayList;

public class WeavingFactory extends WorkShop {
    // sewing --> Fabric
    Depot depot = Depot.getDepot() ;
    Fabric fabric = new Fabric() ;
    private static WeavingFactory weavingFactory = new WeavingFactory();

    private WeavingFactory() {
    }

    public static WeavingFactory getWeavingFactory() {
        return weavingFactory;
    }

    public void makeFabric(){
        if (ourFarm.getInPutsOfWeavingFactory().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int i = ourFarm.getInPutsOfWeavingFactory().size()-1 ; i>=0 ; i--)
            {
                if (ourFarm.getInPutsOfWeavingFactory().get(i) instanceof Sewing) {
                    ourFarm.getOutPutsOfWeavingFactory().add(new Fabric());
                    ourFarm.getInPutsOfWeavingFactory().remove(i);
                }


            }
        }
    }

}
