package doi_tuong;

import java.io.Serializable;

public class LopHoc implements Serializable{
    private String maLop;
    private String tenLopHoc;
    private int soLuongSV;
    private MonHoc monHoc;
    private String ghiChu;

    public LopHoc(String maLop, String tenLopHoc, int soLuongSV, MonHoc monHoc, String ghiChu) {
        this.maLop = maLop;
        this.tenLopHoc = tenLopHoc;
        this.soLuongSV = soLuongSV;
        this.monHoc = monHoc;
        this.ghiChu = ghiChu;
    }

    public LopHoc() {
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLopHoc() {
        return tenLopHoc;
    }

    public void setTenLopHoc(String tenLopHoc) {
        this.tenLopHoc = tenLopHoc;
    }

    public int getSoLuongSV() {
        return soLuongSV;
    }

    public void setSoLuongSV(int soLuongSV) {
        this.soLuongSV = soLuongSV;
    }

    public MonHoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(MonHoc monHoc) {
        this.monHoc = monHoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    } 
}
