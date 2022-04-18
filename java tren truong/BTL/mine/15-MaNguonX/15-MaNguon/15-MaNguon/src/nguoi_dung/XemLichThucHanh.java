/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguoi_dung;

import DBEngine.Database;
import static demo_chuong_trinh.DangNhap.user;
import doi_tuong.TaiKhoan;
import doi_tuong.YeuCauDangKiLichThucHanh;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author admin
 */
public class XemLichThucHanh {
    static Database db = new Database();
    static ArrayList<YeuCauDangKiLichThucHanh> DSLTH = new ArrayList<>();
    public static void XLTHBT(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n-------------LỊCH THỰC HÀNH CỦA BẢN THÂN -------------");
        YeuCauDangKiLichThucHanh.tieuDe3();
        for(int i =0 ;i<DSLTH.size();i++){
            if(DSLTH.get(i).getTrangThaiPheDuyet()==1 && user.getMaGV().equals(DSLTH.get(i).getMaGV()))
            DSLTH.get(i).inYCDK3();
        }
        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();
        
    }
    public static void XLTHCT(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n-------------LỊCH THỰC HÀNH CỦA NHÀ TRƯỜNG -------------");
        YeuCauDangKiLichThucHanh.tieuDe3();
        for(int i =0 ;i<DSLTH.size();i++){
            if(DSLTH.get(i).getTrangThaiPheDuyet()==1)
            DSLTH.get(i).inYCDK3();
        }
        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();
    }
     static public void menuXLTH(){
        try {
            DSLTH = (ArrayList<YeuCauDangKiLichThucHanh>) db.docFile("data/DSYCDK.txt");
        } catch (Exception ex) {
        }
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- XEM LỊCH THỰC HÀNH -------------");
            System.out.println("1: Xem lịch thực hành của bản thân.");
            System.out.println("2: Xem lịch thực hành của nhà trường.");
            System.out.println("3: Trở về");
            System.out.print("=> Lựa chọn của bạn là: ");
            int chon;
            try{
                chon = Integer.parseInt(scan.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }
            
            switch (chon) {
                case 1:
                    XLTHBT();
                    break;
                case 2:
                    XLTHCT();
                    break;
                case 3:
                    break;
                case 4: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
   
}
