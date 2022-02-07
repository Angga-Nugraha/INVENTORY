/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Error;

/**
 *
 * @author Angga Nugraha
 */
public class Error_exception extends Exception{
/**
 * Creates a new instance of <code>PenggunaException</code> without detail
 * message.
 */
    public Error_exception(){};
    
/**
 * @param msg;
 */         
    public Error_exception(String msg){
        super(msg);
    }
}
