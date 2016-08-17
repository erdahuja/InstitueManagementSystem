package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;

public class BatchesDAO {

	public boolean markAttendance() throws SQLException{
	boolean attendanceDone = false;
	String sql = CommonSQLConstants.TAKEATTENDANCE_SQL;
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs;
	
	try
	{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		
		//add db statemnts
		rs=pstmt.executeUpdate();

	}catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("can't execiute");
	}finally
	{
		con.close();
	}
	return attendanceDone;
}
}
