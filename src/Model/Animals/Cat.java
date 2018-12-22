package Model.Animals;

import Model.Cell;
import Model.Upgradable;
import Model.Utils;
import Model.WildAnimal;

public class Cat extends DomesticAnimal implements Upgradable {
    @Override
    public void upgrade() {

    }

    private int level;
    private int maxLevel;

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {

        Cell[][] cells = new Cell[0][];
        for (int k = 1; k< Utils.mapSize ; k++)
        {
            for (int i = x-k ; i<=x+k ; i++)
            {
                for (int j = y - k ;j<=y + k ; j++)
                {
                    if (i>=0&&i<30&&j>=0&&j<30&&!cells[i][j].getCellProducts().isEmpty())
                    {

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
        x  = x +1;
        y  = y -1 ;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
