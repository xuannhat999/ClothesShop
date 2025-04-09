package DTO;

public class ProductImage {
    private int imageId;
    private String url1;
    private String url2;
    private int productColorId;

    public ProductImage(){}
    public ProductImage(int imageId, String url1, String url2, int productColorId) {
        this.imageId = imageId;
        this.url1 = url1;
        this.url2 = url2;
        this.productColorId = productColorId;
    }

    public ProductImage(ProductImage d) {
        this.imageId = d.imageId;
        this.url1 = d.url1;
        this.url2 = d.url2;
        this.productColorId = d.productColorId;
    }

    public int getImageId() { return imageId; }
    public void setImageId(int imageId) { this.imageId = imageId; }
    public String getUrl1() { return url1; }
    public void setUrl1(String url1) { this.url1 = url1; }
    public String getUrl2() { return url2; }
    public void setUrl2(String url2) { this.url2 = url2; }
    public int getProductColorId() { return productColorId; }
    public void setProductColorId(int productColorId) { this.productColorId = productColorId; }
}
