/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Entity.User;
import Error.Error_exception;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Service.User_DAO;
import View.Home_Admin;
import View.Home_Gudang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Angga Nugraha
 */
public class User_DAOimpl implements User_DAO {
    private final Connection connection;
    
    private final String insertUser = "INSERT INTO tb_akun (nik, nama, username, password, hak_akses) VALUES (?, ?, ?, ?, ?)";
    private final String updateUser = "UPDATE tb_akun SET nama = ?, username = ?, password = ?, hak_akses = ? WHERE nik = ?";
    private final String deleteUser = "DELETE FROM tb_akun WHERE nik = ?";
    private final String getByName = "SELECT * FROM tb_akun WHERE name = ?";
    private final String getByUsername = "SELECT * FROM tb_akun WHERE username = ? and password = ?";
    private final String getAll = "SELECT * FROM tb_akun";
    
    public User_DAOimpl(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void insertUser(User user) throws Error_exception{
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, user.getNik());
            statement.setString(2, user.getNama());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getHak_akses());
            statement.executeUpdate();
            
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Akun di tambahkan");
        }catch(SQLException e){
            try{
                JOptionPane.showMessageDialog(null, e);
                connection.rollback();
            }catch(SQLException exception){
                throw new Error_exception(e.getMessage());
            }
        }finally {
            try{
                connection.setAutoCommit(true);   
            }catch(SQLException exception){
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void updateUser(User user) throws Error_exception {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateUser);
            statement.setString(1, user.getNama());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getHak_akses());
            statement.setInt(5, user.getNik());
            statement.executeUpdate();

            connection.setAutoCommit(true);
        }catch(SQLException e){
            try{
                connection.rollback();
            }catch(SQLException exception){
            }
            throw new Error_exception(e.getMessage());
        }finally {
            try{
                connection.setAutoCommit(true);   
            }catch(SQLException exception){
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }

    @Override
    public void deleteUser(Integer nik) throws Error_exception {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteUser);
            statement.setInt(1, nik);
            statement.executeUpdate();
            connection.commit();
        }catch(SQLException e){
            try{
                connection.rollback();
            }catch(SQLException exception){
            }
            throw new Error_exception(e.getMessage());
        }finally {
            try{
                connection.setAutoCommit(true);   
            }catch(SQLException exception){
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                }
            }
        }
    }
    
    @Override
    public List<User> selectUser(String key) throws Error_exception {
        Statement statement = null;
        List<User> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM tb_akun WHERE nik LIKE '%" +key+"%' OR nama LIKE '%"+key+"%'"
                    + "OR username LIKE '%"+key+"%' OR hak_akses LIKE '%"+key+"%'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            User user = null;
            if (result.next()) {
                user = new User();
                user.setNik(result.getInt("nik"));
                user.setNama(result.getString("nama"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setHak_akses(result.getString("hak_akses"));
                list.add(user);
            } else {
                throw new Error_exception("Pengguna dengan nama " + key + " tidak ditemukan");
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Error_exception(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    @Override
    public User getUser(User user) throws Error_exception {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getByUsername);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setNama(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setHak_akses(result.getString("hak_akses"));
                if(result.getString("hak_akses").equals("Admin")){
                    Home_Admin home = new Home_Admin();
                    home.setVisible(true);
                    
                }else if(result.getString("hak_akses").equals("Gudang")){
                    Home_Gudang home = new Home_Gudang();
                    home.setVisible(true);
                }
            }else {
                    JOptionPane.showMessageDialog(null, "Akun tidak ditemukan");
                    throw new Error_exception("Akun tidak ditemukan");
                }
            connection.commit();
            return user;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Error_exception(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
    
    @Override
    public List<User> selectAllPengguna() throws Error_exception {
        Statement statement = null;
        List<User> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(getAll);

            while (result.next()) {
                User user = new User();
                user.setNik(result.getInt("nik"));
                user.setNama(result.getString("nama"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setHak_akses(result.getString("hak_akses"));
                list.add(user);
            }
            connection.commit();
            return list;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new Error_exception(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }
}
