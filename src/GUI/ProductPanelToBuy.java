package GUI;

import BUS.ProductVariantBUS;
import DTO.Product;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class ProductPanelToBuy extends JPanel{
    private Product p;
    private JLabel lblpname,lblimage,lblprice;
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private int userid;
    public ProductPanelToBuy(Product p,int userid)
    {
        this.p=p;
        this.userid=userid;
        init();
    }
    private void init()
    {
        
        setPreferredSize(new Dimension(200,230));
        setLayout(new BorderLayout());
        setBackground(Color.white);
        setOpaque(true);

        JPanel pnlinfo  = new JPanel(new GridLayout(0,1,0,0));
        add(pnlinfo,BorderLayout.SOUTH);

        lblpname = new JLabel(p.getProductName());
        lblpname.setFont(new Font("Arial",Font.CENTER_BASELINE,14));
        lblpname.setBorder(new EmptyBorder(5,10,5,10));
        pnlinfo.add(lblpname);

        lblprice = new JLabel(Theme.df.format(p.getPrice())+ "đ");
        lblprice.setFont(new Font("Arial",Font.CENTER_BASELINE,12));
        lblprice.setBorder(new EmptyBorder(0,10,5,10));
        pnlinfo.add(lblprice);

        ImageIcon im = new ImageIcon(productvariantbus.getAvatarFromPId(p.getProductId()));
        im.setImage(im.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        lblimage = new JLabel(im);
        lblimage.setBorder(new EmptyBorder(0,0,0,0));
        add(lblimage,BorderLayout.CENTER);
        addEvent();
    }   
    public void addEvent()
    {
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new BuyProductVariant(SwingUtilities.getWindowAncestor(ProductPanelToBuy.this), p,userid);
            }
        });
    }
}
