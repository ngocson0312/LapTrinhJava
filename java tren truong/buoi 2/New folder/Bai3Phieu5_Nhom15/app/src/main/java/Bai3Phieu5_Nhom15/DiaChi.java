/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3Phieu5_Nhom15;

/**
 *
 * @author win
 */
public class DiaChi {
    String Duong, Quan, ThanhPho, MaVung;

    public String ToString(){
        return "Duong " + this.Duong + ", Quan " + this.Quan + ", ThanhPho " + this.ThanhPho + ", MaVung " + this.MaVung;
    }

    public DiaChi(String Duong, String Quan, String ThanhPho, String MaVung) {
        this.Duong = Duong;
        this.Quan = Quan;
        this.ThanhPho = ThanhPho;
        this.MaVung = MaVung;
    }

    public DiaChi() {
    }
    
}
