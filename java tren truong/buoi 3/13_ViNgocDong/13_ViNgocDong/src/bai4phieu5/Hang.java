
package bai4phieu5;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class Hang {
//    private String maHang; //Thuận lợi cho việc quản lý sau này
    private String tenHang;
    private double donGia, soLuong;
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
//        System.out.print("\t+ Nhập mã hàng: ");
//        this.maHang = scan.nextLine();
        System.out.print("\t+ Nhập tên hàng: ");
        this.tenHang = scan.nextLine();
        System.out.print("\t+ Nhập đơn giá: ");
        this.donGia = Double.parseDouble(scan.nextLine());
        System.out.print("\t+ Nhập số lượng: ");
        this.soLuong = Double.parseDouble(scan.nextLine());
    }
    
    public double totalMoney(){
        return donGia * soLuong;
    }
    
    static void title(){
        System.out.printf("\n%-20s %-15s %-15s %-15s\n", "Tên hàng", "Đơn giá", "Số lượng", "Thành tiền");
    }
    
    public void output(){
        System.out.printf("%-20s %-15.1f %-15.1f %-15.1f\n", this.tenHang, this.donGia, this.soLuong, totalMoney());
    }

    public String getTenHang() {
        return tenHang;
    }
}
