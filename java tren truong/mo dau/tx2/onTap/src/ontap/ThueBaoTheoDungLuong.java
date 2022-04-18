package ontap;

import java.io.Serializable;
import java.util.Scanner;

public class ThueBaoTheoDungLuong extends ThueBao implements Serializable{
    private static double TIENTHUEBAO = 30000;
    private static double CUOCDUNGLUONG = 50;
    private double MB;
    
    public void nhap() throws Exception{
        Scanner sc = new Scanner(System.in);
        super.nhap();
        
        System.out.print("\t+ Nhập số MB đã dùng: ");
        setMB(Double.parseDouble(sc.nextLine()));
    }
    
    public void xuat(int stt){
        super.xuat(stt);
        System.out.printf("%15.1f %20.1f\n", MB, tinhCuoc());
    }
    
    public double tinhCuoc(){
        return TIENTHUEBAO + CUOCDUNGLUONG * MB;
    }

    
    public void setMB(double MB) throws Exception {
        if(MB == 0)
            throw new Exception("Lượng MB sử dụng phải khác 0!");
        this.MB = MB;
    }
    
    
}
