package Controller;

import Requests.*;
import Requests.Request;

public class CommandAnalyzer {
    private final String ADD_Animal_REQUEST = "buy [a-z]+";
    private final String ADD_WATER_REQUEST = "well";
    private final String ADD_TRANSPORTATION = "add transportation [a-z]+";
    private final String ADD_WORKSHOP = "add workshop [a-z]+";
    private final String ADD_GRASS_REQUEST = "plant [\\d]+ [\\d]+";
    private final String PICKUP_REQUEST = "pick up [\\d]+ [\\d]+";
    private final String SALE_PRODUCT = "[a-z]+ add [a-z]+ [\\d]+";
   private final String CAGE_RQUEST = "cage [\\d]+ [\\d]+";
    private final String UPGRADE_REQUEST = "upgrade [a-z]+";
    private final String GO_TRANSFORMATION_REQUEST = "[a-z]+ go";
    private final String CLEAR_THINGS_FROM_TRANSFORMATION = "[a-z]+ clear";
    private final String  START_WORKSHOP_REQUEST = "start [a-z]+";

    private final String END_REQUEST = "end game";

    public Request getRequest(String command) {
        if (command.matches(ADD_Animal_REQUEST)) {
            String[] params = command.split(" ");
            return new AddAnimalRequest(params[1]);
        }
        if (command.matches(ADD_WATER_REQUEST)) {
            return new AddWaterRequest();
        }
        if (command.matches(ADD_TRANSPORTATION)) {
            return new BuyTransportationRequest();
        }
        if (command.matches(ADD_WORKSHOP)) {
            return new CreateWorkShopRequest();
        }
        if (command.matches(ADD_GRASS_REQUEST)) {
            String[] params = command.split(" ");
            return new AddGrassRequest(Integer.parseInt(params[1] ), Integer.parseInt(params[2]));
        }
        if (command.matches(PICKUP_REQUEST)) {
            String[] params = command.split(" ");

            return new PickUpRequest(Integer.parseInt(params[1]) , Integer.parseInt(params[2]));
        }

        if (command.matches(SALE_PRODUCT)) {
            String[] params = command.split(" ");
            return new SaleProductRequest(params[0] ,params[2] , Integer.parseInt(params[3]) );
        }
        if (command.matches(GO_TRANSFORMATION_REQUEST))
        {
            String[] params = command.split(" ");
            return new GoRequest(params[1]);
        }
        if (command.matches(UPGRADE_REQUEST))
        {
            String[] params = command.split(" ");
            return new UpgradeRequest(params[1]);

        }
        if (command.matches(CAGE_RQUEST))
        {
            String[] params = command.split(" ");
            return new CageRequest(Integer.parseInt(params[1]) , Integer.parseInt(params[2]));

        }
        if (command.matches(CLEAR_THINGS_FROM_TRANSFORMATION))
        {
            String[] params = command.split(" ");
            return new ClearFromTranRequest(params[0]);

        }
        if (command.matches(START_WORKSHOP_REQUEST))
        {
            String[] params = command.split(" ");
            return new StartRequest(params[1]);

        }

        else return new EndRequest();

    }
}


