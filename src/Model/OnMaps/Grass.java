package Model.OnMaps;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass extends Entity {
    Image imageGrass1;



    {
        try {
            imageGrass1 = new Image(new FileInputStream("Grass\\grass1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    ImageView imageView = new ImageView(imageGrass1);

    private boolean isGrass = false;

    public boolean isGrass() {
        return isGrass;
    }

    public void setGrass(boolean grass) {
        isGrass = grass;
    }
}
