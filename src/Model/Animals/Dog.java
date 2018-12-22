package Model.Animals;

import Model.Cell;
import Model.Map;
import Model.Utils;
import Model.WildAnimal;

public class Dog extends Animal {
    private Map map = Map.getMap() ;
    @Override
    public void smartWalk() {

        Cell[][] cells = map.getCells();
        for (int k = 1; k< Utils.mapSize ; k++)
        {
            for (int i = x-k ; i<x+k ; i++)
            {
                for (int j = y - k ;j<y + k ; j++)
                {
                    if (i>=0&&i<30&&j>=0&&j<30&&!cells[i][j].getCellAnimals().isEmpty())
                    {
                        for (int z = 0 ; j<cells[i][j].getCellAnimals().size() ; z++)
                        {
                            if (cells[i][j].getCellAnimals().get(z) instanceof WildAnimal
                                    )
                            {
                                if (i>x )
                                    x  = x +1;
                                else
                                    x  = x -1 ;
                                if (j>y )
                                    y  = y +1 ;
                                else y = y -1 ;
                                return;
                            }
                        }
                    }
                }
            }
        }
        x  = x +1;
        y  = y -1 ;

    }
}
