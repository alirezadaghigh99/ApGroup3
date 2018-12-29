package Model.Workshop;

import Model.OnMaps.Depot;
import Model.OurFarm;
import Model.Products.Egg;
import Model.Products.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;

public class Costum extends WorkShop {
    OurFarm ourFarm = OurFarm.getOurFarm();
    private Product input = new Product();
    private Product output;
    private String path;
    private Depot depot = Depot.getDepot();

    public void makeOutPut()
    {
        try {
            input = (Product) Class.forName(input.getName()).newInstance();
            output = (Product) Class.forName(output.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        for (int i = 0 ; i<depot.getStoredProducts().size() ; i--)
        {
            Class<? extends Product> aClass = input.getClass();
            if (aClass.equals(depot.getStoredProducts().get(i).getClass())) {
                depot.getStoredProducts().remove(i);
                depot.getStoredProducts().add(output);


           }

        }
    }




}


