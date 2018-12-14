package Controller;

import Model.Map;
import Model.OurFarm;
import Requests.*;
import Requests.Request;
import View.View;

public class FarmController {
    private OurFarm ourFarm = OurFarm.getOurFarm();
    private Map map = new Map();
    private View view = new View();
    CommandAnalyzer commandAnalyzer  = new CommandAnalyzer();

    public boolean isGameFinished()
    {
      return false ;
    }

    public void listenForCommand() {
        boolean isFinished = false;

        while (!isFinished)
        {
            String command = view.getCommand().trim();

            Request request = commandAnalyzer.getRequest(command);
            if (request instanceof AddAnimalRequest)
            {

            }
            if (request instanceof AddProductToWorkshopRequest)
            {

            }
            if (request instanceof CreateWorkShopRequest)
            {

            }
            if (request instanceof CageRequest)
            {

            }
            if (request instanceof AddGrassRequest)
            {

            }
            if (request instanceof AddWaterRequest)
            {

            }
            if (request instanceof BuyCageRequest)
            {

            }
            if (request instanceof BuyProductRequest)
            {

            }
            if (request instanceof BuyTransportationRequest)
            {

            }
            if (request instanceof PickUpRequest)
            {

            }
            if (request instanceof PutToCageRequest)
            {

            }
            if (request instanceof SaleProductRequest)
            {

            }
            if (request instanceof EndRequest)
            {
                isFinished = true ;
            }
        }
    }
    public void newGame()
    {

    }

//    public boolean isFinished(CheckGoal checkgoal){
//
//    }

    public void wildEatDomesticAction()
    {

    }
    public void pickUpAction()
    {

    }
    public void collision()
    {

    }
    public void save(){

    }
    public void load(){

    }
    public void passTurn(){

    }

    public void buyRequest (){

    }

    public void upgradeRequest(){

    }



}
