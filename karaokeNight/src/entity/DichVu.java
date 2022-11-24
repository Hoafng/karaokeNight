package entity;

import java.util.Objects;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private double giaDichVu;
	private int soLuong;
	private LoaiDichVu maLoaiDichVu;
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public double getGiaDichVu() {
		return giaDichVu;
	}
	public void setGiaDichVu(double giaDichVu) {
		this.giaDichVu = giaDichVu;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public LoaiDichVu getMaLoaiDichVu() {
		return maLoaiDichVu;
	}
	public void setMaLoaiDichVu(LoaiDichVu maLoaiDichVu) {
		this.maLoaiDichVu = maLoaiDichVu;
	}
	public DichVu(String maDichVu, String tenDichVu, double giaDichVu, int soLuong, LoaiDichVu maLoaiDichVu) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.giaDichVu = giaDichVu;
		this.soLuong = soLuong;
		this.maLoaiDichVu = maLoaiDichVu;
	}
	public DichVu() {
		super();
	}
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}
	@Override
	public String toString() {
		return "DichVu [maDichVu=" + maDichVu + ", tenDichVu=" + tenDichVu + ", giaDichVu=" + giaDichVu + ", soLuong="
				+ soLuong + ", maLoaiDichVu=" + maLoaiDichVu + "]";
	}
	
}
