package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.BatchDTO;
import com.bmpl.ims.users.dto.TakeAttendanceDTO;

public class TakeAttendanceDAO {

	//TakeAttendanceDTO takeattendance;
	public boolean addattendancetake(TakeAttendanceDTO takeattendancedto) throws SQLException, ClassNotFoundException
	{
		boolean isFound = false;
		String sql  = CommonSQLConstants.TAKEATTENDANCE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		Statement stmt=null;
		Integer rs = null;
		List<String> studentlist=null;
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			studentlist=takeattendancedto.getStudent();
			for(String list: studentlist)
			{
			pstmt.setDate(1, (Date)takeattendancedto.getDate());
			pstmt.setString(2, list);
			pstmt.setString(3, takeattendancedto.getBatchname());
			rs = pstmt.executeUpdate();
			}
			if(rs>0){
				isFound = true;
			}
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return isFound;
		
	}
	public static ArrayList<TakeAttendanceDTO> viewattendance(TakeAttendanceDTO takeattendacedto)
	{
		String getcourse = CommonSQLConstants.GETATTANDANCE(takeattendacedto.getBatchname(), takeattendacedto.getSelectedstudent(), takeattendacedto.getEnddate(), takeattendacedto.getStartdate() );
		Statement stmt=null;
		ResultSet rs=null;
		Connection con= null;
		//TakeAttendanceDTO takeattendacedto=null;
		ArrayList<TakeAttendanceDTO> attandanceList = new ArrayList<>();
	try{
		con=CommonDAO.getConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery(getcourse);
		while(rs.next())
		{
			takeattendacedto= new TakeAttendanceDTO();
			takeattendacedto.setBatchname(rs.getString("batchname"));
			takeattendacedto.setSelectedstudent(rs.getString("studentname"));
			takeattendacedto.setDate(rs.getDate("attandance_date"));			
			attandanceList.add(takeattendacedto);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return attandanceList;
	}
	
}
