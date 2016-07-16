package com.bmpl.ims.common.dao;

public interface CommonSQLConstants {
	public static String LOGIN_SQL = "select userid,password from user_mst where userid=? and password=?";
	public static String ADDCOURSE_SQL = "INSERT INTO `InstituteProject`.`courses_table`(`course_name`,`fees`,`course_description`,`duration`,`trainer_name`) VALUES(?,?,?,?,?)";
	public static String VIEWCOURSE_SQL = "SELECT `course_name` FROM `InstituteProject`.`courses_table`";
	public static String CHOOSECOURSE_SQL = "SELECT * FROM `InstituteProject`.`courses_table` where course_name=? ";

	public static String DELETECOURSE_SQL = "DELETE FROM `InstituteProject`.`courses_table` WHERE course_name=?";

	public static String UPDATECOURSE_SQL = "UPDATE `InstituteProject`.`courses_table` SET 'course_name` = ?,`fees` = ?,`course_description` = ?,`duration` = ?,`trainer_name` = ? WHERE `course_name` = ?";

}