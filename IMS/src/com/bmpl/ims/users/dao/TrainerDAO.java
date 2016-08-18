package com.bmpl.ims.users.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.ims.common.CommonDAO;
import com.bmpl.ims.common.CommonSQLConstants;
import com.bmpl.ims.users.dto.RegisterDTO;
import com.bmpl.ims.users.dto.TrainerDTO;
import com.bmpl.ims.users.views.RegistrationView;
import com.bmpl.ims.users.views.TrainerView;

public class TrainerDAO {
	TrainerDTO trainerDTO;

	public boolean addCourse(TrainerDTO trainerDTO) throws ClassNotFoundException, SQLException {
		boolean courseAdded = false;
		String sql = CommonSQLConstants.VIEWCOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, trainerDTO.getName());
			pstmt.setString(2, trainerDTO.getFname());
			pstmt.setString(3, trainerDTO.getPhone());
			pstmt.setString(4, trainerDTO.getAddress());
			pstmt.setString(5, trainerDTO.getMail());
			
			
			rs = pstmt.executeUpdate();
			try {

				courseAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("can't execiute");

			}
		} finally {
			// logger.debug("Resource Close Inside Finally");
			con.close();
		}
		return courseAdded;

	}

	public String getCourseInfo(String info) {
		return RegistrationView.viewCourse(trainerDTO);

	}

	public String updateCourse(String item) throws SQLException {
		boolean isUpdated = false;
		String sql = CommonSQLConstants.CHOOSECOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String info = null;
		trainerDTO = new TrainerDTO();
		RegistrationView cv = null;
		try {

			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				trainerDTO.setName(rs.getString(1));
				trainerDTO.setFname(rs.getString(2));
				trainerDTO.setPhone(rs.getString(3));
				trainerDTO.setAddress(rs.getString(4));
				trainerDTO.setMail(rs.getString(5));

				cv = new RegistrationView();
				info = RegistrationView.viewCourse(trainerDTO);

				System.out.println("course viewed to update");

			}

			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to delete course");
		} finally {
			con.close();
		}
		return info;

	}

	public static boolean deleteCourse(String itemString) throws SQLException {
		boolean isDeleted = false;
		String sql = CommonSQLConstants.DELETECOURSE_SQL;

		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, itemString);
			rs = pstmt.executeUpdate();

			isDeleted = true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to delete course");
		} finally {
			con.close();
		}
		return isDeleted;

	}

	public static ArrayList<String> showCourse(String item) throws SQLException {
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
			rs = pstmt.executeQuery();

			while (rs.next()) {

				list.add(rs.getString(1));

				list.add(rs.getString(2));

				list.add(rs.getString(3));

				list.add(rs.getString(4));

				list.add(rs.getString(5));

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



}

