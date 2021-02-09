package in.jdbc.marksheetResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.mysql.jdbc.ResultSet;

import in.jdbc.marksheet.MarksheetBean;

public class MarksheetModel {
	
	public static void add(MarksheetBean bean) throws Exception{
		ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
		Class.forName(rb.getString("Driver"));
		
		Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
		conn.setAutoCommit(false);
		
		PreparedStatement ps= conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2,bean.getRoll_No());
		ps.setString(3, bean.getFname());
		ps.setString(4, bean.getLname());
		ps.setInt(5, bean.getPhysics());
		ps.setInt(6, bean.getChemistry());
		ps.setInt(7, bean.getMaths());
		ps.executeUpdate();
		((Connection) rb).commit();
		System.out.println("Reacord inserted");
		ps.close();
		conn.close();
	}
	public static void update(MarksheetBean b) throws Exception{
		ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement p=conn.prepareStatement("update marksheet set fname=? where id=?");
		p.setString(1, b.getFname());
		p.setInt(2, b.getId());
		p.executeUpdate();
		conn.commit();
		System.out.println("Record updated");
		p.close();
		conn.close();
	}
	public static void delete(MarksheetBean b) throws Exception{
		ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
		
		conn.setAutoCommit(false);
		PreparedStatement p=conn.prepareStatement("delete from marksheet where id=?");
		
		p.setInt(1, b.getId());
		p.executeUpdate();
		conn.commit();
		System.out.println("delete");
		p.close();
		conn.close();
	}
	public static void search(MarksheetBean b) throws Exception{
		ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement p=conn.prepareStatement("select * from Marksheet where roll_no=?");
		
		p.setString(1, b.getRoll_No());
		ResultSet rs=(ResultSet) p.executeQuery();
		System.out.println("Stu_id\trollno\tfname\tlname\tphysics\tchem\tmaths");
		while(rs.next()){
        	System.out.print(rs.getInt(1));
        	System.out.print("\t"+rs.getString(2));
        	System.out.print("\t"+rs.getString(3));
        	System.out.print("\t"+rs.getString(4));
        	System.out.print("\t"+rs.getInt(5));
        	System.out.print("\t"+rs.getInt(6));
        	System.out.println("\t"+rs.getInt(7));
        }
		
		p.executeQuery();
		conn.commit();
		System.out.println("Record selected");
		p.close();
		conn.close();
	}
	public static void maritlist(MarksheetBean b) throws Exception{
		ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
		Class.forName(rb.getString("Driver"));
		Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
		conn.setAutoCommit(false);
		PreparedStatement p=conn.prepareStatement("select *, (physics+chemistry+maths)as total,(((physics+chemistry+maths)/300)*100)as percentage from marksheet order by percentage desc limit 0,5 ");
		//p.setString(1, b.getRoll_No());
		ResultSet rs=(ResultSet) p.executeQuery();
		System.out.println("Stu_id\trollno\tfname\tlname\tphysics\tchem\tmaths\ttotal\tper");
		while(rs.next()){
        	System.out.print(rs.getInt(1));
        	System.out.print("\t"+rs.getString(2));
        	System.out.print("\t"+rs.getString(3));
        	System.out.print("\t"+rs.getString(4));
        	System.out.print("\t"+rs.getInt(5));
        	System.out.print("\t"+rs.getInt(6));
        	System.out.print("\t"+rs.getInt(7));
        	System.out.print("\t"+rs.getInt(8));
        	System.out.println("\t"+rs.getInt(9)+"%");
        }
		p.executeQuery();
		conn.commit();
		System.out.println("Marit list");
		p.close();
		conn.close();
	}
public static void select(MarksheetBean b) throws Exception{
	ResourceBundle rb=ResourceBundle.getBundle("in.jdbc.marksheetResourceBundle.app");
	Class.forName(rb.getString("Driver"));
	Connection conn=DriverManager.getConnection(rb.getString("URL"),rb.getString("user"),rb.getString("password"));
	
	PreparedStatement p=conn.prepareStatement("Select * from marksheet ");
	//p.setString(1, b.getRoll_No());
	ResultSet rs=(ResultSet) p.executeQuery();
	System.out.println("Stu_id\trollno\tfname\tlname\tphysics\tchem\tmaths");
	while(rs.next()){
    	System.out.print(rs.getInt(1));
    	System.out.print("\t"+rs.getString(2));
    	System.out.print("\t"+rs.getString(3));
    	System.out.print("\t"+rs.getString(4));
    	System.out.print("\t"+rs.getInt(5));
    	System.out.print("\t"+rs.getInt(6));
    	System.out.println("\t"+rs.getInt(7));
    }
	p.executeQuery();
	
	System.out.println("Reacord searched");
	p.close();
	conn.close();
}

}


