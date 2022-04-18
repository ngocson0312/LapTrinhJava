import java.util.Scanner;

public class Bai18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập chuỗi s1: ");
		String s1 = scan.nextLine();
		System.out.print("Mời nhập chuỗi s2: ");
		String s2 = scan.nextLine();
		if(s1.equals(s2)) {
			System.out.print("Hai chuỗi giống nhau");
		}else {
			System.out.print("Hai chuỗi không giống nhau");
		}
	}

}
