package battleship.graphics;

import battleship.services.List_Register_btn;
import battleship.services.Login;
import battleship.services.Register;
import battleship.utils.DataConnect;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class IG_Register extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    public Register register;
    String passwordRegister1;
    String passwordRegister2;

    JFrame fregister = new JFrame("Navale Battlegame");
    JLabel register_titre = new JLabel("REGISTER");
    JLabel register_login_lb = new JLabel("Login : ");
    JLabel register_MDP_lb = new JLabel("Password : ");
    JLabel register_ReMDP_lb = new JLabel(" Confirm Password : ");
    JTextField register_login_tf = new JTextField();
    JPasswordField register_MDP_Pf = new JPasswordField();
    JPasswordField register_ReMDP_Pf = new JPasswordField();
    JButton signup_Button = new JButton("Sign Up");
    JButton return_button = new JButton("Return");
    JPanel register_panel = new JPanel();
    public JLabel register_error = new JLabel();
    public JLabel register_success = new JLabel();


    public void createGUIR() //methode qui creer la fenetre
    {
        fregister.setVisible(true);
        fregister.setResizable(false);
        fregister.setSize(520, 550);
        fregister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fregister.setLocationRelativeTo(null);
        addComponentsToPane(fregister.getContentPane());
    }

    public void addComponentsToPane(Container pane)
    {
        pane.setLayout(null);

    Icon deco_register = new ImageIcon(new ImageIcon("../img/test.PNG").getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));


    register_titre.setBounds(210, 90, 250, 40);
   // register_titre.setForeground(Color.WHITE);
    register_titre.setFont(new Font("TimesRoman",Font.BOLD, 20));
    register_login_lb.setBounds(70, 140, 100, 25);
    register_login_lb.setFont(new Font("TimesRoman",Font.BOLD, 15));
   // register_login_lb.setForeground(Color.WHITE);
    register_login_tf.setBounds(170, 140, 150, 25);
    register_MDP_lb.setBounds(70, 190, 100, 25);
    //register_MDP_lb.setForeground(Color.WHITE);
    register_MDP_Pf.setBounds(170, 190, 150, 25);
    register_MDP_lb.setFont(new Font("TimesRoman",Font.BOLD, 15));
    register_ReMDP_lb.setBounds(70, 240, 200, 25);
   // register_MDP_lb.setForeground(Color.WHITE);
    register_ReMDP_Pf.setBounds(205, 240, 150, 25);
    register_ReMDP_lb.setFont(new Font("TimesRoman",Font.BOLD, 15));
   // register_ReMDP_lb.setForeground(Color.WHITE);
    signup_Button.setBounds(150, 290, 90, 40 );
    return_button.setBounds(300,290, 90, 40);


    register_panel.setBounds(0, 0, 550, 550);

    register_error.setForeground(Color.RED);
    register_error.setBounds(80, 390,400,60);
    register_error.setFont(new Font("TimesRoman",Font.BOLD, 18));
    register_success.setForeground(Color.GREEN);
    register_success.setBounds(80, 390,400,60);
    register_success.setFont(new Font("TimesRoman",Font.BOLD, 18));


    pane.add(register_error);
    pane.add(register_success);
    pane.add(register_titre);
    pane.add(register_login_lb);
    pane.add(register_login_tf);
    pane.add(register_MDP_Pf);
    pane.add(register_MDP_lb);
    pane.add(register_ReMDP_lb);
    pane.add(register_ReMDP_Pf);
    pane.add(signup_Button);
    pane.add(return_button);


    JLabel image_register = new JLabel(deco_register);
    register_panel.add(image_register);
    pane.add(register_panel);


    signup_Button.addActionListener(new List_Register_btn(this));
    return_button.addActionListener(this);
    }

    public IG_Register(Register register){
        this.register = register;
    }
    public String getPseudoRegister() {
        return this.register_login_tf.getText();
    }
    public String getPasswordRegister1() {
        return this.passwordRegister1 = new String(register_MDP_Pf.getPassword());
    }
    public String getPasswordRegister2() {
        return this.passwordRegister2 = new String(register_ReMDP_Pf.getPassword());
    }

     @Override
	public void actionPerformed(ActionEvent e) {
		String actionButton = ((JButton) e.getSource()).getActionCommand() ;
		
		//teste si le bouton appuyer est "Login"
		if(actionButton.equals(return_button.getActionCommand()))
		{
            try {
                Connection connection = DataConnect.getConnection();
                Login login = new Login(connection);IG_Login ig_login = new IG_Login(login);
                ig_login.createGUIL();
                this.fregister.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
		}
    }
}