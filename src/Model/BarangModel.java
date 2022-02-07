/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Database.Koneksi;
import Entity.Barang;
import Error.Error_exception;
import Service.Barang_DAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author Angga Nugraha
 */
public class BarangModel {
    private String jenis_barang;
    private String Kode_barang;
    private String nama_barang;
    private String suplier;
    private String tgl;
    private Integer harga;
    private Integer jumlah;
    private String no_form;

    private final Barang barang = new Barang();
    
    public String getJenis_barang() {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public String getKode_barang() {
        return Kode_barang;
    }

    public void setKode_barang(String Kode_barang) {
        this.Kode_barang = Kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getSuplier() {
        return suplier;
    }

    public void setSuplier(String suplier) {
        this.suplier = suplier;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public String getNo_form() {
        return no_form;
    }

    public void setNo_form(String no_form) {
        this.no_form = no_form;
    }


    
    
    public String tanggal(){
        java.util.Date tgl_sekarang = new java.util.Date();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault());
        String tanggal = date.format(tgl_sekarang);
        return tanggal;
    }
    
    
    public void insertBarang() throws SQLException, Error_exception{
        Barang_DAO dao = Koneksi.getBarang_Dao();
        
        barang.setJenis_barang(this.getJenis_barang());
        barang.setKode_barang(this.getKode_barang());
        barang.setNama_barang(this.getNama_barang());
        barang.setSuplier(this.getSuplier());
        barang.setTgl(this.getTgl());
        barang.setHarga(this.getHarga());
        barang.setJumlah(this.getJumlah());
        barang.setNo_form(this.getNo_form());
        
        dao.insertBarang(barang);
    }
    
    public void updateBarang() throws SQLException, Error_exception{
        Barang_DAO dao = Koneksi.getBarang_Dao();
        
        barang.setJenis_barang(this.getJenis_barang());
        barang.setKode_barang(this.getKode_barang());
        barang.setNama_barang(this.getNama_barang());
        barang.setSuplier(this.getSuplier());
        barang.setTgl(this.getTgl());
        barang.setHarga(this.getHarga());
        barang.setJumlah(this.getJumlah());
        barang.setNo_form(this.getNo_form());
        
        dao.updateBarang(barang);
    }
    
    public void deleteBarang() throws SQLException, Error_exception{
        Barang_DAO dao = Koneksi.getBarang_Dao();       
        dao.deleteBarang(this.getKode_barang());
    }   
    
    public void checkoutBarang() throws SQLException, Error_exception{
        Barang_DAO dao = Koneksi.getBarang_Dao();
        
        barang.setJenis_barang(this.getJenis_barang());
        barang.setKode_barang(this.getKode_barang());
        barang.setNama_barang(this.getNama_barang());
        barang.setSuplier(this.getSuplier());
        barang.setTgl(this.getTgl());
        barang.setHarga(this.getHarga());
        barang.setJumlah(this.getJumlah());
        barang.setNo_form(this.getNo_form());
        
        dao.checkoutBarang(barang, this.getJumlah());
    }
}
