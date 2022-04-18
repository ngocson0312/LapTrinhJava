/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bai3p4;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author VND
 */
public class Main {
    static int soNV,loaiNV;
    static double tongLuong = 0f;
    static NhanVien[] myNV; 
    
    static Scanner s = new Scanner(System.in);
    
    static void nhapDSNV(){
        
        
        System.out.print("- Nhap so luong nhan vien: ");
        soNV = s.nextInt();
        myNV = new NhanVien[soNV];
        
        for(int i = 0; i < soNV; i++){
            System.out.print("- Lua chon loai nhan vien (1.Nhập NVSX, 2.NVVP): ");
            loaiNV = s.nextInt();
            if (loaiNV == 1)
                myNV[i] = new NhanVienSX();
            else
                myNV[i] = new NhanVienVP();
            myNV[i].nhap();
            
            tongLuong = tongLuong + myNV[i].tinhLuong() + myNV[i].tinhPhuCap();
        }
    }
    
    static void inDSNV(){
        System.out.println("\nDanh sach nhan vien SX cong ty la");
        NhanVienSX.inTieuDe();
        for(int i = 0; i < soNV; i++)
            if (myNV[i] instanceof NhanVienSX)
                myNV[i].xuatDL();
        System.out.println("\nDanh sach nhan vien VP cong ty la");
        NhanVienVP.inTieuDe();
        for(int i = 0; i < soNV; i++)
            if (myNV[i] instanceof NhanVienVP)
                myNV[i].xuatDL();
        DecimalFormat f = new DecimalFormat("###,###.0#");
        System.out.println("- Tong luong nhan vien: " + f.format(tongLuong));
    }
    
//    static void sapxepTD(){
//        for(int i = 0; i < myNV.length; i++)
//            for(int j = i + 1; j < myNV.length; j++){
//                if(myNV[i] instanceof NhanVienSX && myNV[j] instanceof NhanVienSX  || myNV[i] instanceof NhanVienVP && myNV[j] instanceof NhanVienVP)
//                    if(myNV[i].tinhLuong() > myNV[j].tinhLuong()){
//                        NhanVien tg = myNV[i];
//                        myNV[i] = myNV[j];
//                        myNV[j] = tg;
//                    }
//                else
//                    if(myNV[i] instanceof NhanVienSX){
//                        NhanVien tg = myNV[i];
//                        myNV[i] = myNV[j];
//                        myNV[j] = tg;
//                    }
//                }
//                
//    }
//    
//    static void sapxepGD(){
//        for(int i = 0; i < myNV.length; i++)
//            for(int j = i + 1; j < myNV.length; j++){
//                if(myNV[i] instanceof NhanVienSX && myNV[j] instanceof NhanVienSX  || myNV[i] instanceof NhanVienVP && myNV[j] instanceof NhanVienVP)
//                    if(myNV[i].tinhLuong() < myNV[j].tinhLuong()){
//                        NhanVien tg = myNV[i];
//                        myNV[i] = myNV[j];
//                        myNV[j] = tg;
//                    }
//                else
//                    if(myNV[i] instanceof NhanVienSX){
//                        NhanVien tg = myNV[i];
//                        myNV[i] = myNV[j];
//                        myNV[j] = tg;
//                    }
//                }
//                
//    }
    
    static void sapXepTD(){
        for(int i = 0; i < myNV.length; i++)
            for(int j = i + 1; j < myNV.length; j++)
                    if(myNV[i].tinhLuong() > myNV[j].tinhLuong()){
                        NhanVien tg = myNV[i];
                        myNV[i] = myNV[j];
                        myNV[j] = tg;
                    }
    }
    
    static void sapXepGD(){
        for(int i = 0; i < myNV.length; i++)
            for(int j = i + 1; j < myNV.length; j++)
                    if(myNV[i].tinhLuong() < myNV[j].tinhLuong()){
                        NhanVien tg = myNV[i];
                        myNV[i] = myNV[j];
                        myNV[j] = tg;
                    }
    }

    static void sapXep(){
        System.out.print("\n- Lua chon kieu sap xep nhan vien theo loai, theo luong (1: tang dan; 2: giam dan): ");
        int i = 0;
        i = s.nextInt();
        if(i == 1){
            System.out.print("\n- Cac danh sach nhan vien sau sap xep theo loai, theo luong tang dan: ");
            sapXepTD();
        }
        else{
            System.out.print("\n- Cac danh sach nhan vien sau sap xep theo loai, theo luong giam dan: ");
            sapXepGD();
        }
    }

    public static void main(String[] args) {
        nhapDSNV();
        inDSNV();
        
        sapXep();
        inDSNV();
    }
    
}
