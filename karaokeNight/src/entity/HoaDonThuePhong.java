package entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

public class HoaDonThuePhong {
	private String maHoaDon;
	private Date ngayLap;
	private double vat;
	private Timestamp gioVaoPhong;
	private Timestamp gioRaPhong;
	private Phong maPhong;
	private KhachHang maKhachHang;
	private NhanVien maNhanVien;
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	
	public Timestamp getGioVaoPhong() {
		return gioVaoPhong;
	}
	public void setGioVaoPhong(Timestamp gioVaoPhong) {
		this.gioVaoPhong = gioVaoPhong;
	}
	public Timestamp getGioRaPhong() {
		return gioRaPhong;
	}
	public void setGioRaPhong(Timestamp gioRaPhong) {
		this.gioRaPhong = gioRaPhong;
	}
	public Phong getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(Phong maPhong) {
		this.maPhong = maPhong;
	}
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	
	public HoaDonThuePhong(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	public HoaDonThuePhong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonThuePhong(String maHoaDon, Date ngayLap, double vat, Timestamp gioVaoPhong, Timestamp gioRaPhong,
			Phong maPhong, KhachHang maKhachHang, NhanVien maNhanVien ) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLap = ngayLap;
		this.vat = vat;
		this.gioVaoPhong = gioVaoPhong;
		this.gioRaPhong = gioRaPhong;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;

	}
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonThuePhong other = (HoaDonThuePhong) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "HoaDonThuePhong [maHoaDon=" + maHoaDon + ", ngayLap=" + ngayLap + ", vat=" + vat + ", gioVaoPhong="
				+ gioVaoPhong + ", gioRaPhong=" + gioRaPhong + ", maPhong=" + maPhong + ", maKhachHang=" + maKhachHang
				+ ", maNhanVien=" + maNhanVien + "]";
	}	
}
