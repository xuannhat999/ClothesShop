package GUI;

import BUS.ProductBUS;
import DTO.Product;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShoppingPanel extends MainPanel{
    private ProductBUS productbus = new ProductBUS();
    private JScrollPane sp;
    private JPanel pnlproduct;
    public ShoppingPanel(int userid)
    {
        super(userid);
        init();
    }
    private void init()
    {

        pnlcon1.setVisible(false);
        pnlcon3.setVisible(false);
        btnadd.setVisible(false);
        // PANEL 4
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=1;

        pnlproduct = new JPanel(new GridBagLayout());
        loadProductVariant(productbus.getAllProduct());
        sp = new JScrollPane(pnlproduct);
        pnlcon4.add(sp,gbc);



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
            ProductVariantPanel pvp = new ProductVariantPanel(i);
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

}
