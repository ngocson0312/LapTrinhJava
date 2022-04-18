package doi_tuong;

import java.io.Serializable;
import static quan_tri_he_thong.DemoQTV.scan;

public class Date implements Serializable{
    private int ngay,thang,nam;

    public Date(int ngay, int thang, int nam) {
        if ( thang > 0 && thang <= 12 )
		this.thang = thang; 
        else {
            this.thang = 1;
            System.out.println( "Tháng " + thang + "không hợp lệ. đặt lại tháng =1." ); 
        } 
        this.nam = nam; 
        this.ngay = checkDay( ngay ); 
    }
    
    private int checkDay( int ngayKiemTra ) {
        int ngayTrongThang[]={0,31,28,31,30,31,30,31,31,30,31,30,31}; 
        if (ngayKiemTra > 0 && ngayKiemTra<=ngayTrongThang[thang ])
        return ngayKiemTra; 
        else if (((thang==2) && (ngayKiemTra == 29)) && ((nam % 400 == 0) || ((nam % 4 == 0) && (nam % 100 != 0 )))) 
                return ngayKiemTra; 
        else { 
                System.out.println( "ngày " + ngayKiemTra + "không hợp lệ, đặt lại =1." ); 
                return 1; 
        }
    } 
    
    public void nhap() {
        System.out.print("Nhap ngay: ");
        ngay = Integer.parseInt(scan.nextLine());
        System.out.print("Nhap thang: ");
        thang = Integer.parseInt(scan.nextLine());
        System.out.print("Nhap nam: ");
        nam = Integer.parseInt(scan.nextLine());
		
    }
    
 
    public Date() {
    }
    
    public String hienThi(){
        return ngay + "/" + thang + "/" + nam;
    }
    
    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
}
