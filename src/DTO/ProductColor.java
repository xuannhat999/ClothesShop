package DTO;

public class ProductColor {
    private int productColorId;
    private int productId;
    private int colorId;
    private String url1,url2;

    public ProductColor(){}
    public ProductColor(int productColorId, int productId, int colorId,String url1,String url2) {
        this.productColorId = productColorId;
        this.productId = productId;
        this.colorId = colorId;
        this.url1 = url1;
        this.url2=url2;
    }
    public ProductColor(ProductColor d) {
        this.productColorId = d.productColorId;
        this.productId = d.productId;
        this.colorId = d.colorId;
        this.url1=d.url1;
        this.url2=d.url2;
    }

    public int getProductColorId() { return productColorId; }
    public void setProductColorId(int productColorId) { this.productColorId = productColorId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }
    public String getURL1(){return url1;}
    public String getURL2(){return url2;}

}
