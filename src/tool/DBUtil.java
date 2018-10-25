package tool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DBUtil {
	
	private static final String MySQL="MySQL";
	private static final String Oracle="Oracle";
	private static final String SQLServer="SQLServer";
	private static Properties p = new Properties();    
	static {
		
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("config.properties");    
		
		try {    
			p.load(inputStream);    
		} catch (IOException e) {    
			e.printStackTrace(); 
			System.out.println("数据库配置文件读取错误...");
		}  
	}

	private static String murl=p.getProperty("MySQLURL");
	//private static String murl="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=UTF-8";
	private static String mname=p.getProperty("MySQLUser");
	private static String mpwd=p.getProperty("MySQLPass");
	
	private static String surl=p.getProperty("SQLServerURL");
	private static String sname=p.getProperty("SQLServerUser");;
	private static String spwd=p.getProperty("SQLServerPass");;
	
	private static String ourl=p.getProperty("OracleURL");
	private static String oname=p.getProperty("OracleUser");;
	private static String opwd=p.getProperty("OraclePass");;
	
	static {
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Class.forName("com.mysql.jdbc.Driver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getMySQLConn(){
		
		Connection conn=null;
		
		try {
			
			conn=DriverManager.getConnection(murl,mname,mpwd);
			DatabaseMetaData metaData = conn.getMetaData();

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
		public static Connection getSQLServerConn(){
			
			Connection conn=null;
			
			try {
				conn=DriverManager.getConnection(surl,sname,spwd);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return conn;
		}
		
		public static Connection getOracleConn(){
			
			Connection conn=null;
			
			try {
				conn=DriverManager.getConnection(ourl,oname,opwd);
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			return conn;
		}
	
	
	public static void closeConn(ResultSet rs,PreparedStatement pstmt,Connection conn){
		
		if(rs!=null){
			
		try {
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					rs.close();
				}
				if(conn!=null){
					rs.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
				
			}
		}

		if(pstmt!=null){
				
			try {
					
				pstmt.close();
					
				
			} catch (SQLException e) {
				
				System.out.println("pstmt关闭异常...");
				e.printStackTrace();
				
			}
		}
		
		
			
		if(conn!=null){
				
			try {
					
				conn.close();
					
			
			} catch (SQLException e) {
				
				System.out.println("conn关闭异常...");
				e.printStackTrace();
				
			}
		}

	}
	
	
	public static Connection getDBConetion(){
		
		String type=p.getProperty("database");
		
		if("Oracle".equals(type)){
			
			return getOracleConn();
			
		}
		else if("MySQL".equals(type)){
			
			return getMySQLConn();
		}
		else if("SQLServer".equals(type)){
			
			return getSQLServerConn();
		}
		else{
			
			System.err.println("数据库配置错误！");
			return null;
		}
		
	}

}