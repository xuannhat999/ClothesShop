package GUI;

import java.awt.GridBagConstraints;

public class SupplierPanel extends MainPanel{
    private SupplierDAO supplierdao = new SupplierDAO();
    public SupplierPanel()
    {
        super();
        init();
    }
    private void init()
    {
        pnlcon1.setVisible(false);
        pnlcon3.setVisible(false);

        GridBagConstraints gbc = new GridBagConstraints();
    }
}
