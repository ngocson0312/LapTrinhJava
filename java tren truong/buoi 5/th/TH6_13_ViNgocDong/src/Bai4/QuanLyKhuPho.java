package Bai4;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuanLyKhuPho {
    
    public static void main(String[] args) {
//        int n = 0;
//        HoGiaDinh x[];
//        
//        System.out.print("- Nhap so ho gia dinh: ");
//        n = Integer.parseInt((new Scanner(System.in)).nextLine());
//        
//        x = new HoGiaDinh[n];
        
        DataSave data = new DataSave();
        String link = "D:\\data.txt";
        
//        nhap(x, n, data, link);
//        System.out.println("\nKET QUA DUOC IN RA");
        //xuat(x);
        
        try {
            HoGiaDinh x = (HoGiaDinh) data.docFile(link);
            x.xuat();
        } catch (Exception ex) {
            Logger.getLogger(QuanLyKhuPho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void nhap(HoGiaDinh[] x, int n, DataSave data, String link){
        for(int i = 0; i < n; i++){
            try {
                x[i] = new HoGiaDinh();
                System.out.println("* Nhap thong tin cua ho gia dinh thu " + (i + 1) + ": ");
                x[i].nhap();
                data.LuuFile(link, x[i]);
            } catch (Exception ex) {
                Logger.getLogger(QuanLyKhuPho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void xuat(HoGiaDinh[] x){
        for(int i = 0; i < x.length; i++){
            System.out.println("* Thong tin cua ho gia dinh thu " + (i + 1) + ": ");
            x[i].xuat();
        }
    }
    
    
}
