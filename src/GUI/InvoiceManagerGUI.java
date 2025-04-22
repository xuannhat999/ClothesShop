package GUI;

import DTO.Invoice;
import DTO.InvoiceDetail;
import BUS.InvoiceBUS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import com.toedter.calendar.JDateChooser;


public class InvoiceManagerGUI extends MainPanel {
    private JTable tblInvoice;
    private DefaultTableModel mdlInvoice;
    private InvoiceBUS invoiceBUS = new InvoiceBUS();
    private RoundedButton btnApprove,btnCancelInvoice,btnPrintInvoice,btnFilterDate,btnReport;
    private JDateChooser dateFrom = new JDateChooser();
    private JDateChooser dateTo = new JDateChooser();
    private int employeeid; 

    public InvoiceManagerGUI(int employeeid) {
        super();
        this.employeeid = employeeid;
        init();

    }

    private void init() {
        String[] columnNames = {"invoice_id", "User", "NhanVien", "Tổng tiền", "Ngày tạo", "Phương thức thanh toán","Trạng Thái","",""};
        
        // PANEL 1: Giao diện thông tin hóa đơn
        mdlInvoice = new DefaultTableModel(columnNames, 0)
        {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Cột cuối (index = 8) sẽ có kiểu Boolean -> hiện checkbox
                if (columnIndex == 8) return Boolean.class;
                return String.class;
            }
        
            @Override
            public boolean isCellEditable(int row, int column) {
                // Chỉ cho phép sửa cột checkbox
                return column == 8;
            }
        };
        tblInvoice = new JTable(mdlInvoice);
        tblInvoice.getColumnModel().getColumn(7).setMinWidth(0); // cột 7 chứa userID. không cần thiết hiển thị nên ẩn
        tblInvoice.getColumnModel().getColumn(7).setMaxWidth(0);
        tblInvoice.getColumnModel().getColumn(7).setWidth(0);
        JScrollPane sp = new JScrollPane(tblInvoice);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        pnlcon4.add(sp, gbc);

 
        
        // Load dữ liệu hóa đơn
        loadDataTable(invoiceBUS.getAllInvoices());

         btnApprove = new RoundedButton("Duyệt đơn", 20);
         btnCancelInvoice = new RoundedButton("Hủy đơn", 20);
         btnPrintInvoice = new RoundedButton("In hóa đơn", 20);
         btnFilterDate = new RoundedButton("Lọc theo thời gian", 20);
        btnReport = new RoundedButton("Thống kê", 20);

        // Set Size 
        btnApprove.setButtonSize(150, 50);
        btnCancelInvoice.setButtonSize(150, 50);
        btnPrintInvoice.setButtonSize(150, 50);
        btnFilterDate.setButtonSize(150, 50);
        btnReport.setButtonSize(150, 50);

        // Set màu và kích thước nếu muốn
        btnApprove.setBackground(Theme.brown);
        btnCancelInvoice.setBackground(Theme.light1);
        btnPrintInvoice.setBackground(Theme.light1);
        btnFilterDate.setBackground(Theme.light1);
        btnReport.setBackground(Theme.light1);

        // Thêm vào pnlcon1
        GridBagConstraints gbcBtn = new GridBagConstraints();
        gbcBtn.insets = new Insets(5, 10, 5, 10);
        gbcBtn.gridy = 0;
        gbcBtn.weightx = 1;
        gbcBtn.fill = GridBagConstraints.BOTH;

        gbcBtn.gridx = 0; pnlcon1.add(btnApprove, gbcBtn);
        gbcBtn.gridx = 1; pnlcon1.add(btnCancelInvoice, gbcBtn);
        gbcBtn.gridx = 2; pnlcon1.add(btnPrintInvoice, gbcBtn);
        gbcBtn.gridx = 3; pnlcon1.add(btnFilterDate, gbcBtn);
        gbcBtn.gridx = 4; pnlcon1.add(btnReport, gbcBtn);

                // Panel chứa lọc ngày
        JPanel pnlDateFilter = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlDateFilter.add(new JLabel("Từ:"));
        pnlDateFilter.add(dateFrom);
        pnlDateFilter.add(new JLabel("Đến:"));
        pnlDateFilter.add(dateTo);
        dateFrom.setDateFormatString("yyyy-MM-dd");
        dateTo.setDateFormatString("yyyy-MM-dd");
        
