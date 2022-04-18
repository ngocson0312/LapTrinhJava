import java.util.Scanner;

public class Bai14 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập chuỗi s1: ");
		String s1 = scan.nextLine();
		String[] str = s1.split("");
		String[] str2 = new String[str.length];
		str2[0] =str[0];
		int x=1;
		for(int i=1;i<str.length;i++) {
			int dem = 0;
			for(int j=0;j<x;j++) {
				if(str[i] == str2[j]) {
					dem++;
				}
			}
			if(dem == 0) {
				str2[x] = str[i];
				x++;
			}
		}
		System.out.print("Số kt khác nhau là: "+x);
	}
	
}
