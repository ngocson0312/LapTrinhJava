/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3Phieu5_Nhom15;

/**
 *
 * @author win
 */
public class XuatSinhVien {
    public static void main(String[] args) {
        SinhVien[] list = {
            new SinhVien("a", "1", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 7, 8, 0, "xxx"),
            new SinhVien("a", "2", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 6, 9, 5, "xxx"),
            new SinhVien("a", "3", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 5, 10, 2, "xxx"),
            new SinhVien("a", "4", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 4, 5, 4, "xxx"),
            new SinhVien("a", "5", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 4, 3, 8, "xxx"),
            new SinhVien("a", "6", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", "e"), 2, 9, 9, "xxx")
        };
        
        
        output(list);
    }
    
    public static void output(SinhVien[] list){
        System.out.printf("%50c" ,"DANH SÁCH CÁC SINH VIÊN!!1");
    }
}
