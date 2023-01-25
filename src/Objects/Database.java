package Objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.LinkedList;

public class Database {
    String db = "jdbc:mysql://127.0.0.1:3306/hotelsdb";
    String user = "root";
    String pass = "St951659";
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




    public String getFirstName(String usename) throws SQLException{
        ps = con.prepareStatement("Select fName from users where username = ?");
        ps.setString(1, usename);
        rs = ps.executeQuery();
        rs.next();
        return rs.getString(1);
    }



    public LinkedList<String> getCities() throws SQLException{
            ps = con.prepareStatement("Select DISTINCT city from hotels");
            rs = ps.executeQuery();
        LinkedList<String> cities = new LinkedList<String>();
        while(rs.next()){
            cities.add(rs.getString(1));

        }
        return cities;

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

        public Blob getHotelIcon(int id)throws SQLException{
            ps = con.prepareStatement("Select icon from hotels where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return rs.getBlob(1);

        }

        public String getHotelName(int id)throws SQLException{
            ps = con.prepareStatement("Select hName from hotels where id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return rs.getString(1);


        }

        public LinkedList<Integer> getHotelsIn(String city)throws SQLException{
            ps = con.prepareStatement("Select id from hotels where city = ?");
            ps.setString(1, city);
            rs = ps.executeQuery();
            LinkedList<Integer> hotels = new LinkedList<>();
            while(rs.next()){
                hotels.add(rs.getInt(1));

            }

            return hotels;
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
   public void setHotelIcon(File f, int id) throws SQLException, FileNotFoundException {
       FileInputStream fs=new FileInputStream(f);

       ps= con.prepareStatement("update hotels set icon = ? where id = ?");
       ps.setBinaryStream(1,fs,(int)f.length());
       ps.setInt(2, id);
       ps.executeUpdate();

   }

    public void setPerm(String user, int perm)throws SQLException{
        ps = con.prepareStatement("update users set perm = ? where username = ? ");
        ps.setString(1, user);
        ps.setInt(2, perm);
        ps.executeUpdate();

    }
    public LinkedList<Integer> getsReservations(String user)throws SQLException{
            ps = con.prepareStatement("SELECT  id from reservations where c_user = ?");
            ps.setString(1, user);
            LinkedList<Integer> res = new LinkedList<>();
            rs = ps.executeQuery();
            while(rs.next()){
                res.add(rs.getInt(1));
            }
            return res;

    }

    public void cancelReserv(int id)throws SQLException{
            ps = con.prepareStatement("DELETE FROM reservations WHERE id =?");
            ps.setInt(1, id);
            ps.executeUpdate();

    }

    public Integer getHotelFromRes(int id)throws SQLException{
            ps = con.prepareStatement("SELECT hotel_id FROM reservations WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
    }
    public void book(int hotel_id, String c_user, int people, int nights, Date accommodation, Date vacation, int rooms)throws SQLException{
            ps = con.prepareStatement("insert into reservations(hotel_id, c_user, people, nights, accommodation, vacation, rooms) values(?, ?, ?, ?, ?, ?,?)");
            ps.setInt(1, hotel_id);
            ps.setString(2, c_user);
            ps.setInt(3, people);
        ps.setInt(4, nights);
        ps.setDate(5, accommodation);
        ps.setDate(6, vacation);
        ps.setInt(7, rooms);
        ps.executeUpdate();

    }



}
