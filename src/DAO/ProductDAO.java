package DAO;

import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public List<Product> getAllProduct()
    {
        List<Product> pl = new ArrayList<>();
        String sql ="select * from product";
        try{
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                pl.add(new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("category_id"),
                    rs.getInt("material_id"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("brand_id"),
                    rs.getInt("gender")
                ));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return pl;
    }
    public Product getProductFromId(int id)
    {
        String sql ="select * from product where product_id = ?";
        Product product = null;
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {   
               product =new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getInt("category_id"),
                rs.getInt("material_id"),
                rs.getString("description"),
                rs.getBigDecimal("price"),
                rs.getInt("brand_id"),
                rs.getInt("gender")
            );
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return product;
    }
    public Product getLastProduct()
    {
        String sql ="select * from product order by product_id desc limit 1";
        Product product = new Product();
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                product = new Product(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getInt("category_id"),
                    rs.getInt("material_id"),
                    rs.getString("description"),
                    rs.getBigDecimal("price"),
                    rs.getInt("brand_id"),
                    rs.getInt("gender")

                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public boolean removeProduct(int id)
    {
        String sql = "delete from product where product_id = ?;";
        String sql1 = "alter table product auto_increment =?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);

            if(stm.executeUpdate()<=0)
            {
                return false;
            }

            PreparedStatement stm1 = conn.prepareStatement(sql1);
            stm1.setInt(1, getNextProductId());
            if(stm1.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addProduct(Product p)
    {
        String sql = "insert into product (product_name,category_id,material_id,description,price,brand_id,gender) values(?,?,?,?,?,?,?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, p.getProductName());
            stm.setInt(2, p.getCategoryId());
            stm.setInt(3, p.getMaterialId());
            stm.setString(4, p.getDescription());
            stm.setBigDecimal(5, p.getPrice());
            stm.setInt(6, p.getBrandId());
            stm.setInt(7, p.getGender());
            if(stm.executeUpdate()>0)
            {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public int getNextProductId()
    {
        String sql ="SELECT IFNULL(MAX(product_id), 0) + 1 AS next_id FROM product";
        int nextid =0;
        try {
            Connection conn = DatabaseConnection.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next())
            {
                nextid = rs.getInt("next_id");
            }
            
        } catch (SQLException  e) {
            e.printStackTrace();
        }
        return nextid;
    }
    public boolean updateProduct(Product product)
    {
        String sql="update product set product_name =?,category_id=?,material_id=?,description=?,price=?,brand_id=?,gender=? where product_id =?";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, product.getProductName());
            stm.setInt(2, product.getCategoryId());
            stm.setInt(3, product.getMaterialId());
            stm.setString(4, product.getDescription());
            stm.setBigDecimal(5, product.getPrice());
            stm.setInt(6, product.getBrandId());
            stm.setInt(7, product.getGender());
            stm.setInt(8, product.getProductId());
            if (stm.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public List<Product> filterProduct(Category cat,Material mat,Brand bra,Gender gen,String keyword)
    {
        String sql ="select * from product "+
                    "where (? is null or category_id =?) "+
                    "and (? is null or material_id = ?) "+
                    "and (? is null or brand_id = ?) "+
                    "and (? is null or gender = ?) "+
                    "and (lower(product_name) like (?))";
        List<Product> pl = new ArrayList<>();
        try{
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            if(cat!=null)
            {
                stm.setInt(1,cat.getCategoryId());
                stm.setInt(2,cat.getCategoryId());
            }
            else 
            {
                stm.setNull(1,Types.INTEGER);
                stm.setNull(2,Types.INTEGER);
            }
            if(mat!=null)
            {
                stm.setInt(3,mat.getMaterialId());
                stm.setInt(4,mat.getMaterialId());
            }
            else
            {
                stm.setNull(3,Types.INTEGER);
                stm.setNull(4,Types.INTEGER);
            }

            if(bra!=null)
            {
                stm.setInt(5,bra.getBrandId());
                stm.setInt(6,bra.getBrandId());
            }
            else 
            {
                stm.setNull(5,Types.INTEGER);
                stm.setNull(6,Types.INTEGER);
            }

            if(gen!=null)
            {
                stm.setInt(7,gen.getGenderId());
                stm.setInt(8,gen.getGenderId());
            }
            else{
                stm.setNull(7,Types.INTEGER);
                stm.setNull(8,Types.INTEGER);
            }
            stm.setString(9,"%"+keyword+"%");
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                pl.add(new Product(rs.getInt("product_id"),
                                    rs.getString("product_name"),
                                    rs.getInt("category_id"),
                                    rs.getInt("material_id"),
                                    rs.getString("description"),
                                    rs.getBigDecimal("price"),
                                    rs.getInt("brand_id"),
                                    rs.getInt("gender")));
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return pl;
    }

}
