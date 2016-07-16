package com.bmpl.ims.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;

import com.bmpl.ims.common.dao.CommonScreenConstants;

public class CommonUtility {
	private static  HashMap<String,String> screenClassMap = new HashMap<>();
	static{
		mapScreenWithClassName();
	}
	private CommonUtility(){}
	public static String getPrintStackTrace(Exception e){
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		
		e.printStackTrace(pw);
		return sw.toString();
		
	}
	
	private static void mapScreenWithClassName(){
		screenClassMap.put(CommonScreenConstants.ADD_USER
				, CommonScreenConstants.ADD_USER_CLASS);
		screenClassMap.put(CommonScreenConstants.DELETE_USER
				, CommonScreenConstants.DELETE_USER_CLASS);
	}
	
	public static String getClassName(String screenName){
		return screenClassMap.get(screenName);
	}

}
