/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Error.Error_exception;
import java.sql.SQLException;
import View.Login;

/**
 *
 * @author Angga Nugraha
 */
public class Main {
    /**
     *
     * @param args
     * @throws java.sql.SQLException
     * @throws Error.Error_exception 
     */
    public static void main(String[] args) throws SQLException, Error_exception {
        Login login = new Login();
        login.setVisible(true);
    }
}
