package Bai2;

import java.util.Scanner;

abstract class KhachHang extends NgayThang{
	protected String maKH,hoTen;
	protected double soLuong;
	protected double donGia;
	
	abstract double thanhTien();

	public void nhap() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Moi nhap ma khach hang: ");
		maKH = scan.nextLine();
		System.out.print("Moi nhap ho ten: ");
		hoTen = scan.nextLine();
		super.nhap();
		System.out.print("Moi nhap so luong: ");
		soLuong= scan.nextDouble();
		System.out.print("Moi nhap don gia");
		donGia = scan.nextDouble();
	}
	static void inTieuDe() {
		System.out.printf("%10s %25s %10s %7s %7s","Ma kh","Ho ten","Ngay thang","So luong","Don gia");
	}
	public void xuat() {
		System.out.printf("%10s %25s",maKH,hoTen);
		super.xuat();
		System.out.printf("%7.2f %7.2f",soLuong,donGia);
	}
}
