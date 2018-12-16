package Model;

public class Grass extends Entity {
    private boolean isGrass = false;
    private Well well  ;

    public boolean isGrass() {
        return isGrass;
    }

    public void setGrass(boolean grass) {
        isGrass = grass;
    }

    public Well getWell() {
        return well;
    }

    public void setWell(Well well) {
        this.well = well;
    }
}
