package GUI.FilterPanel;

import javax.swing.JDialog;
import javax.swing.JPanel;

import GUI.Theme;
import java.awt.BorderLayout;

public class BigDialog extends JDialog {
    public BigDialog(JPanel panelmain)
    {
        super();
        init(panelmain);
    }
    private void init(JPanel panelmain)
    {
        setSize(1200,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setBackground(Theme.light1);
        
        setLayout(new BorderLayout());
        add(panelmain,BorderLayout.CENTER);
        setVisible(true);
    }
}
