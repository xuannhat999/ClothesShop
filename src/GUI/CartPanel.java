package GUI;

import BUS.CartBUS;
import BUS.ProductVariantBUS;
import DTO.Cart;
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
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CartPanel extends JDialog{
    private int userid;
    private JLabel lblcart,lblprice;
    private JPanel pnlproduct;
    private JScrollPane sp;
    private CartBUS cartbus = new CartBUS();
    private ProductVariantBUS productvariantbus= new ProductVariantBUS(); 
    private RoundedButton btnorder;
    private BigDecimal total;
    public CartPanel(int userid,Window window)
    {
        super(window,ModalityType.APPLICATION_MODAL);
        this.userid=userid;
        init(userid);

    }
    private void init(int userid)
    {
        setSize(1200,700);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Theme.light1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0;
        gbc.weighty=0;
        lblcart = new JLabel("Giỏ hàng");
        lblcart.setFont(new Font("Roboto",Font.BOLD,30));
        add(lblcart,gbc);


        pnlproduct = new JPanel(new GridBagLayout());
        pnlproduct.setBackground(Theme.light1);
        loadProductFromCart(cartbus.getAllCartFromUserId(userid));
        sp=new JScrollPane(pnlproduct);
        sp.setPreferredSize(new Dimension(1100,500));
        sp.setBackground(Color.white);
        sp.getViewport().setBackground(Color.white);
        gbc.weightx=1;
        gbc.weighty=1;
        gbc.gridy=1;
        add(sp,gbc);

        JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,10));
        pnlbtn.setOpaque(false);
        gbc.gridy=2;
        gbc.weighty=0;
        add(pnlbtn,gbc);

        lblprice = new JLabel();
        loadPrice();
        lblprice.setFont(Theme.infofont1);
        pnlbtn.add(lblprice);

        btnorder = new RoundedButton("Mua hàng",20);
        btnorder.setForeground(Color.white);
        btnorder.setBackground(Theme.brown);
        btnorder.setButtonSize(100,50);
        pnlbtn.add(btnorder);



        

        addEvent();

        setVisible(true);
    }
    public void loadProductFromCart(List<Cart> cl)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,1,1,1);
        int rowcount=0;
        gbc.gridx=0;
        gbc.weightx=1;
        gbc.weighty=0;
        for(Cart i:cl)
        {
            ProductVariant pv = productvariantbus.getProductVariantFromId(i.getProductVariantId());
            ProductVariantPanel pvp = new ProductVariantPanel(pv, i.getQuantity(),userid);
            pvp.getRemoveButton().addActionListener(e->{
                SwingUtilities.invokeLater(()->{
                    loadPrice();
                });
    });
            pvp.getQuantityPanel().getQuanTextField().getDocument().addDocumentListener(new DocumentListener() {

                @Override
                public void insertUpdate(DocumentEvent e) {
                    SwingUtilities.invokeLater(()->{
                        loadPrice();
                    });
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    SwingUtilities.invokeLater(()->{
                        loadPrice();
                    });
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                }
                
            });
            gbc.gridy=rowcount;
            pnlproduct.add(pvp,gbc);;
            rowcount++;
        }
    }
    public void loadPrice()
    {   
        total = cartbus.getTotalFromCartList(cartbus.getAllCartFromUserId(userid));
        String t = Theme.df.format(total);
        lblprice.setText("Tổng tiền:  "+t+"đ");
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == btnorder)
                {
                    new PayPanel(getOwner(), userid,cartbus.getAllCartFromUserId(userid));
                    CartPanel.this.dispose();
                }
            }
            
        };
        btnorder.addActionListener(al);
    }


}
