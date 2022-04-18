package Bai2;

import java.util.Scanner;

public class NgayThang {
	protected int ngay,thang,nam;
	public void nhap() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Moi nhap ngay thang: ");
		ngay = scan.nextInt();
		thang = scan.nextInt();
		nam = scan.nextInt();
	}
	public void xuat() {
		String ngayThang = ngay+"/"+thang+"/"+nam;
		System.out.printf("%10s",ngayThang);
	}
}
