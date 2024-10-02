package vn.iotstar.models;

public class SanPham {
	private int id;
	private String ten;
	private String giaban;
	private String giahtai;
	private String hinhanh;
	
	public String getHinhanh() {
		return hinhanh;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getGiaban() {
		return giaban;
	}
	public void setGiaban(String giaban) {
		this.giaban = giaban;
	}
	public String getGiahtai() {
		return giahtai;
	}
	public void setGiahtai(String giahtai) {
		this.giahtai = giahtai;
	}
	public SanPham(String ten, String giaban, String giahtai, String hinhanh) {
		super();
		this.ten = ten;
		this.giaban = giaban;
		this.giahtai = giahtai;
		this.hinhanh=hinhanh;
	}
	public SanPham(int id,String ten, String giaban, String giahtai, String hinhanh) {
		super();
		this.id=id;
		this.ten = ten;
		this.giaban = giaban;
		this.giahtai = giahtai;
		this.hinhanh=hinhanh;
	}
	public SanPham() {
		
	}
	
}
