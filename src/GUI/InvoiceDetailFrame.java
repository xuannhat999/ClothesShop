package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
//import javax.swing.text.Document;

import BUS.InvoiceDetailBUS;
import DAO.InvoiceDetailDAO;
import DAO.UserDAO;
import DTO.User;
import DAO.InvoiceDAO;

import java.util.Date;
import java.util.List;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
public class InvoiceDetailFrame extends JFrame {
    // private static final String PageSize = null;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblCustomerName, lblCustomerAddress, lblDate, lblTotal,lbltransfer;
    private InvoiceDetailBUS s = new InvoiceDetailBUS();
    private int ID,user_id;

    public InvoiceDetailFrame(int invoiceId,int User_id) {
        this.ID = invoiceId;
        this.user_id = User_id;
        setTitle("Chi tiết hóa đơn #" + invoiceId);
        setSize(600, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        
        

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        JLabel lblTitle = new JLabel("HÓA ĐƠN", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Serif", Font.BOLD, 28));
        lblTitle.setForeground(new Color(0, 102, 102));
        topPanel.add(lblTitle, BorderLayout.NORTH);

        lblDate = new JLabel("Ngày lập: 20/07/2030");
        lblDate.setFont(new Font("SansSerif", Font.PLAIN, 14));
        topPanel.add(lblDate, BorderLayout.SOUTH);

        

        // Customer + Seller info
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserFromId(user_id);



        JPanel infoPanel = new JPanel(new GridLayout(1, 2, 40, 10));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 1, 20));

        JPanel customerPanel = new JPanel(new GridLayout(3, 1));
        customerPanel.add(new JLabel("Hóa đơn cho:"));
        lblCustomerName = new JLabel("Trần Hưng");
        lblCustomerAddress = new JLabel("123 Đường ABC, Thành phố DEF");
        lblCustomerName.setText(user.getFullName());
        lblCustomerAddress.setText(user.getAddress());          
        customerPanel.add(lblCustomerName);
        customerPanel.add(lblCustomerAddress);

        JPanel sellerPanel = new JPanel(new GridLayout(4, 1));
        sellerPanel.add(new JLabel("Công Ty:"));
        sellerPanel.add(new JLabel("CLOTHESSHOP"));
        sellerPanel.add(new JLabel("CLOTHESSHOP@gmail.com"));
        sellerPanel.add(new JLabel(""));

        infoPanel.add(customerPanel);
        infoPanel.add(sellerPanel);
        topPanel.add(infoPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Table
        String[] columns = {"Sản phẩm", "Màu", "Size", "Số Lượng","Giá"};;

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        
        // table.setShowGrid(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(1, 1, 0, 0));
        add(scrollPane, BorderLayout.CENTER);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        scrollPane.getViewport().setBackground(Color.WHITE);
        
        // Total
        JPanel bottomPanel = new JPanel(new BorderLayout());
        lblTotal = new JLabel("Tổng cộng: ", SwingConstants.RIGHT);
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 16));
        lblTotal.setForeground(new Color(0, 102, 102));
        lblTotal.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        bottomPanel.add(lblTotal, BorderLayout.EAST);
        JPanel infoPanell = new JPanel(new GridLayout(2, 1));
        infoPanell.setBackground(Color.WHITE);

        JTextArea paymentInfo = new JTextArea("Thông tin thanh toán:\nNgân hàng VB\nTên tài khoản: Công ty XNK Thanh Hà\nSố tài khoản: 123-456-7890\nHóa đơn từ ngày: ");
        paymentInfo.setEditable(false);
        paymentInfo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        paymentInfo.setBackground(Color.WHITE);

        JTextArea contactInfo = new JTextArea("Thông tin liên hệ:\nxinchao@trangwebhay.vn\n123 Đường ABC, Thành phố DEF\n+84 912 345 678");
        contactInfo.setEditable(false);
        contactInfo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        contactInfo.setBackground(Color.WHITE);

        infoPanell.add(paymentInfo);
        infoPanell.add(contactInfo);

        // Gắn vào footerPanel
        bottomPanel.add(infoPanell, BorderLayout.WEST);
        //bottomPanel.add(totalPanel, BorderLayout.EAST);

        //add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(paymentInfo, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);   
        loadDataTable();
        //setVisible(true);

        topPanel.setBackground(Color.WHITE);
        infoPanel.setBackground(Color.WHITE);
        customerPanel.setBackground(Color.WHITE);
        sellerPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.WHITE);
        //footerPanel.setBackground(Color.WHITE);
        lblTotal.setBackground(Color.WHITE);
        infoPanel.setBackground(Color.WHITE);
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        scrollPane.getViewport().setBackground(Color.WHITE);
        setBackground(Color.WHITE);
        JTableHeader header = table.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));


        JButton btnExportPDF = new JButton("Xuất PDF");
btnExportPDF.setFont(new Font("SansSerif", Font.BOLD, 14));
btnExportPDF.setForeground(Color.WHITE);
btnExportPDF.setBackground(new Color(0, 102, 102));
btnExportPDF.setFocusPainted(false);
btnExportPDF.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

// Xử lý khi bấm nút
btnExportPDF.addActionListener(e -> {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Lưu hóa đơn dưới dạng PDF");
    fileChooser.setSelectedFile(new File("HoaDon_" + ID + ".pdf"));

    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        exportToPDF(fileToSave.getAbsolutePath());
    }
});

// Tạo panel chứa nút, thêm vào cuối bottomPanel
JPanel exportPanel = new JPanel();
exportPanel.setBackground(Color.WHITE);
exportPanel.add(btnExportPDF);
bottomPanel.add(exportPanel, BorderLayout.CENTER); // Đặt ở giữa panel dưới
    }

    public void loadDataTable(){
        double totalAmount = 0;
        List<Object[]> details = s.getAllInvoices(ID);
        for (Object[] row : details) {
        // double lineTotal = details.getUnitPrice() * d.getQuantity();
        // totalAmount += lineTotal;
        int quantity = Integer.parseInt(row[3].toString());
        double unitPrice = Double.parseDouble(row[4].toString());

        double lineTotal = quantity * unitPrice;
        totalAmount += lineTotal;
        model.addRow(new Object[]{
            row[0], // Tên sản phẩm
            row[1], // Màu
            row[2], // Size
            quantity,
            unitPrice,
            lineTotal
        });
        DAO.InvoiceDAO dao = new DAO.InvoiceDAO();
        Date createDate = dao.getInvoiceDateById(ID);
        if (createDate != null) {
        lblDate.setText("Ngày lập: " + createDate.toString());
}

    }

    lblTotal.setText("Tổng cộng: " + String.format("%.0f", totalAmount) + " VND");
}


public void exportToPDF(String filePath) {
    try {
        Document document = new Document(PageSize.A4.rotate(), 36, 36, 36, 36);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // Chụp lại nội dung Frame thành ảnh
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        this.paint(g2); // hoặc paintAll(g2)
        g2.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        Image img = Image.getInstance(baos.toByteArray());

        // Scale ảnh cho vừa khổ ngang A4
        img.scaleToFit(PageSize.A4.getHeight() - 72, PageSize.A4.getWidth() - 72); // khổ ngang
        img.setAlignment(Image.ALIGN_CENTER);
        document.add(img);

        document.close();

        JOptionPane.showMessageDialog(this, "Xuất PDF thành công:\n" + filePath);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi xuất PDF:\n" + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}


}

