package DTO;

public class Supplier {
    private int suppllierId;
    private String supplierName;
    private String phone;
    private String email;
    private String address;

    public Supplier(){}
    public Supplier(int supplierId, String supname, String phone, String email, String address) {
        this.suppllierId = supplierId;
        this.supplierName = supname;
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

    public int getSupplierId() { return suppllierId; }
    public void setSupplierId(int brandId) { this.suppllierId = brandId; }
    public String getSupplierName() { return supplierName; }
    public void setSupplierName(String brandName) { this.supplierName = brandName; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override 
    public String toString()
    {
        return supplierName;
    }
    // Trong lớp Supplier.java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Supplier other = (Supplier) obj;
    return this.suppllierId == other.suppllierId;
}

@Override
public int hashCode() {
    return Integer.hashCode(suppllierId);
}

}
