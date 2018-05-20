package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBManager {

    public static final String url = "jdbc:mysql://krogericenewnew.ci3jnwfxaijm.us-east-1.rds.amazonaws.com:3306/krogerice?verifyServerCertificate=false&useSSL=false";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";  
    public static final String password = "22222222";

    public Connection  conn = null;  
    public PreparedStatement pst = null;  
  
    public DBManager(String sql) {  
        try {  
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
            pst = conn.prepareStatement(sql);
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    public void close() {
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    } 
}
