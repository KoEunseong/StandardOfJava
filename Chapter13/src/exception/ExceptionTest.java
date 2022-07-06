package exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class ExceptionTest {
	public static void main(String[] args) {
		
		try(FileInputStream fis = new FileInputStream("a.txt")) {
			
		} catch (FileNotFoundException e) {
			System.out.println(e+"bbb");
		} catch (IOException e1) {
			System.out.println(e1);
		} 
		
	}
}
