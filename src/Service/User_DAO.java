/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Entity.User;
import Error.Error_exception;
import java.util.List;

/**
 *
 * @author Angga Nugraha
 */
public interface User_DAO {
    public void insertUser(User user) throws Error_exception;
    public void updateUser(User user) throws Error_exception;
    public void deleteUser(Integer nik) throws Error_exception;
    public User getUser(User user) throws Error_exception;
    public List<User> selectAllPengguna() throws Error_exception;
    public List<User> selectUser(String cari) throws Error_exception;
}
