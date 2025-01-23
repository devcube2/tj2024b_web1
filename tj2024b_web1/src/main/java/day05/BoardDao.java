package day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {
	private Connection conn;
	private static BoardDao instance = new BoardDao();

	private BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0122", "root", "1234");
			if (conn != null) {
				System.out.println("DB 연동 성공");
			} else {
				System.out.println("** DB 연동 실패 **");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static BoardDao getInstance() {
		return instance;
	}

	public boolean execute(String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			int count = ps.executeUpdate();
			if (count >= 1)
				return true;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}

	public ArrayList<BoardDto> findByAll() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate, bview, bpwd from board";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				BoardDto BoardDto = new BoardDto();
				BoardDto.setBno(rs.getInt("bno"));
				BoardDto.setBtitle(rs.getString("btitle"));
				BoardDto.setBcontent(rs.getString("bcontent"));
				BoardDto.setBwriter(rs.getString("bwriter"));
				BoardDto.setBdate(rs.getString("bdate"));
				BoardDto.setBview(rs.getInt("bview"));
				BoardDto.setBpwd(rs.getString("bpwd"));
				list.add(BoardDto);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public BoardDto findByOne(String sql) {
		BoardDto dto = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDto();
				dto.setBno(rs.getInt("bno"));
				dto.setBtitle(rs.getString("btitle"));
				dto.setBcontent(rs.getString("bcontent"));
				dto.setBwriter(rs.getString("bwriter"));
				dto.setBdate(rs.getString("bdate"));
				dto.setBview(rs.getInt("bview"));
				dto.setBpwd(rs.getString("bpwd"));
				System.out.println(dto);

			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return dto;
	}

	public boolean checkPassword(String sql) {
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) { // 비밀번호 일치
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return false;
	}
}