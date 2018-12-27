import Model.Workshop.WorkShop;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonWorkshop {
//    public WorkShop readWorkshop(String path)
//    {
//        File F = new File(path);
//        InputStream stream = new FileInputStream(F);
//        StringBuilder json = new StringBuilder();
//        int byteCode = 0;
//        try {
//            byteCode = stream.read();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        while (byteCode != -1) {
//            json.append((char) byteCode);
//            try {
//                byteCode = stream.read();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        try {
//            stream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JsonParser jsonParser = new JsonParser();
//        Object object = jsonParser.parse(json.toString());
//        JsonObject jsonObject = (JsonObject) object;
//        JsonArray jsonWorkShop = jsonObject.get("workshops").getAsJsonArray();
//    }
}
