package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.UserDTO;

public class LoginDAO {
	private Logger logger = Logger.getLogger(LoginDAO.class);
	public boolean authenticateUser(UserDTO userDTO) throws ClassNotFoundException, SQLException{
		logger.debug("Inside DAO Authenticate User "+userDTO);
		boolean isFound = false;
		String sql  = CommonSQLConstants.LOGIN_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				isFound = true;
			}
		}
		finally{
			logger.debug("Resource Close Inside Finally");
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return isFound;
	}

}
