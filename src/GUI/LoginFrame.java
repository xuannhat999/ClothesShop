package GUI;

import BUS.UserBUS;
import DTO.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginFrame extends JFrame{
    private JPanel header;
    private JLabel lblname,lblpass;
    private JTextField txfname;
    private JPasswordField txfpass;
    private RoundedButton btnlogin;
    private UserBUS userbus = new UserBUS();;
    public LoginFrame()
    {
        init();
    }
    private void init()
    {
        setSize(980,980);
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(Theme.light1);
        getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.darkGray));

        header = new Header(this);
        add(header,BorderLayout.NORTH);

        JPanel pnlmainlogin = new JPanel();
        pnlmainlogin.setLayout(new GridBagLayout());
        add(pnlmainlogin,BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        lblname = new JLabel("Username");
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        pnlmainlogin.add(lblname,gbc);

        txfname = new JTextField();
        txfname.setPreferredSize(new Dimension(250,50)); 
        gbc.gridy=1;
        pnlmainlogin.add(txfname,gbc);

        lblpass = new JLabel("Password");
        gbc.gridy=2;
        pnlmainlogin.add(lblpass,gbc);

        txfpass = new JPasswordField();
        txfpass.setPreferredSize(new Dimension(250,50));
        gbc.gridy=3;
        pnlmainlogin.add(txfpass,gbc);

        btnlogin = new RoundedButton("Login", 10);
        btnlogin.setButtonSize(70 ,30);
        btnlogin.setFont(12,Color.black);
        gbc.gridy=4;
        pnlmainlogin.add(btnlogin,gbc);

        addEvent();
        setVisible(true);
    }
    private void addEvent()
    {
        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==btnlogin)
                {
                    loginCheck(txfname.getText(),new String(txfpass.getPassword()));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        };
        btnlogin.addMouseListener(ml);
    }
    public void loginCheck(String name, String pass)
    {
        User user = userbus.loginCheck(name,pass);
        if(user != null)
        {
            new MainFrame(user.getRoleId());
            this.dispose();
        }
        else 
        {
            System.out.println("Login failed");
        }
        
    }
}
