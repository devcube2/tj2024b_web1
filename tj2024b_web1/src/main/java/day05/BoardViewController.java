package day05;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/day05/board/view")
public class BoardViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[BoardViewController doGet 호출]");		
		
		int bno = Integer.parseInt(req.getParameter("bno"));		
		
		String sql = String.format("SELECT bno, btitle, bcontent, bwriter, bdate, bview, bpwd FROM board WHERE bno = %d", bno);
		System.out.println(sql);
		BoardDto result = BoardDao.getInstance().findByOne(sql);	
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonResult);
	}
}
