/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Entity.Barang;
import Error.Error_exception;
import java.util.List;

/**
 *
 * @author Angga Nugraha
 */
public interface Barang_DAO {
    public void insertBarang(Barang barang) throws Error_exception;
    public void updateBarang(Barang barang) throws Error_exception;
    public void deleteBarang(String kode_brg) throws Error_exception;
    public void checkoutBarang(Barang barang, Integer jumlah) throws Error_exception;
    public List <Barang> selectAllbarang() throws Error_exception;
    public List<Barang> selectAllbarang2() throws Error_exception;
    public List<Barang> selectBarang(String key) throws Error_exception;
    
}
