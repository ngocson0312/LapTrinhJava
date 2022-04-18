/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author VND
 */
public class DemoXe {
    static ArrayList<Xe> dsXe= new ArrayList<Xe>();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        
        
        while(true){
            System.out.println("\t==Quan ly xe==");
            System.out.print("1: Nhập danh sách xe\n");
            System.out.print("2: In danh sách xe\n");
            System.out.print("3: Tìm kiếm xe có trọng tải max\n");
            System.out.print("4: Xóa xe theo stt\n");
            System.out.print("5: Sắp xếp\n");
            System.out.print("6: Thoát\n");
            System.out.print("=> Nhập lựa chọn của bạn: ");
            int chon = Integer.parseInt(sc.nextLine());
            
            switch(chon){
                case 1:
                    nhapXe(); break;
                case 2:
                    inDSXe(); break;
                case 3:
                    timXeTrongTaiMax(); break;
                case 4:
                    System.out.print("- Nhập số xe cần xóa: ");
                    int stt = sc.nextInt();
                    xoaXe(stt); 
                    break;
                case 5:
                    sapXep();
                    break;
                case 6:
                    System.out.println("=> Cảm ơn bạn đã sử dụng dịch vụ!^^");
                    System.exit(0);
                default:
                    System.out.println("=> Lựa chọn của bạn chưa đúng!");
                    sc.nextLine();
                    break;
            }
        }
    }
    
    public static void nhapXe() {
        Xe xe = new Xe();
        System.out.println("- Trọng tải không được bằng 0.");
        xe.nhap();
        
        if (xe.getTrongTai() != 0f) 
            dsXe.add(xe);
        else{
            System.out.println("=> Trọng tải không được bằng 0. Việc nhập bị dừng lại!");
            sc.nextLine();
        }
    }
    
    public static void inDSXe() {
        Xe.inTieuDe();
        for (int i = 0; i < dsXe.size(); i++){
           dsXe.get(i).inDL();
        }
    }
    
    public static boolean xoaXe(int stt) {
        if ((stt>=0)&&(stt<=dsXe.size())){
            dsXe.remove(stt);
            return true;
        }
        else{ 
            System.out.println("- Vị trí xe ngoài phạm vi.");
            return false;
        }
    }
    
    public static void timXeTrongTaiMax(){
        Comparator<Xe> c = new Comparator<Xe>() {
            @Override
            public int compare(Xe t, Xe t1) {
                return Float.compare(t.getTrongTai(),t1.getTrongTai());
            }
        };
        
        Xe x = Collections.max(dsXe,c);
        System.out.println("- DS xe có trọng tải tối đa là: ");
        Xe.inTieuDe();
        float max = x.getTrongTai();
        for (int i = 0; i < dsXe.size(); i++) {
            if (dsXe.get(i).getTrongTai()== max) {
                dsXe.get(i).inDL();
            }
        }
    }

    private static void sapXep() {
        Comparator<Xe> x = new Comparator<Xe>() {
            @Override
            public int compare(Xe o1, Xe o2) {
                return o1.getTenXe().compareTo(o2.getTenXe());
            }
        };
        
    }
}
