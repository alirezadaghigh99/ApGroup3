package Model;


public class WorkShop extends Building implements Upgradable{
    @Override
    public void upgrade() throws Exception {
        if( level == maxLevel)
            throw new Exception("level exceeded");
        if( upgradeCost() > money)
            throw new Exception("money is not enough");
        this.level++ ;
        this.money -= upgradeCost() ;

    }

    private int level ;
    private  int maxLevel ;
    private int constValue = 100 ;//constValue alaki meqdar dadim

    public int upgradeCost(){
        return this.level * this.level * 100 * this.constValue ;
    }


}
