package Bai4;

import java.io.Serializable;
import java.util.Scanner;

public class Nguoi implements Serializable{
    private String hoTen;
    private int tuoi, namSinh;
    private String ngheNghiep;
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("\t+ Nhap ho ten: ");
        hoTen = sc.nextLine();
        System.out.print("\t+ Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("\t+ Nhap nam sinh: ");
        namSinh = Integer.parseInt(sc.nextLine());
        System.out.print("\t+ Nhap nghe nghiep: ");
        ngheNghiep = sc.nextLine();
    }
    
    static void tieuDe(){
        System.out.printf("%-30s %-10s %-10s %-20s\n", "Ho ten", "Tuoi", "Nam sinh", "Nghe nghiep");
    }
    
    public void xuat(){
        System.out.printf("%-30s %-10d %-10d %-20s\n", hoTen, tuoi, namSinh, ngheNghiep);
    }
}
