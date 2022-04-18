package doi_tuong;

import java.io.Serializable;

public class PhongThucHanh implements Serializable{
    private String maPhong;
    private String tenPhong; 
    private KhuNha khuNha;
    private int soLuongMay;
    private String cauHinh;
    private String ghiChu;
    private String trangThai;
    
    public PhongThucHanh( String tenPhong, int soLuongMay, String cauHinh, String ghiChu, String trangThai,KhuNha khuNha) {
        this.maPhong = tenPhong + khuNha.getTenKhuNha();
        this.tenPhong = tenPhong ;
        this.soLuongMay = soLuongMay;
        this.cauHinh = cauHinh;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.khuNha = khuNha;
    }
    
    public void hienThi() {
        System.out.printf("   %-10s %-20s %-10d %-12s %-30s %-10s %n",maPhong,tenPhong,soLuongMay,cauHinh,ghiChu,trangThai);  
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public KhuNha getKhuNha() {
        return khuNha;
    }

    public void setKhuNha(KhuNha khuNha) {
        this.khuNha = khuNha;
    }

    public int getSoLuongMay() {
        return soLuongMay;
    }

    public void setSoLuongMay(int soLuongMay) {
        this.soLuongMay = soLuongMay;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
