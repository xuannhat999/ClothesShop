package GUI;

import BUS.CartBUS;
import BUS.ProductBUS;
import BUS.ProductVariantBUS;
import DAO.ProductColorDAO;
import DTO.Cart;
import DTO.Product;
import DTO.ProductColor;
import DTO.ProductVariant;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProductDetailPanel extends JDialog{
    private JLabel lblpname,lbldescription,lblbrand,lblmaterial,lblpquantity;
    private JPanel pnlinfo,pnlimage;
    private Product p;
    private ProductBUS productbus = new ProductBUS();
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private ProductColorDAO productcolordao = new ProductColorDAO();
    private List<ColorCheckBox>colorcheckbox = new ArrayList<>();
    private List<SizeCheckBox> sizecheckbox = new ArrayList<>();
    private QuantityPanel pnlquan;
    private RoundedButton btnorder,btnaddtocart;
    private int userid;
    private CartBUS cartbus = new CartBUS();
    public ProductDetailPanel(Window window,Product p,int userid)
    {
        super(window,ModalityType.APPLICATION_MODAL);
        this.p=p;
        this.userid=userid;
        init();
    }
    private void init()
    {
        setSize(1200,700);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Theme.light1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // PANEL CON
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        lblpname = new JLabel(p.getProductName());
        lblpname.setFont(new Font("Arial",Font.BOLD,30));
        lblpname.setBorder(new EmptyBorder(10,10,50,0));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=2;
        add(lblpname,gbc);

        pnlimage = new JPanel();
        pnlimage.setPreferredSize(new Dimension(300,300));
        pnlimage.setMaximumSize(pnlimage.getPreferredSize());
        pnlimage.setMinimumSize(pnlimage.getPreferredSize());
        pnlimage.setOpaque(true);
        gbc.gridy=1;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        add(pnlimage,gbc);

        pnlinfo = new JPanel(new GridBagLayout());
        pnlinfo.setOpaque(false);
        gbc.gridx=1;
        gbc.weightx=1;
        gbc.weighty=1;
        add(pnlinfo,gbc);


        // COMPONENT


            // PANEL INFO
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill =GridBagConstraints.NONE;
        lblbrand = new JLabel("Thương hiệu: "+productbus.getBrandFromId(p.getBrandId()).getBrandName());
        lblbrand.setFont(Theme.infofont1);
        lblbrand.setBorder(new EmptyBorder(0,0,0,0));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlinfo.add(lblbrand,gbc);

        lblmaterial = new JLabel("Chất liệu: "+productbus.getMaterialFromId(p.getMaterialId()).getMaterialName());
        lblmaterial.setFont(Theme.infofont1);
        gbc.gridy=1;
        pnlinfo.add(lblmaterial,gbc);

        lbldescription = new JLabel("Mô tả: "+p.getDescription());
        lbldescription.setFont(Theme.infofont1);
        gbc.gridy=2;
        pnlinfo.add(lbldescription,gbc);

        JLabel lblcolor = new JLabel("Màu sắc:");
        lblcolor.setFont(Theme.infofont1);
        gbc.gridy=3;
        pnlinfo.add(lblcolor,gbc);
        
                // COLOR CHECKBOX
        JPanel pnlcolorbox = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnlcolorbox.setOpaque(false);
        gbc.gridy=4;
        pnlinfo.add(pnlcolorbox,gbc);

        ButtonGroup colorgroup = new ButtonGroup();
        for(ProductColor i: productcolordao.getAllProductColorFromPId(p.getProductId()))
        {
            ColorCheckBox cbb = new ColorCheckBox(i.getColorId(),20);
            colorcheckbox.add(cbb);
            colorgroup.add(cbb);
            pnlcolorbox.add(cbb);
        }
                // SIZE CHECKBOX
        JLabel lblsize = new JLabel("Size: ");
        lblsize.setBorder(new EmptyBorder(0,0,0,0));
        lblsize.setFont(Theme.infofont1);
        gbc.gridy=5;
        pnlinfo.add(lblsize,gbc);

        JPanel pnlsizebox = new JPanel(new FlowLayout(FlowLayout.LEFT,0,20));
        pnlsizebox.setBorder(new EmptyBorder(0,0,0,0));
        pnlsizebox.setOpaque(false);
        gbc.gridy=6;
        pnlinfo.add(pnlsizebox,gbc);    

        ButtonGroup sizegroup = new ButtonGroup();
        SizeCheckBox sizes = new SizeCheckBox("S",15);
        sizecheckbox.add(sizes);

        SizeCheckBox sizem = new SizeCheckBox("M",15);
        sizecheckbox.add(sizem);

        SizeCheckBox sizel = new SizeCheckBox("L",15);
        sizecheckbox.add(sizel);

        SizeCheckBox sizexl = new SizeCheckBox("XL",15);
        sizecheckbox.add(sizexl);
        
        for(JCheckBox i : sizecheckbox)
        {
            sizegroup.add(i);
            pnlsizebox.add(i);
        }
        
                // PANEL QUANTITY BUY
        JLabel lblquan = new JLabel("Số lượng: ");
        lblquan.setFont(Theme.infofont1);
        gbc.gridy=7;
        pnlinfo.add(lblquan,gbc);


        pnlquan = new QuantityPanel(30);
        pnlquan.setEditable(false);
        gbc.gridy=8;
        pnlinfo.add(pnlquan,gbc);

                // QUANTITY STATUS

            lblpquantity = new JLabel();
            lblpquantity.setFont(Theme.infofont1);
            lblpquantity.setVisible(false);
            gbc.gridy=9;
            pnlinfo.add(lblpquantity,gbc);
        
            // BUTTON BUY
        JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.LEFT,5,5));
        pnlbtn.setOpaque(false);
        gbc.gridy=10;
        pnlinfo.add(pnlbtn,gbc);

        btnaddtocart = new RoundedButton("Thêm vào giỏ", 10);
        btnaddtocart.setButtonSize(200,50);
        btnaddtocart.setBackground(Theme.light1);
        btnaddtocart.setBorderWidth(1);
        btnaddtocart.setBorderColor(Theme.brown);
        btnaddtocart.setEnabled(false);
        pnlbtn.add(btnaddtocart);

        btnorder = new RoundedButton("Mua ngay", 10);
        btnorder.setButtonSize(200, 50);
        btnorder.setBackground(Theme.brown);
        btnorder.setForeground(Color.white);
        btnorder.setEnabled(false);
        pnlbtn.add(btnorder);

        JPanel lblblank = new JPanel();
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridheight=11;
        gbc.weightx=2;
        pnlinfo.add(lblblank,gbc);

        addEvent();

        setVisible(true);
    }
    public int getColorIdFromCheckBox()
    {
        for(ColorCheckBox i : colorcheckbox)
        {
            if(i.isSelected())
            {
                return i.getColorId();
            }
        }
        return -1;
    }
    public String getSizeFromCheckBox()
    {
        for(JCheckBox i: sizecheckbox)
        {
            if(i.isSelected())
            {
                return i.getText();
            }
        }
        return null;
    }
    public void loadQuantityStatus(boolean status)
    {   
        if(status)
            lblpquantity.setText("Tình trạng:  Còn hàng");
        else lblpquantity.setText("Tình trạng:  Hết hàng");
    }
    private void addEvent()
    {
        ItemListener il = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean status = isBuyable();
                if(getColorIdFromCheckBox()!=-1 && getSizeFromCheckBox()!=null)
                {   
                    lblpquantity.setVisible(true);
                    pnlquan.setEditable(status);
                    loadQuantityStatus(status);
                }
            }
            
        };
        for(ColorCheckBox i: colorcheckbox)
        {
            i.addItemListener(il);
        }
        for(SizeCheckBox i : sizecheckbox)
        {
            i.addItemListener(il);
        }
        pnlquan.getQuanTextField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(()->{
                    checkQuanToBuy();
                });

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(()->{
                checkQuanToBuy();
                });
                      
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
            
        });
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnaddtocart)
                {
                    ProductVariant pv = getProductVariantFromGUI();
                    int buyquan = pnlquan.getQuan();
                    Cart cart = cartbus.getCartFromProductVariantUserId(pv, userid);
                    if(cart!=null)
                    {
                        if(cart.getQuantity()+buyquan<pv.getQuantity())
                        {
                            if(cartbus.updateCartQuantity(userid, pv, cart.getQuantity()+buyquan))
                                JOptionPane.showMessageDialog(ProductDetailPanel.this, "Sản phẩm đã có sẵn trong giỏ hàng, đã cập nhật số lượng","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    else 
                    {
                        if(pv.getQuantity()>buyquan)
                        {
                            if(cartbus.addProductToCart(pv, userid, buyquan)){
                                JOptionPane.showMessageDialog(ProductDetailPanel.this, "Thêm vào giỏ hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        }
                        }
                    }
                    
                }
            }
            
        };
        btnaddtocart.addActionListener(al);
    }
    public boolean isBuyable()
    {
        int buyquan = pnlquan.getQuan();
        ProductVariant pv = getProductVariantFromGUI();
        if(pv!=null)
        {
            if(productvariantbus.checkIsBuyable(pv,buyquan))
            {
                return true;
            }
        }
        return false;
    }
    public void checkQuanToBuy()
    {
        if(isBuyable() && pnlquan.getQuan()>0)
        {
            btnaddtocart.setEnabled(true);
            btnorder.setEnabled(true);
        }
        else 
        {
            btnaddtocart.setEnabled(false);
            btnorder.setEnabled(false);
        }
    }
    public ProductVariant getProductVariantFromGUI()
    {
        ProductColor pc = productcolordao.getProductColorFromPIdAndColorId(p.getProductId(), getColorIdFromCheckBox());
        ProductVariant pv =null;
        if(pc!=null)
        {
            pv = productvariantbus.getProductVariantFromPCIdAndSize(pc.getProductColorId(), getSizeFromCheckBox());
        }
        return pv;
    }
    
}
