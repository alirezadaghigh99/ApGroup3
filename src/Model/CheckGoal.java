package Model;

import Model.Animals.Cow;
import Model.Animals.Hen;
import Model.Animals.Sheep;
import Model.OnMaps.Map;
import Model.OurFarm;
import Model.Products.Egg;
import Model.Products.Milk;
import Model.Products.Wool;

public class CheckGoal {
    private int requirmentOfCow ;
    private int requirmentOfEgg ;
    private int requirmentOfwool ;
    private int requirmentOfMilk ;
    private int requirmentOfGold ;
    private int requirmentOfHen ;
    private int requirmentOfSheep ;
    private int requirmentOfWorkshopLevel ;
    OurFarm ourFarm = OurFarm.getOurFarm();
    public boolean checkLevel1()
    {
        for (int i = 0 ; i<ourFarm.getAnimals().size() ; i++)
        {
            requirmentOfCow=0;
            requirmentOfSheep=0;
            requirmentOfHen=0;
            requirmentOfEgg=0;
            requirmentOfMilk = 0;
            requirmentOfwool=0;
            if (ourFarm.getAnimals().get(i) instanceof Hen)
            {
             requirmentOfHen++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Cow)
            {
                requirmentOfCow++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Sheep)
            {
                requirmentOfSheep++;
            }
        }
        for (int j = 0 ; j<ourFarm.getProducts().size() ; j++)
        {
            if (ourFarm.getProducts().get(j) instanceof Egg)
            {
                requirmentOfEgg++;
            }
            if (ourFarm.getProducts().get(j) instanceof Wool)
            {
                requirmentOfwool++;
            }
            if (ourFarm.getProducts().get(j) instanceof Milk)
            {
                requirmentOfMilk++;
            }

        }
        if (requirmentOfMilk==0&&requirmentOfEgg==1&&requirmentOfwool==0&&requirmentOfSheep==1&&requirmentOfHen==3&&requirmentOfCow==1)
            return true ;
        else
            return false;
    }
    public boolean checkLevel2()
    {
        for (int i = 0 ; i<ourFarm.getAnimals().size() ; i++)
        {
            requirmentOfCow=0;
            requirmentOfSheep=0;
            requirmentOfHen=0;
            requirmentOfEgg=0;
            requirmentOfMilk = 0;
            requirmentOfwool=0;
            if (ourFarm.getAnimals().get(i) instanceof Hen)
            {
                requirmentOfHen++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Cow)
            {
                requirmentOfCow++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Sheep)
            {
                requirmentOfSheep++;
            }
        }
        for (int j = 0 ; j<ourFarm.getProducts().size() ; j++)
        {
            if (ourFarm.getProducts().get(j) instanceof Egg)
            {
                requirmentOfEgg++;
            }
            if (ourFarm.getProducts().get(j) instanceof Wool)
            {
                requirmentOfwool++;
            }
            if (ourFarm.getProducts().get(j) instanceof Milk)
            {
                requirmentOfMilk++;
            }

        }
        if (requirmentOfMilk==2&&requirmentOfEgg==4&&requirmentOfwool==0&&requirmentOfSheep==2&&requirmentOfHen==5&&requirmentOfCow==2)
            return true ;
        else
            return false;
    }
    public boolean checkLevel3()
    {
        for (int i = 0 ; i<ourFarm.getAnimals().size() ; i++)
        {
            requirmentOfCow=0;
            requirmentOfSheep=0;
            requirmentOfHen=0;
            requirmentOfEgg=0;
            requirmentOfMilk = 0;
            requirmentOfwool=0;
            if (ourFarm.getAnimals().get(i) instanceof Hen)
            {
                requirmentOfHen++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Cow)
            {
                requirmentOfCow++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Sheep)
            {
                requirmentOfSheep++;
            }
        }
        for (int j = 0 ; j<ourFarm.getProducts().size() ; j++)
        {
            if (ourFarm.getProducts().get(j) instanceof Egg)
            {
                requirmentOfEgg++;
            }
            if (ourFarm.getProducts().get(j) instanceof Wool)
            {
                requirmentOfwool++;
            }
            if (ourFarm.getProducts().get(j) instanceof Milk)
            {
                requirmentOfMilk++;
            }

        }
        if (requirmentOfMilk==2&&requirmentOfEgg==5&&requirmentOfwool==1&&requirmentOfSheep==3&&requirmentOfHen==4&&requirmentOfCow==2)
            return true ;
        else
            return false;
    }
    public boolean checkLevel4()
    {
        for (int i = 0 ; i<ourFarm.getAnimals().size() ; i++)
        {
            requirmentOfCow=0;
            requirmentOfSheep=0;
            requirmentOfHen=0;
            requirmentOfEgg=0;
            requirmentOfMilk = 0;
            requirmentOfwool=0;
            if (ourFarm.getAnimals().get(i) instanceof Hen)
            {
                requirmentOfHen++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Cow)
            {
                requirmentOfCow++;
            }
            if (ourFarm.getAnimals().get(i) instanceof Sheep)
            {
                requirmentOfSheep++;
            }
        }
        for (int j = 0 ; j<ourFarm.getProducts().size() ; j++)
        {
            if (ourFarm.getProducts().get(j) instanceof Egg)
            {
                requirmentOfEgg++;
            }
            if (ourFarm.getProducts().get(j) instanceof Wool)
            {
                requirmentOfwool++;
            }
            if (ourFarm.getProducts().get(j) instanceof Milk)
            {
                requirmentOfMilk++;
            }

        }
        if (requirmentOfMilk==4&&requirmentOfEgg==9&&requirmentOfwool==5&&requirmentOfSheep==3&&requirmentOfHen==10&&requirmentOfCow==5)
            return true ;
        else
            return false;
    }

    public int getRequirmentOfCow() {
        return requirmentOfCow;
    }

    public void setRequirmentOfCow(int requirmentOfCow) {
        this.requirmentOfCow = requirmentOfCow;
    }

    public int getRequirmentOfEgg() {
        return requirmentOfEgg;
    }

    public void setRequirmentOfEgg(int requirmentOfEgg) {
        this.requirmentOfEgg = requirmentOfEgg;
    }

    public int getRequirmentOfwool() {
        return requirmentOfwool;
    }

    public void setRequirmentOfwool(int requirmentOfwool) {
        this.requirmentOfwool = requirmentOfwool;
    }

    public int getRequirmentOfMilk() {
        return requirmentOfMilk;
    }

    public void setRequirmentOfMilk(int requirmentOfMilk) {
        this.requirmentOfMilk = requirmentOfMilk;
    }

    public int getRequirmentOfGold() {
        return requirmentOfGold;
    }

    public void setRequirmentOfGold(int requirmentOfGold) {
        this.requirmentOfGold = requirmentOfGold;
    }

    public int getRequirmentOfHen() {
        return requirmentOfHen;
    }

    public void setRequirmentOfHen(int requirmentOfHen) {
        this.requirmentOfHen = requirmentOfHen;
    }

    public int getRequirmentOfSheep() {
        return requirmentOfSheep;
    }

    public void setRequirmentOfSheep(int requirmentOfSheep) {
        this.requirmentOfSheep = requirmentOfSheep;
    }

    public int getRequirmentOfWorkshopLevel() {
        return requirmentOfWorkshopLevel;
    }

    public void setRequirmentOfWorkshopLevel(int requirmentOfWorkshopLevel) {
        this.requirmentOfWorkshopLevel = requirmentOfWorkshopLevel;
    }
}
