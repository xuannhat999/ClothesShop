package DAO;

import DTO.ImportProductDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportDetailDAO {

    public ImportDetailDAO(){}
    // 1. Lấy tất cả chi tiết phiếu nhập
    public List<ImportProductDetail> getAllImportDetails() {
        String sql = "SELECT * FROM import_product_detail";
        List<ImportProductDetail> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                list.add(new ImportProductDetail(
                    rs.getInt("import_detail_id"),
                    rs.getInt("import_id"),
                    rs.getInt("product_variant_id"),
                    rs.getInt("quantity"),
                    rs.getBigDecimal("amount")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. Thêm một chi tiết phiếu nhập
    public boolean addImportDetail(ImportProductDetail detail) {
        String sql = "INSERT INTO import_product_detail (import_id, product_variant_id, quantity, amount) " +
                     "VALUES (?, ?, ?, ?)";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, detail.getImportId());
            ps.setInt(2, detail.getProductVariantId());
            ps.setInt(3, detail.getQuantity());
            ps.setBigDecimal(4, detail.getAmount());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 3. Xoá chi tiết theo ID
    public boolean removeImportDetail(int importDetailId) {
        String sql = "DELETE FROM import_product_detail WHERE import_detail_id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, importDetailId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 4. Cập nhật chi tiết phiếu nhập
    public boolean updateImportDetail(ImportProductDetail detail) {
        String sql = "UPDATE import_product_detail SET import_id = ?, product_variant_id = ?, " +
                     "quantity = ?, amount = ? WHERE import_detail_id = ?";

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, detail.getImportId());
            ps.setInt(2, detail.getProductVariantId());
            ps.setInt(3, detail.getQuantity());
            ps.setBigDecimal(4, detail.getAmount());
            ps.setInt(5, detail.getImportDetailId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 5. Lấy danh sách chi tiết theo ID phiếu nhập
    public List<ImportProductDetail> getDetailsByImportId(int importId) {
        String sql = "SELECT * FROM import_product_detail WHERE import_id = ?";
        List<ImportProductDetail> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, importId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ImportProductDetail(
                    rs.getInt("import_detail_id"),
                    rs.getInt("import_id"),
                    rs.getInt("product_variant_id"),
                    rs.getInt("quantity"),
                    rs.getBigDecimal("amount")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
