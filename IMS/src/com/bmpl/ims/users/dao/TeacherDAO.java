package com.bmpl.ojas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ojas.Common.*;
import com.bmpl.ojas.DTO.TeacherDTO;

public class TeacherDAO {
	
	public boolean addTutor(TeacherDTO teacherDTO) throws SQLException{
		boolean tutorAdded = false;
		String sql = CommonSQLConstants.ADDTUTOR_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		
		try {
			con = CommonDAO.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		pstmt = con.prepareStatement(sql);
		
		rs = pstmt.executeUpdate();
		
		tutorAdded =true;
		
		
		
		
		return tutorAdded;
	}
	public ArrayList<String> getCourse() throws SQLException {
		boolean coursesShown = false;
		String sql = CommonSQLConstants.VIEWCOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		ArrayList<String> list = new ArrayList<String>();
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString("name"));

				coursesShown = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			coursesShown = false;

		} finally {
			con.close();
		}
		return list;
	}
	
public boolean deleteCourse(String item) throws SQLException{
	boolean isDeleted = false;
	String sql = CommonSQLConstants.DELETECOURSE_SQL;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs ;
	try{
		
	con = CommonDAO.getConnection();
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, item);
	rs = pstmt.executeUpdate();
	
	isDeleted = true;
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Failed to delete");
	}finally{
		con.close();
	}
	
	return isDeleted = true;
}

public static boolean updateCourse(String item) throws SQLException{
	boolean isUpdated = false;
	String sql = CommonSQLConstants.UPDATECOURSE_SQL;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs;
	try{
	con = CommonDAO.getConnection();
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1, item);
	rs=pstmt.executeUpdate();
	
	isUpdated = true;
	}catch(Exception e)
	{
	e.printStackTrace();
	
	System.out.println("Failed to update");
	}finally{
	con.close();
}


	return isUpdated = true;
}

/*public static ArrayList<String> showCourse(String item) throws SQLException {
	boolean coursesShown = false;
	String sql = CommonSQLConstants.CHOOSECOURSE_SQL;
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	ArrayList<String> list = new ArrayList<String>();
	try {
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, item);
		pstmt.setString(2, item);
		pstmt.setString(3, item);
		pstmt.setString(4, item);
		pstmt.setString(5, item);
		pstmt.setString(6, item);
		pstmt.setString(7, item);
		
		
		rs = pstmt.executeQuery();

		while (rs.next()) {

			list.add(rs.getString(1));

			list.add(rs.getString(2));

			list.add(rs.getString(3));

			list.add(rs.getString(4));

			list.add(rs.getString(5));
			list.add(rs.getString(6));
			list.add(rs.getString(7));

			coursesShown = true;
		

	}
	}catch (Exception e) {
		e.printStackTrace();
		coursesShown = false;

	} finally {
		con.close();
	}
	return list;


	
	

}*/
}