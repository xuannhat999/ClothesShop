package GUI;

import BUS.CartBUS;
import BUS.ProductVariantBUS;
import BUS.UserBUS;
import DAO.PaymentMethodDAO;
import DTO.Cart;
import DTO.PaymentMethod;
import DTO.User;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class PayPanel extends JDialog{
    private int userid;
    private RoundedPanel pnlinfo,pnlpay;
    private JPanel pnlproduct,pnlbtn;
    private RoundedButton btnorder;
    private JScrollPane sp;
    private CartBUS cartbus = new CartBUS();
    private ProductVariantBUS productvariantbus = new ProductVariantBUS();
    private JLabel lblname,lbldob,lblemail,lblphone,lbladdress,lblbank,lblbanknum,lblbankaccname,lbltotal;
    private JComboBox<PaymentMethod> cbbpaymethod;
    private UserBUS userbus = new UserBUS();
    private PaymentMethodDAO pmdao = new PaymentMethodDAO();
    private List<Cart> cartlist = new ArrayList<>();
    private BigDecimal total;
    public PayPanel(Window window,int userid,List<Cart> cl)
    {
        super(window,ModalityType.APPLICATION_MODAL);
        this.cartlist=cl;
        this.userid=userid;
        this.cartlist = cl;
        init();
    }
    private void init()
    {
        setSize(1200,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        getRootPane().setBackground(Theme.light1);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        // PANEL CON 
        pnlinfo = new RoundedPanel(15);
        pnlinfo.setLayout(new GridBagLayout());
        pnlinfo.setBackground(Theme.light1);
        pnlinfo.setBorderWidth(1);
        pnlinfo.setBorderColor(Theme.brown);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=1;
        add(pnlinfo,gbc);

        pnlpay = new RoundedPanel(15);
        pnlpay.setLayout(new GridBagLayout());
        pnlpay.setBackground(Theme.light1);
        pnlpay.setBorderWidth(1);
        pnlpay.setBorderColor(Theme.brown);
        gbc.gridx=1;
        add(pnlpay,gbc);

        pnlproduct = new JPanel(new GridBagLayout());
        loadProduct();
        sp = new JScrollPane(pnlproduct);
        sp.setPreferredSize(new Dimension(1100,300));
        gbc.gridy=2;
        gbc.gridx=0;
        gbc.gridwidth=2;
        add(sp,gbc);

        pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
        gbc.gridy=3;
        gbc.weighty=0;
        add(pnlbtn,gbc);

        // COMPONENT
            // INFO 
            User user = userbus.getUserFromId(userid);
            JLabel lbluserinfo = new JLabel("Thông tin khách hàng");
            lbluserinfo.setFont(Theme.infofont1);
            lbluserinfo.setBorder(new EmptyBorder(0,0,30,0));
            lbluserinfo.setHorizontalAlignment(SwingConstants.CENTER);
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.weightx=1;
            gbc.weighty=0;
            gbc.gridwidth=1;
            pnlinfo.add(lbluserinfo,gbc);

            lblname = new JLabel("Họ và tên:  "+ user.getFullName());
            lblname.setFont(Theme.infofont2);
            gbc.gridy=1;
            pnlinfo.add(lblname,gbc);

            lbldob = new JLabel("Ngày sinh:  "+user.getDob().toString());
            lbldob.setFont(Theme.infofont2);
            gbc.gridy=2;
            pnlinfo.add(lbldob,gbc);

            lblemail = new JLabel("Email:  "+user.getEmail());
            lblemail.setFont(Theme.infofont2);
            gbc.gridy=3;
            pnlinfo.add(lblemail,gbc);

            lblphone = new JLabel("Số điện thoại:  "+user.getPhone());
            lblphone.setFont(Theme.infofont2);
            gbc.gridy=4;
            pnlinfo.add(lblphone,gbc);

            lbladdress = new JLabel("Địa chỉ:  "+user.getAddress());
            lbladdress.setFont(Theme.infofont2);
            gbc.gridy=5;
            pnlinfo.add(lbladdress,gbc);

            JLabel lblblank = new JLabel();
            gbc.weighty=1;
            gbc.gridy=6;
            pnlinfo.add(lblblank,gbc);

            // PAYMENT METHOD
            JLabel lblpaymethod = new JLabel("Phương thức thanh toán");
            lblpaymethod.setFont(Theme.infofont1);
            lblpaymethod.setHorizontalAlignment(SwingUtilities.CENTER);
            lblpaymethod.setBorder(new EmptyBorder(0,0,30,0));
            gbc.gridx=0;
            gbc.gridy=0;
            gbc.weightx=1;
            gbc.weighty=0;
            pnlpay.add(lblpaymethod,gbc);

            cbbpaymethod = new JComboBox<>();
            for(PaymentMethod i :pmdao.getAllPaymentMethod())
            {
                cbbpaymethod.addItem(i);
            }
            gbc.gridy=1;
            gbc.weightx=0;
            pnlpay.add(cbbpaymethod,gbc);

            lblbank = new JLabel("Ngân hàng:  BANK 1");
            gbc.gridy=2;
            pnlpay.add(lblbank,gbc);

            lblbanknum = new JLabel("Số tài khoản:  01234567890");
            gbc.gridy=3;
            pnlpay.add(lblbanknum,gbc);

            lblbankaccname = new JLabel("Tên người nhận:  NGUYEN VAN A");
            gbc.gridy=4;
            pnlpay.add(lblbankaccname,gbc);

            IsBanking(false);
        // PANEL BOTTOM
        total = cartbus.getTotalFromCartList(cartlist);
        lbltotal = new JLabel("Tổng tiền:  "+ Theme.df.format(total));
        lbltotal.setFont(Theme.infofont1);
        pnlbtn.add(lbltotal);
        

        btnorder = new RoundedButton("Đặt hàng", 15);
        btnorder.setBackground(Theme.brown);
        btnorder.setButtonSize(100, 50);
        btnorder.setForeground(Color.white);
        pnlbtn.add(btnorder);

        addEvent();
        setVisible(true);
    }
    public void IsBanking(boolean a)
    {
        lblbank.setVisible(a);
        lblbanknum.setVisible(a);
        lblbankaccname.setVisible(a);
    }
    public void loadProduct()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(1, 1, 1, 1);
        int row =0;
        gbc.gridx=0;
        gbc.weightx=1;
        gbc.weighty=0;
        for(Cart i :cartlist)
        {
            ProductVariantPanel pvp =new ProductVariantPanel(productvariantbus.getProductVariantFromId(i.getProductVariantId()),i.getQuantity() ,userid);
            pvp.getRemoveButton().setVisible(false);
            pvp.getQuantityPanel().setEditableQuanPanel(false);
            gbc.gridy=row;
            pnlproduct.add(pvp,gbc);
            row++;
        }
    }
    public PaymentMethod getpPaymentMethod()
    {
        return (PaymentMethod) cbbpaymethod.getSelectedItem();
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==cbbpaymethod)
                {
                    IsBanking(getpPaymentMethod().getPaymentMethodId()==2);
                }
                else if (e.getSource()==btnorder)
                {
                    if(cartlist.size()>1)
                    {
                        for(Cart i:cartlist)
                        {
                            cartbus.removeProductFromCart(userid, productvariantbus.getProductVariantFromId(i.getProductVariantId()));
                        }
                    }
                    PayPanel.this.dispose();
                }
            }
            
        };
        cbbpaymethod.addActionListener(al);
        btnorder.addActionListener(al);
    }


}
