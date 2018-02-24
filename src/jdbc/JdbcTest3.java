package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest3 {
 public static void main(String[] args) {
	String url="jdbc:mysql://192.168.228.167:3306/bbb";
	String user="root";
	String password="123456";
	PreparedStatement pre =null;
	Connection con =null;
	 try {
		 //加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//选择要操作的数据库
		 con = DriverManager.getConnection(url,user,password);
		//创建命令窗口，写sql语句
		 pre = con.prepareStatement("delete  from test where id=?");
		pre.setInt(1, 1);
		int exe = pre.executeUpdate();
		System.out.println(exe);
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		
			try {
				if(pre!=null)
				   pre.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
}
