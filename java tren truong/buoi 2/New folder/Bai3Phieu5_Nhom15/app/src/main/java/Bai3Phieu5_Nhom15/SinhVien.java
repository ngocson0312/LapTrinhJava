/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3Phieu5_Nhom15;

/**
 *
 * @author win
 */
public class SinhVien implements ChuyenNganh {
    String ho, ten, diaChiNha;
    DiaChi diaChiTruong;
    double diem01, diem02, diem03;
    String tenCN;
    
    public String ToString(){
        return diaChiTruong.ToString();
    }
    
    public void setCotDiem(int loaiDiem, double diemSo){
        switch(loaiDiem){
            case 1: this.diem01 = diemSo; break;
            case 2: this.diem02 = diemSo; break;
            case 3: this.diem03 = diemSo; break;
            default: break;
        }
    }
    
    public double getCotDiem(int loaiDiem){
        double diem = 0;
        switch(loaiDiem){
            case 1: diem = this.diem01; break;
            case 2: diem = this.diem02; break;
            case 3: diem = this.diem03; break;
            default: break;
        }
        return diem;
    }
    
    public double getDTB(){
        return (this.diem01 + this.diem02 + this.diem03) / 3.0;
    }

    @Override
    public void setChuyenNganh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getChuyenNganh() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public SinhVien(String ho, String ten, String diaChiNha, DiaChi diaChiTruong, double diem01, double diem02, double diem03, String tenCN) {
        this.ho = ho;
        this.ten = ten;
        this.diaChiNha = diaChiNha;
        this.diaChiTruong = diaChiTruong;
        this.diem01 = diem01;
        this.diem02 = diem02;
        this.diem03 = diem03;
        this.tenCN = tenCN;
    }
}

