

import java.util.Scanner;

public class Bai3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			
			System.out.print("Mời nhập n là số nguyên dương = ");
			n= scan.nextInt();
			
		}while(n < 0);
		System.out.print("Kết quả giai thừa của "+n+" = "+GiaiThua(n));
	}
	public static int GiaiThua(int n) {
		if(n == 1 || n == 0) {
			return 1;
		}else {
			return GiaiThua(n - 1)*n;
		}
		
	}

}
