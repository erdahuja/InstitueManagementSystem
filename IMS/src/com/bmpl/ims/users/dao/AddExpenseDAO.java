package com.bmpl.ims.users.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.AddExpenseDTO;


public class AddExpenseDAO {
	public boolean addExpense(AddExpenseDTO addexpenseDTO) throws SQLException, ClassNotFoundException{
		boolean expenseAdded=false;
		String sql=CommonSQLConstants.ADDEXPENSE_SQL;
		Connection con=null;
		PreparedStatement pstmt = null;
		int rs ;
		try{
			con=CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,addexpenseDTO.getCapital_lease_cost());
			pstmt.setInt(2, addexpenseDTO.getAdvertising_cost());
			pstmt.setInt(3, addexpenseDTO.getBroadband_cost());
			pstmt.setInt(4, addexpenseDTO.getStaff_salary_cost());
			pstmt.setInt(5, addexpenseDTO.getMaintainance_cost());
			pstmt.setInt(6, addexpenseDTO.getMiscellaneous());
			rs = pstmt.executeUpdate();
			try{
				expenseAdded=true;
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("can't execute");

			}
		}finally {
				// logger.debug("Resource Close Inside Finally");
				con.close();
			}
			return expenseAdded;
		
	}

}

