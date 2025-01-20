package day03.task2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WaitingDao {
	private Connection conn;
	// + 싱글톤
	private static WaitingDao instance = new WaitingDao();

	private WaitingDao() {
		try {
			// DB연동 코드 : 
			// 코드 작성전에 필수 : 프로젝트의 mysql-connector-j-9.1.0.jar
			// 라이브러리 폴더 경로 : src -> main -> webapp -> web-inf -> lib 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mydb0120",
					"root" , "1234");
			if (conn != null) {
				System.out.println("DB 연동 성공");
			}
			else {
				System.out.println("** DB 연동 실패 **");
			}
		}catch( Exception e ) { System.out.println(e); }
	}

	public static WaitingDao getInstance() {
		return instance;
	}

	// 1. 방문록 등록 SQL
	public boolean write(WaitingDto waitingDto) {
		try {
			String sql = "insert into waiting(telno, count) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, waitingDto.getTelNo());
			ps.setInt(2, waitingDto.getCount());
			int count = ps.executeUpdate();
			if (count == 1)
				return true;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	} // f end

	// 4. 방문록 삭제 SQL
	public boolean delete(int no) {
		try {
			String sql = "delete from waiting where no = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			int count = ps.executeUpdate();
			if (count == 1)
				return true;
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	} // f end

}// class end