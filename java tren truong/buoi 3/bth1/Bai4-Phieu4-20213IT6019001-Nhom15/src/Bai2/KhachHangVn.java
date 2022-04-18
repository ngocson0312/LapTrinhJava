package Bai2;

import java.util.Scanner;

public class KhachHangVn extends KhachHang {

	private int loaiKH;
	private int dinhMuc;
	@Override
	double thanhTien() {
		if(soLuong < dinhMuc) {
			return soLuong*donGia;
		}else {
			return soLuong*donGia*dinhMuc+(soLuong - dinhMuc)*donGia*2.5;
		}
	}
	public void nhap() {
		super.nhap();
		System.out.print("Moi nhap loai kh: ");
		System.out.print("1: Sinh hoat, 2: Kinh doang, 3: San xuat ");
		Scanner scan = new Scanner(System.in);
		loaiKH = scan.nextInt();
		
	}
	public static void inTieuDe() {
		System.out.printf("%10s %15s %n","Loai kh: ","Thanh tien: ");
	}
	public void xuat() {
		super.xuat();
		String l = "";
		if(loaiKH == 1) {
			l = "Sinh hoat";
		}else if( loaiKH ==2) {
			l = "Kinh doanh";
		}else if( loaiKH == 3) {
			l = "San xuat";
		}
		System.out.printf("%10s %15.2f%n",l,thanhTien());
	}

}
