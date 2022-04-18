

import java.util.Scanner;

public class Bai6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.print("Mời nhập số n: ");
		n= scan.nextInt();
		System.out.print(KTNT(n));
		

	}
	public static String KTNT(int a) {
		int dem = 0;
		for(int i = 1; i <= a; i++) {
			if(a % i == 0) {
				dem++;
			}
		}
		if(dem == 2) {
			return "Số "+a+" là số nguyên tố";
		}
		return "Số "+a+" không là số nguyên tố";
	}

}
