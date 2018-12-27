package Model.Requests;

public class LoadRequest extends Request {
    private String path ;

    public LoadRequest(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
