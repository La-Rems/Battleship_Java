package battleship.services;

import java.sql.*;

public class Register {
    private final Connection conn;
    protected Boolean response;

    public Register(Connection conn){
        this.conn=conn;
    }

    public boolean SignUp (String rlogin, String rpwd, String rpwd2) {
        Statement stmt = null;
        String sql = "SELECT log FROM Accounts WHERE log = '"+rlogin+"'";
        try {
            stmt= conn.createStatement();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        ResultSet rs;
        try {
            assert stmt != null;
            rs = stmt.executeQuery(sql);

            if (!rs.next() && rpwd != null && rpwd.equals(rpwd2)) {
                String sql2 = "INSERT INTO Accounts (log, pass) VALUES ('"+rlogin+"', '"+rpwd+"')";
                    try {
                        stmt= conn.createStatement();
                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }
                    ResultSet rs2;
                    try {
                        assert stmt != null;
                        rs2 = stmt.executeQuery(sql2);
                        rs2.first();
                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }
                response = true;
                //System.out.println("Login created! Welcome!");
            } else {
                response = false;
            }rs.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return response;
    }
}
