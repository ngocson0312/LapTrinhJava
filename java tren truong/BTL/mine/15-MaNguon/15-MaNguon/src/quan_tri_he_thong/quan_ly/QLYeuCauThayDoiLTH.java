package quan_tri_he_thong.quan_ly;

import doi_tuong.YeuCauDangKiLichThucHanh;
import doi_tuong.YeuCauThayDoiLichThucHanh;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.quan_ly.QuanLy.db;
import static quan_tri_he_thong.quan_ly.QuanLy.dsYCTD;
import static quan_tri_he_thong.quan_ly.QuanLy.linkYCTD;
import static quan_tri_he_thong.DemoQTV.scan;
import static quan_tri_he_thong.quan_ly.QuanLy.dsYCDK;
import static quan_tri_he_thong.quan_ly.QuanLy.linkYCDK;

/**
 *
 * @author VND
 */

public class QLYeuCauThayDoiLTH {
    //Xây dựng menu
    public static void menuYCDK(){
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN LÝ YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH -------------");
            System.out.println("1: Danh sách các yêu cầu thay đổi lịch thực hành chờ phê duyệt.");
            System.out.println("2: Xem danh sách các yêu cầu thay đổi lịch thực hành đã phê duyệt gần đây.");
            System.out.println("3: Tìm kiếm yêu cầu thay đổi lịch thực hành.");
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
                    taskDSYCTD();
                    break;
                case 2:
                    taskDSTDDPD();
                    break;
                case 3:
                    taskTKYCTD();
                    break;
                case 4: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
    
    // Xây dựng chức năng ds yêu cầu thay đổi lịch thực hành
    
    // in dữ liệu chưa phê duyệt
    public static void inYCCPD(){
        // In tiêu đề
        YeuCauThayDoiLichThucHanh.tieuDe1();
        
        // In dữ liệu
        int stt = 0;
        for(YeuCauThayDoiLichThucHanh i : dsYCTD)
            if(i.getTrangThaiPheDuyet() == 3)
                i.inYCDK1(++stt);
    }
    
    // in dữ liệu chưa phê duyệt chi tiết
    public static void inYCCPDChiTiet(int index){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- CHI TIẾT YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH -------------");
            
        boolean a = false, b = false, c = true, d = false;
        
        if(dsYCTD.get(index).getLTH().getMaCaThucHanh() != dsYCTD.get(index).getMaCaTHmoi())
            a = true;
        if(!dsYCTD.get(index).getLTH().getMaPhongThucHanh().equals(dsYCTD.get(index).getMaPTHmoi()))
            b = true;
        if(!dsYCTD.get(index).getLTH().getNgayBatDau().equals(dsYCTD.get(index).getNgayTHmoi()))
            c = true;
        if(dsYCTD.get(index).getLTH().getSoTuan() != dsYCTD.get(index).getSoTuan())
            d = true;
        
        System.out.println("\n=> Các thông tin yêu cầu thay đổi trên lịch thực hành: ");
        // In tiêu đề
        YeuCauThayDoiLichThucHanh.tieuDe2(a, b, c, d);
        
        // In dữ liệu
        dsYCTD.get(index).inYCDK2(a, b, c, d);
        
        System.out.println("\n=> Chi tiết lịch thực hành cũ: ");
        YeuCauDangKiLichThucHanh.tieuDe3();
        dsYCTD.get(index).getLTH().inYCDK3();
    }
    
    
    
    // in dữ liệu đã phê duyệt
    public static void inYCDPD(){
        // In tiêu đề
        YeuCauThayDoiLichThucHanh.tieuDe3();
        
        // In dữ liệu
        int stt = 0;
        for(YeuCauThayDoiLichThucHanh i : dsYCTD)
            if(i.getTrangThaiPheDuyet() != 3)
                i.inYCDK3(++stt);
    }
//    
    
    
    
    // Xây dựng chi tiết chức năng
    public static void taskDSYCTD(){    
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- DANH SÁCH YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH CHỜ PHÊ DUYỆT -------------");
            
            if(!existYCChuaDuyet()){
                System.out.println("\n=> Đã duyệt hết toàn bộ yêu cầu thay đổi lịch thực hành rồi!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
                return;
            }
            
            inYCCPD();
            
            System.out.print("\n=> Lựa chọn 1 mã yêu cầu cần làm việc: ");
            String ma = scan.nextLine();

            int index = existYC(ma);
            
            if(index != -1){
                
                inYCCPDChiTiet(index);
                
                // In các chức năng thao tác với dữ liệu
                System.out.println("\n- Thực hiện thao tác với dữ liệu:");
                System.out.println("1: Phê duyệt.");
                System.out.println("2: Trở về.");
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
                        pheDuyet(index);
                        break;
                    case 2:
                        return;
                    default:
                        System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                        System.out.println("=> Enter để tiếp tục!");
                        scan.nextLine();
                }
            }
            else{
                System.out.println("\n=> Mã yêu cầu phê duyệt không tồn tại!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
            }
        }
           
    }
    
    // xây dựng chức năng phê duyệt yêu cầu
    public static void pheDuyet(int index){
        while(true){
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
                            dsYCTD.get(index).setTrangThaiPheDuyet(1);
                            //Set lại dữ liệu cho lịch thực hành sau khi chấp thuận thay đổi
                            int i = viTri(dsYCTD.get(index).getLTH().getMaYCDK());
                            dsYCDK.get(i).setMaCaThucHanh(dsYCTD.get(index).getMaCaTHmoi());
                            dsYCDK.get(i).setMaPhongThucHanh(dsYCTD.get(index).getMaPTHmoi());
                            dsYCDK.get(i).setNgayBatDau(dsYCTD.get(index).getNgayTHmoi());
                            dsYCDK.get(i).setSoTuan(dsYCTD.get(index).getSoTuan());
                                
                            System.out.println("\n=> Phê duyệt thành công! Dữ liệu được cập nhật vào hệ thống.");
                            System.out.println("=> Enter để tiếp tục!");
                            scan.nextLine();
                            break;

                        case 2:
                            dsYCTD.get(index).setTrangThaiPheDuyet(2);
                            System.out.print("\n=> Nhập lý do (không nên bỏ trống lý do): ");
                            dsYCTD.get(index).setGhiChu(scan.nextLine());
                            
                            
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
                db.LuuFile(linkYCTD, dsYCTD);
                db.LuuFile(linkYCDK, dsYCDK);
            } catch (Exception ex) {
                Logger.getLogger(QLYeuCauThayDoiLTH.class.getName()).log(Level.SEVERE, null, ex);
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
    
    //Xác định vị trí của Lich thực hành
    public static int viTri(String ma){
        for(YeuCauDangKiLichThucHanh i : dsYCDK)
            if(i.getMaYCDK().equals(ma))
                return dsYCDK.indexOf(i);
        return -1;
    }
    
    
  
// Xây dựng chức năng ds yêu cầu đã phê duyệt
    public static void taskDSTDDPD(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- XEM DANH SÁCH YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH ĐÃ PHÊ DUYỆT -------------");

        if(!existYCDaDuyet()){
            System.out.println("\n=> không có yêu cầu đăng ký nào được phê duyệt gần đây!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
            return;
        }

        inYCDPD();
        
        System.out.print("\n=> Lựa chọn 1 mã yêu cầu để xem chi tiết: ");
        String ma = scan.nextLine();

        int index = existYC(ma);

        if(index != -1){
            inYCCPDChiTiet(index);
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
        else{
            System.out.println("\n=> Mã yêu cầu phê duyệt không tồn tại!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
         
    } //end
    
// Xây dựng chức năng tìm kiếm yêu cầu và cho phép duyệt luôn nếu yêu cầu đó chưa được duyệt
    public static void taskTKYCTD(){
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- TÌM KIẾM YÊU CẦU THAY ĐỔI LỊCH THỰC HÀNH -------------");
            
            System.out.print("\n=> Hãy nhập 1 mã yêu cầu cần tìm kiếm: ");
            String ma = scan.nextLine();

            int index = existYC(ma);
            int tt = -1;
            
            
            if(index != -1){
                System.out.println("\n=> Kết quả tìm kiếm: ");
                inYCCPDChiTiet(index);
                
                if(dsYCTD.get(index).getTrangThaiPheDuyet() == 3){
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
                                dsYCTD.get(index).setTrangThaiPheDuyet(1);

                                System.out.println("\n=> Phê duyệt thành công!");
                                System.out.println("=> Enter để tiếp tục!");
                                scan.nextLine();
                                break;
                            case 2:
                                dsYCTD.get(index).setTrangThaiPheDuyet(2);
                                System.out.print("\n=> Nhập lý do (không nên bỏ trống lý do): ");
                                dsYCTD.get(index).setGhiChu(scan.nextLine());

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
                db.LuuFile(linkYCTD, dsYCTD);
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
        for(YeuCauThayDoiLichThucHanh i : dsYCTD)
            if(ma.equals(i.getMaYCTD()))
                return dsYCTD.indexOf(i);
        return -1;
    }
    
    // Kiểm tra xem còn yêu cầu nào chưa duyệt hay không 
    public static boolean existYCChuaDuyet(){
        for(YeuCauThayDoiLichThucHanh i : dsYCTD)
            if(i.getTrangThaiPheDuyet() == 3)
                return true;
        return false;
    }
    
    // Kiểm tra xem có yêu cầu nào được duyệt hay không 
    public static boolean existYCDaDuyet(){
        for(YeuCauThayDoiLichThucHanh i : dsYCTD)
            if(i.getTrangThaiPheDuyet() != 3)
                return true;
        return false;
    }
    
}
