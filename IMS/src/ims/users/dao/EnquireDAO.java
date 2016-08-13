package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.EnquireDTO;
import com.bmpl.ims.users.views.EnquireView;

public class EnquireDAO {
	public boolean addEnquire(EnquireDTO enquireDTO) throws ClassNotFoundException, SQLException{
		boolean enquireadded = false;
		String sql = CommonSQLConstants.ENQUIRE_SQL;
		Connection con = null;
		PreparedStatement pstm = null;
		int rs;
		con = CommonDAO.getConnection();
		pstm = con.prepareStatement(sql);
		pstm.setString(1, enquireDTO.getFirstName());
		pstm.setString(2, enquireDTO.getSecondName());
		pstm.setString(3, enquireDTO.getAddress1());
		pstm.setString(4, enquireDTO.getAddress2());
		pstm.setString(5, enquireDTO.getEmail());
		pstm.setString(6, enquireDTO.getMobileContact());
		pstm.setString(7, enquireDTO.getOtherContact());
		pstm.setString(8, enquireDTO.getSlot1());
		pstm.setString(9, enquireDTO.getSlot2());
		pstm.setString(10, enquireDTO.getFatherFirstName());
		pstm.setString(11, enquireDTO.getFatherSecondName());
		pstm.setString(12, enquireDTO.getFatherMobileContact());
		pstm.setString(13, enquireDTO.getFatherOtherContact());
		pstm.setString(14, enquireDTO.getUniversity());
		pstm.setString(15, enquireDTO.getQualification());
		pstm.setString(16, enquireDTO.getReference());
		EnquireView enquireView = new EnquireView();
		pstm.setTimestamp(17,enquireView.getCurrentTimeStamp());
		//pstm.setString(18, enquireDTO.getEnquireContact());
		
		
		rs = pstm.executeUpdate();
		try{
			enquireadded=true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("can't execute");
		}
		finally{
			con.close();
		}
		return enquireadded;
	
	}

	public static ArrayList<String> getCourse() throws SQLException, ClassNotFoundException
	{
		String getcourse = CommonSQLConstants.COURSE_SQL;
		Statement stmt=null;
		ResultSet rs=null;
		Connection con= null;
		ArrayList<String> courseList = new ArrayList<>();
		
		con=CommonDAO.getConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery(getcourse);
		while(rs.next())
		{
			EnquireDTO enquireDTO= new EnquireDTO();
			enquireDTO.setCoursename(rs.getString("coursename"));
			courseList.add(enquireDTO.getCoursename());
		}
		return courseList;
	}
	}


