package Model.Workshop;

import Model.Depot;
import Model.OurFarm;
import Model.Product;
import Model.Products.Cookie;
import Model.Products.EggPowder;
import Model.Products.Sewing;
import Model.Products.Wool;

import java.util.ArrayList;

public class SpinneryFactory extends WorkShop {
    //wool --> sewing
    Sewing sewing = new Sewing();
    Depot depot = Depot.getDepot() ;
    private static SpinneryFactory spinneryFactory  = new SpinneryFactory();

    private SpinneryFactory() {
    }

    public static SpinneryFactory getSpinneryFactory() {
        return spinneryFactory;
    }

    public void makeSewing(){
        {
            if (ourFarm.getInPutsOfSpinnery().isEmpty())
                System.out.println("there is nothing to create");
            else
            {
                for (int i = ourFarm.getInPutsOfSpinnery().size()-1 ; i>=0 ; i--)
                {
                    if (ourFarm.getInPutsOfSpinnery().get(i) instanceof Wool) {
                        ourFarm.getOutPutsOfSpinnery().add(new Sewing());
                        ourFarm.getInPutsOfSpinnery().remove(i);
                    }


                }
            }
        }}
}
