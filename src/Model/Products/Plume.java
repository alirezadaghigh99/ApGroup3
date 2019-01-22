package Model.Products;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Plume extends Product {
    private Image image;

    {
        try {
            image = new Image(new FileInputStream("C:\\Users\\SE7EN-PC\\Desktop\\Textures\\Products\\Flour.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private ImageView imageView  = new ImageView(image) ;
}
