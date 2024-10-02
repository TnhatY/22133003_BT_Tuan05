package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBconnectionSQLServer;
import vn.iotstar.models.SanPham;



public interface SanPhamDAO {
	
	void insertSp(SanPham sp);
	void editSP(SanPham sp);
	void deleteSp(int id);
	SanPham get(int id);
	SanPham get(String name);
	List<SanPham> getSP();
	List<SanPham> search(String keyword);
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	
	
	public static void main(String[] args) {
		try {
			//SanPhamDAO svDao= new SanPhamDAO();
			//List<SanPham> list = svDao.getSP();
			//for (SanPham sv : list) {
			//	System.out.println(sv.getTen());
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
