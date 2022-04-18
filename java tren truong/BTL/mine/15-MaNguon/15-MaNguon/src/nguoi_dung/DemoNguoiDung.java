/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguoi_dung;

import DBEngine.Database;
import demo_chuong_trinh.DangNhap;
import static demo_chuong_trinh.DangNhap.user;
import doi_tuong.Date;
import doi_tuong.LopHoc;
import doi_tuong.MonHoc;
import doi_tuong.TaiKhoan;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import nguoi_dung.lich_thuc_hanh.CnLichThucHanh;
import quan_tri_he_thong.BaoTri.BaoTri;
import quan_tri_he_thong.BaoTri.BaoTriPhongThucHanh;
import static quan_tri_he_thong.DemoQTV.scan;
import quan_tri_he_thong.lich_su_he_thong.LichSuHeThong;

/**
 *
 * @author DELL
 */
public class DemoNguoiDung {
    
    static ArrayList<TaiKhoan> acc = new ArrayList<>();
    public static void xemTT(){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- THÔNG TIN CÁ NHÂN -------------");
        TaiKhoan.tieuDe();
        user.inDSTK(1);
    }
    public static int ktratontai(){
        for (TaiKhoan i : acc){
            if (i.getMaGV().equals(user.getMaGV())){
                return acc.indexOf(i);
            }
        }
        return -1;
    }
    static Database db = new Database();
    public static int index ;
    public static void capNhatTT(){
        while(true){
        System.out.println("\n---------------------------------------------------------------------------------------------");
        System.out.println("\n------------- CẬP NHẬT THÔNG TIN CÁ NHÂN -------------");
        System.out.println("1:Họ tên");
        System.out.println("2:Ngày sinh");
        System.out.println("3:Giới tính");
        System.out.println("4:Chuyên ngành");
        System.out.println("5: Quay lại");
        System.out.print("=> Lựa chọn của bạn là: ");
        int c;
        try{
        c = Integer.parseInt(scan.nextLine());
        }
        catch(Exception err){
            c = -1;
        }
        
        switch(c){
            case 1:
                System.out.print("Nhập họ tên mới: ");
                String ht = scan.nextLine();
                acc.get(index).setHoTen(ht);
                user.setHoTen(ht);
                {
                    try {
                        db.LuuFile("data/DSTK.txt", acc);
                    } catch (Exception ex) {
                        Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case 2:
                System.out.print("Nhập ngày sinh mới: ");
                Date d = new Date();
                acc.get(index).setNgaySinh(d);
                try{
                    d.nhap();
                    user.setNgaySinh(d);
                }catch (Exception e){
                    System.err.println(e);
                }
                {
                    try {
                        db.LuuFile("data/DSTK.txt", acc);
                    } catch (Exception ex) {
                        Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 3:
                System.out.print("Nhập giới tính mới: ");
                String gt = scan.nextLine();
                acc.get(index).setGioiTinh(gt);
                user.setGioiTinh(gt);
                {
                    try {
                        db.LuuFile("data/DSTK.txt", acc);
                    } catch (Exception ex) {
                        Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 4:
                System.out.print("Nhập chuyên ngành mới: ");
                String nc = scan.nextLine();
                acc.get(index).setChuyenNganh(nc);
                user.setChuyenNganh(nc);
                {
                    try {
                        db.LuuFile("data/DSTK.txt", acc);
                    } catch (Exception ex) {
                        Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case 5: return;
            default:
                System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                System.out.println("=> Enter để tiếp tục!");
                scan.nextLine();
            }
        
            System.out.println("\n=> Thay đổi thông tin thành công!");
            System.out.println("=> Enter để tiếp tục!");
            scan.nextLine();
        }
        
    }
    
    
    
    
    public static void doiMK(){
        
        while(true)
        {
            System.out.println("Mời nhập mật khẩu cũ: ");
            String mkc = scan.nextLine();
            if (user.getMatKhau().equals(mkc)){
                System.out.println("Mời nhập mật khẩu mới: ");
                try{
                    String mkm = scan.nextLine();
                    acc.get(index).setMatKhau(mkm);
                    user.setMatKhau(mkm);
                    {
                        try {
                            db.LuuFile("data/DSTK.txt", acc);
                        } catch (Exception ex) {
                            Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                catch (Exception e){
                    System.err.println(e);    
                }
                
                
                System.out.println("Đổi mật khẩu thành công");
                return;
            }else{
                System.out.println("Không trùng khớp !! Mời nhập lại");
            }
        }
    }
    
    public static void menuNguoiDung(){
        
        try {
            acc = (ArrayList<TaiKhoan>) db.docFile("data/DSTK.txt");
        } catch (Exception ex) {
            Logger.getLogger(DemoNguoiDung.class.getName()).log(Level.SEVERE, null, ex);
        }
        index = ktratontai();
        
        while(true){
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println("\n------------- CHƯƠNG TRÌNH ĐĂNG KÝ LỊCH THỰC HÀNH -------------");
                System.out.println("1: Lịch thực hành.");
                System.out.println("2: Xem thông tin danh sách phòng thực hành");
                System.out.println("3: Cá nhân.");
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
                        CnLichThucHanh.menuLichThucHanh();
                        break;
                    case 2:
                        BaoTriPhongThucHanh.hienThiPhongThucHanh();
                        break;
                    case 3:
                        menuCaNhan();
                        break;
                    case 4: return;
                    default:
                        System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                        System.out.println("=> Enter để tiếp tục!");
                        scan.nextLine();
            }
        }
    }
    
    public static void menuCaNhan(){

            while(true){
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println("\n------------- CÁ NHÂN -------------");
                System.out.println("1: Xem thông tin cá nhân.");
                System.out.println("2: Cập nhật thông tin cá nhân.");
                System.out.println("3: Đổi mật khẩu.");
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
                        xemTT();
                        break;
                    case 2:
                        capNhatTT();
                        break;
                    case 3:
                        doiMK();
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
