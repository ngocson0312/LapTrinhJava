/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quan_tri_he_thong.BaoTri;

import DBEngine.Database;
import doi_tuong.PhongThucHanh;
import java.io.File;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

/**
 *
 * @author DatLuu
 */
public class BaoTri {
    public static ArrayList<PhongThucHanh> list = new ArrayList<PhongThucHanh>();
    static Database data = new Database();
    static String linkPTH = "data/pth.txt";
    
    public static void menuBaoTri(){
        
         if((new File(linkPTH).exists())){
           
             try {
                 list = (ArrayList<PhongThucHanh>) data.docFile(linkPTH);
             } catch (Exception ex) {
                 java.util.logging.Logger.getLogger(BaoTri.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
           while(true){
            System.out.println("\n------------- Bảo Trì -------------");
            System.out.println("1: Bảo trì lịch thực hành.");
            System.out.println("2: Bảo trì phòng thực hành .");
            System.out.println("3: Quay lại");
            System.out.print("=> Lựa chọn của bạn là: ");
            Scanner sc = new Scanner(System.in);
            int chon;
            try{
                chon = Integer.parseInt(sc.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }            
            switch (chon) {
                case 1:
                    BaoTriLichThucHanh.menuBaoTri2();
                    break;
                case 2:
                    BaoTriPhongThucHanh.menuBaoTri3();
                    break;
                case 3: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    sc.nextLine();
            }
        }   
    }
}
