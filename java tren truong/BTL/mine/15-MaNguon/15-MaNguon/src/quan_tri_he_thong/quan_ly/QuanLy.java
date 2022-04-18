package quan_tri_he_thong.quan_ly;

import DBEngine.Database;
import doi_tuong.Date;
import doi_tuong.TaiKhoan;
import doi_tuong.YeuCauDangKiLichThucHanh;
import doi_tuong.YeuCauThayDoiLichThucHanh;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author VND
 */

public class QuanLy {
    
    static Database db = new Database();
    static ArrayList<YeuCauDangKiLichThucHanh> dsYCDK = new ArrayList<>();
    static ArrayList<YeuCauThayDoiLichThucHanh> dsYCTD = new ArrayList<>();
    static ArrayList<TaiKhoan> dsTK = new ArrayList<>();
    static int autoIDTK = 0;
    static String linkYCDK = "data/DSYCDK.txt";
    static String linkYCTD = "data/DSYCTD.txt";
    static String linkTK = "data/DSTK.txt";
    static String linkIDTK = "data/IDTK.txt";
    
    
    
    public static void menuQuanLy(){
        docData();

        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- MENU QUẢN LÝ -------------");
            System.out.println("1: Quản lý các yêu cầu đăng ký lịch thực hành.");
            System.out.println("2: Quản lý các yêu cầu thay đổi lịch thực hành.");
            System.out.println("3: Quản lý tài khoản.");
            System.out.println("4: Trở về.");
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
                    QLYeuCauDangKyLTH.menuYCDK();
                    break;
                case 2:
                    QLYeuCauThayDoiLTH.menuYCDK();
                    break;
                case 3:
                    QLTaiKhoan.menuQLTK();
                    break;
                case 4: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
    
    public static void docData(){
        // Đọc dữ liệu trong hệ thống
        try {
            dsYCDK = (ArrayList<YeuCauDangKiLichThucHanh>) db.docFile(linkYCDK);
        } catch (Exception ex) {
            System.err.println("- k đọc được dữ liệu.");
        }
            
        try {
            dsYCTD = (ArrayList<YeuCauThayDoiLichThucHanh>) db.docFile(linkYCTD);
        } catch (Exception ex) {
            System.err.println("- k đọc được dữ liệu.");
        }
        try {
            dsTK =  (ArrayList<TaiKhoan>) db.docFile(linkTK);
        } catch (Exception ex) {
            System.err.println("- k đọc được dữ liệu.");
        }
        try {
            autoIDTK = (int) db.docFile(linkIDTK);
        } catch (Exception ex) {
            System.err.println("- k đọc được dữ liệu.");
        }
    }
    
}
