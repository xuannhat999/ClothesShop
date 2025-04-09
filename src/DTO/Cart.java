package DTO;

public class Cart {
    private int userId;
    private int productVariantId;
    private int quantity;

    public Cart(){}
    public Cart(int userId, int productVariantId, int quantity) {
        this.userId = userId;
        this.productVariantId = productVariantId;
        this.quantity = quantity;
    }

    public Cart(Cart d) {
        this.userId = d.userId;
        this.productVariantId = d.productVariantId;
        this.quantity = d.quantity;
    }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getProductVariantId() { return productVariantId; }
    public void setProductVariantId(int productVariantId) { this.productVariantId = productVariantId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
