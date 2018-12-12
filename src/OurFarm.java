import java.util.ArrayList;

public class OurFarm {
    private ArrayList<WildAnimal>wildAnimals = new ArrayList<>();
    private ArrayList<DomesticAnimal>domesticAnimals = new ArrayList<>();
    private ArrayList <Product>products = new ArrayList<>();
    private ArrayList <Building> buildings = new ArrayList<Building>();
    Map map ;
    private static OurFarm ourFarm = new OurFarm();

    private OurFarm() {
        this.ourFarm = ourFarm;
    }

    public static OurFarm getOurFarm(){
        return ourFarm ;
    }


}
