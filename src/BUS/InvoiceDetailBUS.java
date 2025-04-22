package BUS;
import DTO.Invoice;
import DTO.InvoiceDetail;
import DAO.InvoiceDAO;

import java.util.List;
import java.util.Date;
import DAO.InvoiceDetailDAO;

public class InvoiceDetailBUS {
    private DAO.InvoiceDetailDAO s ;
    public InvoiceDetailBUS(){
        s = new InvoiceDetailDAO();
    }
    public List<Object[]> getAllInvoices(int ID) {
      

        return s.getFullDetailsByInvoiceId(ID);
    }
}
