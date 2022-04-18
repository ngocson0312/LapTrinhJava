/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CT;

import java.util.Scanner;

/**
 *
 * @author VND
 */

public class Xe implements MayMoc{
    private String tenXe;
    private String tenKH;
    private String NL;
    private DoanhNghiep dn = new DoanhNghiep();
    private float trongTai;
    private float tienDatCoc;
    private int namSX;
    //cụ thể hóa 2 phương thức trong MayMoc
    
    public void setNhienLieu(String NL){
        this.NL = NL;
    }
    
    public void setNamsx(int namSX){
        if (namSX > 0)
            this.namSX = namSX;
        else
            this.namSX = 2016;
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("- Nhap ten xe: ");
        tenXe = sc.nextLine();
        System.out.print("- Nhap nhien lieu cua xe: ");
        setNhienLieu( sc.nextLine());
        System.out.print("- Nhap ten khach hang thue xe: ");
        tenKH = sc.nextLine();
        System.out.println("- Nhap doanh nghiep: ");
        dn.nhap();
        System.out.print("- Nhap trong tai: ");
        trongTai = Float.parseFloat(sc.nextLine());
        if(trongTai == 0) return;
        
        System.out.print("- Nhap so tien dat coc(VND): ");
        tienDatCoc = Float.parseFloat(sc.nextLine());
        System.out.print("- Nhap nam san xuat xe: ");
        setNamsx(Integer.parseInt(sc.nextLine()));
    }
    
    public static void inTieuDe(){
        System.out.printf("%-10s %-10s %-10s %-25s %-10s %-10s %-10s%n", "Ten xe", "Ten kh", "Nhien lieu", "Doanh nghiep", "Tai trong", "Tien DC", "Nam sx");
    }

    public void inDL(){
        System.out.printf("%-10s %-10s %-10s %-25s %-10.1f %-10.1fs %-10d %n", tenXe, tenKH, NL, dn, trongTai, tienDatCoc, namSX);
    }
    
    public float getTrongTai() {
        return trongTai;
    }

    public String getTenXe() {
        return tenXe;
    }
    
    
}



