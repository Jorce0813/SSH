package cn.gdufe.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author luhengxun
 * @describe The bean for database's connection
 */
public class DbBean {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public DbBean() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Open the Connection with the mysql database
	 */
	public void openConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8";
			String username = "root";
			String password = "123456";
			conn = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Query from the table in DB
	 * @param sql
	 * @return
	 */
	public ResultSet executeQuery(String sql){
		rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * Update the record in DB
	 * @param sql
	 * @return
	 */
	public int executeUpdate(String sql){
		int n = 0;
		try {
			pstm = conn.prepareStatement(sql);
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * Close the Connection with the DB
	 */
	public void closeConnection(){
		try {
			if(rs!=null)
				rs.close();
			if(pstm!=null)
				pstm.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
