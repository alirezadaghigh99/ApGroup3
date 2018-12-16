package Model.Requests;

public class GoRequest extends Request{
    private String transName ;

    public GoRequest(String transName) {
        this.transName = transName;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }
}
