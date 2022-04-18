import java.util.Scanner;

public class Bai1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Nhap vao mot so: ");
		int n = Integer.parseInt(scan.nextLine());
		if (snt(n))
			System.out.println("N la so nguyen to");
		else 
			System.out.println("N khong la so nguyen to");
	}
	
	public static boolean snt(int n) {
		if (n == 1) return false;
		for (int i=2;i<=Math.sqrt(n);++i) {
			if (n%i == 0)
				return false;
		}
		return true;
	}

}
