/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VND
 */
public class QLCB {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<CanBo> list = new ArrayList<>();
    
    public static void main(String[] args) {

        while (true) {
            System.out.println("----- CHUONG TRINH QUAN LY CAN BO -----");
            System.out.println("1: Them can bo.");
            System.out.println("2: Tim kiem can bo theo ho ten.");
            System.out.println("3: Hien thi danh sach can bo.");
            System.out.println("4: Thoat.");
            System.out.print("=>System: Lua chon cua ban la: ");
            int n;
            
            
            try{
                n = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                n = 0;
            }
            
            switch (n) {
                case 1:
                    try {
                        addCB() ;
                    } catch (Exception ex) {
                        System.out.println("\n=>System: Co loi xay ra trong qua trinh nhap du lieu! Vui long thu lai! Xin cam on.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    searchCB();
                    break;
                    
                case 3:
                    if(list.size() == 0){
                        System.out.println("\n=>System: Danh sach trong.");
                        sc.nextLine();
                    }
                    else{
                        displayCB(list);
                    }
                    break;
                    
                case 4:
                    System.out.println("\n=>System: Cam on ban da su dung san pham cua chung toi. Tam Biet!");
                    System.exit(0);
                    
                default:
                    System.out.println("\n=>System: Lua chon cua ban khong dung! Hay thu lai.");
                    sc.nextLine();
            }
        }
    }

    private static void addCB() throws Exception{
        while(true){
            CanBo x;
            
            System.out.println("----- Lua chon loai can bo -----");
            System.out.println("1: Cong nhan.");
            System.out.println("2: Ky su.");
            System.out.println("3: Nhan vien.");
            System.out.println("4: Quay lai.");
            System.out.print("=>System: Lua chon cua ban la: ");
            int n;
            
            
            try{
                n = Integer.parseInt(sc.nextLine());
            } catch(Exception err){
                n = 0;
                sc.nextLine();
            }
            
            switch (n) {
                case 1:
                    x = new CongNhan();
                    x.input();
                    list.add(x);
                    System.out.println("\n=>System: Them thanh cong 1 cong nhan vao danh sach!");
                    sc.nextLine();
                    break;
                        
                case 2:
                    x = new KySu();
                    x.input();
                    list.add(x);
                    System.out.println("\n=>System: Them thanh cong 1 ky su vao danh sach!");
                    sc.nextLine();
                    break;
                    
                case 3:
                    x = new NhanVien();
                    x.input();
                    list.add(x);
                    System.out.println("\n=>System: Them thanh cong 1 nhan vien vao danh sach!");
                    sc.nextLine();
                    break;
                    
                case 4:
                    return;
                    
                default:
                    System.out.println("\n=>System: Lua chon cua ban khong dung! Hay thu lai.");
            }
        }
    }

    private static void searchCB() {
        String key = "";
        System.out.print("=>System: Nhap ho ten nguoi muon tim: ");
        key = sc.nextLine();
        
        ArrayList<CanBo> x = new ArrayList<>();
        search(key, x);
        
        if(x.size() != 0){
            displayCB(x);
        }
        else{
            System.out.println("\n=>System: Ten nguoi ban muon tim kiem khong ton tai trong danh sach!");
            sc.nextLine();
        }
    }
    
    public static void search(String key, ArrayList<CanBo> x){
        for(CanBo i : list)
            if(key.compareToIgnoreCase(i.getFullName()) == 0){
                x.add(i);
            }
    }

    private static void displayCB(ArrayList<CanBo> x) {
        System.out.println("\n=>System: Hien thi cac ket qua co trong danh sach!");
        
        System.out.println("\n* Danh sach cong nhan:");
        CongNhan.title();
        int stt = 0;
        for(CanBo i : x)
            if(i instanceof CongNhan)
                i.output(++stt);
        
        System.out.println("\n* Danh sach ky su:");
        CongNhan.title();
        stt = 0;
        for(CanBo i : x)
            if(i instanceof KySu)
                i.output(++stt);
        
        System.out.println("\n* Danh sach nhan vien:");
        CongNhan.title();
        stt = 0;
        for(CanBo i : x)
            if(i instanceof NhanVien)
                i.output(++stt); 
        
        sc.nextLine();
    }

    
}
