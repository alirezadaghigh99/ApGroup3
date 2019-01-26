package Model.OnMaps;

import Model.SpriteAnimation;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass extends Entity {
    private static Grass instance = new Grass();
    Image imageGrass1;


    {
        try {
            imageGrass1 = new Image(new FileInputStream("Grass\\grass1.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    ImageView imageView = new ImageView(imageGrass1);

    public Animation grassAnimation() {
        return new SpriteAnimation(imageView, Duration.millis(1000), 10, 4, 0, 0,
                150, 136);
    }

    private boolean isGrass = false;

    public boolean isGrass() {
        return isGrass;
    }

    public void setGrass(boolean grass) {
        isGrass = grass;
    }

    public Image getImageGrass1() {
        return imageGrass1;
    }

    public static Grass getInstance() {
        return instance;
    }
}
