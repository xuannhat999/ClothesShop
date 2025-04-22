package DTO;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class InvoiceDetail {
    private int invoiceId;  // Mã hóa đơn
    private int productVariantId;  // Mã sản phẩm
    private int quantity;  // Số lượng
    private BigDecimal amount;  // Số tiền/sp

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
