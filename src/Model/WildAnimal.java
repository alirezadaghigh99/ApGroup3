package Model;

import Model.Animals.Animal;
import Model.Animals.DomesticAnimal;

public class WildAnimal extends Animal {
    private boolean isHungry;

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    @Override
    public void randomWalk() {
        super.randomWalk();
    }

    @Override
    public void smartWalk() {
        Cell[][] cells = map.getCells();
        for (int k = 1 ; k<Utils.mapSize ; k++)
        {
            for (int i = xOfAnimal-k ; i<xOfAnimal+k ; i++)
            {
                for (int j = yOfAnimal - k ;j<yOfAnimal + k ; j++)
                {
                    if (i>=0&&i<30&&j>=0&&j<30&&!cells[i][j].getCellAnimals().isEmpty())
                    {
                        for (int z = 0 ; j<cells[i][j].getCellAnimals().size() ; z++)
                        {
                            if (cells[i][j].getCellAnimals().get(z)instanceof  ProducerAnimal)
                            {
                                if (i>xOfAnimal)
                                    xOfAnimal = xOfAnimal+1;
                                else
                                    xOfAnimal = xOfAnimal-1 ;
                                if (j>yOfAnimal)
                                    yOfAnimal = yOfAnimal+1 ;
                                else yOfAnimal = yOfAnimal-1 ;
                                return;
                            }
                        }
                    }
                }
            }
        }
        xOfAnimal = xOfAnimal+1;
        yOfAnimal = yOfAnimal-1 ;

    }
}
