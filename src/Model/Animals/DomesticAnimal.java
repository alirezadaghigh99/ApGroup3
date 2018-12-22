package Model.Animals;

import Model.Cell;

import Model.Map;
import Model.Utils;

public class DomesticAnimal extends Animal  {
    private double energy ;
    private boolean isWeak ;
    private boolean canEat ;
    private boolean isFullEnergy ;

    @Override
    public void randomWalk() {
        super.randomWalk();
    }
    private Map map = Map.getMap();
    @Override
    public void smartWalk() {
        Cell[][] cell = map.getCells();
        for (int k = 1; k< Utils.mapSize ; k++)
        {
            for (int i = x -k ; i<=x +k ; i++)
            {
                for (int j = y -k ; j<=y +k ; j++)
                {
                    if (i<30&&i>=0&&j<30&&j>=0&&cell[i][j].getGrass().isGrass())
                    {
                        if (i>x)
                            x  = x +1;
                        else
                            x  = x -1 ;
                        if (j>y )
                            y  = y +1 ;
                        else y  = y -1 ;
                        return;
                    }
                }
            }

        }
        x  = x  +1 ;
        y  = y  +1 ;
    }


}
