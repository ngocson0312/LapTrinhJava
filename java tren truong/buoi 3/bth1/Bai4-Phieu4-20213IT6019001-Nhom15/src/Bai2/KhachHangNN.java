package Bai2;

import java.util.Scanner;

public class KhachHangNN extends KhachHang{
	private String quocTich;
	@Override
	double thanhTien() {
		return donGia*soLuong;
	}
	public void nhap() {
		super.nhap();
		System.out.print("Moi nhap quoc tich: ");
		Scanner scan = new Scanner(System.in);
		quocTich = scan.nextLine();	
	}
	public static void inTieuDe() {
		System.out.printf("%10s %15s %n","Quoc tich","Thanh tien");
	}
	public void xuat() {
		super.xuat();
		System.out.printf("%10s %15.2fs%n",quocTich,thanhTien());
	}
}