        // Thêm panel này vào `pnlcon1`
        GridBagConstraints gbcDate = new GridBagConstraints();
        gbcDate.gridx = 3;
        gbcDate.gridy = 1;
        gbcDate.gridwidth = 2;
        gbcDate.fill = GridBagConstraints.HORIZONTAL;
        pnlcon1.add(pnlDateFilter, gbcDate);

        
        // Thiết lập sự kiện
        addEvent();
    }

    // Hàm tải dữ liệu hóa đơn vào bảng
    private void loadDataTable(List<Invoice> invoices) {
        
        mdlInvoice.setRowCount(0);
        for (Invoice invoice : invoices) {
            mdlInvoice.addRow(new Object[]{
                invoice.getInvoiceId(),
                invoice.getUsername(),
                invoice.getEmployeeId(),
                invoice.getTotalAmount(),
                invoice.getCreateDate(),
                invoice.getPaymentMethodId(),
                invoice.getApproved(),
                 invoice.getUserId()
            });
        }
    }



    private void addEvent() {
        tblInvoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2 && tblInvoice.getSelectedRow() != -1) {
                    int invoiceId = Integer.parseInt(tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 0).toString());
                    int userid= Integer.parseInt(tblInvoice.getValueAt(tblInvoice.getSelectedRow(), 7).toString());
                    new InvoiceDetailFrame(invoiceId,userid).setVisible(true);
                }
            }
        });
        btnApprove.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
            null,
            "Xác nhận duyệt các sản phẩm này?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            // Thực hiện hành động duyệt
            boolean found = false;
            for (int i = 0; i < tblInvoice.getRowCount(); i++) {
                Boolean isChecked = (Boolean) tblInvoice.getValueAt(i, 8); // cột checkbox
                if (isChecked != null && isChecked) {
                    int id = Integer.parseInt(tblInvoice.getValueAt(i, 0).toString());
                    invoiceBUS.approveInvoice(id);
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(this, "Đã duyệt các đơn hàng được chọn!");
                loadDataTable(invoiceBUS.getAllInvoices());
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một đơn hàng để duyệt.");
            }
        }
        else {
            // Không làm gì cả hoặc thoát
            JOptionPane.showMessageDialog(this, "Đã hủy hành động");}
        });
        
        btnCancelInvoice.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
            null,
            "Xác nhận hủy các sản phẩm này?",
            "Xác nhận",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.YES_OPTION) {
            // Thực hiện hành động hủy
            boolean found = false;
            for (int i = 0; i < tblInvoice.getRowCount(); i++) {
                Boolean isChecked = (Boolean) tblInvoice.getValueAt(i, 8); // cột checkbox
                if (isChecked != null && isChecked) {
                    int id = Integer.parseInt(tblInvoice.getValueAt(i, 0).toString());
                    invoiceBUS.cancelInvoice(id);
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(this, "Đã hủy các đơn hàng !");
                loadDataTable(invoiceBUS.getAllInvoices());
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn ít nhất một đơn hàng để hủy.");
            }
        }
        else {
            // Không làm gì cả hoặc thoát
            JOptionPane.showMessageDialog(this, "Đã hủy hành động");}
        
        });
        
        // btnPrintInvoice.addActionListener(e -> {
        //     int row = tblInvoice.getSelectedRow();
        //     if (row != -1) {
        //         int id = Integer.parseInt(tblInvoice.getValueAt(row, 0).toString());
        //         invoiceBUS.printInvoice(id); // Hàm này bạn có thể mở giao diện xuất PDF hoặc in đơn
        //     }
        // });
        
        btnFilterDate.addActionListener(e -> {
            java.util.Date from = dateFrom.getDate();
            java.util.Date to = dateTo.getDate();
        
            if (from == null || to == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và kết thúc.");
                return;
            }
        
            if (from.after(to)) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn hoặc bằng ngày kết thúc.");
                return;
            }
        
            loadDataTable(invoiceBUS.getInvoicesByDateRange(from, to));
        });
        
    //     btnReport.addActionListener(e -> {
    //         double revenue = invoiceBUS.getTotalRevenue();
    //         JOptionPane.showMessageDialog(this, "Tổng doanh thu: " + revenue + " VND");
    //     });
        
    // }

    
}

}
