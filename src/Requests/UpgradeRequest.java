package Requests;

public class UpgradeRequest extends Request {
   private String thingWeWantUpgrade ;

    public UpgradeRequest(String thingWeWantUpgrade) {
        this.thingWeWantUpgrade = thingWeWantUpgrade;
    }

    public String getThingWeWantUpgrade() {
        return thingWeWantUpgrade;
    }

    public void setThingWeWantUpgrade(String thingWeWantUpgrade) {
        this.thingWeWantUpgrade = thingWeWantUpgrade;
    }
}

