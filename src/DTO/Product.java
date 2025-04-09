package DTO;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private String productName;
    private int categoryId;
    private int materialId;
    private String description;
    private BigDecimal price;
    private int brandId;
    private int gender;

    public Product(){}
    // Constructor
    public Product (int productId, String productName, int categoryId, int materialId, String description, BigDecimal price, int brandId, int gender) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
        this.materialId = materialId;
        this.description = description;
        this.price = price;
        this.brandId = brandId;
        this.gender = gender;
    }
    public Product(Product d)
    {
        this.productId = d.productId;
        this.productName = d.productName;
        this.categoryId = d.categoryId;
        this.materialId = d.materialId;
        this.description = d.description;
        this.price = d.price;
        this.brandId = d.brandId;
        this.gender = d.gender;
    }

    // Getters and Setters
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    public int getMaterialId() { return materialId; }
    public void setMaterialId(int materialId) { this.materialId = materialId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public int getBrandId() { return brandId; }
    public void setBrandId(int brandId) { this.brandId = brandId; }
    public int getGender() { return gender; }
    public void setGender(int gender) { this.gender = gender; }
}
