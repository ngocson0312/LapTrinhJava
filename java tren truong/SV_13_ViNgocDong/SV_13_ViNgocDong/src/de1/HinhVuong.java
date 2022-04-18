package de1;

import java.io.Serializable;
import java.util.Scanner;

public class HinhVuong extends DaGiac implements Serializable{
    private int a;

    @Override
    protected int tinhCV() {
        return a * 4;
    }

    @Override
    protected int tinhDT() {
        return a * a;
    }

    @Override
    protected boolean nhapDL(){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.print("- Nhập mã hình: ");
            setMaHinh(sc.nextLine());
            System.out.print("- Nhập tên hình: ");
            setTenHinh(sc.nextLine());
        } catch (Exception ex) {
            System.err.println(ex);
            System.out.println("=> Thêm mới hình thất bại!");
            sc.nextLine();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + a + "\t" + tinhCV() + "\t" + tinhDT();
    }
    
    


    public HinhVuong(String maHinh, String tenHinh, int a) {
        super(maHinh, tenHinh);
        this.a = a;
    }
    
}
