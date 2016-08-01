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
}
