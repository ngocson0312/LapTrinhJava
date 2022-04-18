/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vidu;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author VND
 */
public class SinhVien implements Serializable{
    String ten;
    int tuoi;

    public void setTen(String ten) throws Exception {
        if(ten.trim().equals("")){
            throw new Exception("Ten khong duoc de trong ...");
        }
        else
            this.ten = ten;
    }

    public void setTuoi(int tuoi) throws Exception{
        if(tuoi <= 0){
            throw new Exception("Tuoi lon hon 0 ...");
        }
        else
            this.tuoi = tuoi;
    }
    
    public void nhap(){
        //cach 2: while(true){
        try{
            Scanner scan = new Scanner(System.in);
        
            System.out.print("Nhap ten: ");
            setTen(scan.nextLine());
            System.out.print("Nhap tuoi: ");
            setTuoi(scan.nextInt());
        }
    
        catch (Exception er){
            //cach 1 nhap();
            System.out.print("Chuong trinh dang loi: " + er.toString());
        }
    //}
    }

    @Override
    public String toString() {
        return "SinhVien{" + "ten=" + ten + ", tuoi=" + tuoi + '}';
    }
    
    
    
}
