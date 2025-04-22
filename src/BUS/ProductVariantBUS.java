package BUS;

import DAO.ProductColorDAO;
import DAO.ProductVariantDAO;
import DTO.Product;
import DTO.ProductColor;
import DTO.ProductVariant;
import java.util.List;

public class ProductVariantBUS {
    ProductVariantDAO productvariantdao = new ProductVariantDAO();
    ProductColorDAO productcolordao = new ProductColorDAO();
    public ProductVariantBUS()
    {}
    public ProductVariant getProductVariantFromPCIdAndSize(int pcid,String size)
    {
        return productvariantdao.getProductVariantFromPCAndSize(pcid, size);
    }
    public boolean checkIsBuyable(ProductVariant pv,int buyquan)
    {   
        if(pv!=null)
        {
            int pvquan =pv.getQuantity();
            if(pvquan>buyquan)
            {
                return true;
            }
        }
        return false;
    }
    public boolean updateProductVariant(ProductVariant pv)
    {
        return productvariantdao.updateProductVariant(pv);
    }
    public Product getProductFromProductVariantId(int pvid)
    {
        return productvariantdao.getProductFromProductVariantId(pvid);
    }
    public ProductVariant getProductVariantFromId(int pvid)
    {
        return productvariantdao.getProductVariantFromId(pvid);
    }
    public List<ProductColor> getProductColorFromPID(int pid)
    {
        return productcolordao.getAllProductColorFromPId(pid);
    }
    public List<ProductVariant> getAllProductVariantFromPCID(int pcid)
    {
        return productvariantdao.getAllProductVariantFromPCId(pcid);
    }
    public ProductColor getProductColorFromPIdColorId(int pid,int colorid)
    {
        return productcolordao.getProductColorFromPIdAndColorId(pid, colorid);
    }
    public boolean addProductColor(ProductColor pc)
    {
        if(getProductColorFromPIdColorId(pc.getProductId(), pc.getColorId())!=null)
        {
            System.out.print("Product Color alredy existed");
            return false;
        }
        return productcolordao.addProductColor(pc);
    }  
    
    public boolean updateProductColor(ProductColor pc)
    {
        if(getProductColorFromPIdColorId(pc.getProductId(), pc.getColorId())==null)
        {
            System.out.print("Product Color not found");
            return false;
        }
        return productcolordao.updateProductColor(pc);
    }
    public boolean addProductVariantFromPC(ProductColor pc)
    {
        if(productvariantdao.getAllProductVariantFromPCId(pc.getProductColorId()).isEmpty())
        {
            return productvariantdao.addProductVariant(pc);
            
        }
        return false;
    }
    public ProductColor getProductColorFromPCId(int pcid)
    {
        return productcolordao.getProductColorFromId(pcid);
    }
    public String getAvatarFromPId(int product_id)
    {
        return productcolordao.getAvatarProductFromProductId(product_id);
    }
    public boolean removeProductVariant(int pvid)
    {
        return productvariantdao.removeProductVariant(pvid);
    }
    public boolean removeProductColor(int pcid)
    {
        return productcolordao.removeProductColor(pcid);
    }



}
