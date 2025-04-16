package BUS;

import DAO.CartDAO;
import DTO.Cart;
import DTO.ProductVariant;

import java.math.BigDecimal;
import java.util.List;

import javax.naming.BinaryRefAddr;

public class CartBUS {
    private CartDAO cartdao = new CartDAO();
    private ProductVariantBUS pvb = new ProductVariantBUS();
    public CartBUS()
    {}
    public List<Cart> getAllCartFromUserId(int userid)
    {
        return cartdao.getProductVariantInUserCart(userid);
    }
    public boolean addProductToCart(ProductVariant pv ,int userid,int quan)
    {
        Cart cart = new Cart(userid,pv.getProductVariantId(),quan);
        return cartdao.addProductVariantToUserCart(cart);
    }
    public boolean removeProductFromCart(int userid,ProductVariant pv)
    {
        return cartdao.removeProductFromCart(userid, pv);
    }
    public boolean updateCartQuantity(int userid,ProductVariant pv,int newquan)
    {
        return cartdao.updateCart(userid, pv, newquan);
    }
    public Cart getCartFromProductVariantUserId(ProductVariant pv , int userid)
    {
        return cartdao.getCartFromProductVariantUserId(pv.getProductVariantId(), userid);
    }
    public BigDecimal getTotalFromCartList(List<Cart> cl)
    {
        BigDecimal total = BigDecimal.ZERO;
        for(Cart i : cl)
        {
            total=total.add(pvb.getProductFromProductVariantId(i.getProductVariantId()).getPrice().multiply(BigDecimal.valueOf(i.getQuantity())));
        }
        return total;
    }

}
