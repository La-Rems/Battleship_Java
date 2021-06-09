package battleship.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import battleship.services.List_Login_btn;
import battleship.services.Login;
import battleship.services.Register;
import battleship.utils.DataConnect;

public class IG_Login extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    public Login login;
    protected Register register;
    String passwordLogin;

    public JFrame f = new JFrame("Naval Battle Game");
    JPanel login_panel = new JPanel();
    JTextField login_tf = new JTextField();
    JLabel login_lb = new JLabel("Login : ");
    JLabel MDP_lb = new JLabel("Password :");
    public JLabel login_error = new JLabel();
    JLabel login_titre = new JLabel("CONNEXION");
    JPasswordField MDP_Pf = new JPasswordField();
    JButton login_button = new JButton("Log in");
    JButton register_button = new JButton("Register ?");


    JPanel content = new JPanel(new GridBagLayout());

    JPanel panel = new JPanel();


    public void createGUIL() //methode qui creer la fenetre
    {

        f.setResizable(false);
        f.setSize(550, 550);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        /////////////////////////////////////////
        /*
        content.setBackground(Color.GREEN);
        content.setBorder(new EmptyBorder(200, 200, 200, 200));
        f.setContentPane(content);*/
        addComponentsToPane(f.getContentPane());////ne pas enlever
        /*f.pack();*/
        //////////////////////////////////////////////
        f.repaint();
        f.setVisible(true);
    }

    public void addComponentsToPane(Container pane)
    {

        Icon deco_login = new ImageIcon(new ImageIcon("../img/test.PNG").getImage().getScaledInstance(550, 550, Image.SCALE_DEFAULT));

        login_titre.setBounds(220, 140, 250, 40);
        login_titre.setFont(new Font("TimesRoman",Font.BOLD, 20));
        login_lb.setBounds(105, 200, 100, 25);
        login_lb.setFont(new Font("TimesRoman",Font.BOLD, 15));
        login_tf.setBounds(205, 200, 150, 25);
        MDP_lb.setBounds(105, 250, 100, 25);
        MDP_lb.setFont(new Font("TimesRoman",Font.BOLD, 15));
        MDP_Pf.setBounds(205, 250, 150, 25);

        //login_panel.setBackground(Color.lightGray);
        login_panel.setBounds(0, 0, 550, 550);
        login_error.setForeground(Color.RED);
        login_error.setBounds(125, 340,400,60);
        login_error.setFont(new Font("TimesRoman",Font.BOLD, 25));


        login_button.setBounds(150, 300, 90, 40 );
        register_button.setBounds(300,300, 120, 40);

        //panel.setSize(550, 550);
        //pane.add(panel); //////////////////


        pane.add(login_error);
        pane.add(login_panel);
        pane.add(login_tf);
        pane.add(login_lb);
        pane.add(MDP_Pf);
        pane.add(MDP_lb);
        pane.add(login_titre);
        pane.add(register_button);
        pane.add(login_button);

        JLabel image_login = new JLabel(deco_login);
        login_panel.add(image_login);
        pane.add(login_panel);



        login_button.addActionListener(new List_Login_btn(this));
        register_button.addActionListener(this);
    }

    public IG_Login(Login login){
        this.login = login;
    }
    public String getPseudoLogin() {
        return this.login_tf.getText();
    }
    public String getPasswordLogin() {
        return this.passwordLogin = new String(MDP_Pf.getPassword());
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		String actionButton = ((JButton) e.getSource()).getActionCommand() ;
		
		
		//teste si le bouton appuyer est "Register?""
		if(actionButton.equals(register_button.getActionCommand()))
		{
            try {
                Connection connection = DataConnect.getConnection();
                Register register = new Register(connection);
                IG_Register ig_register = new IG_Register(register);
                ig_register.createGUIR();
                this.f.setVisible(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
		}
    }
}