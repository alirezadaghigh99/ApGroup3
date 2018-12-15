package Model.Requests;

public class StartRequest extends Request {
     private  String workshopName ;

    public StartRequest(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }
}
