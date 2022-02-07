/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Objects;

/**
 *
 * @author Angga Nugraha
 */
public class Barang {
    private String jenis_barang;
    private String Kode_barang;
    private String nama_barang;
    private String suplier;
    private String tgl;
    private Integer harga;
    private Integer jumlah;
    private String no_form;
    
    public Barang(){}

    public void setJenis_barang(String jenis_barang) {
        this.jenis_barang = jenis_barang;
    }

    public void setKode_barang(String Kode_barang) {
        this.Kode_barang = Kode_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public void setSuplier(String suplier) {
        this.suplier = suplier;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public void setNo_form(String no_form) {
        this.no_form = no_form;
    }

    public String getJenis_barang() {
        return jenis_barang;
    }

    public String getKode_barang() {
        return Kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public String getSuplier() {
        return suplier;
    }

    public String getTgl() {
        return tgl;
    }

    public Integer getHarga() {
        return harga;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public String getNo_form() {
        return no_form;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barang other = (Barang) obj;
        if (!Objects.equals(this.jenis_barang, other.jenis_barang)) {
            return false;
        }
        if (!Objects.equals(this.Kode_barang, other.Kode_barang)) {
            return false;
        }
        if (!Objects.equals(this.nama_barang, other.nama_barang)) {
            return false;
        }
        if (!Objects.equals(this.suplier, other.suplier)) {
            return false;
        }
        if (!Objects.equals(this.tgl, other.tgl)) {
            return false;
        }
        if (!Objects.equals(this.no_form, other.no_form)) {
            return false;
        }
        if (!Objects.equals(this.harga, other.harga)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        return true;
    }
    
    
}
