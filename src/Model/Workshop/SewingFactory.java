package Model.Workshop;

import Model.Depot;
import Model.Product;
import Model.Products.Clothe;
import Model.Products.Fabric;

import java.util.ArrayList;

public class SewingFactory extends WorkShop {
    // fabric  --> clothe

    private static SewingFactory sewingFactory = new SewingFactory();

    public static SewingFactory getSewingFactory() {
        return sewingFactory;
    }

    private SewingFactory() {
    }

    Depot depot = Depot.getDepot() ;

    Clothe clothe = new Clothe();

    public void makeClothe(){
        if (ourFarm.getInPutsOfSewingFactory().isEmpty())
            System.out.println("there is nothing to create");
        else
        {
            for (int j = ourFarm.getInPutsOfSewingFactory().size()-1 ; j>=0 ; j--)
            {
                if (ourFarm.getInPutsOfSewingFactory().get(j) instanceof Fabric)
                {
                    ourFarm.getOutPutsOfSewingFactory().add(new Clothe());
                    ourFarm.getInPutsOfSewingFactory().remove(j);
                }
            }
        }
    }

}
