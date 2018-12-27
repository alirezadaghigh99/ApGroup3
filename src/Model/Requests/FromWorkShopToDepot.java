package Model.Requests;

public class FromWorkShopToDepot extends Request {
    private String workShopName;
    private String productName ;

    public FromWorkShopToDepot(String workShopName, String productName) {
        this.workShopName = workShopName;
        this.productName = productName;
    }

    public String getWorkShopName() {
        return workShopName;
    }

    public void setWorkShopName(String workShopName) {
        this.workShopName = workShopName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
