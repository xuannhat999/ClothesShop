package GUI;

import DAO.PermissionDAO;
import DAO.RoleDAO;
import DTO.Permission;
import DTO.Role;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
public class AccountPanel extends JDialog{
    private JTextField txfusername, txfpassword;
    private List<JCheckBox> chblp,chbli,chblc,chble;
    private JCheckBox chbbuy;
    private RoundedPanel pnlper;
    private RoundedButton btnsave,btnback;
    private JComboBox<Role> cbbrole;
    private RoleDAO roledao = new RoleDAO();
    private PermissionDAO perdao = new PermissionDAO();
    public AccountPanel(){
        init();
    }
    public void init()
    {
        setSize(800,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Theme.light1);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel lblname = new JLabel("Tài khoản");
        lblname.setFont(Theme.infofont1);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=2;
        add(lblname,gbc);

        JLabel lblusername = new JLabel("Username");
        lblusername.setHorizontalAlignment(SwingUtilities.RIGHT);
        gbc.gridy=1;
        gbc.gridwidth=1;
        add(lblusername,gbc);

        JLabel lblpass = new JLabel("Password");
        lblpass.setHorizontalAlignment(SwingUtilities.RIGHT);
        gbc.gridy=2;
        add(lblpass,gbc);

        JLabel lblblank = new JLabel();
        gbc.gridx=2;
        gbc.gridy=1;
        gbc.gridheight=2;
        gbc.weightx=1;
        add(lblblank,gbc);

        txfusername = new JTextField();
        txfusername.setPreferredSize(new Dimension(250,30));
        gbc.gridheight=1;
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.weightx=0;
        gbc.weighty=0;
        add(txfusername,gbc);

        txfpassword = new JTextField();
        txfpassword.setPreferredSize(new Dimension(250,30));
        gbc.gridy=2;
        add(txfpassword,gbc);

        pnlper = new RoundedPanel(25);
        pnlper.setLayout(new BorderLayout());
        pnlper.setBorder(new EmptyBorder(10,10,10,10));
        pnlper.setBackground(Theme.light1);
        pnlper.setBorderWidth(1);
        pnlper.setBorderColor(Theme.brown);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=3;
        gbc.weightx=1;
        gbc.weighty=1;
        add(pnlper,gbc);

        JPanel pnlbot = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlbot.setOpaque(false);
        gbc.gridy=4;
        gbc.weighty=0;
        add(pnlbot,gbc);

        btnback = new RoundedButton("Quay lại",15);
        btnback.setButtonSize(200, 40);
        btnback.setBackground(Theme.light2);
        btnback.setBorderColor(Theme.brown);
        btnback.setBorderWidth(1);
        pnlbot.add(btnback);

        btnsave = new RoundedButton("Lưu",15);
        btnsave.setBackground(Theme.brown);
        btnsave.setButtonSize(200, 40);
        pnlbot.add(btnsave);

        // PNL PERMISSON
        JPanel pnlrole = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlrole.setOpaque(false);
        pnlper.add(pnlrole,BorderLayout.NORTH);

        JLabel lblrole = new JLabel("Quyền");
        pnlrole.add(lblrole);

        cbbrole = new JComboBox<>();
        cbbrole.setPreferredSize(new Dimension(200,35));
        pnlrole.add(cbbrole);

        JPanel pnlft = new JPanel(new GridBagLayout());
        pnlft.setOpaque(false);
        pnlper.add(pnlft,BorderLayout.CENTER);

        JLabel ft1 = new JLabel("Mua hàng");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlft.add(ft1,gbc);

        chbbuy = new JCheckBox();
        gbc.gridx=1;
        gbc.gridy=0;
        pnlft.add(chbbuy,gbc);
        chbbuy.setOpaque(false);

        JLabel action1 = new JLabel("Xem");
        JLabel action2 = new JLabel("Thêm");
        JLabel action3 = new JLabel("Sửa");
        JLabel action4 = new JLabel("Xóa");

        gbc.gridwidth=1;
        gbc.gridwidth=1;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridy=1;
        gbc.gridx=1;
        pnlft.add(action1,gbc);
        gbc.gridx=2;
        pnlft.add(action2,gbc);
        gbc.gridx=3;
        pnlft.add(action3,gbc);
        gbc.gridx=4;
        pnlft.add(action4,gbc);



        JLabel ft2 = new JLabel("Quản lý sản phẩm");
        JLabel ft4 = new JLabel("Quản lý hóa đơn");
        JLabel ft5 = new JLabel("Quản lý khách hàng");
        JLabel ft6 = new JLabel("Quản lý nhân viên");

        gbc.gridx=0;
        gbc.gridy=2;
        gbc.weightx=1;
        gbc.weighty=0;
        gbc.gridwidth=1;
        pnlft.add(ft2,gbc);
        gbc.gridy=3;
        pnlft.add(ft4,gbc);
        gbc.gridy=4;
        pnlft.add(ft5,gbc);
        gbc.gridy=5;
        pnlft.add(ft6,gbc);


        chblp= new ArrayList<>();
        chbli = new ArrayList<>();
        chblc = new ArrayList<>();
        chble = new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            chblp.add(new JCheckBox());
            chbli.add(new JCheckBox());
            chblc.add(new JCheckBox());
            chble.add(new JCheckBox()); 
        }
        

        gbc.gridy=2;
        int column=1;
        for(JCheckBox i:chblp)
        {
            i.setOpaque(false);
            gbc.gridx=column;
            pnlft.add(i,gbc);
            column++;
        }

        gbc.gridy=3;
        column=1;
        for(JCheckBox i:chbli)
        {
            i.setOpaque(false);
            gbc.gridx=column;
            pnlft.add(i,gbc);
            column++;
        }

        gbc.gridy=4;
        column=1;
        for(JCheckBox i:chblc)
        {
            i.setOpaque(false);
            gbc.gridx=column;
            pnlft.add(i,gbc);
            column++;
        }

        gbc.gridy=5;
        column=1;
        for(JCheckBox i:chble)
        {
            i.setOpaque(false);
            gbc.gridx=column;
            pnlft.add(i,gbc);
            column++;
        }
        

        for(Role i:roledao.getAllRole())
        {
            cbbrole.addItem(i);
        }



        
        addEvent();
        setVisible(true);
    }
    public void loadPermission(List<Permission> pl)
    {
        for(int i=0;i<chblc.size();i++)
        {
            chblp.get(i).setSelected(false);
            chbli.get(i).setSelected(false);
            chble.get(i).setSelected(false);
            chblc.get(i).setSelected(false);

        }
        for(Permission i: pl)
        {   

            if(i.getFeatureId()==1)
            {
                chbbuy.setSelected(true);;
            }
            else if(i.getFeatureId()==2)
            {
                chblp.get(i.getActionId()-1).setSelected(true);
            }
            else if(i.getFeatureId() ==4)
            {
                chbli.get(i.getActionId()-1).setSelected(true);
            }
            else if(i.getFeatureId() ==5)
            {
                chblc.get(i.getActionId()-1).setSelected(true);
            }
            else if(i.getFeatureId() ==6)
            {
                chble.get(i.getActionId()-1).setSelected(true);
            }
        }
    }
    public Role getRoleIdFromCBB()
    {
        return (Role) cbbrole.getSelectedItem();
    }
    private void addEvent()
    {
        ActionListener al = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cbbrole)
                {
                    Role role = getRoleIdFromCBB();
                    loadPermission(perdao.getPermissionFromRoleId(role.getRoleId()));
                }
            }
            
        };
        cbbrole.addActionListener(al);
    }
}
