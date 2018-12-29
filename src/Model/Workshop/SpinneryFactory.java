package Model.Workshop;

import Model.OnMaps.Depot;
import Model.Products.Sewing;
import Model.Products.Wool;

public class SpinneryFactory extends WorkShop {
    //wool --> sewing
    Sewing sewing = new Sewing();
    Depot depot = Depot.getDepot() ;
    private static SpinneryFactory spinneryFactory  = new SpinneryFactory();

    public SpinneryFactory() {
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
