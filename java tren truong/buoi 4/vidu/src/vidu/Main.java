/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vidu;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VND
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static String fileName = "src/vidu/SinhVien.txt";
    static DBEngine db = new DBEngine();
    
    public static void main(String[] args) {
        SinhVien x = new SinhVien();
        x.nhap();
        System.out.println(x);
        try {
            db.LuuFile(fileName, x);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //doc
        try {
            x = (SinhVien) db.docFile(fileName);
            System.out.println(x);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
