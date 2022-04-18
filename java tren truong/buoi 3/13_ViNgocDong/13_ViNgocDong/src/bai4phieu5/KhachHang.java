package bai4phieu5;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class KhachHang {
//    private String maKH;
    private String tenKH, diaChi;
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
//        System.out.print("\t+ Nhập mã khách hàng: ");
//        this.maKH = scan.nextLine();
        System.out.print("\t+ Nhập tên khách hàng: ");
        this.tenKH = scan.nextLine();
        System.out.print("\t+ Nhập địa chỉ khách hàng: ");
        this.diaChi = scan.nextLine();
    }
    
    public void output(){
        System.out.printf("%10s %-30s %10s %-30s\n", "Khách hàng:", this.tenKH, "Địa chỉ:", this.diaChi);
    }

}
