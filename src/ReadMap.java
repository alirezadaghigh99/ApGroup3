import Model.OnMaps.Map;
import Model.Products.Sewing;
import Model.Workshop.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;

public class ReadMap
{
    public Map ReadMapOfGame(String path)
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
        while (byteCode != -1&&byteCode>-2) {
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
        JsonArray jsonWorkshops = jsonObject.get("workshop").getAsJsonArray();
        ArrayList<JsonWorkshop> workshops = new ArrayList<>();
        int workshopNumbers = workshops.size();
        for (int i = 0 ; i<workshopNumbers ; i++)
        {
            JsonWorkshop workshop = new JsonWorkshop();
            workshop.setType(jsonWorkshops.get(i).getAsJsonObject().get("type").getAsInt());
            workshop.setLevel(jsonWorkshops.get(i).getAsJsonObject().get("level").getAsInt());
            workshops.add(workshop);
        }
        Map map =new Map();
        for (int i = 0 ; i<workshops.size() ; i++)
        {
            if (workshops.get(i).getType() == 1)
            {
                CakeBakery cakeBakery = new CakeBakery();
            }
            if (workshops.get(i).getType()==2)
            {
                CookieBakery  cookieBakery = new CookieBakery();
            }
            if (workshops.get(i).getType()==3)
            {
                SpinneryFactory spinneryFactory = new SpinneryFactory();

            }
            if (workshops.get(i).getType()==4)
            {
                SewingFactory sewingFactory = new SewingFactory();

            }
            if (workshops.get(i).getType()==5)
            {
                EggPowderPlantWorkShop eggPowderPlantWorkShop = new EggPowderPlantWorkShop();
            }
            if (workshops.get(i).getType()==6)
            {
                WeavingFactory weavingFactory = new WeavingFactory();
            }
        }
        return map;

    }


}
