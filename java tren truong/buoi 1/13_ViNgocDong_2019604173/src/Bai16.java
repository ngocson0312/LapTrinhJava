import java.util.Scanner;

public class Bai16 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		System.out.print("Mời nhập chuỗi s: ");
//		String s = scan.nextLine();
		String s = "Hello world Hello world Hello world fdsf cxvd dsfds dfds";
		System.out.print(s.compareTo("Hello world"));
		String[] str = s.split("Hello world");
		int dem=0;
		for(int i=0;i<str.length;i++) {
			System.out.print(str[i]);
			if(str[i].equals("Hello world")) {
				dem++;
			}
		}
		System.out.print("Số chuỗi là: "+dem);

	}

}
