import java.util.ArrayList;
import java.util.Arrays;

public class Depot extends Building implements Upgradable{
    private OurFarm ourFarm = new OurFarm();
    private int capacity ;
    private int level ;
    private  int maxLevel ;



    @Override
    public void upgrade() {

    }

    private boolean isFull = false;


    private ArrayList<Product> storedProducts;
    public void store(Product ... products){
        storedProducts.addAll(Arrays.asList(products));
    }
    public Product pickUp(Product ... products)
    {return null;}

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }


