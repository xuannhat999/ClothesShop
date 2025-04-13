package BUS;

import DAO.ProductVariantDAO;
import DTO.ProductVariant;

public class ProductVariantBUS {
    ProductVariantDAO productvariantdao = new ProductVariantDAO();
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


}
