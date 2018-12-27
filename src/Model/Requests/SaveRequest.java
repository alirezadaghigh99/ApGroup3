package Model.Requests;

public class SaveRequest extends Request
{
    private String path ;

    public SaveRequest(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
