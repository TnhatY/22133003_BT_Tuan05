package vn.iotstar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.config.DBconnectionSQLServer;
import vn.iotstar.models.SanPham;

public class SanPhamDAOImpl implements SanPhamDAO {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public void insertSp(SanPham sp) {
		String sql = "INSERT INTO SanPham(ten,giaban,giahientai,hinhanh) VALUES (?,?,?,?)";
		 try {
			 conn = new DBconnectionSQLServer().getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, sp.getTen());
			 ps.setString(2, sp.getGiaban());
			 ps.setString(3, sp.getGiahtai());
			 ps.setString(4, sp.getHinhanh());
			 ps.executeUpdate();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 
	}

	@Override
	public void editSP(SanPham sp) {
		String sql = "UPDATE SanPham SET ten = ?,giaban=?,giahientai=?,hinhanh=? WHERE id =?";
		 try {
			 conn = new DBconnectionSQLServer().getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, sp.getTen());
			 ps.setString(2, sp.getGiaban());
			 ps.setString(3, sp.getGiahtai());
			 ps.setString(4, sp.getHinhanh());
			 ps.setInt(5, sp.getId());
			 ps.executeUpdate();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	}

	@Override
	public void deleteSp(int id) {
		String sql = "DELETE FROM SanPham WHERE id = ?";
		 try {
			conn =  new DBconnectionSQLServer().getConnection();
		 	PreparedStatement ps = conn.prepareStatement(sql);
		 	ps.setInt(1, id);
		 	ps.executeUpdate();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
	}

	@Override
	public SanPham get(int id) {
		 String sql = "SELECT * FROM SanPham WHERE id = ? ";
		 try {
		 conn = new DBconnectionSQLServer().getConnection();
		 PreparedStatement ps = conn.prepareStatement(sql);
		 ps.setInt(1, id);
		 ResultSet rs = ps.executeQuery();
		 while (rs.next()) {
		 SanPham category = new SanPham();
		 category.setId(rs.getInt("id"));
		 category.setTen(rs.getString("ten"));
		 category.setGiaban(rs.getString("giaban"));
		 category.setGiahtai(rs.getString("giahientai"));
		 category.setHinhanh(rs.getString("hinhanh"));
		 return category;
		 }} catch (Exception e) {
		 e.printStackTrace();}
		 return null;
	}

	@Override
	public SanPham get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPham> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SanPham> getSP() {
		List<SanPham> list =new ArrayList<SanPham>();
		String sql = "SELECT * FROM [SanPham]";
		try {
			conn = new DBconnectionSQLServer().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new SanPham(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5)
						));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

}
