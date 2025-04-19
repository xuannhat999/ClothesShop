package DTO;

import java.math.BigDecimal;

public class InvoiceDetail {
    private int invoiceId;  // Mã hóa đơn
    private int productVariantId;  // Mã sản phẩm
    private int quantity;  // Số lượng
    private Double amount;  // Số tiền (tính theo sản phẩm x số lượng)

    // Getter và Setter
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
