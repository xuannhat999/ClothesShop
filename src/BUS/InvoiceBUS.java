package BUS;

import DTO.Invoice;
import DTO.InvoiceDetail;


import java.util.List;
import java.util.Date;

import DAO.InvoiceDAO;

public class InvoiceBUS {
    private InvoiceDAO s ;
    public InvoiceBUS(){
        s = new InvoiceDAO();
    }
    // Phương thức lấy tất cả các hóa đơn
    public List<Invoice> getAllInvoices() {
        // Giả sử lấy từ CSDL hoặc danh sách giả

        return s.getAllInvoices();
    }

    // Phương thức thêm hóa đơn
    public void addInvoice(Invoice invoice) {
        // Thực hiện thêm hóa đơn vào CSDL
    }

    // Phương thức cập nhật hóa đơn
    public void updateInvoice(Invoice invoice) {
        // Cập nhật hóa đơn trong CSDL
    }

    // Phương thức xóa hóa đơn
    public void removeInvoice(int invoiceId) {
        // Xóa hóa đơn trong CSDL
    }

    public boolean approveInvoice(int invoiceId) {
        if(s.approveInvoice(invoiceId)){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean cancelInvoice(int invoiceId) {
        if(s.cancelInvoice(invoiceId)){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Invoice> getInvoicesByDateRange(Date from, Date to) {
        return s.getInvoicesByDateRange(from,to);
    }
    

    public double getTotalRevenue(Date from, Date to) {
        return s.getTotalRevenue(from, to);
    }
}
