
package com.bmpl.ojas.Common;

public interface CommonSQLConstants {
 
public static String REGISTRATION_SQL = 
"INSERT INTO `registerdb`.`register_page`(`Name`,`Address`,`Country`,`State`,`Phone`,`Email"
+ "`,`Fname`) VALUES(?,?,?,?,?,?,?)";

public static String VIEWCOURSE_SQL="SELECT `name` FROM `registerdb`.`register_page`";
public static String ADDTUTOR_SQL="INSERT INTO `registerdb`.`register_page`.`courses_table`(`course_name`,`fees`,`course_description`,`duration`,`trainer_name`) VALUES(?,?,?,?,?)";
public static String DELETECOURSE_SQL="DELETE FROM `registerdb`.`register_page` WHERE `name`=?";
public static String UPDATECOURSE_SQL="UPDATE `registerdb`.`register_page` SET `name`=?";
}


