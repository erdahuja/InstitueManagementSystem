package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.BatchDTO;

public class BatchDAO {

	public boolean addbatch(ArrayList<BatchDTO> arraybatch) throws SQLException, ClassNotFoundException
	{
		boolean isaddbatch=false;
		String sql  = CommonSQLConstants.ADDBATCH_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		Integer row=null;
		//String url2 = "jdbc:mysql://localhost:3306/admin?user=root&password=sunil2345";
		//ResourceBundle rb=ResourceBundle.getBundle("connetionfile");
		//Class.forName(rb.getString("drivername"));
		try{
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admin;",rb.getString("userid"),rb.getString("password"));
		con=CommonDAO.getConnection();
		for(BatchDTO batahlist: arraybatch)
		{
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, batahlist.getBatchname());
		pstmt.setString(2, batahlist.getCoursename());
		pstmt.setString(3, batahlist.getTrainername());
		pstmt.setLong(4, batahlist.getTotalsets());
		pstmt.setString(5, batahlist.getDescription());
		pstmt.setDate(6, (java.sql.Date)batahlist.getBatchstartdate());
		pstmt.setString(7, batahlist.getStarttime());
		pstmt.setString(8, batahlist.getEndtime());
		row = pstmt.executeUpdate();
		}
		if(row>0)
		{
			isaddbatch=true;
		}
		}
		finally
		{
			con.close();
		}
		return isaddbatch;
	}
	
	public static ArrayList<String> getCourse() throws SQLException, ClassNotFoundException
	{
		String getcourse = CommonSQLConstants.VIEWCOURSE_SQL;
		Statement stmt=null;
		ResultSet rs=null;
		Connection con= null;
		BatchDTO batchdto=null;
		ArrayList<String> courseList = new ArrayList<>();
		
		con=CommonDAO.getConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery(getcourse);
		while(rs.next())
		{
			batchdto= new BatchDTO();
			batchdto.setCoursename(rs.getString("course_name"));
			batchdto.setCourse_id(rs.getInt("course_id"));
			courseList.add(batchdto.getCoursename());
		}
		return courseList;
	}
}
