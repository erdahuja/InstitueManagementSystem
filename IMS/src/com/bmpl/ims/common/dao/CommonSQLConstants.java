package com.bmpl.ims.common.dao;

public interface CommonSQLConstants {
//public static String LOGIN_SQL = "select userid,password from user_mst where userid=? and password=?";
public static String LOGIN_SQL = "select user_master.`userid`,"
		+ "role_master.`rolename`,right_master.`rightname`, "
		+" `right_master`.`screenname`,right_master.`category` "
+" from user_master , role_master, right_master , user_role_mapping, "
+" role_right_mapping where user_master.`userid`=? "
+" and user_master.`pwd`=? and user_master.`uid`=user_role_mapping.`uid` "
+" and role_master.`roleid`=user_role_mapping.`roleid` "
+" and role_master.`roleid`=role_right_mapping.`roleid` and "
+ " right_master.`rightid`=role_right_mapping.`rightid`";

public static String ADDBATCH_SQL="Insert into batch_table (batchname, coursename, trainername, totalsets, description, batch_starts) Values (?,?,?,?,?,?)";
public static String LOGIN_SQL2="select username,password from user_table where username=? and password=?";
public static String GETCOURSE_SQL="select * from course_table";

		public static String ADDCOURSE_SQL = "INSERT INTO `InstituteProject`.`courses_table`(`course_name`,`fees`,`course_description`,`duration`,`trainer_name`) VALUES(?,?,?,?,?)";
	public static String VIEWCOURSE_SQL = "SELECT `course_name` FROM `InstituteProject`.`courses_table`";
	public static String CHOOSECOURSE_SQL = "SELECT * FROM `InstituteProject`.`courses_table` where course_name=? ";

	public static String DELETECOURSE_SQL = "DELETE FROM `InstituteProject`.`courses_table` WHERE course_name=?";

	public static String UPDATECOURSE_SQL = "UPDATE `InstituteProject`.`courses_table` SET 'course_name` = ?,`fees` = ?,`course_description` = ?,`duration` = ?,`trainer_name` = ? WHERE `course_name` = ?";
	public static String VIEWBATCHES_SQL = "";
	public static String VIEWSTUDENTS_SQL="";
	public static String TAKEATTENDANCE_SQL = "";
	
}
