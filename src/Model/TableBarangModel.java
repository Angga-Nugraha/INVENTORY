/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Entity.Barang;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Angga Nugraha
 */
public class TableBarangModel extends AbstractTableModel{

    private List <Barang> list = new ArrayList<>();
    
    public void setList(List<Barang> list){
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "Jenis Barang";
            case 1 -> "Kode Barang";
            case 2 -> "Nama Barang";
            case 3 -> "Suplier";
            case 4 -> "Tanggal Masuk";
            case 5 -> "Harga";
            case 6 -> "Jumlah";
            case 7 -> "No_form";
            
            default -> null;
        };
    }
    
    @Override
    public int getRowCount() {
         return list.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getJenis_barang();
            case 1 -> list.get(rowIndex).getKode_barang();
            case 2 -> list.get(rowIndex).getNama_barang();
            case 3 -> list.get(rowIndex).getSuplier();
            case 4 -> list.get(rowIndex).getTgl();
            case 5 -> list.get(rowIndex).getHarga();
            case 6 -> list.get(rowIndex).getJumlah();
            case 7 -> list.get(rowIndex).getNo_form();
            default -> null;
        };
    }
    
}
