import java.util.Scanner;

public class bai7 {

	public bai7() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int arr[] = {1,2,3,4,5};
		int n = arr.length;
		int x = 2;
		int result = search(arr,0,n-1,x) + 1;
		if(result == -1)
			System.out.println("NO");
		else
			System.out.println("YES: "+ result);
	}
	public static int search(int arr[], int l, int r, int x) {
		if (r>=l) {
			int m = (l+r)/2;
			if (arr[m] == x)
				return m;
			if (arr[m] > x)
				return search(arr,l,m-1,x);
			return search(arr,m+1,r,x);
		}
		return -1;
	}
}
