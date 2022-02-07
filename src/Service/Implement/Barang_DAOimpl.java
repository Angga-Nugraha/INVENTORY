/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.Implement;

import Entity.Barang;
import Error.Error_exception;
import Service.Barang_DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Angga Nugraha
 */
public class Barang_DAOimpl implements Barang_DAO{
    private final Connection connection;
    
    private final String insertBarang = "INSERT INTO tb_barang (jenis_brg, kode_brg, nama_brg, suplier, tgl, harga, qty, no_form) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String updateBarang = "UPDATE tb_barang SET jenis_brg = ?, nama_brg = ?, suplier = ?, tgl = ?, harga = ?, qty = ?, no_form = ? WHERE kode_brg = ?";
    private final String deleteBarang = "DELETE FROM tb_barang WHERE kode_brg = ?";
    private final String getAll = "SELECT * FROM tb_barang";
    private final String getAll2 = "SELECT * FROM tb_brgout";
    private final String checkout = "INSERT INTO tb_brgout (jenis, kode, nama, suplier, tgl, harga, jumlah, no_form) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
    
    public Barang_DAOimpl(Connection connection){
        this.connection = connection;
    }
    
    @Override
    public void insertBarang(Barang barang) throws Error_exception{
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertBarang);
            statement.setString(1, barang.getJenis_barang());
            statement.setString(2, barang.getKode_barang());
            statement.setString(3, barang.getNama_barang());
            statement.setString(4, barang.getSuplier());
            statement.setString(5, barang.getTgl());
            statement.setInt(6, barang.getHarga());
            statement.setInt(7, barang.getJumlah());
            statement.setString(8, barang.getNo_form());
            statement.executeUpdate();
            
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Barang di tambahkan");
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
    public void updateBarang(Barang barang) throws Error_exception{
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updateBarang);
            statement.setString(1, barang.getJenis_barang());
            statement.setString(2, barang.getNama_barang());
            statement.setString(3, barang.getSuplier());
            statement.setString(4, barang.getTgl());
            statement.setInt(5, barang.getHarga());
            statement.setInt(6, barang.getJumlah());
            statement.setString(7, barang.getNo_form());
            statement.setString(8, barang.getKode_barang());
            statement.executeUpdate();
            
            connection.setAutoCommit(true);
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
    public void deleteBarang(String kode_brg) throws Error_exception {
        PreparedStatement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deleteBarang);
            statement.setString(1, kode_brg);
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
    public void checkoutBarang(Barang barang, Integer jumlah) throws Error_exception{
        PreparedStatement statement = null;
        try{            
            connection.setAutoCommit(false);            
            statement = connection.prepareStatement(checkout);
            statement.setString(1, barang.getJenis_barang());
            statement.setString(2, barang.getKode_barang());
            statement.setString(3, barang.getNama_barang());
            statement.setString(4, barang.getSuplier());
            statement.setString(5, barang.getTgl());
            statement.setInt(6, barang.getHarga());
            statement.setInt(7, barang.getJumlah());
            statement.setString(8, barang.getNo_form());
            statement.executeUpdate();
            
            connection.setAutoCommit(true);
            JOptionPane.showMessageDialog(null, "Barang di tambahkan");
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
    public List<Barang> selectAllbarang() throws Error_exception {
        Statement statement = null;
        List<Barang> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(getAll);

            while (result.next()) {
                Barang barang = new Barang();
                barang.setJenis_barang(result.getString("jenis_brg"));
                barang.setKode_barang(result.getString("kode_brg"));
                barang.setNama_barang(result.getString("nama_brg"));
                barang.setSuplier(result.getString("suplier"));
                barang.setTgl(result.getString("tgl"));
                barang.setHarga(result.getInt("harga"));
                barang.setJumlah(result.getInt("qty"));
                barang.setNo_form(result.getString("no_form"));
                list.add(barang);
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
    public List<Barang> selectAllbarang2() throws Error_exception {
        Statement statement = null;
        List<Barang> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(getAll2);

            while (result.next()) {
                Barang barang = new Barang();
                barang.setJenis_barang(result.getString("jenis"));
                barang.setKode_barang(result.getString("kode"));
                barang.setNama_barang(result.getString("nama"));
                barang.setSuplier(result.getString("suplier"));
                barang.setTgl(result.getString("tgl"));
                barang.setHarga(result.getInt("harga"));
                barang.setJumlah(result.getInt("jumlah"));
                barang.setNo_form(result.getString("no_form"));
                list.add(barang);
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
    public List<Barang> selectBarang(String key) throws Error_exception {
        Statement statement = null;
        List<Barang> list = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            String sql = "SELECT * FROM tb_barang WHERE nama_brg LIKE '%" +key+"%' OR kode_brg LIKE '%"+key+"%'"
                    + "OR suplier LIKE '%"+key+"%' OR jenis_brg LIKE '%"+key+"%'";
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            Barang barang = null;
            if (result.next()) {
                barang = new Barang();
                barang.setJenis_barang(result.getString("jenis_brg"));
                barang.setKode_barang(result.getString("kode_brg"));
                barang.setNama_barang(result.getString("nama_brg"));
                barang.setSuplier(result.getString("suplier"));
                barang.setTgl(result.getString("tgl"));
                barang.setHarga(result.getInt("harga"));
                barang.setJumlah(result.getInt("qty"));
                barang.setNo_form(result.getString("no_form"));
                list.add(barang);
            }else{
                throw new Error_exception("Barang dengan nama " + key + " tidak ditemukan");
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
