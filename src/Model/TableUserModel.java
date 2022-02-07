/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */ 
package Model;

import Entity.User;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Angga Nugraha
 */
public class TableUserModel extends AbstractTableModel{
    private List<User> list = new ArrayList<>();
    
    public void setList(List<User> list) {
        this.list = list;
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "NIK";
            case 1 -> "Nama";
            case 2 -> "Username";
            case 3 -> "Password";
            case 4 -> "Hak Akses";
            default -> null;
        };
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> list.get(rowIndex).getNik();
            case 1 -> list.get(rowIndex).getNama();
            case 2 -> list.get(rowIndex).getUsername();
            case 3 -> list.get(rowIndex).getPassword();
            case 4 -> list.get(rowIndex).getHak_akses();
            default -> null;
        };
    }
}
