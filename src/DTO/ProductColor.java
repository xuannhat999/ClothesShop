package DTO;

public class ProductColor {
    private int productColorId;
    private int productId;
    private int colorId;
    private String url;

    public ProductColor(){}
    public ProductColor(int productColorId, int productId, int colorId,String url) {
        this.productColorId = productColorId;
        this.productId = productId;
        this.colorId = colorId;
        this.url = url;
    }
    public ProductColor(ProductColor d) {
        this.productColorId = d.productColorId;
        this.productId = d.productId;
        this.colorId = d.colorId;
        this.url=d.url;
    }

    public int getProductColorId() { return productColorId; }
    public void setProductColorId(int productColorId) { this.productColorId = productColorId; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public int getColorId() { return colorId; }
    public void setColorId(int colorId) { this.colorId = colorId; }
    public String getURL(){return url;}


}
