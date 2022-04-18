package Bai2;

import java.util.Scanner;

public class HoaDon {
	static int soLuong,loaiKH;
	static KhachHang dsKH[];
	private double tongSlVN;
	private double tongSlNN;
	private double tbSlNN;
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Moi nhap so luong khach hang: ");
		soLuong = scan.nextInt();
		dsKH = new KhachHang[soLuong];
		for(int i=0;i<soLuong;i++) {
			System.out.print("1: Khach hang Viet Nam \n2: Khach hang nuoc ngoai");
			loaiKH = scan.nextInt();
			if(loaiKH ==1) {
				dsKH[i] = new KhachHangVn();
			}else {
				dsKH[i] = new KhachHangNN();
			}
			dsKH[i].nhap();
		}
		
	}
	public void xuat() {
		KhachHang.inTieuDe();
		KhachHangVn.inTieuDe();
		for(int i=0;i<soLuong;i++) {
			if(dsKH[i] instanceof KhachHangVn) {
				dsKH[i].xuat();
				tongSlVN+= dsKH[i].soLuong;
			}
		}
		System.out.printf("%-44s %10.2f %n","Tong so luong: ",tongSlVN);
		KhachHang.inTieuDe();
		KhachHangNN.inTieuDe();
		int dem=0;
		for(int i=0;i<soLuong;i++) {
			if(dsKH[i] instanceof KhachHangNN) {
				dsKH[i].xuat();
				tongSlNN+= dsKH[i].soLuong;
				dem++;
				tbSlNN+=dsKH[i].thanhTien();
			}
		}
		System.out.printf("%-44s %10.2f %n","Tong so luong: ",tongSlNN);
		System.out.printf("%78s %10.2f %n","Trung binh thanh tien: ",tbSlNN/dem);
		
	}
	public void xuatHoaDonTheoYeuCau() {
		for(int i=0;i<soLuong;i++) {
			if(dsKH[i].thang == 9 && dsKH[i].nam == 2013) {
				dsKH[i].xuat();
			}
		}
	}
}
