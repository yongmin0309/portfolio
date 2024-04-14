package biz;


import java.sql.SQLException;
import java.util.ArrayList;

import dao.CosDao;
import vo.ReVo;



public class CosService {
	CosDao dao = new CosDao();
	
	public ArrayList<ReVo> cosList(){
		ArrayList<ReVo> list = dao.cosList();
		return list;
	}
	
	public int getMaxRe_code() {
		int re_code = dao.getMaxRe_code();
		return re_code;
	}
	
	
	public int cosInsert(ReVo re) throws SQLException {
		int n = dao.CosInsert(re);
		return n;
	}
	
	public ReVo getCos(int re_code) {
		ReVo re = dao.getCos(re_code);
		return re;
	}
	
	public int cosUpdate(ReVo re) throws SQLException {
		int n = dao.cosUpdate(re);
		return n;
	}
	public int cosDelete(int re_code) {
		int n = dao.cosDelete(re_code);
		return n;
	}
}
