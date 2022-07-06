package exception;

public class ArrayExceptionTest {
	public static void main(String[] args) {
		int[] a = new int[5];		
		try {	
		for(int i = 0; i<=5; i++) {
			System.out.println(a[i]);
			}
		}catch(Exception e ) {
			System.out.println(e);
		}
	}
}
