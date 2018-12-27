package Model.Workshop;

import Controller.FarmController;
import Model.Building;
import Model.OurFarm;
import Model.Upgradable;

public class WorkShop extends Building implements Upgradable {
protected OurFarm ourFarm = OurFarm.getOurFarm();
    private boolean isWorking = false ;

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    @Override
    public void upgrade() throws Exception {
        int money=0 ;   // money ro alaki meqdar dadim
        if( level == maxLevel)
            throw new Exception("level exceeded");
        if( upgradeCost() > money)
            throw new Exception("money is not enough");
        this.level++ ;
        money -= upgradeCost() ;
        setWorking(true);
    }

    private int level ;
    private  int maxLevel ;
    private int constValue = 100 ;//constValue alaki meqdar dadim

    public int upgradeCost(){
        return this.level * this.level * 100 * this.constValue ;
    }


}
