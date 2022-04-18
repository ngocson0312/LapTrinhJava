package vn.nhom15.btphieu5;

import java.util.ArrayList;
import java.util.Scanner;

public class XuatSinhVien {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
//		test
//        SinhVien[] list = {
//            new SinhVien("a", "1", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 123), 7, 8, 0, "xxx"),
//            new SinhVien("a", "2", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 125), 6, 9, 5, "xxx"),
//            new SinhVien("a", "3", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 456), 5, 10, 2, "xxx"),
//            new SinhVien("a", "4", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 458), 4, 5, 4, "xxx"),
//            new SinhVien("a", "5", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 789), 4, 3, 8, "xxx"),
//            new SinhVien("a", "6", "chung ta khong thuoc ve nhau",new DiaChi("x", "y", "z", 789), 2, 9, 9, "xxx")
//        };
		
        int n = 0;
        System.out.print("\n- Welcome!!!");
        System.out.print("\n- Nhap vao so sinh vien: ");
        n = Integer.parseInt(sc.nextLine());
        
        SinhVien[] list = new SinhVien[n];
        for(int i = 0; i < n; i++) {
        	list[i] = new SinhVien();
        	System.out.print("\n- Nhap vao thong tin sinh vien thu " + (i + 1) + ":\n");
        	input(list[i]);
        }
        
        output(list);
    }
    
	public static void input(SinhVien sv) {
		System.out.print("\t+ Nhap ho sinh vien: ");
		sv.ho = sc.nextLine();
		
		System.out.print("\t+ Nhap ten sinh vien: ");
		sv.ten = sc.nextLine();
		
		System.out.print("\t+ Nhap dia chi nha: ");
		sv.diaChiNha = sc.nextLine();
		
		System.out.println("\t+ Nhap dia chi truong: ");
		sv.diaChiTruong = new DiaChi();
		System.out.print("\t\t* Nhap Duong: ");
		sv.diaChiTruong.Duong = sc.nextLine();
		
		System.out.print("\t\t* Nhap Quan: ");
		sv.diaChiTruong.Quan = sc.nextLine();
		
		System.out.print("\t\t* Nhap  Thanh Pho: ");
		sv.diaChiTruong.ThanhPho = sc.nextLine();
		
		System.out.print("\t\t* Nhap MaVung: ");
		sv.diaChiTruong.MaVung = sc.nextLong();
		
		System.out.print("\t+ Nhap diem loai 1: ");
		sv.diem01 = sc.nextDouble();
		
		System.out.print("\t+ Nhap diem loai 2: ");
		sv.diem02 = sc.nextDouble();
		
		System.out.print("\t+ Nhap diem loai 3: ");
		sv.diem03 = sc.nextDouble();
		
		System.out.print("\t+ Nhap ten chu nhiem: ");
		sc.nextLine();
		sv.tenCN = sc.nextLine();
	}

	
    public static void output(SinhVien[] list){
    	int j = 0;
    	ArrayList<SinhVien> x = new ArrayList<SinhVien>();
    	
    	double dtbMax = maxDTB(list);
    	
        System.out.printf("\n%100s","DANH SACH SINH VIEN!!!\n");
        System.out.printf("%-5s %-30s %-40s %-40s %-10s %-10s %-10s %-30s %-5s \n","STT", "Ho Ten", "Dia chi nha", "Dia chi truong", "Diem 1", "Diem 2", "Diem 3", "Ten chu nhiem", "DTB");
        for(SinhVien i : list) {
        	System.out.printf("%-5d %-30s %-40s %-40s %-10.1f %-10.1f %-10.1f %-30s %-5.1f\n", j++, i.ho + " " + i.ten, i.diaChiNha, i.ToString(), i.diem01, i.diem02, i.diem03, i.tenCN, i.getDTB());
        	if(dtbMax == i.getDTB())
        		x.add(i);
        }
        
        j = 0;
        
        System.out.println("\n- Cac sinh vien co diem trung binh cao nhat:\n");
        System.out.printf("%-5s %-30s %-5s \n","STT", "Ho Ten", "DTB");
        for(SinhVien i : x)
        	System.out.printf("%-5d %-30s %-5.1f\n", j++, i.ho + " " + i.ten, i.getDTB());
        
    }
    
    public static double maxDTB(SinhVien[] list) {
    	double m = 0;
    	for(SinhVien i : list)
    		if(m < i.getDTB())
    			m  = i.getDTB();
    	return m;
    }
    
}
