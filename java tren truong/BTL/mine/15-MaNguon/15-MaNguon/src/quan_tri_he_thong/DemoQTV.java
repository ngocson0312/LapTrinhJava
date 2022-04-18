package quan_tri_he_thong;

import doi_tuong.Quyen;
import doi_tuong.TaiKhoan;
import java.util.Scanner;
import quan_tri_he_thong.BaoTri.BaoTri;
import quan_tri_he_thong.lich_su_he_thong.LichSuHeThong;
import quan_tri_he_thong.quan_ly.QuanLy;

/**
 *
 * @author VND
 */

public class DemoQTV {
    static public Scanner scan = new Scanner(System.in);
 
    static public void menuQTV(){
        
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN TRỊ HỆ THỐNG -------------");
            System.out.println("1: Quản lý.");
            System.out.println("2: Bảo trì.");
            System.out.println("3: Xem lịch sử hệ thống.");
            System.out.println("4: Đăng xuất.");
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
                    QuanLy.menuQuanLy();
                    break;
                case 2:
                    BaoTri.menuBaoTri();
                    break;
                case 3:
                    LichSuHeThong.hienThi();
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
