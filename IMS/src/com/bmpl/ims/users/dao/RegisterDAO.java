package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.ims.common.CommonDAO;
import com.bmpl.ims.common.CommonSQLConstants;


public class RegisterDAO {

	public boolean register(com.bmpl.ims.users.dto.RegisterDTO registerDTO) throws SQLException, ClassNotFoundException {

		boolean registration = false;
		String sql = CommonSQLConstants.REGISTRATION_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;

		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, registerDTO.getName());
			pstmt.setString(2, registerDTO.getFname());
			pstmt.setString(3, registerDTO.getAddress());
			pstmt.setString(4, registerDTO.getPhone());
			/*
			 * pstmt.setString(5, registerDTO.getBatch()); 
			 * pstmt.setString(6, registerDTO.getCountry());
			 * 
			 */
			pstmt.setString(5, registerDTO.getMail());
			pstmt.setString(6, registerDTO.getBatch()); 
			pstmt.setString(7, registerDTO.getCourse());
			pstmt.setString(8, registerDTO.getPath());
			rs = pstmt.executeUpdate();

			try {

				registration = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Registration Failed");
			}

		} finally {
			if (con != null) {
				con.close();
			}
		}

		return registration;

	}

}

