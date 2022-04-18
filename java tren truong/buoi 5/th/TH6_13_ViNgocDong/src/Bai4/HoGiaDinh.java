package Bai4;

import java.io.Serializable;
import java.util.Scanner;

public class HoGiaDinh implements Serializable{
    private int soTV, soNha;
    private Nguoi[] caNhan;
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("- Nhap so thanh vien cua ho gia dinh: ");
        soTV = Integer.parseInt(sc.nextLine());
        
        caNhan = new Nguoi[soTV];
        
        System.out.print("- Nhap so nha cua ho gia dinh: ");
        soNha = Integer.parseInt(sc.nextLine());
        
        System.out.println("Nhap thong tin cua tung thanh vien trong ho.");
        for(int i = 0; i < soTV; i++){
            caNhan[i] = new Nguoi();
            System.out.println("- Nhap thong tin thanh vien thu " + (i + 1) + ": ");
            caNhan[i].nhap();
        }
    }
    
    public void xuat(){
        System.out.println("- So thanh vien trong ho: " + soTV);
        System.out.println("- So nha cua ho thanh vien nay: " + soNha);
        System.out.println("- Thong tin cua tung thanh vien trong ho gia dinh nay:");
        
        Nguoi.tieuDe();
        for(int i = 0; i < soTV; i++)
            caNhan[i].xuat();
        
        System.out.println();
    }
}
