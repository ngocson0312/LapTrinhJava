package doi_tuong;

import java.io.Serializable;

public class KhuNha implements Serializable{
    private int maKhuNha;
    private String tenKhuNha;
    private int soLuongTang;
    private String ghiChu;

    public KhuNha(int maKhuNha, String tenKhuNha, int soLuongTang, String ghiChu) {
        this.maKhuNha = maKhuNha;
        this.tenKhuNha = tenKhuNha;
        this.soLuongTang = soLuongTang;
        this.ghiChu = ghiChu;
    }

    public int getMaKhuNha() {
        return maKhuNha;
    }

    public void setMaKhuNha(int maKhuNha) {
        this.maKhuNha = maKhuNha;
    }

    public String getTenKhuNha() {
        return tenKhuNha;
    }

    public void setTenKhuNha(String tenKhuNha) {
        this.tenKhuNha = tenKhuNha;
    }

    public int getSoLuongTang() {
        return soLuongTang;
    }

    public void setSoLuongTang(int soLuongTang) {
        this.soLuongTang = soLuongTang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
