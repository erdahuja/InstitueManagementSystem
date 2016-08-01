package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.TrainerDTO;

public interface TrainerDao {

	public static  boolean insertData(TrainerDTO trainer) throws ClassNotFoundException, SQLException{
		boolean istrue = false;
		String sql  = CommonSQLConstants.Trainer_Registration_SQl;
		Connection con = null;
		PreparedStatement pstmt = null;
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, trainer.getTrainer_name());
		pstmt.setInt(2, trainer.getTrainer_age());
		pstmt.setString(3, trainer.getTrainer_gender());
		pstmt.setString(4, trainer.getTrainer_mobileno());
		pstmt.setString(5, trainer.getTrainer_address());
		pstmt.setString(6, trainer.getTrainer_email());
		pstmt.setString(7, trainer.getTrainer_subject());
		pstmt.setString(8, trainer.getTrainer_image());
		int result = pstmt.executeUpdate();
		
		if(result > 0 ){
			System.out.println("data insert succesfully");
			istrue = true;
		}
		con.close();
		pstmt.close();
		return istrue;
		
		
		
		
		
	}
	
	
}
