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
    private int requirementOfCow;
    private int requirementOfEgg;
    private int requirementOfWool;
    private int requirementOfMilk;
    private int requirementOfGold;
    private int requirementOfHen;
    private int requirementOfSheep;
    private int requirementOfWorkshopLevel;
    private int level = 1;

    public void setConditions() {
        if (level == 1) {
            requirementOfCow = 0;
            requirementOfEgg = 1;
            requirementOfGold = 0;
            requirementOfHen = 4;
            requirementOfMilk = 0;
            requirementOfSheep = 0;
            requirementOfWool = 0;
            requirementOfWorkshopLevel = 0;
        }
        if (level == 2) {
            requirementOfCow = 0;
            requirementOfEgg = 3;
            requirementOfGold = 40;
            requirementOfHen = 4;
            requirementOfMilk = 0;
            requirementOfSheep = 1;
            requirementOfWool = 0;
            requirementOfWorkshopLevel = 0;
        }
        if (level == 3) {
            requirementOfCow = 0;
            requirementOfEgg = 2;
            requirementOfGold = 80;
            requirementOfHen = 6;
            requirementOfMilk = 0;
            requirementOfSheep = 1;
            requirementOfWool = 0;
            requirementOfWorkshopLevel = 0;
        }
        if (level == 4) {
            requirementOfCow = 0;
            requirementOfEgg = 2;
            requirementOfGold = 120;
            requirementOfHen = 5;
            requirementOfMilk = 0;
            requirementOfSheep = 1;
            requirementOfWool = 1;
            requirementOfWorkshopLevel = 0;
        }
    }

    public int getRequirementOfCow() {
        return requirementOfCow;
    }

    public int getRequirementOfEgg() {
        return requirementOfEgg;
    }

    public int getRequirementOfWool() {
        return requirementOfWool;
    }

    public int getRequirementOfMilk() {
        return requirementOfMilk;
    }

    public int getRequirementOfGold() {
        return requirementOfGold;
    }

    public int getRequirementOfHen() {
        return requirementOfHen;
    }

    public int getRequirementOfSheep() {
        return requirementOfSheep;
    }

    public int getRequirementOfWorkshopLevel() {
        return requirementOfWorkshopLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}