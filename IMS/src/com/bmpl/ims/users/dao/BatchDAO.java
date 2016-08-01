package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.BatchDTO;
import com.bmpl.ims.users.dto.CourseDTO;

public class BatchDAO {

	public boolean addbatch(BatchDTO batchdto) throws SQLException, ClassNotFoundException
	{
		boolean isaddbatch=false;
		String sql  = CommonSQLConstants.ADDBATCH_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		//String url2 = "jdbc:mysql://localhost:3306/admin?user=root&password=sunil2345";
		//ResourceBundle rb=ResourceBundle.getBundle("connetionfile");
		//Class.forName(rb.getString("drivername"));
		try{
		//Class.forName("com.mysql.jdbc.Driver");
		//Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/admin;",rb.getString("userid"),rb.getString("password"));
		con=CommonDAO.getConnection();
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, batchdto.getBatchname());
		pstmt.setString(2, batchdto.getCoursename());
		pstmt.setString(3, batchdto.getTrainername());
		pstmt.setLong(4, batchdto.getTotalsets());
		pstmt.setString(5, batchdto.getDescription());
		pstmt.setDate(6, (java.sql.Date)batchdto.getBatchstartdate());
		int row = pstmt.executeUpdate();
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
	
	public ArrayList<String> getCourse() throws SQLException, ClassNotFoundException
	{
		String getcourse = CommonSQLConstants.GETCOURSE_SQL;
		Statement stmt=null;
		ResultSet rs=null;
		Connection con= null;
		BatchDTO batchdto=new BatchDTO();
		ArrayList<String> courseList = new ArrayList<>();
		
		con=CommonDAO.getConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery(getcourse);
		while(rs.next())
		{
			CourseDTO Coursedto= new CourseDTO();
			Coursedto.setCoursename(rs.getString("coursename"));
			courseList.add(Coursedto.getCoursename());
		}
		return courseList;
	}
}
