/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT;

/**
 *
 * @author VND
 */
import java.util.Scanner;

public class DoanhNghiep {
    private String tenDN;
    private String soDT;
    private String diaChi;
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\t+ Nhap ten DN: ");
        tenDN = sc.nextLine();
        System.out.print("\t+ Nhap so dien thoai: ");
        soDT = sc.nextLine();
        System.out.print("\t+ Nhap dia chi: ");
        diaChi = sc.nextLine();
    }
    
    @Override
    public String toString() {
        return "("+tenDN + "," + soDT + "," + diaChi+")";
    }
 }
