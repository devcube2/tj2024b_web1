package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import day03.task4.WaitingDao;
import day03.task4.WaitingDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board")
public class BoardController extends HttpServlet {
	private boolean checkPassword(int bno, String pwd) {
		String sql = String.format("SELECT * FROM board WHERE bno = %d and bpwd = '%s'", bno, pwd);
		return BoardDao.getInstance().checkPassword(sql);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[BoardController doPost 호출]");

		// 브라우저로부터 받은 값
		ObjectMapper mapper = new ObjectMapper();
		BoardDto dto = mapper.readValue(req.getReader(), BoardDto.class);

		// 쿼리 실행
		String sql = String.format(
				"INSERT INTO board (btitle, bcontent, bwriter, bpwd) VALUES ('%s', '%s', '%s', '%s')", dto.getBtitle(),
				dto.getBcontent(), dto.getBwriter(), dto.getBpwd());
		boolean result = BoardDao.getInstance().execute(sql);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[BoardController doGet 호출]");
		ArrayList<BoardDto> result = BoardDao.getInstance().findByAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[BoardController doPut 호출]");

		// 브라우저로부터 받은 값
		ObjectMapper mapper = new ObjectMapper();
		BoardDto dto = mapper.readValue(req.getReader(), BoardDto.class);

		resp.setContentType("application/json");
		// 비밀번호 검사
		if (!checkPassword(dto.getBno(), dto.getBpwd())) {
			resp.getWriter().print(false);
			return;
		}

		// 쿼리 실행
		String sql = String.format("UPDATE board SET btitle = '%s' , bcontent = '%s' , bwriter = '%s' where bno = %d",
				dto.getBtitle(), dto.getBcontent(), dto.getBwriter(), dto.getBno());
		boolean result = BoardDao.getInstance().execute(sql);
		resp.getWriter().print(result);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[BoardController doDelete 호출]");

		// 브라우저로부터 받은 값
		int bno = Integer.parseInt(req.getParameter("bno"));
		String pwd = req.getParameter("pwd");

		resp.setContentType("application/json");

		if (!checkPassword(bno, pwd)) {
			resp.getWriter().print(false);
			return;
		}

		// 쿼리 실행
		String sql = String.format("DELETE FROM board WHERE bno = %d", bno);
		boolean result = BoardDao.getInstance().execute(sql);
		resp.getWriter().print(result);
	}
}