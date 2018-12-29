package Model.Workshop;

import Model.Products.Cake;
import Model.Products.Egg;
import Model.Products.Flour;

public class CakeBakery extends WorkShop {
    // flour & cookie --> cake
    private  boolean count1 =false;
    private boolean count2 = false;
    private static CakeBakery cakeBakery = new CakeBakery();

    public CakeBakery() {
    }

    public static CakeBakery getCakeBakery() {
        return cakeBakery;
    }

    public void makeCake()
    {
        if (ourFarm.getInPutsOfCakeBakery().isEmpty())
        {
            System.out.println("there is nothing to create");
        }
        else
        {
            for (int k = ourFarm.getInPutsOfCakeBakery().size()-1 ; k>=0 ; k--)
            {
                if (ourFarm.getInPutsOfCakeBakery().get(k) instanceof Egg)
                    count1 = true;
                if (ourFarm.getInPutsOfCakeBakery().get(k) instanceof Flour)
                    count2 = true;
                if (count1&&count2)
                    ourFarm.getOutPutsOfCakeBakery().add(new Cake());

            }
            if (!(count2&&count1))
                System.out.println("there is nothing to create");
        }

    }

    //public Cake cookBakery(Flour flour, Egg egg){
     //   return new Cake() ;
   // }

}
