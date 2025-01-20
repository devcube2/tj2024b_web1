package day03.task2;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day03/waiting")
public class WaitingController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doGet 호출]");
	}
	
	// 1. 방문록 작성 : 등록은 주로 POST
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doPost 호출]");
		// 1.. BODY(본문)의 JSON를 DTO로 파싱/변환 하기 위한 인스턴스 생성/준비
		ObjectMapper mapper = new ObjectMapper();
		// 2. JSON -> DTO 변환
		WaitingDto visitDto = mapper.readValue(req.getReader(), WaitingDto.class);
		System.out.println(visitDto);		
		// 3. DAO 처리
		boolean result = WaitingDao.getInstance().write(visitDto);
		System.out.println("post : " + result);
	}
	
	// 2. 방문록 삭제 : 삭제는 주로 DELETE
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[doDelete 호출]");
		// 1. queryString의 매개변수를 파싱 하기 위한 코드
		int no = Integer.parseInt(req.getParameter("no"));
		System.out.println("no : " + no);
		// 2. DAO 처리
		boolean result = WaitingDao.getInstance().delete(no);
		System.out.println("delete : " + result);
	}
}
