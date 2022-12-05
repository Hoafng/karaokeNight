package entity;

import java.sql.Timestamp;
import java.util.Objects;

public class PhieuDatPhong {
	private String maPhieuDatPhong;
	private int soGioDat;
	private Timestamp ngayDatPhong;
	private Timestamp ngayNhanPhong;
	private Phong maPhong;
	private KhachHang maKhachHang;
	private boolean tonTai;
	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}
	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public int getSoGioDat() {
		return soGioDat;
	}
	public void setSoGioDat(int soGioDat) {
		this.soGioDat = soGioDat;
	}
	public Timestamp getNgayDatPhong() {
		return ngayDatPhong;
	}
	public void setNgayDatPhong(Timestamp ngayDatPhong) {
		this.ngayDatPhong = ngayDatPhong;
	}
	public Timestamp getNgayNhanPhong() {
		return ngayNhanPhong;
	}
	public void setNgayNhanPhong(Timestamp ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
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
	
	public boolean isTonTai() {
		return tonTai;
	}
	public void setTonTai(boolean tonTai) {
		this.tonTai = tonTai;
	}
	
	public PhieuDatPhong(String maPhieuDatPhong, int soGioDat, Timestamp ngayDatPhong, Timestamp ngayNhanPhong, Phong maPhong,
			KhachHang maKhachHang, boolean tonTai) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.soGioDat = soGioDat;
		this.ngayDatPhong = ngayDatPhong;
		this.ngayNhanPhong = ngayNhanPhong;
		this.maPhong = maPhong;
		this.maKhachHang = maKhachHang;
		this.tonTai = tonTai;
	}
	public PhieuDatPhong(String maPhieuDatPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	public PhieuDatPhong() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhieuDatPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuDatPhong other = (PhieuDatPhong) obj;
		return Objects.equals(maPhieuDatPhong, other.maPhieuDatPhong);
	}
	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", soGioDat=" + soGioDat + ", ngayDatPhong="
				+ ngayDatPhong + ", ngayNhanPhong=" + ngayNhanPhong + ", maPhong=" + maPhong + ", soDienThoai="
				+ maKhachHang + "]";
	}
	
}
