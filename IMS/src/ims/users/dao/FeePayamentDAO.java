package com.bmpl.ims.users.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.bmpl.ims.common.dao.CommonDAO;
import com.bmpl.ims.common.dao.CommonSQLConstants;
import com.bmpl.ims.users.dto.FeePaymentDTO;

public class FeePayamentDAO {
	
	public class function{
		String sql=CommonSQLConstants.SearchInfo_SQL;
		Connection con=null;
	    PreparedStatement pstmt = null;
	    ResultSet rs=null;
		public ResultSet find(String s){
			try{
				con=CommonDAO.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,s);
				rs=pstmt.executeQuery();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("can't execute search");
			}
			return rs;
		}
	}
	public boolean feePayment(FeePaymentDTO feepaymentDTO) throws SQLException, ClassNotFoundException{
		boolean feeAdded=false;
		String sql=CommonSQLConstants.MAKEPAYMENT_SQL;
		//String sq=CommonSQLConstants.MAKEPAYMENTN_SQL;
		Connection con=null;
		PreparedStatement pstmt = null;
		
		int rs ;
		try{
			con=CommonDAO.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,feepaymentDTO.getAdmissionNum());
			pstmt.setString(2, feepaymentDTO.getStudentName());
			pstmt.setString(3, feepaymentDTO.getCourseName());
			pstmt.setInt(4, feepaymentDTO.getTotalFee());
			pstmt.setInt(5, feepaymentDTO.getDiscount());
			pstmt.setInt(6, feepaymentDTO.getPayableAmount());
			pstmt.setInt(7, feepaymentDTO.getPaidAmount());
			pstmt.setInt(8, feepaymentDTO.getDueAmount());
			pstmt.setString(9,  feepaymentDTO.getDate());
			pstmt.setString(10, feepaymentDTO.getModeofPayment());
			pstmt.setString(11,feepaymentDTO.getChequeNum());
			/*if (feepaymentDTO.equals(ChequeNum).getChequeNum().isEmpty()) {
				pstmt.setInt(11,feepaymentDTO.getChequeNum());
			} else {
			   pstmt.setNull(1, Types.INTEGER);
			}*/
			
			
			pstmt.setString(12, feepaymentDTO.getBankName());
			rs = pstmt.executeUpdate();
			try{
				feeAdded=true;
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("can't execute");

			}
		}finally {
				// logger.debug("Resource Close Inside Finally");
				con.close();
			}
			return feeAdded;
		
	}

}
