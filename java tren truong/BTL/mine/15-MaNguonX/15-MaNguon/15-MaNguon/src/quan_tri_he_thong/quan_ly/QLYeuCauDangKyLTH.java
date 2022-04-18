package quan_tri_he_thong.quan_ly;

import doi_tuong.TaiKhoan;
import doi_tuong.YeuCauDangKiLichThucHanh;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.quan_ly.QuanLy.db;
import static quan_tri_he_thong.quan_ly.QuanLy.dsYCDK;
import static quan_tri_he_thong.quan_ly.QuanLy.linkYCDK;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author VND
 */

public class QLYeuCauDangKyLTH {
    
    
    //Xây dựng menu
    public static void menuYCDK(){
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN LÝ YÊU CẦU ĐĂNG KÝ LỊCH THỰC HÀNH -------------");
            System.out.println("1: Danh sách các yêu cầu đăng ký lịch thực hành chờ phê duyệt.");
            System.out.println("2: Xem danh sách các lịch thực hành đã phê duyệt gần đây.");
            System.out.println("3: Tìm kiếm yêu cầu đăng ký lịch thực hành.");
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
                    taskDSYCDK();
                    break;
                case 2:
                    taskDSDPD();
                    break;
                case 3:
                    taskTKYC();
                    break;
                case 4: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
    
    
// Xây dựng chức năng ds yêu cầu đăng ký lịch thực hành
    
    // in dữ liệu chưa phê duyệt
    public static void inYCCPD(){
        
        
        // In tiêu đều
        YeuCauDangKiLichThucHanh.tieuDe1();
        
        // In dữ liệu
        int stt = 0;
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getTrangThaiPheDuyet() == 3)
                i.inYCDK1(++stt);
    }
    
