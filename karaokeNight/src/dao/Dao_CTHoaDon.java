package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CTHoaDonThuePhong;
import entity.DichVu;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.LoaiDichVu;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class Dao_CTHoaDon {
	public CTHoaDonThuePhong getHoaDon(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		CTHoaDonThuePhong ctHD = null;
		try {
			String sql = "select  * " + "from HoaDonThuePhong h join CTHoaDonThuePhong c on h.maHoaDon = c.maHoaDon "
					+ "where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDonThuePhong hoadon = new HoaDonThuePhong(rs.getString("maHoaDon"));
				DichVu dichvu = new DichVu(rs.getString("maDichVu"));
				ctHD = new CTHoaDonThuePhong(hoadon, dichvu, rs.getInt("soLuongDichVu"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ctHD;
	}

	public ArrayList<CTHoaDonThuePhong> getAllCTHD() {
		ArrayList<CTHoaDonThuePhong> dshd = new ArrayList<CTHoaDonThuePhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *" + "from CTHoaDonThuePhong hd join DichVu  dv on hd.maDichVu = dv.maDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				HoaDonThuePhong hd = new HoaDonThuePhong(rs.getString("maHoaDon"));
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuong"), new LoaiDichVu(rs.getString("maLoaiDichVu")));
				CTHoaDonThuePhong cthd = new CTHoaDonThuePhong(hd, dv, rs.getInt("soLuongDichVu"));
				dshd.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}

	public ArrayList<CTHoaDonThuePhong> getAllCTHDDichVu(String maPhong) {
		ArrayList<CTHoaDonThuePhong> dshd = new ArrayList<CTHoaDonThuePhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "  select * from CTHoaDonThuePhong ct\r\n"
					+ "        join HoaDonThuePhong hd on hd.maHoaDon=ct.maHoaDon  join DichVu dv on dv.maDichVu =ct.maDichVu\r\n"
					+ "        where maPhong =? and gioRaPhong  is NULL";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				HoaDonThuePhong hd = new HoaDonThuePhong(rs.getString("maHoaDon"));
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuong"), new LoaiDichVu(rs.getString("maLoaiDichVu")));
				CTHoaDonThuePhong cthd = new CTHoaDonThuePhong(hd, dv, rs.getInt("soLuongDichVu"));
				dshd.add(cthd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}

	public boolean updateSoLuongThem(int soLuong, String maDichVu, String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Update CTHoaDonThuePhong set soLuongDichVu = ? where maDichVu = ? and maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setInt(1, soLuong);
			statement.setString(2, maDichVu);
			statement.setString(3, maHoaDon);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}
	public boolean insertDichVuThem(CTHoaDonThuePhong hdtp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into CTHoaDonThuePhong VALUES(?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, hdtp.getMaHoaDon().getMaHoaDon());
			statement.setString(2, hdtp.getMaDichVu().getMaDichVu());
			statement.setInt(3, hdtp.getSoLuongDichVu());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

}