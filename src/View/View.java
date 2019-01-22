package View;

import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public String getCommand() {
        return scanner.nextLine().toLowerCase();
    }

    public void logViewMoney(int money) {
        System.out.println("money: " + money);
    }

    public void logBadCommand() {
        System.out.println("this command is not allowed");
    }

    public void logNothing() {
        System.out.println("there is nothing to create");
    }

    public void logCantClear() {
        System.out.println("there is nothing to clear");
    }

    public void logCantAdd() {
        System.out.println("depot is empty");
    }

    public void logItsEmpty() {
        System.out.println("this cell is empty");
    }

    public void logSeeMap(int cellsOfMap) {
        System.out.print(cellsOfMap);
    }

    public void logSeeTime(long time) {
        System.out.println("time: " + time);
    }

    public void logSeeDomesticAnimals(int numberOfHen, int numberOfCow, int numberOfSheep) {
        System.out.println("number of hens: " + numberOfHen);
        System.out.println("number of cows: " + numberOfCow);
        System.out.println("number of sheeps: " + numberOfSheep);

    }

    public void logSeeWildAnimal(int numberOfLion, int numberOfBear) {
        System.out.println("numberOfLion: " + numberOfLion);
        System.out.println("numberOfBear: " + numberOfBear);

    }

    public void logSeeLevel(int level) {
        System.out.println("level: " + level);
    }

    public void logItsFull() {
        System.out.println("its full");
    }

    public void logNotEnoughMoney() {
        System.out.println("money is not enough!");
    }
}
