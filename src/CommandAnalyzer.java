import Requests.*;
import Requests.Request;

public class CommandAnalyzer {
    private final String ADD_Animal_REQUEST = "add animal -[a-z]+";
    private final String ADD_WATER_REQUEST = "add water";
    private final String ADD_TRANSPORTATION = "add transportation [a-z]+";
    private final String ADD_WORKSHOP = "add workshop [a-z]+";
    private final String ADD_GRASS_REQUEST = "add grass";
    private final String PICKUP_REQUEST = "pick up [a-z]+";
    private final String ADD_PRODUCT_TO_WORKSHOP = "add [a-z]+ to [a-z]+";
    private final String BUY_CAGE = "buy cage";
    private final String PUT_WILD_INTO_CAGE = "put [a-z]+ to cage";
    private final String BUY_PRODUCT = "buy product [a-z]+";
    private final String SELL_PRODUCT = "sell product [a-z]+";
    private final String END_REQUEST = "end game";

    public Request getRequest(String command) {
        if (command.matches(ADD_Animal_REQUEST)) {
            return new AddAnimalRequest(2);
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
            return new AddGrassRequest();
        }
        if (command.matches(PICKUP_REQUEST))
            return new PickUpRequest();
        if (command.matches(BUY_CAGE)) {
            return new BuyCageRequest();
        }
        if (command.matches(PUT_WILD_INTO_CAGE)) {
            return new PutToCageRequest();
        }
        if (command.matches(BUY_PRODUCT)) {
            return new BuyProductRequest();
        }
        if (command.matches(SELL_PRODUCT)) {
            return new SellProductRequest();
        }
        if (command.matches(ADD_PRODUCT_TO_WORKSHOP)) {
            return new AddProductToWorkshopRequest();
        }
        else return new EndRequest();

    }
}


