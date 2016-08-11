package com.bmpl.counsellorform.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bmpl.counsellorform.DTO.counsellorDTO;
import com.bmpl.counsellorform.commonDAO.commonDAO;
import com.bmpl.counsellorform.view.commonSQLconstant;

public class counsellorDAO {
	public boolean counsellor(counsellorDTO counsellorDTO) throws SQLException{
	boolean counsellor = false;
	String sql = commonSQLconstant.COUNSELLOR_SQL;
	Connection con = null;
	PreparedStatement pstmt = null;
	int rs ;
try {
		con= commonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,counsellorDTO.getName());
		pstmt.setString(2,counsellorDTO.getAddress());
		pstmt.setString(3,counsellorDTO.getPhonenumber());
		pstmt.setString(4,counsellorDTO.getQualification());
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
	