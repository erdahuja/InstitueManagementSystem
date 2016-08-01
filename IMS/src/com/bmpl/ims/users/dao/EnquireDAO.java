package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.EnquireDTO;

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
		java.sql.Date date;
		
		
		rs = pstm.executeUpdate();
		try{
			enquireadded=true;
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("can't execiute");
		}
		finally{
			con.close();
		}
		return enquireadded;
	
	}
	
	public ArrayList<String> getCourse() throws SQLException{
		boolean courseShown = false;
		String sql = CommonSQLConstants.COURSE_SQL;
		Connection con = null;
		PreparedStatement pstm = null;
			ResultSet rs;
			ArrayList<String> list = new ArrayList();
				try {
					con = CommonDAO.getConnection();
				
				pstm = con.prepareStatement(sql);
				rs = pstm.executeQuery();
				
				while(rs.next()){
					list.add(rs.getString("CourseName"));
					courseShown = true;
				}
				}
					catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				finally{
					con.close();
				}
				return list;
			}
	}

