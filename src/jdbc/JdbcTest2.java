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
    		//��������
			Class.forName("com.mysql.jdbc.Driver");
			//ѡ��Ҫ���������ݿ�
			 con = DriverManager.getConnection(url,user,password);
			//��������ڣ�дsql���
			 pre = con.prepareStatement("select * from course");
			 //����sql��䲢�鿴���,�������ɾ�ģ��򷵻���Ӱ�������������ǲ�ѯ���ص��ǲ�ѯ���
			 //��ɾ�ĵ��õ���executeUpdate,����int,��ѯ���õ���executeQuery,����ResultSet
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
