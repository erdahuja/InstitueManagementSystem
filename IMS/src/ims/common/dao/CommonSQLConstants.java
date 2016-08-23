package com.bmpl.ims.common.dao;

import java.util.ArrayList;

public interface CommonSQLConstants {
	public static String LOGIN_SQLAdmin = "select 'username','password' from `InstituteProject`.user_table where username=? and password=?";
	public static String LOGIN_SQLCounsellor = "select 'username','password' from `InstituteProject`.counselor_table where username=? and password=?";
	public static String ADDCOURSE_SQL = "INSERT INTO `InstituteProject`.`courses_table`(`course_name`,`fees`,`course_description`,`duration`,`trainer_name`) VALUES(?,?,?,?,?)";
	public static String VIEWCOURSE_SQL = "SELECT `course_name` FROM `InstituteProject`.`courses_table`";
	public static String CHOOSECOURSE_SQL = "SELECT * FROM `InstituteProject`.`courses_table` where course_name=? ";

	public static String DELETECOURSE_SQL = "DELETE FROM `InstituteProject`.`courses_table` WHERE course_name=?";

	public static String UPDATECOURSE_SQL = "UPDATE `InstituteProject`.`courses_table` SET 'course_name` = ?,`fees` = ?,`course_description` = ?,`duration` = ?,`trainer_name` = ? WHERE `course_name` = ?";
	public static String VIEWBATCHES_SQL = "SELECT batchname FROM `InstituteProject`.`batch_table`";
	public static String VIEWSTUDENTS_SQL = "";
	public static String Trainer_Registration_SQl = "INSERT INTO `amit`.`trainer_registration` (`Trainer_name`, `Trainer_age`, `Trainer_gender`, `Trainer_mobileno`, `Trainer_email`, `Trainer_address`, `Trainer_image`, `Trainer_subject`, `Trainer_hiredate`) VALUES (?,?,?,?,?,?,?,?,?);";

	public static String ENQUIRE_SQL = "INSERT INTO `project`.`enquire_sql`"
			+ "(`firstName`,`secondName`,`address1`,`address2`,`email`,`mobileContact`,`otherContact`,`slot1`,`slot2`,`fatherFirstName`,"
			+ "`fatherSecondName`,`fatherMobileContact`,`fatherOtherContact`,`university`,`qualification`,`reference`,`EnquireDate`)"
			+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String COURSE_SQL = "SELECT * from `project`.`course_sql`";
	public static String COUNSELLOR_SQL = "INSERT INTO `counsellordb`.`consellorpage`(`Name`,`Address`,`Phonenumber`,`Qualification`,`Gender`)"
			+ "VALUES(?,?,?,?,?)";

	public static String ADDTUTOR_SQL = "";

	public static String ADDBATCH_SQL = "Insert into `InstituteProject`.batch_table (batchname, coursename, trainername, totalsets, description, batch_starts, starttime, endtime) Values (?,?,?,?,?,?,?,?)";
	public static String GETCOURSE_SQL = "";

	public static String REGISTRATION_SQL = "";
	public static String ADDEXPENSE_SQL = "INSERT INTO `InstituteProject`.`add_expenses`(`capital_lease_cost`,`advertising_cost`,`broadband_cost`,"
			+ "`staff_salary_cost`,`maintainance_cost`,`miscellaneous`) VALUES(?,?,?,?,?,?)";

	public static String SearchInfo_SQL = "select*from student_iinfo where AdmissionNum=?";
	public static String COMBOX_SQL = "Select* from payment_type";

	public static String MAKEPAYMENT_SQL = "INSERT INTO `InstituteProject`.`feepayment`(`AdmissionNum`,`StudentName`,`CourseName`,"
			+ "`TotalFee`,`Discount`,`PayableAmount`,`PaidAmount`,`DueAmount`,`Date`,`ModeofPayment`,`ChequeNum`,`BankName`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
//	public static String SUMOFPAYMENTS_SQL = "select sum(PaidAmount) from feepayment where Date ==CURDATE()";

	public static String TAKEATTENDANCE_SQL = "Insert into attandance_table (attandance_date, studentname, batchname) Values (?,?,?)";
	public static String GETSTUDENTLIST(String batchName)	
	{
	String VIEWSTUDENTS="select * from student_table where batch_name='"+batchName+"'";
	return VIEWSTUDENTS;
	}
	public static String GETATTANDANCE(String batchname, String studentname, java.util.Date startdate, java.util.Date enddate)
	{
	String VIEWATTENDANCE_SQL = "SELECT * FROM attandance_table WHERE studentname='"+studentname+"' and batchname='"+batchname+"' and attandance_date between '"+startdate+"'and '"+enddate+"'";
	return VIEWATTENDANCE_SQL;
}

}
