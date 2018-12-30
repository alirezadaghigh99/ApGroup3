package Model.Requests;

public class OpenDirectory extends Request {
    private String path ;

    public OpenDirectory(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
