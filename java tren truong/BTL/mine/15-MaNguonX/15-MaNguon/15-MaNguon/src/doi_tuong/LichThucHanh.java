/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doi_tuong;

import java.io.Serializable;

/**
 *
 * @author DatLuu
 */
public class LichThucHanh implements Serializable{
    private int ngay;
    private String caThucHanh;
    private String khuNha;
    private String maPhong;
    private String maLop;
    private String tenGV;
    private String tenMonHoc;

    public LichThucHanh(int ngay, String caThucHanh, String khuNha, String maPhong, String maLop, String tenGV, String tenMonHoc) {
        this.ngay = ngay;
        this.caThucHanh = caThucHanh;
        this.khuNha = khuNha;
        this.maPhong = maPhong;
        this.maLop = maLop;
        this.tenGV = tenGV;
        this.tenMonHoc = tenMonHoc;
    }

    public LichThucHanh() {
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public String getCaThucHanh() {
        return caThucHanh;
    }

    public void setCaThucHanh(String caThucHanh) {
        this.caThucHanh = caThucHanh;
    }

    public String getKhuNha() {
        return khuNha;
    }

    public void setKhuNha(String khuNha) {
        this.khuNha = khuNha;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenGV() {
        return tenGV;
    }

    public void setTenGV(String tenGV) {
        this.tenGV = tenGV;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
     public void hienThilich() {
        System.out.printf("   %-10d %-20s %-10s %12 %-12s %-30s %-30s %n",ngay,caThucHanh,khuNha,maPhong,maLop,tenGV,tenMonHoc);  
    }
    
    
    
}
