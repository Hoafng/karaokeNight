package entity;

import java.util.Objects;

public class Phong {
	private String maPhong;
	private String tinhTrang;
	private double giaPhong;
	private int soLuongNguoi;
	private LoaiPhong maLoaiPhong;
	private boolean tonTai;
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public double getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}
	public int getSoLuongNguoi() {
		return soLuongNguoi;
	}
	public void setSoLuongNguoi(int soLuongNguoi) {
		this.soLuongNguoi = soLuongNguoi;
	}
	public LoaiPhong getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(LoaiPhong maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	
	public boolean isTonTai() {
		return tonTai;
	}
	public void setTonTai(boolean tonTai) {
		this.tonTai = tonTai;
	}
	
	public Phong(String maPhong, String tinhTrang, double giaPhong, int soLuongNguoi, LoaiPhong maLoaiPhong,
			boolean tonTai) {
		super();
		this.maPhong = maPhong;
		this.tinhTrang = tinhTrang;
		this.giaPhong = giaPhong;
		this.soLuongNguoi = soLuongNguoi;
		this.maLoaiPhong = maLoaiPhong;
		this.tonTai = tonTai;
	}
	public Phong() {
		super();
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tinhTrang=" + tinhTrang + ", giaPhong=" + giaPhong + ", soLuongNguoi="
				+ soLuongNguoi + ", maLoaiPhong=" + maLoaiPhong + "]";
	}
	
}
