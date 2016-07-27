package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.AddCourseDTO;
import com.bmpl.ims.users.views.CourseView;

public class CoursesDAO {
	AddCourseDTO addCourseDTO;

	public boolean addCourse(AddCourseDTO addcourseDTO) throws ClassNotFoundException, SQLException {
		boolean courseAdded = false;
		String sql = CommonSQLConstants.ADDCOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs;
		try {
			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, addcourseDTO.getCourse_name());
			pstmt.setLong(2, addcourseDTO.getFees());
			pstmt.setString(3, addcourseDTO.getCourse_description());
			pstmt.setLong(4, addcourseDTO.getDuration());
			pstmt.setString(5, addcourseDTO.getTrainer_name());
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
		return CourseView.viewCourse(addCourseDTO);

	}

	public String updateCourse(String item) throws SQLException {
		boolean isUpdated = false;
		String sql = CommonSQLConstants.CHOOSECOURSE_SQL;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		String info = null;
		addCourseDTO = new AddCourseDTO();
		CourseView cv = null;
		try {

			con = CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, item);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				addCourseDTO.setCourse_description(rs.getString(3));
				addCourseDTO.setCourse_name(rs.getString(1));
				addCourseDTO.setDuration(Integer.parseInt(rs.getString(4)));
				addCourseDTO.setTrainer_name(rs.getString(5));
				addCourseDTO.setFees(Integer.parseInt(rs.getString(2)));

				cv = new CourseView();
				info = CourseView.viewCourse(addCourseDTO);

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
