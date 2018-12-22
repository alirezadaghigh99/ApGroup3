import Controller.FarmController;

public class Main {
    public static void main(String[] args) {
        FarmController farmController = new FarmController();
        farmController.listenForCommand();
    }
}
