package entity;

import java.sql.Date;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private String soDienThoai;
	private Date ngaySinh;
	private String diaChi;
	private boolean gioiTinh;
	private String cmnd;
	private String chucVu;
	private String email;
	private TaiKhoan tenTaiKhoan;
	private boolean tonTai;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
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
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TaiKhoan getTenTaiKhoan() {
		return tenTaiKhoan;
	}
	public void setTenTaiKhoan(TaiKhoan tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}
	
	public boolean isTonTai() {
		return tonTai;
	}
	public void setTonTai(boolean tonTai) {
		this.tonTai = tonTai;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
	}
	
	public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, Date ngaySinh, String diaChi,
			boolean gioiTinh, String cmnd, String chucVu, String email, TaiKhoan tenTaiKhoan, boolean tonTai) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.cmnd = cmnd;
		this.chucVu = chucVu;
		this.email = email;
		this.tonTai = tonTai;
		this.tenTaiKhoan = tenTaiKhoan;
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", soDienThoai=" + soDienThoai
				+ ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", cmnd=" + cmnd
				+ ", chucVu=" + chucVu + ", email=" + email + ", tenTaiKhoan=" + tenTaiKhoan + "]";
	}
	
}
