/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Service.Barang_DAO;
import Service.Implement.Barang_DAOimpl;
import Service.Implement.User_DAOimpl;
import Service.User_DAO;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Angga Nugraha
 */
public class Koneksi {
    private static Connection connection;
    private static User_DAO user;
    private static Barang_DAO barang;
    
    public static Connection getConnection() throws SQLException{
        if(connection == null){
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/inventory_db");
            datasource.setUser("root");
            datasource.setPassword("");
            
            connection = datasource.getConnection();
        }
        return connection;
    }
    
    public static User_DAO getUser_Dao() throws SQLException{
        if(user == null){
            user = new User_DAOimpl(getConnection());
        }
        return user;
    } 
    public static Barang_DAO getBarang_Dao() throws SQLException{
        if(barang == null){
            barang = new Barang_DAOimpl(getConnection());
        }
        return barang;
    } 
}
