package com.bmpl.ims.common.dao;

public interface CommonSQLConstants {
public static String LOGIN_SQL = "select userid,password from user_mst where userid=? and password=?";
}
