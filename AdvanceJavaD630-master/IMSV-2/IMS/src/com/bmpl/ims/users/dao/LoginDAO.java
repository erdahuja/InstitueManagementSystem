package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.RightDTO;
import com.bmpl.ims.users.dto.UserDTO;

public class LoginDAO {
	private Logger logger = Logger.getLogger(LoginDAO.class);
	public UserDTO authenticateUser(UserDTO userDTO) throws ClassNotFoundException, SQLException{
		logger.debug("Inside DAO Authenticate User "+userDTO);
		boolean isFound = false;
		String sql  = CommonSQLConstants.LOGIN_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO userObject = null;
		ArrayList<RightDTO> rightList = new ArrayList<>();
		try{
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getPassword());
			rs = pstmt.executeQuery();
//			if(rs.next()){
//				isFound = true;
//			}
			while(rs.next()){
				if(userObject==null){
					userObject = new UserDTO();
					userObject.setUserid(rs.getString("userid"));
					userObject.setRole(rs.getString("rolename"));
				}
				RightDTO rightDTO = new RightDTO();
				rightDTO.setRightName(rs.getString("rightname"));
				rightDTO.setScreenName(rs.getString("screenname"));
				rightDTO.setCategory(rs.getString("category"));
				rightList.add(rightDTO);
				
			}
			if(userObject!=null){
				userObject.setRightList(rightList);
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
		return userObject;
	}

}
