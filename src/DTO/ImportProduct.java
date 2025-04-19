package DTO;
import java.math.BigDecimal;
import java.sql.Date;

public class ImportProduct {
    private int importProductId;
    private int employeeId;
    private BigDecimal totalAmount;
    private Date createdDate;
    private int supplierId;
    private int paymentMethod;

    // Constructor mặc định
    public ImportProduct() {}

    // Constructor sao chép
    public ImportProduct(ImportProduct d) {
            this.importProductId = d.importProductId;
            this.employeeId = d.employeeId;
            this.totalAmount = d.totalAmount;
            this.createdDate = d.createdDate;
            this.supplierId = d.supplierId;
            this.paymentMethod = d.paymentMethod;
        
    }
    public ImportProduct(int importProductId, int employeeId, BigDecimal totalAmount,
    Date createdDate, int supplierId, int paymentMethod) {
this.importProductId = importProductId;
this.employeeId = employeeId;
this.totalAmount = totalAmount;
this.createdDate = createdDate;
this.supplierId = supplierId;
this.paymentMethod = paymentMethod;
}

    // Getter và Setter
    public int getImportProductId() {
        return importProductId;
    }

    public void setImportProductId(int importProductId) {
        this.importProductId = importProductId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

