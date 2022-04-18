/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.ArrayList;
import java.util.Scanner;
import quan_tri_he_thong.BaoTri.BaoTri;

/**
 *
 * @author DatLuu
 */
public class Demo {
    public static void Menu(){
       
        while(true){
            System.out.println("\n---------------------------------------------------------------------------------------------");
            System.out.println("\n------------- QUẢN TRỊ HỆ THỐNG -------------");
            System.out.println("1: Quản lý.");
            System.out.println("2: Bảo trì.");
            System.out.println("3: Xem lịch sử hệ thống.");
            System.out.println("4: Đăng xuất.");
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
                    //menuQuanLy();
                    break;
                case 2:
//                    BaoTri.menuBaoTri1();
                    break;
                case 3:
                    //LichSuHeThong.hienThi();
                    break;
                case 4:
                    //dangXuat();
                    break;
                default:
                    System.out.println("\n=> Lựa chọn của bạn chưa chính xác. Vui lòng thử lại!");
                    System.out.println("=> Enter để tiếp tục!");
                    sc.nextLine();
            }
        }
    }

     public static void main(String[] args) {
         Menu();
    }
}
