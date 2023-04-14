/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp2dpbo;

/**
 *
 * @author binta
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author binta
 */
public class dbConnection {
    private Statement stmt=null;
    private Connection conn=null;
    
    public dbConnection(){
        String conAddress = "jdbc:mysql://localhost/tp2dpbo";
        String user = "root";
        String pass = "";
        connect(conAddress, user, pass);
    }
    //    method connect to database
    private void connect(String conAddress, String user, String pass) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(conAddress, user, pass);
            stmt = conn.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
//    method select query
    public ResultSet selectQuery(String sql){
        try {
            stmt.executeQuery(sql);
            return stmt.getResultSet();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
//  method update query
    public int updateQuery(String sql){
        try {
            return stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }
//    getStatement method
    public Statement getStatement(){
        return stmt;
    }
}
