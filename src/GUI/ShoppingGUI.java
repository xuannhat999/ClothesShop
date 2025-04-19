package GUI;

import BUS.ProductBUS;
import DTO.Product;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ShoppingGUI extends MainPanel{
    private ProductBUS productbus = new ProductBUS();
    private JScrollPane sp;
    private JPanel pnlproduct;
    private int userid;
    private RoundedButton btncart;
    public ShoppingGUI(int userid)
    {
        super();
        this.userid=userid;
        init();
    }
    private void init()
    {


        pnlcon1.setVisible(false);
        pnlcon3.setVisible(false);
        btnadd.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        // PANEL 2
        JLabel lblblank = new JLabel();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;
        pnlcon2.add(lblblank,gbc);
        JPanel pnlbtn = new JPanel(new FlowLayout(FlowLayout.RIGHT,5,5));
        pnlbtn.setOpaque(false);
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=0;
        pnlcon2.add(pnlbtn,gbc);

        btncart = new RoundedButton("", 25);
        btncart.setButtonSize(70,50);
        btncart.setBackground(Theme.brown);
        pnlbtn.add(btncart);
        ImageIcon iconcart = new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-cart-40.png");
        btncart.setIcon(iconcart);



        // PANEL 4
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;

        pnlproduct = new JPanel(new GridBagLayout());
        loadProductVariant(productbus.getAllProduct());
        sp = new JScrollPane(pnlproduct);
        pnlcon4.add(sp,gbc);

        addEvent();
    }
    private void loadProductVariant(List<Product> pl)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(3, 3, 3, 3);
        gbc.weightx=1;
        gbc.weighty=0;
        int columnCount = 5; // Số cột mong muốn
        int row = 0, col = 0;

        for (Product i : pl) {
            ProductPanelToBuy pvp = new ProductPanelToBuy(i,userid);
            gbc.gridx = col;
            gbc.gridy = row;
            pnlproduct.add(pvp,gbc);

            col++;
            if (col == columnCount) {
                col = 0;
                row++;
                }
        }
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btncart)
                {
                    new CartPanel(userid,SwingUtilities.getWindowAncestor(ShoppingGUI.this));
                }
            }
        };
        btncart.addActionListener(al);
    }

}
