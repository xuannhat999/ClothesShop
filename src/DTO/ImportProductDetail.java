package DTO;

import java.math.BigDecimal;

public class ImportProductDetail {
    private int import_detial_id;
    private int importId;
    private int productVariantId;
    private int quantity;
    private BigDecimal amount;

    // Constructor mặc định
    public ImportProductDetail() {}

    // Constructor sao chép
    public ImportProductDetail(ImportProductDetail d) {
            this.import_detial_id=d.import_detial_id;
            this.importId = d.importId;
            this.productVariantId = d.productVariantId;
            this.quantity = d.quantity;
            this.amount = d.amount;
        
    }

    // Constructor đầy đủ
    public ImportProductDetail(int idid,int importId, int productVariantId, int quantity, BigDecimal amount) {
        this.import_detial_id=idid;
        this.importId = importId;
        this.productVariantId = productVariantId;
        this.quantity = quantity;
        this.amount = amount;
    }

    // Getter và Setter
    public int getImportDetailId()
    {
        return import_detial_id;
    }
    public void setImportDetailId(int idid)
    {
        this.import_detial_id=idid;
    }
    public int getImportId() {
        return importId;
    }

    public void setImportId(int importId) {
        this.importId = importId;
    }

    public int getProductVariantId() {
        return productVariantId;
    }

    public void setProductVariantId(int productVariantId) {
        this.productVariantId = productVariantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
