package Requests;

public class ClearFromTranRequest extends Request {
    private String transnName ;

    public ClearFromTranRequest(String transnName) {
        this.transnName = transnName;
    }

    public String getTransnName() {
        return transnName;
    }

    public void setTransnName(String transnName) {
        this.transnName = transnName;
    }
}
