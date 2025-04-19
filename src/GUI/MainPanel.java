package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
    protected JPanel pnlcon3,pnlcon4;
    protected RoundedPanel pnlcon1,pnlcon2;
    protected RoundedButton btnsave,btnadd,btnremove,btnupdate,btncancel,btnfind,btnfilter,btndetail;
    protected JTextField txfsearch;

    public MainPanel()
    {
        init();
    }
    private void init()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5  , 5, 5, 5);

        // PANEL Image

        // PANEL 1
        pnlcon1 = new RoundedPanel(20);
        pnlcon1.setLayout(new GridBagLayout());
        pnlcon1.setBackground(Theme.light1);
        pnlcon1.setBorder(new EmptyBorder(10,10,5,10));
        pnlcon1.setBorderWidth(1);
        pnlcon1.setBorderColor(Theme.brown);
        pnlcon1.setPreferredSize(new Dimension(700,350));
        pnlcon1.setMinimumSize(new Dimension(600,350));
        gbc.gridx=0;
        gbc.weightx=1;
        gbc.weighty=1;
        add(pnlcon1,gbc);

        // PANEL 2
        pnlcon2 = new RoundedPanel(20);
        pnlcon2.setLayout(new GridBagLayout());
        pnlcon2.setBackground(Theme.light1);
        pnlcon2.setBorder(new EmptyBorder(10,10,10,10));
        pnlcon2.setMinimumSize(new Dimension(350,230));
        pnlcon2.setBorderWidth(1);
        pnlcon2.setBorderColor(Theme.brown);
        gbc.gridx=1;
        gbc.weightx=0;
        add(pnlcon2,gbc);

        // PANEL 3
        pnlcon3 = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.gridwidth=1;
        add(pnlcon3,gbc);

        JLabel lblblank = new JLabel();
        gbc.gridx=1;
        gbc.weighty=1;
        add(lblblank,gbc);

        // PANEL 4
        pnlcon4 = new JPanel(new GridBagLayout());
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=1;
        gbc.weighty=8;
        gbc.gridwidth=2;
        add(pnlcon4,gbc);
        
        // COMPONENT
        JPanel pnlsearch = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlsearch.setPreferredSize(new Dimension(400,60));
        pnlsearch.setMaximumSize(pnlsearch.getPreferredSize());
        pnlsearch.setOpaque(false);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=4;
        pnlcon2.add(pnlsearch,gbc);

        txfsearch = new JTextField();
        txfsearch.setPreferredSize(new Dimension(250,50));
        pnlsearch.add(txfsearch);

        btnfind = new RoundedButton("", 25);
        btnfind.setPreferredSize(new Dimension(50,50));
        btnfind.setBackground(Theme.brown);
        pnlsearch.add(btnfind);
        btnfind.setIcon(new ImageIcon("ClothesShop\\icon\\icons8-search-30.png"));

        btnfilter = new RoundedButton("",25);
        btnfilter.setPreferredSize(new Dimension(50,50));
        btnfilter.setBackground(Theme.light1);
        btnfilter.setBorderWidth(1);
        btnfilter.setBorderColor(Theme.brown);
        pnlsearch.add(btnfilter);
        btnfilter.setIcon(new ImageIcon("ClothesShop\\icon\\icons8-filter-30.png"));

        btnadd = new RoundedButton("Thêm", 20);
        btnadd.setBackground(Theme.brown);
        btnadd.setButtonSize(100, 40);
        btnadd.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlcon2.add(btnadd,gbc);

        btnremove = new RoundedButton("Xóa", 20);
        btnremove.setBackground(Theme.light1);
        btnremove.setBorderWidth(1);
        btnremove.setBorderColor(Theme.brown);
        btnremove.setButtonSize(100, 40);
        gbc.gridx=1;
        pnlcon2.add(btnremove,gbc);
        

        btnupdate = new RoundedButton("Cập nhật", 20);
        btnupdate.setBackground(Theme.light1);
        btnupdate.setBorderWidth(1);
        btnupdate.setBorderColor(Theme.brown);
        btnupdate.setButtonSize(100  , 40);
        gbc.gridx=2;
        pnlcon2.add(btnupdate,gbc);
       
        btndetail = new RoundedButton("Chi tiết",20);
        btndetail.setBackground(Theme.light1);
        btndetail.setBorderWidth(1);
        btndetail.setBorderColor(Theme.brown);
        btndetail.setButtonSize(100,40);
        gbc.gridx=3;
        pnlcon2.add(btndetail,gbc);
       
        btncancel = new RoundedButton("Hủy", 20);
        btncancel.setBackground(Theme.light1);
        btncancel.setBorderWidth(1);
        btncancel.setBorderColor(Theme.brown);
        btncancel.setButtonSize(200, 40);
        gbc.gridx=0;
        pnlcon3.add(btncancel,gbc);
        
        btnsave = new RoundedButton("Lưu", 20);
        btnsave.setBackground(Theme.brown);
        btnsave.setForeground(Color.white);
        btnsave.setButtonSize(200,40);
        gbc.gridx=1;
        pnlcon3.add(btnsave,gbc);

        
        setButtonVisible(false);
        /*pnlcon1.setOpaque(true);
        pnlcon2.setOpaque(true);
        pnlcon3.setOpaque(true);
        pnlcon4.setOpaque(true);
        pnlcon5.setOpaque(true);
        pnlcon1.setBackground(Color.blue);
        pnlcon2.setBackground(Color.red);
        pnlcon3.setBackground(Color.green);
        pnlcon4.setBackground(Color.yellow);
        pnlcon5.setBackground(Color.gray);*/
        
    }    
    public void setButtonVisible(boolean e)
    {
        btnsave.setVisible(e);
        btncancel.setVisible(e);
        btndetail.setVisible(e);
        btnupdate.setVisible(e);
        btnremove.setVisible(e);
    }



}
