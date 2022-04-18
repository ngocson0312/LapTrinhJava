

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Bai15 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] mangDem = new int[Character.MAX_VALUE];
		System.out.print("Mời nhập chuỗi s: ");
		String str = scan.nextLine();
		for (int i = 0; i < str.length(); i++) {
			mangDem[str.charAt(i)]++;
		}
		int max = mangDem[0];
		char kt = 0;
		for (int i = 0; i < mangDem.length; i++) {
		
			if (mangDem[i] != 0 && mangDem[i]> max) {
				max = mangDem[i];
			}
		}
		for (int i = 0; i < mangDem.length; i++) {
			
			if (mangDem[i] == max) {
				max = mangDem[i];
				kt = (char) i;
				System.out.println("Kí tự xuất hiện nhiều nhất "+(char) kt + " : " + max);
			}
		}
		

	}

}
