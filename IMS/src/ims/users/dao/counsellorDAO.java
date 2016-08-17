package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.CounsellorDTO;

public class counsellorDAO {
	public boolean counsellor(CounsellorDTO counsellorDTO) throws SQLException{
	boolean counsellor = false;
	String sql = CommonSQLConstants.COUNSELLOR_SQL;
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs ;
try {
		con= CommonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,counsellorDTO.getName());
		pstmt.setString(2,counsellorDTO.getAddress());
		pstmt.setString(3,counsellorDTO.getPhonenumber());
		pstmt.setString(4,counsellorDTO.getQualification());
		pstmt.setString(5,counsellorDTO.getGender());
		rs = pstmt.executeUpdate();
		if(rs>0)
		{
			counsellor =true;
		}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed");
			}
	      finally{
	    	  if(con!=null){
              con.close();
              }
	      }
	return counsellor;
}
}
	