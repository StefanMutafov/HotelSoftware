package Objects;

import java.sql.*;
import java.util.LinkedList;

public class Database {
    String db = "jdbc:mysql://127.0.0.1:3306/hotelsdb";
    String user = "root";
    String pass = "StefanM951659";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

        public Database( ){
            try {
                con = DriverManager.getConnection(db, user, pass);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        public String getPass(String user)throws SQLException{
            ps = con.prepareStatement("SELECT pass FROM users WHERE username = ?");
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()) {
                return rs.getString(1);
            }else{
                return null;
            }
        }

        public ResultSet get(String statement) throws SQLException {
            ps = con.prepareStatement(statement);
            rs = ps.executeQuery();
            return rs;

        }

    public ResultSet get(String statement, int id) throws SQLException {
        ps = con.prepareStatement(statement);
        ps.setInt(1, id);
        rs = ps.executeQuery();
        return rs;

    }
        public void register(String user, String pass, String fName, String lName, String phone, String e_mail, String secCont, String rDate) throws SQLException {
            ps = con.prepareStatement("INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?)" );
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, fName);
            ps.setString(4, lName);
            ps.setString(6, phone);
            ps.setString(7, e_mail);
            ps.setString(8, secCont);
            ps.setString(5, rDate);
            ps.setInt(9, 0);
            ps.executeUpdate();
            System.out.println("database record succersfull");

        }

        public LinkedList<String> getUsernames() throws SQLException {
            ps = con.prepareStatement("select username from Users ");
            rs = ps.executeQuery();
            LinkedList<String> users = new LinkedList<String>();
            while(rs.next()){
                users.add(rs.getString(1));

            }
            return users;
        }

    public LinkedList<String> getEmails() throws SQLException {
        ps = con.prepareStatement("select e_mail from users ");
        rs = ps.executeQuery();
        LinkedList<String> emails = new LinkedList<String>();
        while(rs.next()){
            emails.add(rs.getString(1));

        }
        return emails;
    }

    public int getPerm(String user)throws SQLException{
        ps = con.prepareStatement("select perm from users where username =?");
        ps.setString(1, user);
        rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }
    public void setPerm(String user, int perm)throws SQLException{
        ps = con.prepareStatement("update users set perm = ? where username = ? ");
        ps.setString(1, user);
        ps.setInt(2, perm);
        ps.executeUpdate();

    }



}
