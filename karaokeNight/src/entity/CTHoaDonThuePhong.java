package entity;

import java.util.Objects;

public class CTHoaDonThuePhong {
	private HoaDonThuePhong maHoaDon;
	private DichVu maDichVu;
	private int soLuongDichVu;
	
	public HoaDonThuePhong getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(HoaDonThuePhong maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public DichVu getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(DichVu maDichVu) {
		this.maDichVu = maDichVu;
	}
	public int getSoLuongDichVu() {
		return soLuongDichVu;
	}
	public void setSoLuongDichVu(int soLuongDichVu) {
		this.soLuongDichVu = soLuongDichVu;
	}

	public CTHoaDonThuePhong(HoaDonThuePhong maHoaDon, DichVu maDichVu) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDichVu = maDichVu;
	}
	public CTHoaDonThuePhong(HoaDonThuePhong maHoaDon, DichVu maDichVu, int soLuongDichVu) {
		super();
		this.maHoaDon = maHoaDon;
		this.maDichVu = maDichVu;
		this.soLuongDichVu = soLuongDichVu;
	}
	public CTHoaDonThuePhong() {
		super();
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDichVu, maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTHoaDonThuePhong other = (CTHoaDonThuePhong) obj;
		return Objects.equals(maDichVu, other.maDichVu) && Objects.equals(maHoaDon, other.maHoaDon);
	}
	@Override
	public String toString() {
		return "CTHoaDonThuePhong [maHoaDon=" + maHoaDon + ", maDichVu=" + maDichVu + ", soLuongDichVu=" + soLuongDichVu
				+ "]";
	}
		
}
