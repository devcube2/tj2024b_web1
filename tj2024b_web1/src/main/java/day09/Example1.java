package day09;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		try {
			// [1] 실행중인 자바 자료를 (윈도우)파일에 출력 하기
			FileOutputStream out = new FileOutputStream("z:/java/test1.txt");
			String str = "Hello JAVA";
			out.write(str.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		// [2] 키보드로부터 입력받은 자료를 파일에 출력하기
		try {		
			FileOutputStream out = new FileOutputStream("z:/java/test2.txt");
			Scanner scan = new Scanner(System.in);
			System.out.println("[2] 메모장에 작성할 내용입력: ");
			String str = scan.next();
			out.write(str.getBytes());			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
