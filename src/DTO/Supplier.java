package DTO;

public class Supplier {
    private int suppllierId;
    private String supplierName;
    private String phone;
    private String email;
    private String address;

    public Supplier(){}
    public Supplier(int supplierId, String brandName, String phone, String email, String address) {
        this.suppllierId = supplierId;
        this.supplierName = brandName;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Supplier(Supplier d) {
        this.suppllierId = d.suppllierId;
        this.supplierName = d.supplierName;
        this.phone = d.phone;
        this.email = d.email;
        this.address = d.address;
    }

    public int getBrandId() { return suppllierId; }
    public void setBrandId(int brandId) { this.suppllierId = brandId; }
    public String getBrandName() { return supplierName; }
    public void setBrandName(String brandName) { this.supplierName = brandName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
