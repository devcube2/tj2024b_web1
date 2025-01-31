package day09;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day09/example3")
public class Example3 extends HttpServlet {
	
	// * 여러개 map객체를 저장할 list 선언
	private ArrayList<HashMap<String, String>> list = new ArrayList();
	private String filePath = "z:/java";
	
	// 1. doPost : 파일쓰기
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		HashMap<String, String> map = mapper.readValue(req.getReader(), HashMap.class);
		
		list.add(map);
		
		File file = new File(filePath);
		if ( !file.exists() ) {
			file.mkdir();
		}
		
		FileOutputStream out = new FileOutputStream(filePath + "/test3.txt");
		String outStr = mapper.writeValueAsString(list);
		byte[] bytes = outStr.getBytes();
		out.write(bytes);
		
		resp.setContentType("text/plain");
		resp.getWriter().print("파일 저장 성공");
	}
	
	// 2. 파일 내용 가져오기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 지정한 파일경로의 파일객체로 가져오기
		File file = new File(filePath + "/test3.txt");
		if (!file.exists()) { // 2. 만일 파일이 존재하지 않으면
			System.out.println("파일이 존재하지 않습니다.");
			resp.setContentType("text/plain");
			resp.getWriter().print("파일이 존재하지 않습니다. : " + filePath + "/test3.txt");
		} else {
			// 3. 파일의 자료들을 arraylist 타입으로 변환
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<HashMap<String, String>> list = mapper.readValue(file, ArrayList.class);
			// 4. 읽어온 파일의 list 내용들을 다시 json 문자열로 변환
			String jsonResult = mapper.writeValueAsString(list);
			// 5. 파일의 내용 HTTP 응답하기
			resp.setContentType("application/json");
			resp.getWriter().print(jsonResult);
		}
	}
}
