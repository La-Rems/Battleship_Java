package battleship.services;

import battleship.graphics.IG_Game;
import battleship.graphics.IG_Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List_Login_btn implements ActionListener {
    private Login login;
    private IG_Login ig_login;
    Boolean response;

    public List_Login_btn(IG_Login ig_login){
        this.login = ig_login.login;
        this.ig_login = ig_login;
    }
    @Override
    public void actionPerformed(ActionEvent e){

        response = this.login.SignIn(this.ig_login.getPseudoLogin(), this.ig_login.getPasswordLogin());

        if (response){
            IG_Game game = new IG_Game();
            game.createGame();
            ig_login.f.setVisible(false);
        } else  {
            this.ig_login.login_error.setText("Wrong username or password.");
        }
    }
}
