/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo_chuong_trinh;

import DBEngine.Database;
import doi_tuong.TaiKhoan;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import nguoi_dung.DemoNguoiDung;
import quan_tri_he_thong.DemoQTV;

/**
 *
 * @author DELL
 */

public class DangNhap{
    static public TaiKhoan user;
    static Scanner sc = new Scanner (System.in);
    static Database db = new Database();
    public static void giaoDien(){
            
            while(true){
                System.out.println("\n---------------------------------------------------------------------------------------------");
                System.out.println("\n------------- CHÀO MỪNG ĐẾN VỚI CHƯƠNG TRÌNH -------------");
                System.out.print("=> Nhập tên tài khoản: ");
                String userName = sc.nextLine();
                System.out.print("=> Nhập mật khẩu: ");
                String passW = sc.nextLine();
                if(checker(userName, passW)){
                    System.out.println("Đăng nhập thành công");
                    
                    if(user.getQuyen().getMaQuyen() == 1){
                        DemoNguoiDung.menuNguoiDung();
                    }else if(user.getQuyen().getMaQuyen() != 1){
                        DemoQTV.menuQTV();
                    }
                }else{
                    System.out.println("Đăng nhập thất bại");
                    System.out.print("Bạn có muốn đăng nhập tiếp không (1:có/chữ bất kỳ:Không): ");
                    String i=sc.nextLine();
                    if(!i.equals("1")){
                        System.out.println("Chào tạm biệt !!");
                        System.exit(0);
                    }
                }
            }
    }
    
    // Kiểm tra tài khoản, mật khẩu kết hợp đọc dữ liệu
    public static boolean checker(String userName, String pass){
        ArrayList<TaiKhoan> acc = new ArrayList<>();
        try {
             acc = (ArrayList<TaiKhoan>) db.docFile("data/DSTK.txt");
        } catch (Exception ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (TaiKhoan a:acc){
            if(a.getTenTaiKhoan().equals(userName)&&a.getMatKhau().equals(pass)){
                user = a;
                
                return true;
            }
        }
        return false ;
    }
    
    
    public static void main(String[] args){
        giaoDien();
    }
}
