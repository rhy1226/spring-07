package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {
    
    	public static void main(String[] args) {
    		//格式：jdbc:mysql://主机IP：端口号/数据库名
    		String url="jdbc:mysql://192.168.228.167:3306/aaa?useUnicode=true&characterEncoding=utf8";
    		String user="root";
    		String password="123456";
    		int exe =0;
    		PreparedStatement pre =null;
    		Connection con = null;
		
    		try {
    			//加载驱动（反射）--- 选择要操作的数据库种类
				Class.forName("com.mysql.jdbc.Driver");
				//选择要操作的数据库----创建连接，主机IP 端口名，用户名，密码 
				 con = DriverManager.getConnection(url,user,password);
				//创建命令窗口，写sql语句
				 pre = con.prepareStatement("insert into xuesheng(name,b_id) values(?,?)");
				 //注入参数
				 pre.setString(1, "任换影");
				 pre.setInt(2, 1);
				//运行sql语句，如果是增删改，则返回受影响的行数，如果是查询返回的是查询结果
				 //增删改调用的是executeUpdate,返回为int。查询调用的是executeQuery,返回的是ResultSet
			     exe = pre.executeUpdate();
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
