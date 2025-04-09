package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainPanel extends JPanel{
    protected int roleid;
    protected JPanel pnlcon3,pnlcon4,pnlcon5;
    protected RoundedPanel pnlimage,pnlcon1,pnlcon2;
    protected RoundedButton btnsave,btnadd,btnremove,btnupdate,btncancel,btnfind,btnfilter;
    protected JTextField txfsearch;

    public MainPanel(int roleid)
    {
        this.roleid = roleid;
        init();
    }
    private void init()
    {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5  , 5, 5, 5);

        // PANEL Image
        pnlimage = new RoundedPanel(20);
        pnlimage.setBackground(Theme.light1);
        pnlimage.setBorder(new EmptyBorder(10,10,10,10));
        pnlimage.setBorderWidth(1);
        pnlimage.setBorderColor(Theme.brown);
        pnlimage.setPanelSize(320, 320);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=0;
        gbc.weighty=0;
        gbc.gridwidth=1;
        add(pnlimage,gbc);

        // PANEL 1
        pnlcon1 = new RoundedPanel(20);
        pnlcon1.setLayout(new GridBagLayout());
        pnlcon1.setBackground(Theme.light1);
        pnlcon1.setBorder(new EmptyBorder(10,10,10,10));
        pnlcon1.setBorderWidth(1);
        pnlcon1.setBorderColor(Theme.brown);
        gbc.gridx=1;
        gbc.weightx=2;
        gbc.weighty=1;

  
        add(pnlcon1,gbc);

        // PANEL 2
        pnlcon2 = new RoundedPanel(20);
        pnlcon2.setLayout(new GridBagLayout());
        pnlcon2.setBackground(Theme.light1);
        pnlcon2.setBorder(new EmptyBorder(10,10,10,10));
        pnlcon2.setBorderWidth(1);
        pnlcon2.setBorderColor(Theme.brown);
        gbc.gridx=2;
        gbc.weightx=1;
        add(pnlcon2,gbc);

        // PANEL 3
        pnlcon3 = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridwidth=3;
        add(pnlcon3,gbc);

        // PANEL 4
        pnlcon4 = new JPanel(new GridBagLayout());
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=1;
        gbc.weighty=8;
        gbc.gridwidth=3;
        add(pnlcon4,gbc);
        
        // PANEL 5  
        pnlcon5 = new JPanel(new GridBagLayout());
        gbc.gridy=3;
        gbc.weighty=1;
        add(pnlcon5,gbc);
        
        JPanel pnlsearch = new JPanel();
        pnlsearch.setLayout(null);
        pnlsearch.setPreferredSize(new Dimension(300,50));
        pnlsearch.setOpaque(false);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=3;
        pnlcon2.add(pnlsearch,gbc);

        txfsearch = new JTextField();
        txfsearch.setBounds(0,0,250,50);
        pnlsearch.add(txfsearch);

        btnfind = new RoundedButton("", 25);
        btnfind.setBounds(260,0,50,50);
        btnfind.setBackground(Theme.brown);
        pnlsearch.add(btnfind);
        btnfind.setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-search-30.png"));

        btnfilter = new RoundedButton("",25);
        btnfilter.setBounds(320,0,50,50);
        btnfilter.setBackground(Theme.light1);
        btnfilter.setBorderWidth(1);
        btnfilter.setBorderColor(Theme.brown);
        pnlsearch.add(btnfilter);
        btnfilter.setIcon(new ImageIcon("D:\\VSCode\\ClothesShop\\icon\\icons8-filter-30.png"));

        btnadd = new RoundedButton("Thêm", 20);
        btnadd.setBackground(Theme.brown);
        btnadd.setButtonSize(80, 40);
        btnadd.setForeground(Color.white);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlcon2.add(btnadd,gbc);

        btnremove = new RoundedButton("Xóa", 20);
        btnremove.setBackground(Theme.light1);
        btnremove.setBorderWidth(1);
        btnremove.setBorderColor(Theme.brown);
        btnremove.setButtonSize(80, 40);
        gbc.gridx=1;
        pnlcon2.add(btnremove,gbc);
        btnremove.setVisible(false);

        btnupdate = new RoundedButton("Cập nhật", 20);
        btnupdate.setBackground(Theme.light1);
        btnupdate.setBorderWidth(1);
        btnupdate.setBorderColor(Theme.brown);
        btnupdate.setButtonSize(80  , 40);
        gbc.gridx=2;
        pnlcon2.add(btnupdate,gbc);
        btnupdate.setVisible(false);

        btncancel = new RoundedButton("Hủy", 20);
        btncancel.setBackground(Theme.light1);
        btncancel.setBorderWidth(1);
        btncancel.setBorderColor(Theme.brown);
        btncancel.setButtonSize(100, 30);
        gbc.gridx=0;
        pnlcon3.add(btncancel,gbc);
        btncancel.setVisible(false);

        btnsave = new RoundedButton("Lưu", 20);
        btnsave.setBackground(Theme.brown);
        btnsave.setButtonSize(100, 30);
        btnsave.setForeground(Color.white);
        gbc.gridx=1;
        pnlcon3.add(btnsave,gbc);
        btnsave.setVisible(false);


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
    



}
