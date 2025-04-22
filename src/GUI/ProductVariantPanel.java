package GUI;

import BUS.CartBUS;
import BUS.ProductVariantBUS;
import DAO.ColorDAO;
import DAO.ProductColorDAO;
import DTO.Product;
import DTO.ProductVariant;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProductVariantPanel extends JPanel{
    private ProductVariant pv;
    private int buyquan;
    private JPanel pnlinfo,pnlbtn,pnlimage;
    private JLabel lblpname,lblpcolor,lblpsize,lblprice,lblimage;
    private ProductVariantBUS productVariantbus= new ProductVariantBUS();
    private ColorDAO colordao = new ColorDAO();
    private ProductColorDAO productcolordao = new ProductColorDAO();
    private RoundedButton btnremove;
    private QuantityPanel pnlquan;
    private int userid;
    private CartBUS cartbus = new CartBUS();
    public ProductVariantPanel(ProductVariant pv,int buyquan,int userid)
    {
        this.pv=pv;
        this.buyquan=buyquan;
        this.userid=userid;
        init();
    }

    private void init()
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1100,100));
        setBorder(BorderFactory.createLineBorder(Theme.brown,1));
        setBackground(Theme.light1);
        setOpaque(true);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.insets = new Insets(0,0,0,0);

        pnlimage = new JPanel(new BorderLayout());
        pnlimage.setPreferredSize(new Dimension(100,100));
        pnlimage.setMinimumSize(pnlimage.getPreferredSize());
        pnlimage.setBorder(BorderFactory.createLineBorder(Theme.brown,1));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0;
        gbc.weighty=0;
        add(pnlimage,gbc);

        ImageIcon pimage = new ImageIcon(productVariantbus.getProductColorFromPCId(pv.getProductColorId()).getURL());
        pimage.setImage(pimage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        lblimage = new JLabel(pimage);
        pnlimage.add(lblimage,BorderLayout.CENTER);

        pnlinfo = new JPanel(new GridBagLayout());
        pnlinfo.setPreferredSize(new Dimension(900,100));
        pnlinfo.setOpaque(false);
        pnlinfo.setBorder(new EmptyBorder(0,20,0,0));
        gbc.gridx=1;
        add(pnlinfo,gbc);

        pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT,20,20));
        pnlbtn.setOpaque(false);
        gbc.weightx=1;
        gbc.gridx=2;
        add(pnlbtn,gbc);

        // COMPONENT
            // PANEL IMAGE 

            // PANEL INFO
            lblpname = new JLabel(getProductFromProductVariant().getProductName());
            lblpname.setFont(Theme.infofont1);
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.weightx=1;
            gbc.weighty=1;
            gbc.gridwidth=2;
            pnlinfo.add(lblpname,gbc);

            lblpcolor = new JLabel("Màu: "+colordao.getColorFromId(productcolordao.getProductColorFromId(pv.getProductColorId()).getColorId()).getColorName());
            lblpcolor.setFont(Theme.infofont2);
            lblpcolor.setForeground(Color.darkGray);
            gbc.gridy=1;
            gbc.gridx=0;
            gbc.gridwidth=1;
            pnlinfo.add(lblpcolor,gbc);

            lblpsize = new JLabel("Size: "+pv.getSize());
            lblpsize.setFont(Theme.infofont2);
            lblpsize.setForeground(Color.darkGray);
            gbc.gridx=1;
            pnlinfo.add(lblpsize,gbc);

            lblprice = new JLabel(Theme.df.format(getProductFromProductVariant().getPrice())+" đ");
            lblprice.setFont(Theme.infofont1);
            gbc.gridx=0;
            gbc.gridy=2;
            gbc.gridwidth=2;
            pnlinfo.add(lblprice,gbc);

        // PANEL BUTTON 
            pnlquan = new QuantityPanel(30);
            pnlquan.setQuantity(buyquan);
            pnlbtn.add(pnlquan);

            btnremove = new RoundedButton("", 20);
            btnremove.setButtonSize(30,30);
            btnremove.setBackground(Theme.redpastel);

            ImageIcon removeicon = new ImageIcon("icon/icons8-remove-30.png");
            removeicon.setImage(removeicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
            btnremove.setIcon(removeicon);
            pnlbtn.add(btnremove);

            addEvent();
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnremove)
                {
                    Container parent = getParent();
                    parent.remove(ProductVariantPanel.this);
                    parent.revalidate();
                    parent.repaint();
                    if(cartbus.removeProductFromCart(userid, pv))
                    {
                        JOptionPane.showMessageDialog(parent,"Đã xóa sản phẩm khỏi giỏ hàng","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            
        };
        btnremove.addActionListener(al);

        pnlquan.getQuanTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(()->{
                    updateCartQuantity();
                });
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(()->{
                    updateCartQuantity();
                });
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
    }
    public Product getProductFromProductVariant()
    {
        return productVariantbus.getProductFromProductVariantId(pv.getProductVariantId());
    }
    public int getQuantity()
    {
        return pnlquan.getQuan();
    }
    public RoundedButton getRemoveButton()
    {
        return btnremove;
    }
    public void updateCartQuantity()
    {
        cartbus.updateCartQuantity(userid, pv, getQuantity());
    }
    public QuantityPanel getQuantityPanel()
    {
        return pnlquan;
    }

}
