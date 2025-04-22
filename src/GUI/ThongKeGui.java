package GUI;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DAO.ThongKeDAO;

import java.awt.*;
import java.util.List;

public class ThongKeGui extends JFrame {
    private JTable tblDoanhThu, tblSanPham;
    private DefaultTableModel modelDoanhThu, modelSanPham;

    public ThongKeGui() {
        setTitle("Thống kê bán hàng");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Panel thống kê doanh thu theo tháng
        JPanel panelDoanhThu = new JPanel(new BorderLayout());
        modelDoanhThu = new DefaultTableModel(new String[]{"Tháng", "Doanh thu"}, 0);
        tblDoanhThu = new JTable(modelDoanhThu);
        panelDoanhThu.add(new JScrollPane(tblDoanhThu), BorderLayout.CENTER);
        tabbedPane.addTab("Doanh thu theo tháng", panelDoanhThu);

        // Panel thống kê sản phẩm bán chạy
        JPanel panelSanPham = new JPanel(new BorderLayout());
        modelSanPham = new DefaultTableModel(new String[]{"Tên sản phẩm", "Số lượng bán"}, 0);
        tblSanPham = new JTable(modelSanPham);
        panelSanPham.add(new JScrollPane(tblSanPham), BorderLayout.CENTER);
        tabbedPane.addTab("Sản phẩm bán chạy", panelSanPham);

        add(tabbedPane);

        loadData();
    }

    private void loadData() {
        ThongKeDAO dao = new ThongKeDAO();

        // Doanh thu theo tháng
        List<Object[]> doanhThuData = dao.getDoanhThuTheoThang();
        for (Object[] row : doanhThuData) {
            modelDoanhThu.addRow(row);
        }

        // Sản phẩm bán chạy
        List<Object[]> spBanChayData = dao.getSanPhamBanChay();
        for (Object[] row : spBanChayData) {
            modelSanPham.addRow(row);
        }
    }
    // public static void main(String[] args) {
    //     new ThongKeGui().setVisible(true);
    // }
}

