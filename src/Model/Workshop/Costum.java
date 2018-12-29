package Model.Workshop;

import Model.OurFarm;
import Model.Products.Product;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;

public class Costum extends WorkShop {
    OurFarm ourFarm = OurFarm.getOurFarm();
    private ArrayList<Product>inputs = new ArrayList<>();
    private String output;
    private String path;

    public Costum(String path) {
        this.path = path;
    }

    {
        File f = new File(path);
        InputStream stream = null;
        try {
            stream = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder json = new StringBuilder();
        int byteCode = 0;
        try {
            byteCode = stream.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (byteCode != -1 && byteCode > -3) {
            json.append((char) byteCode);
            try {
                byteCode = stream.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParser parser = new JsonParser();
        Object object = parser.parse(json.toString());
        JsonObject jsonObject = (JsonObject) object;

    }
}


