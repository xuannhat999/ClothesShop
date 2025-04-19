package DTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Invoice {
    private int invoiceId;  // Mã hóa đơn
    private int userId;  // Mã người dùng
    private int employeeId;  // Mã nhân viên
    private BigDecimal totalAmount;  // Tổng số tiền
    private Date createDate;  // Ngày tạo hóa đơn
    private int paymentMethodId;  // Phương thức thanh toán
    //private int bankAccountId;  // Tài khoản ngân hàng
    private List<InvoiceDetail> invoiceDetails;  // Chi tiết hóa đơn
    private String approved; 
    private String username;

    // Getter và Setter
    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getApproved() {
        return approved;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    // public int getBankAccountId() {
    //     return bankAccountId;
    // }

    // public void setBankAccountId(int bankAccountId) {
    //     this.bankAccountId = bankAccountId;
    // }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public String isApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
