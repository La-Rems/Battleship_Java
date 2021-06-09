package battleship.services;

import java.sql.*;
public class Login {
    private final Connection conn;
    String USERNAME="";
    String PASSWORD="";
    Boolean response;

    public Login(Connection conn){
        this.conn=conn;
    }

     public Boolean SignIn (String user,String pwd) {
         Statement stmt = null;
         String sql = "SELECT log, pass FROM Accounts WHERE log = '"+user+"'";
         try {
           stmt= conn.createStatement();
         } catch (SQLException throwable) {
             throwable.printStackTrace();
         }
         ResultSet rs;
         try {
            assert stmt != null;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                USERNAME = rs.getString(1);
                PASSWORD= rs.getString(2);
            }
            if (USERNAME.equals("") || !PASSWORD.equals(pwd)) {
                response = false;
                //System.out.println("Invalid Logins");
            }else if (USERNAME.equals(user)) {
                response = true;
                //System.out.println("Access Granted! Welcome!");
            }
            rs.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return response;
    }
}