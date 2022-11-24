package entity;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String soDienThoai;
	private String tenKhachHang;
	private Date ngaySinh;
	private String diaChi;
	private boolean gioiTinh;
	private String cmnd;
	private boolean tonTai;
	private Date lanDungCuoi;
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public boolean isTonTai() {
		return tonTai;
	}
	public void setTonTai(boolean tonTai) {
		this.tonTai = tonTai;
	}
	public Date getLanDungCuoi() {
		return lanDungCuoi;
	}
	public void setLanDungCuoi(Date lanDungCuoi) {
		this.lanDungCuoi = lanDungCuoi;
	}
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String maKhachHang, String soDienThoai, String tenKhachHang, Date ngaySinh, String diaChi,
			boolean gioiTinh, String cmnd, boolean tonTai, Date lanDungCuoi) {
		super();
		this.maKhachHang = maKhachHang;
		this.soDienThoai = soDienThoai;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.tonTai = tonTai;
		this.lanDungCuoi = lanDungCuoi;
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", soDienThoai=" + soDienThoai + ", tenKhachHang="
				+ tenKhachHang + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", cmnd="
				+ cmnd + ", tonTai=" + tonTai + ", lanDungCuoi=" + lanDungCuoi + "]";
	}

	
}
