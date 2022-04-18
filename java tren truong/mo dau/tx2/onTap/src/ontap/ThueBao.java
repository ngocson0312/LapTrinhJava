package ontap;

import java.io.Serializable;
import java.util.Scanner;

public class ThueBao implements Serializable{
    protected String hoTen, diaChi, SDT;
    
  
    public void nhap() throws Exception{
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\t+ Nhập họ tên thuê bao: ");
        setHoTen(sc.nextLine());
        System.out.print("\t+ Nhập địa chỉ: ");
        setDiaChi(sc.nextLine());
        System.out.print("\t+ Nhập số điện thoại: ");
        setSDT(sc.nextLine());
    }

    public void setHoTen(String hoTen) throws Exception {
        if(hoTen.trim().equals(""))
            throw new Exception("Họ tên thuê bao không được để trống!");
        this.hoTen = hoTen;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    public void xuat(int stt){
        System.out.printf("%-5d %-30s %-30s %-15s ", stt, hoTen, diaChi, SDT);
    }
    
    static void title(){
        System.out.printf("%-5s %-30s %-30s %-15s %15s %20s\n", "STT", "Họ tên thuê bao", "Địa chỉ", "Số điện thoại", "Số MB đã dùng", "Tiền cước phải trả");
    }
}
