

import java.util.Scanner;

public class Bai5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a,b;
		System.out.print("Mời nhập số a: ");
		a= scan.nextInt();
		System.out.print("Mời nhập số b: ");
		b= scan.nextInt();
		System.out.print("UCLN của "+a+" và "+b+" là : "+UCLN(a,b));

	}
	public static int UCLN(int a,int b) {
		if(b == 0) {
			return a;
		}else {
			return UCLN(b,a%b);
		}
		
	}

}
