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
		 //��������
		Class.forName("com.mysql.jdbc.Driver");
		//ѡ��Ҫ���������ݿ�
		 con = DriverManager.getConnection(url,user,password);
		//��������ڣ�дsql���
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
