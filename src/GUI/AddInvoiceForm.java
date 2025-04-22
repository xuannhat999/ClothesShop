package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.InvoiceDAO;
import DAO.InvoiceDetailDAO;
import DTO.Invoice;
import DTO.InvoiceDetail;
import BUS.InvoiceBUS;
import GUI.InvoiceManagerGUI;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.Date;

public class AddInvoiceForm extends JFrame {
    private JTextField txtInvoiceId, txtIDkhach, txtTotal;
    private JLabel lblDate;
    private JTable table;
    private DefaultTableModel model;
    private int UserID;
    private InvoiceBUS invoiceBUS = new InvoiceBUS();
    private InvoiceManagerGUI parentGUI;
    public AddInvoiceForm(int userID,InvoiceManagerGUI parentGUI) {
        setTitle("Thêm Hóa Đơn");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.UserID = userID;
        this.parentGUI = parentGUI;
        initUI();

    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // JLabel lblInvoiceId = new JLabel("Mã hóa đơn:");
        JLabel lblUserId = new JLabel("Mã Khách hàng:");
        JLabel lblCreatedDate = new JLabel("Ngày tạo:");
        JLabel lblTotal = new JLabel("Tổng tiền:");

        txtInvoiceId = new JTextField("HD" + System.currentTimeMillis());
        txtInvoiceId.setEditable(false);

        txtIDkhach = new JTextField();
        lblDate = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        txtTotal = new JTextField("0");
        txtTotal.setEditable(false);

        // Bảng chi tiết hóa đơn
        model = new DefaultTableModel(new Object[]{"Mã sản phẩm", "Số lượng", "Đơn giá"}, 0);

        // tính tổng tiền tự động và điền giá tự động
        model.addTableModelListener(e -> {
            int row = e.getFirstRow();
            int col = e.getColumn();

    // Chỉ xử lý khi người dùng sửa cột "Mã sản phẩm"
    if (col == 0) {
        String variantId = model.getValueAt(row, 0).toString();

        // Gọi DAO để lấy đơn giá
        double price =InvoiceDetailDAO.getUnitPriceByVariantId(variantId);
        model.setValueAt(price, row, 2);  // cập nhật vào cột đơn giá
        }

        // Sau đó tính lại thành tiền và tổng tiền
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                double unitPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
                double lineTotal = quantity * unitPrice;
            // model.setValueAt(lineTotal, i, 3);
                total += lineTotal;
            } catch (Exception ex) {
            // Có thể chưa nhập đủ dữ liệu
        }
    }
    txtTotal.setText(String.valueOf(total));
        });

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Các nút
        JButton btnAddRow = new JButton("Thêm dòng");
        JButton btnRemoveRow = new JButton("Xóa dòng");
        JButton btnSave = new JButton("Lưu hóa đơn");

        btnAddRow.addActionListener(e -> model.addRow(new Object[]{"", 1, 0.0,}));

        btnRemoveRow.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) model.removeRow(row);
        });

        btnSave.addActionListener(e -> {
            addInvoice();
            
        });

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    // .addComponent(lblInvoiceId)
                    .addComponent(lblUserId)
                    .addComponent(lblCreatedDate)
                    .addComponent(lblTotal))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    // .addComponent(txtInvoiceId)
                    .addComponent(txtIDkhach)
                    .addComponent(lblDate)
                    .addComponent(txtTotal))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                // .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                //     .addComponent(lblInvoiceId)
                //     .addComponent(txtInvoiceId))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUserId)
                    .addComponent(txtIDkhach))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCreatedDate)
                    .addComponent(lblDate))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtTotal))
        );

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnAddRow);
        buttonPanel.add(btnRemoveRow);
        buttonPanel.add(btnSave);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // lấy thông tin hóa đơn
        // String invoiceId = txtInvoiceId.getText().trim();
        // String Id_khach = txtUserId.getText().trim();
        // String createdDate = lblDate.getText();  // đang là dạng "dd/MM/yyyy"
        // double totalAmount = Double.parseDouble(txtTotal.getText().trim());
        // InvoiceDAO s = new InvoiceDAO();
        

    }  

    public void addInvoice(){
        try {
            // Lấy dữ liệu
            int userKhach = Integer.parseInt(txtIDkhach.getText());

            // Parse ngày từ JLabel (dd/MM/yyyy) → java.sql.Date
            String createdDateStr = lblDate.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(createdDateStr, formatter);
            Date sqlDate = Date.valueOf(localDate);

            // Tính tổng tiền từ bảng
            double totalAmount = Double.parseDouble(txtTotal.getText().trim());
            BigDecimal stotalAmount = BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP);
            // Tạo đối tượng hóa đơn
            Invoice invoice = new Invoice(); 
            invoice.setApproved("pending");
            invoice.setCreateDate(sqlDate);
            invoice.setEmployeeId(this.UserID);
            invoice.setUserId(userKhach);
            invoice.setTotalAmount(stotalAmount);
            invoice.setPaymentMethodId(1);
            
            // Thêm hóa đơn → lấy ra ID
            int invoiceId = InvoiceDAO.addInvoice(invoice);
            if (invoiceId == -1) {
                JOptionPane.showMessageDialog(null, "Thêm hóa đơn thất bại!");
                return;
            }

            // Duyệt qua bảng để thêm các dòng chi tiết hóa đơn
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                int variantId = Integer.parseInt(model.getValueAt(i, 0).toString());
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                Double unitPrice = Double.parseDouble(model.getValueAt(i, 2).toString());
                BigDecimal Pricesp = BigDecimal.valueOf(unitPrice).setScale(2, RoundingMode.HALF_UP);
                InvoiceDetail detail = new InvoiceDetail();
                detail.setInvoiceId(invoiceId);
                detail.setAmount(Pricesp);
                detail.setProductVariantId(variantId);
                detail.setQuantity(quantity);
                InvoiceDetailDAO.insertInvoiceDetail(detail);
            }

            JOptionPane.showMessageDialog(null, "Thêm hóa đơn thành công!");
            parentGUI.loadData(); // Load lại dữ liệu
            dispose();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi: " + ex.getMessage());
        }
    }
    

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> new AddInvoiceForm(21).setVisible(true));
    // }
}
