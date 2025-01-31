package day09;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example2 {
	public static void main(String[] args) {

		// [2] 파일의 자료를 자바로 가져오기 (입력)
		try {
			// (1) 파일입력스트림 객체 생성
			FileInputStream in = new FileInputStream("z:/java/test1.txt");
			// (2) 바이트 배열 선언 , 임의의 크기 10
			byte[] bytes = new byte[10];
			in.read(bytes);
			String str = new String(bytes);
			System.out.println(str);
			System.out.println("파일불러오기성공");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		// [3] 파일 클래스
			// (1) 지정한 경로의 파일을 자바 객체와 연결하기
		File file = new File("z:/java/test1.txt");
			// (2) 파일 존재 여부 확인 메소드
		System.out.println(file.isFile());
			// (3) 파일 이름 반환 메소드
		System.out.println(file.getName());
		System.out.println(file.exists());
			// (4) 파일 (바이트)용량 반환 메소드
		System.out.println(file.length());
		System.out.println(file.delete());
		System.out.println(file.getPath());
		
		File file2 = new File("z:/java2");
		if (!file2.exists()) {
			file2.mkdir();
		}
	}
}