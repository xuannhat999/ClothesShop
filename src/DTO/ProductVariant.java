package DTO;

public class ProductVariant {
    private int productVariantId;
    private int productColorId;
    private String size;
    private int quantity;

    public ProductVariant(){}
    public ProductVariant(int productVariantId, int productColorId, String size, int quantity) {
        this.productVariantId = productVariantId;
        this.productColorId = productColorId;
        this.size = size;
        this.quantity = quantity;
    }

    public ProductVariant(ProductVariant d) {
        this.productVariantId = d.productVariantId;
        this.productColorId = d.productColorId;
        this.size = d.size;
        this.quantity = d.quantity;
    }

    public int getProductVariantId() { return productVariantId; }
    public void setProductVariantId(int productVariantId) { this.productVariantId = productVariantId; }
    public int getProductColorId() { return productColorId; }
    public void setProductColorId(int productColorId) { this.productColorId = productColorId; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
