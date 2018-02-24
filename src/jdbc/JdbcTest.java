package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTest {
    
    	public static void main(String[] args) {
    		//��ʽ��jdbc:mysql://����IP���˿ں�/���ݿ���
    		String url="jdbc:mysql://192.168.228.167:3306/aaa?useUnicode=true&characterEncoding=utf8";
    		String user="root";
    		String password="123456";
    		int exe =0;
    		PreparedStatement pre =null;
    		Connection con = null;
		
    		try {
    			//�������������䣩--- ѡ��Ҫ���������ݿ�����
				Class.forName("com.mysql.jdbc.Driver");
				//ѡ��Ҫ���������ݿ�----�������ӣ�����IP �˿������û��������� 
				 con = DriverManager.getConnection(url,user,password);
				//��������ڣ�дsql���
				 pre = con.prepareStatement("insert into xuesheng(name,b_id) values(?,?)");
				 //ע�����
				 pre.setString(1, "�λ�Ӱ");
				 pre.setInt(2, 1);
				//����sql��䣬�������ɾ�ģ��򷵻���Ӱ�������������ǲ�ѯ���ص��ǲ�ѯ���
				 //��ɾ�ĵ��õ���executeUpdate,����Ϊint����ѯ���õ���executeQuery,���ص���ResultSet
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
