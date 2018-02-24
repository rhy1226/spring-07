package jdbc;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest2 {
    public static void main(String[] args) {
		String url="jdbc:mysql://192.168.228.167:3306/aaa";
		String user="root";
		String password="123456";
		PreparedStatement pre=null;
		 ResultSet exe =null;
		 Connection con =null;
    	try {
    		//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//选择要操作的数据库
			 con = DriverManager.getConnection(url,user,password);
			//创建命令窗口，写sql语句
			 pre = con.prepareStatement("select * from course");
			 //运行sql语句并查看结果,如果是增删改，则返回受影响的行数，如果是查询返回的是查询结果
			 //增删改调用的是executeUpdate,返回int,查询调用的是executeQuery,返回ResultSet
			  exe = pre.executeQuery();
			 while(exe.next()){
				 System.out.println(exe.getString("name")+","+exe.getInt("id"));
			 }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(exe!=null)
				    exe.close();
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
