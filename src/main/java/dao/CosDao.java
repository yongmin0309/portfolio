package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtils;
import vo.ReVo;


public class CosDao {
	public ArrayList<ReVo> cosList() {
		ArrayList<ReVo> list = new ArrayList<ReVo>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select re_code, re_phone, \r\n"
					+ " re_date , re_time , re_person, cos_code, cos_price \r\n"
					+ " from re_tbl ");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				ReVo vo = new ReVo();
				vo.setRe_code(rs.getInt("re_code"));
				vo.setRe_phone(rs.getString("re_phone"));
				vo.setRe_date(rs.getDate("re_date"));
				vo.setRe_time(rs.getString("re_time"));
				vo.setRe_person(rs.getInt("re_person"));
				vo.setCos_code(rs.getString("cos_code"));
				vo.setCos_price(rs.getString("cos_price"));
				list.add(vo);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}
	
	
	public int getMaxRe_code() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int re_code = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select max(re_code)+1 re_code from re_tbl ");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				re_code = rs.getInt("re_code");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return re_code;
	}
	
	
	
	
	
	public int CosInsert(ReVo re) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			ps =  conn.prepareStatement("Insert into re_tbl values(?,?,?,?,?,?,?)");
			ps.setInt(1, re.getRe_code());
			ps.setString(2, re.getRe_phone());
			ps.setDate(3, re.getRe_date());
			ps.setString(4, re.getRe_time());
			ps.setInt(5, re.getRe_person());
			ps.setString(6, re.getCos_code());
			ps.setString(7, re.getCos_price());
			
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
public ReVo getCos(int re_code) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReVo  vo = null;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" select re_code, re_phone, re_date, re_time, "
					+ " re_person, cos_code, cos_price "
					+ " from re_tbl where re_code = ?");
			ps.setInt(1, re_code);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				vo = new ReVo();
				vo.setRe_code(rs.getInt("re_code"));
				vo.setRe_phone(rs.getString("re_phone"));
				vo.setRe_date(rs.getDate("re_date"));
				vo.setRe_time(rs.getString("re_time"));
				vo.setRe_person(rs.getInt("re_person"));
				vo.setCos_code(rs.getString("cos_code"));
				vo.setCos_price(rs.getString("cos_price"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(conn, ps, rs);
		}
		return vo;
	}
	
	public int cosUpdate(ReVo re) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0 ;
		
		try {
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(" Update re_tbl set re_phone=?, re_date=?, re_time=? ,"
					+ " re_person=?, cos_code=?, cos_price=? where re_code=? ");
			ps.setString(1, re.getRe_phone());
			ps.setDate(2,  re.getRe_date());
			ps.setString(3, re.getRe_time());
			ps.setInt(4, re.getRe_person());
			ps.setString(5, re.getCos_code());
			ps.setString(6, re.getCos_price());
			ps.setInt(7, re.getRe_code());
			n = ps.executeUpdate();
			if(n>0) {
				conn.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
			conn.rollback();
		}finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
	
	public int cosDelete(int re_code) {
		Connection conn = null;
		PreparedStatement ps = null;
		int n = 0;
		
		try {
			conn = DBUtils.getConnection();
			String sql = " Delete from re_tbl where re_code=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, re_code);
			n = ps.executeUpdate();
			if(n>0) {		
				DBUtils.commit(conn);
			}
		}catch(Exception e) {
			e.printStackTrace();
			DBUtils.rollack(conn);
		} finally {
			DBUtils.close(conn, ps);
		}
		return n;
	}
}
