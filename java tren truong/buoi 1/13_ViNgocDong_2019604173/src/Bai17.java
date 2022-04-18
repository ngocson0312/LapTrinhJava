import java.util.Scanner;

public class Bai17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời nhập chuỗi s: ");
		String s = scan.nextLine();
		String[] arr = s.split(" ");
		StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < arr.length; i++) {
	    	 sb.append(arr[i].substring(0, 1).toUpperCase()+arr[i].substring(1).toLowerCase()+" ");
	    }  
	    System.out.print(sb);
	}

}
