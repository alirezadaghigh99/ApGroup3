package Model.Requests;

public class SaleProductRequest extends Request {
    private String transName , produtName ;
    private int count ;

    public SaleProductRequest(String transName, String produtName, int count) {
        this.transName = transName;
        this.produtName = produtName;
        this.count = count;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
