package bai4phieu5;

import java.util.Scanner;

/**
 *
 * @author VND
 */
public class HoaDon {
    private String maHD, ngayLap;
    private KhachHang khachHang = new KhachHang();
    private Hang[] dsHang;
    private int soHH = 0;
    private double tongTien = 0;
    
    public void input(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n- Nhập thông tin hóa đơn:");
        System.out.print("\t+ Nhập mã hóa đơn: ");
        this.maHD = scan.nextLine();
        System.out.print("\t+ Nhập ngày tạo hóa đơn: ");
        this.ngayLap = scan.nextLine();
        khachHang.input();
        
        System.out.print("- Nhập số lượng hàng hóa: ");
        soHH = Integer.parseInt(scan.nextLine());
        
        dsHang = new Hang[soHH];
        
        for(int i = 0; i < soHH; i++){
            System.out.println("- Nhập thông tin hàng hóa thứ " + (i + 1)+ ": ");
            dsHang[i] = new Hang();
            dsHang[i].input();
            
            tongTien += dsHang[i].totalMoney();
        }
    }
    
    public void output(){
        System.out.printf("\n%40s\n","HOA DON BAN HANG");
        
        System.out.printf("%10s %-30s %10s %-30s\n", "Mã hóa đơn:", this.maHD, "Ngày bán:", this.ngayLap);
        khachHang.output();
        dsHang[0].title();
        for(int i = 0; i < soHH; i++)
            dsHang[i].output();
        
        System.out.printf("%-20s %-31s %-15.1f\n", "Tổng tiền", "", this.tongTien);
    }
    
    public void sapxep(){
        for(int i = 0; i < soHH; i++)
            for(int j = i + 1; j < soHH; j++){
                if(dsHang[i].getTenHang().compareToIgnoreCase(dsHang[j].getTenHang()) > 0){
                    Hang tg = dsHang[i];
                    dsHang[i] = dsHang[j];
                    dsHang[j] = tg;
                }
                else if(dsHang[i].getTenHang().compareToIgnoreCase(dsHang[j].getTenHang()) == 0
                        && dsHang[i].totalMoney() > dsHang[j].totalMoney()){
                    Hang tg = dsHang[i];
                    dsHang[i] = dsHang[j];
                    dsHang[j] = tg; 
                }
            }
        
    }
}
