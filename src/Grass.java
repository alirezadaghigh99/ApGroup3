public class Grass extends Entity {
    private int length ;
    private Well well  ;
    private int maxLength ;

    public int getLength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
    public void irrigation (int length)
    {
        well.pickUpWater();
        length++;
    }
}
