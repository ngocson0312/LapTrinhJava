package quan_tri_he_thong.quan_ly;

import static demo_chuong_trinh.DangNhap.user;
import doi_tuong.Quyen;
import doi_tuong.TaiKhoan;
import java.util.logging.Level;
import java.util.logging.Logger;
import static quan_tri_he_thong.quan_ly.QuanLy.autoIDTK;
import static quan_tri_he_thong.quan_ly.QuanLy.db;
import static quan_tri_he_thong.quan_ly.QuanLy.dsTK;
import static quan_tri_he_thong.quan_ly.QuanLy.linkTK;
import static quan_tri_he_thong.DemoQTV.scan;

/**
 *
 * @author VND
 */

public class QLTaiKhoan {
 
    public static void menuQLTK(){
        
        
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN LÝ TÀI KHOẢN -------------");
            System.out.println("1: Quản lý tài khoản giáo viên.");
            System.out.println("2: Quản lý tài khoản quản trị viên.");
            System.out.println("3: Trở về.");
//            System.out.println("4: Tạo tài khoản trưởng khoa."); //Bị ẩn khỏi hệ thống
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
                    taskQLTKGV();
                    break;
                case 2:
                    taskQLTKQTV();
                    break;
                case 3: return;
//                case 4: them(3); break; //Bị ẩn khỏi hệ thống
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
    
//Xây dựng chức năng quản trị tài khoản giáo viên
    public static void taskQLTKGV(){
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN LÝ TÀI KHOẢN GIÁO VIÊN -------------");
            System.out.println("1: Thêm.");
            System.out.println("2: Sửa.");
            System.out.println("3: Xóa.");
            System.out.println("4: Xem danh sách tài khoản giáo viên.");
            System.out.println("5: Trở về.");
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
                    them(1);
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xem(1);
                    break;
                case 5: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
    
    
    
    //Xây dựng chức năng thêm tài khoản giáo viên
    public static void them(int loai){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- THÊM TÀI KHOẢN -------------");
        // Tự động sinh một tài khoản bao gồm ID, Tên tài khỏa, Mật khẩu, Trạng thái
        // CÁc thông tin khác người dùng sẽ dùng chức năng "cá nhân" để thêm thông tin bản thân lên hệ thống
        if(loai == 1){
            TaiKhoan newTKGV = new TaiKhoan(true, autoIDTK);
            System.out.println("\n=> Tạo thành công 1 tài khoản giáo viên!\nTên tài khoản: " +
                    newTKGV.getTenTaiKhoan() + ", Mật khẩu: " + newTKGV.getMatKhau());
            

            dsTK.add(newTKGV);
            autoIDTK++;
            // Lưu lại list sau khi thêm
            try {
                db.LuuFile(linkTK, dsTK);
                db.LuuFile(QuanLy.linkIDTK, autoIDTK);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        else if(loai == 2){
            TaiKhoan newTKQTV = new TaiKhoan(true, new Quyen(2, "Quản trị viên", "Thực hiện quản trị hệ thống"),autoIDTK);
            System.out.println("\n=> Tạo thành công 1 tài khoản quản trị viên!\nTên tài khoản: " +
                    newTKQTV.getTenTaiKhoan() + ", Mật khẩu: " + newTKQTV.getMatKhau());

            dsTK.add(newTKQTV);
            autoIDTK++;
            // Lưu lại list sau khi thêm
            try {
                db.LuuFile(linkTK, dsTK);
                db.LuuFile(QuanLy.linkIDTK, autoIDTK);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
        else if(loai == 3){
            TaiKhoan newTKTK = new TaiKhoan(true, new Quyen(3, "Trưởng khoa", "Cao cấp hơn quản trị viên"),autoIDTK);
            System.out.println("\n=> Tạo thành công tài khoản trưởng khoa!\nTên tài khoản: " +
                    newTKTK.getTenTaiKhoan() + ", Mật khẩu: " + newTKTK.getMatKhau());

            dsTK.add(newTKTK);
            autoIDTK++;
            // Lưu lại list sau khi thêm
            try {
                db.LuuFile(linkTK, dsTK);
                db.LuuFile(QuanLy.linkIDTK, autoIDTK);
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }        
        
        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();
    }
    
    //Xây dựng chức năng sửa tài khoản giáo viên
    public static void sua(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- SỬA TRẠNG THÁI TÀI KHOẢN -------------");
        //Nhằm mục đích thay đổi trạng thái tài khoản : đóng hoặc mở
        // Khi tài khoản bị đóng thì sẽ không được truy nhập vào hệ thống nữa
        System.out.println("\n=> Nhập mã tài khoản: ");
        String ma = scan.nextLine();
        
        int index = existTK(ma);
        
        if(index != -1){
            System.out.println("\n=> Thay đổi trạng thái tài khoản(1: mở, 2: đóng, bất kỳ: hủy): ");
            int chon;
            try{
                chon = Integer.parseInt(scan.nextLine());
                if(chon == 1)
                    dsTK.get(index).setTrangThai(true);
                else if(chon == 2)
                    dsTK.get(index).setTrangThai(false);
                
                try {
                    db.LuuFile(linkTK, dsTK);
                } catch (Exception ex) {
                    Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            catch(Exception err){
                chon = -1;
            }
            
            System.out.println("\n=> Thay đổi trạng thái thành công!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
        else{
            System.out.println("\n=> Mã tài khoản này không tồn tại trong hệ thống!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
    }
    
    public static void xoa(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- XÓA TÀI KHOẢN GIÁO VIÊN -------------");
        
        System.out.println("\n=> Nhập mã tài khoản: ");
        String ma = scan.nextLine();
        
        int index = existTK(ma);
        
        if(index != -1){
            dsTK.remove(index);
            try {
                db.LuuFile(linkTK, dsTK);
            } catch (Exception ex) {
                Logger.getLogger(QLTaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("\n=> Xóa tài khoản thành công!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
        else{
            System.out.println("\n=> Mã tài khoản này không tồn tại trong hệ thống!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
    }
    
    public static void xem(int loai){
        int dem = 0;
        if(loai == 1){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- TÀI KHOẢN GIÁO VIÊN -------------");
            TaiKhoan.tieuDe();
            for(TaiKhoan i : dsTK)
                if(i.getQuyen().getMaQuyen() == 1)
                    i.inDSTK(++dem);
        }
        else if(loai == 2){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- TÀI KHOẢN QUẢN TRỊ VIÊN -------------");
            TaiKhoan.tieuDe();
            for(TaiKhoan i : dsTK)
                if(i.getQuyen().getMaQuyen() == 2)
                    i.inDSTK(++dem);
        }
        
        System.out.println("=> Enter để tiếp tục!");
        scan.nextLine();
    }
    
    public static int existTK(String ma){
        for(TaiKhoan i : dsTK)
            if(i.getMaGV().equals(ma))
                return dsTK.indexOf(i);
        return -1;
    }
    
//Xây dựng chức năng quản trị tài khoản giáo viên
    public static void taskQLTKQTV(){
        
        if(user.getQuyen().getMaQuyen() != 3){
            System.out.println("\n=> Chỉ trưởng khoa hoặc tài khoản được trưởng khoa phân quyền mới được truy nhập vào chức năng này!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
            return;
        }
        
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN LÝ TÀI KHOẢN QUẢN TRỊ VIÊN -------------");
            System.out.println("1: Thêm.");
            System.out.println("2: Sửa.");
            System.out.println("3: Xóa.");
            System.out.println("4: Xem danh sách tài khoản quản trị viên.");
            System.out.println("5: Trở về.");
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
                    them(2);
                    break;
                case 2:
                    sua();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xem(2);
                    break;
                case 5: return;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    scan.nextLine();
            }
        }
    }
}
