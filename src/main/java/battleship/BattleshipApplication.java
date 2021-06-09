package battleship;

import battleship.graphics.IG_Login;
import battleship.services.Login;
import battleship.utils.DataConnect;

import java.sql.SQLException;

public class BattleshipApplication {
    public static void main(String[] args) throws SQLException {
        Login login = new Login(DataConnect.getConnection());
        IG_Login glogin = new IG_Login(login);
        glogin.createGUIL();
    }
}