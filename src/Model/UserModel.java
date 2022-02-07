/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Koneksi;
import Entity.User;
import Error.Error_exception;
import java.sql.SQLException;
import Service.User_DAO;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Angga Nugraha
 */
public class UserModel {
    private Integer nik;
    private String nama;
    private String username;
    private String password;
    private String hak_akses;
    
    private final User user = new User();
    
    public String tanggal(){
        java.util.Date tgl_sekarang = new java.util.Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        String tanggal = date.format(tgl_sekarang);
        return tanggal;
    }

    public Integer getNik() {
        return this.nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

//    @Override
    public String getNama() {
        return this.nama;
    }

//    @Override
    public void setNama(String nama) {
        this.nama = nama;
    }

//    @Override
    public String getUsername() {
        return this.username;
    }

//    @Override
    public void setUsername(String username) {
        this.username = username;
    }

//    @Override
    public String getPassword() {
        return this.password;
    }

//    @Override
    public void setPassword(String password) {
        this.password = password;
    }

//    @Override
    public String getHak_akses() {
        return this.hak_akses;
    }

//    @Override
    public void setHak_akses(String hak_akses) {
        this.hak_akses = hak_akses;
    }    
    
    
    public void insertUser() throws SQLException, Error_exception{
        User_DAO dao = Koneksi.getUser_Dao();
        
        user.setNik(getNik());
        user.setNama(getNama());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setHak_akses(getHak_akses());
        
        dao.insertUser(user);
    }
    
    public void updateUser() throws SQLException, Error_exception{
        User_DAO dao = Koneksi.getUser_Dao();
        
        user.setNik(getNik());
        user.setNama(getNama());
        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setHak_akses(getHak_akses());
        
        dao.updateUser(user);
    }
    
    public void deleteUser() throws SQLException, Error_exception{
        User_DAO dao = Koneksi.getUser_Dao();       
        dao.deleteUser(getNik());
    }        
    
    public void getUser(String username, String pass) throws SQLException, Error_exception{
        User_DAO dao = Koneksi.getUser_Dao();
        user.setUsername(username);
        user.setPassword(pass);

        dao.getUser(user);
    }
}