    // in dữ liệu đã phê duyệt
    public static void inYCDPD(){
        // In tiêu đều
        YeuCauDangKiLichThucHanh.tieuDe2();
        
        // In dữ liệu
        int stt = 0;
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getTrangThaiPheDuyet() != 3)
                i.inYCDK2(++stt);
    }
    
    // Xây dựng chi tiết chức năng
    public static void taskDSYCDK(){    
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- DANH SÁCH YÊU CẦU ĐĂNG KÝ LỊCH THỰC HÀNH CHỜ PHÊ DUYỆT -------------");
            
            if(!existYCChuaDuyet()){
                System.out.println("\n=> Đã duyệt hết toàn bộ yêu cầu đăng ký lịch thực hành rồi!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
                return;
            }
            
            inYCCPD();
            
            // In các chức năng thao tác với dữ liệu
            System.out.println("\n- Thực hiện thao tác với dữ liệu:");
            System.out.println("1: Phê duyệt các yêu cầu đăng ký.");
            System.out.println("2: Chấp thuận toàn bộ yêu cầu đăng ký.");
            System.out.println("3: Trở về.");
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
                    pheDuyet();
                    break;
                case 2:
                    pheDuyetAll();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
           
    }
    
    // xây dựng chức năng phê duyệt yêu cầu
    public static void pheDuyet(){
        while(true){
            System.out.print("\n=> Hãy nhập 1 mã yêu cầu cần phê duyệt: ");
            String ma = scan.nextLine();

            int index = existYC(ma);
            int tt = -1;
            
            
            if(index != -1){
                while(tt != 1 && tt != 2){
                    System.out.print("\n=> Nhập trạng thái phê duyệt (1: Chấp thuận, 2: không chấp thuận): ");

                    try{
                        tt = Integer.parseInt(scan.nextLine());
                    }
                    catch (Exception err){
                        tt = -1;
                    } 

                    switch(tt){
                        case 1:
                            dsYCDK.get(index).setTrangThaiPheDuyet(1);
                            
                            System.out.println("\n=> Phê duyệt thành công!");
                            System.out.println("=> Enter để tiếp tục!");
                            scan.nextLine();
                            break;
                        case 2:
                            dsYCDK.get(index).setTrangThaiPheDuyet(2);
                            System.out.print("\n=> Nhập lý do (không nên bỏ trống lý do): ");
                            dsYCDK.get(index).setGhiChu(scan.nextLine());
                            
                            System.out.println("\n=> Phê duyệt thành công!");
                            System.out.println("=> Enter để tiếp tục!");
                            scan.nextLine();
                            break;
                        default:
                            System.out.println("\n=> Lựa chọn trạng thái phê duyệt chưa chính xác. Vui lòng thử lại!");
                            System.out.println("=> Enter để tiếp tục!");
                            scan.nextLine();
                    }
                } 
            }
            else{
                System.out.println("\n=> Mã yêu cầu phê duyệt không tồn tại!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
            }
            
            try {
                db.LuuFile(linkYCDK, dsYCDK);
            } catch (Exception ex) {
                Logger.getLogger(QLYeuCauDangKyLTH.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Hỏi xem còn phê duyệt tiếp không
            if(dsYCDK.size() != 0){
                System.out.print("\n=> Tiếp tục phê duyệt? (1: có, bất kỳ: không): ");
                int chon;
                try{
                    chon = Integer.parseInt(scan.nextLine());
                }
                catch(Exception err){
                    chon = -1;
                }

                if(chon != 1)
                    return;
            }
            else
                return;
        }
    }
    
    // Xây dựng chức năng phê duyệt toàn bộ
    public static void pheDuyetAll(){
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getTrangThaiPheDuyet() == 3)
                i.setTrangThaiPheDuyet(1);
        
        System.out.println("\n=> Phê duyệt toàn bộ yêu cầu thành công!");
        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();
    } //end
  
// Xây dựng chức năng ds yêu cầu đã phê duyệt
    public static void taskDSDPD(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- XEM DANH SÁCH YÊU CẦU ĐĂNG KÝ LỊCH THỰC HÀNH ĐÃ PHÊ DUYỆT -------------");

        if(!existYCDaDuyet()){
            System.out.println("\n=> không có yêu cầu đăng ký nào được phê duyệt gần đây!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
            return;
        }

        inYCDPD();

        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();         
    } //end
    
// Xây dựng chức năng tìm kiếm yêu cầu và cho phép duyệt luôn nếu yêu cầu đó chưa được duyệt
    public static void taskTKYC(){
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- TÌM KIẾM YÊU CẦU ĐĂNG KÝ LỊCH THỰC HÀNH -------------");
            
            System.out.print("\n=> Hãy nhập 1 mã yêu cầu cần tìm kiếm: ");
            String ma = scan.nextLine();

            int index = existYC(ma);
            int tt = -1;
            
            
            if(index != -1){
                System.out.println("\n=> Kết quả tìm kiếm: ");
                YeuCauDangKiLichThucHanh.tieuDe2();
                dsYCDK.get(index).inYCDK2(1);
                
                if(dsYCDK.get(index).getTrangThaiPheDuyet() == 3){
                    // Hỏi xem còn phê duyệt tiếp không
                    System.out.print("\n=> Có phê duyệt luôn hay không? (1: có, bất kỳ: không): ");
                    int chon;
                    try{
                        chon = Integer.parseInt(scan.nextLine());
                    }
                    catch(Exception err){
                        chon = -1;
                    }

                    if(chon != 1)
                        return;

                    while(tt != 1 && tt != 2){
                        System.out.print("\n=> Nhập trạng thái phê duyệt (1: Chấp thuận, 2: không chấp thuận): ");

                        try{
                            tt = Integer.parseInt(scan.nextLine());
                        }
                        catch (Exception err){
                            tt = -1;
                        } 

                        switch(tt){
                            case 1:
                                dsYCDK.get(index).setTrangThaiPheDuyet(1);

                                System.out.println("\n=> Phê duyệt thành công!");
                                System.out.println("=> Enter để tiếp tục!");
                                scan.nextLine();
                                break;
                            case 2:
                                dsYCDK.get(index).setTrangThaiPheDuyet(2);
                                System.out.print("\n=> Nhập lý do (không nên bỏ trống lý do): ");
                                dsYCDK.get(index).setGhiChu(scan.nextLine());

                                System.out.println("\n=> Phê duyệt thành công!");
                                System.out.println("=> Enter để tiếp tục!");
                                scan.nextLine();
                                break;
                            default:
                                System.out.println("\n=> Lựa chọn trạng thái phê duyệt chưa chính xác. Vui lòng thử lại!");
                                System.out.println("=> Enter để tiếp tục!");
                                scan.nextLine();
                        }
                    } 
                }
            }
            else{
                System.out.println("\n=> Mã yêu cầu không tồn tại!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
            }
            
            try {
                db.LuuFile(linkYCDK, dsYCDK);
            } catch (Exception ex) {
                Logger.getLogger(QLYeuCauDangKyLTH.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Hỏi xem còn phê duyệt tiếp không
            System.out.print("\n=> Tiếp tục tìm kiếm? (1: có, bất kỳ: không): ");
            int chon;
            try{
                chon = Integer.parseInt(scan.nextLine());
            }
            catch(Exception err){
                chon = -1;
            }
            
            if(chon != 1)
                return;
            }
 
    }
    
    // Kiểm tra sự tồn tại của yêu cầu trong danh sách.
    public static int existYC(String ma){
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(ma.equals(i.getMaYCDK()))
                return dsYCDK.indexOf(i);
        return -1;
    }
    
    // Kiểm tra xem còn yêu cầu đăng ký nào chưa duyệt hay không 
    public static boolean existYCChuaDuyet(){
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getTrangThaiPheDuyet() == 3)
                return true;
        return false;
    }
    
    // Kiểm tra xem có yêu cầu đăng ký nào được duyệt hay không 
    public static boolean existYCDaDuyet(){
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getTrangThaiPheDuyet() != 3)
                return true;
        return false;
    }
    
}
