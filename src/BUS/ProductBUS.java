package BUS;

import DAO.BrandDAO;
import DAO.CategoryDAO;
import DAO.GenderDAO;
import DAO.MaterialDAO;
import DAO.ProductDAO;
import DTO.Brand;
import DTO.Category;
import DTO.Gender;
import DTO.Material;
import DTO.Product;
import java.util.List;

public class ProductBUS {
    ProductDAO productdao = new ProductDAO();
    CategoryDAO categorydao = new CategoryDAO();
    BrandDAO brandao = new BrandDAO();
    MaterialDAO materialdao = new MaterialDAO();
    GenderDAO genderdao = new GenderDAO();
    public ProductBUS() {
    }
    public List<Product> getAllProduct()
    {
        return productdao.getAllProduct();
    }
    public List<Category> getAllCategory()
    {
        return categorydao.getAllCategory();
    }
    public List<Material> getAllMaterial()
    {
        return materialdao.getAllMaterial();
    }
    public List<Brand> getAllBrand()
    {
        return brandao.getAllBrand();
    }
    public List<Gender> getAllGender()
    {
        return genderdao.getAllGender();
    }
    public Product getProductFromId(int id)
    {
        return productdao.getProductFromId(id);
    }
    public Category getCategoryFromId(int id)
    {
        return categorydao.getCategoryFromId(id);
    }
    public Material getMaterialFromId(int id)
    {
        return materialdao.getMaterialFromId(id);
    }
    public Brand getBrandFromId(int id)
    {
        return brandao.getBrandFromId(id);
    }
    public Gender getGenderFromId(int id)
    {
        return genderdao.getGenderFromId(id);
    }

    public boolean removeProduct(int id)
    {
        if(productdao.getProductFromId(id) == null)
        {
            System.out.println("Product not found");
            return false;
        }
        return productdao.removeProduct(id);
    }

    public boolean addProduct(Product p)
    {
        if(productdao.getProductFromId(p.getProductId()) != null)
        {
            System.out.println("Product already exists");
            return false;
        }
        if(p.getProductName().equals("") || p.getProductName() == null)
        {
            System.out.println("Product name is empty");
            return false;
        }
        if(p.getPrice() == null)
        {
            System.out.print("Price is empty");
            return false;
        }
        if(p.getCategoryId() <0)
        {
            return false;
        }
        return productdao.addProduct(p);
    }

    public int getNextProductId()
    {
        return productdao.getNextProductId();
    }

    public boolean updateProduct(Product p)
    {
        if(productdao.getProductFromId(p.getProductId()) == null)
        {
            System.out.println("Product not found");
            return false;
        }
        if(p.getProductName().equals("") || p.getProductName() == null)
        {
            System.out.println("Product name is empty");
            return false;
        }
        if(p.getPrice() == null)
        {
            System.out.print("Price is empty");
            return false;
        }
        return productdao.updateProduct(p);
    }
    public List<Product> searchProduct(Category cat,Material mat,Brand bra,Gender gen,String keyword)
    {

        return productdao.filterProduct(cat, mat, bra, gen,keyword);
    }


}
