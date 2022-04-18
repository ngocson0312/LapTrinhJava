

import java.util.Scanner;

public class Bai19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập chuỗi s: ");
		String s = scan.nextLine();
		int a;
		do {
			System.out.print("Vi trì đầu a: ( a> 0) ");
			a = scan.nextInt();
		}while(a < 0 || a > s.length());
		int b;
		do {
			System.out.print("Vi trì cuối b ( thuộc chuỗi): ");
			b = scan.nextInt();
		}while(b > s.length() || b < 0 || b < a);
		System.out.print("Chuỗi sau khi cắt: "+s.substring(a, b));

	}

}
