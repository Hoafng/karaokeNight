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

public class Dao_HoaDon {

	public HoaDonThuePhong getMaHoaDon(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		HoaDonThuePhong hoadon = null;
		try {
			String sql = "select distinct  * "
					+ "from HoaDonThuePhong h join CTHoaDonThuePhong c on h.maHoaDon = c.maHoaDon "
					+ "where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Phong p = new Phong(rs.getString("maPhong"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				hoadon = new HoaDonThuePhong(rs.getString("maHoaDon"), rs.getDate("ngayLap"), rs.getFloat("VAT"),
						rs.getTimestamp("gioVaoPhong"), rs.getTimestamp("gioRaPhong"), p, kh, nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoadon;
	}

	public ArrayList<HoaDonThuePhong> getAllHoaDon() {
		ArrayList<HoaDonThuePhong> dshd = new ArrayList<HoaDonThuePhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *"
					+ "from HoaDonThuePhong as hd join NhanVien as nv on hd.MaNhanVien = nv.MaNhanVien join KhachHang as kh on hd.MaKhachHang = kh.MaKhachHang";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Timestamp gioVaoPhong = rs.getTimestamp(4);
				Timestamp gioRaPhong = rs.getTimestamp(5);
				Phong p = new Phong(rs.getString("maPhong"));
				TaiKhoan tk =  new TaiKhoan(rs.getString("tenTaiKhoan"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"), rs.getString(11), rs.getDate(12), rs.getString(13),
						rs.getBoolean(14), rs.getString(15) , rs.getString("chucVu"), rs.getString("email"),tk,rs.getBoolean(19) );
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"),rs.getString(21),rs.getString(22), rs.getDate(23), rs.getString(24),rs.getBoolean(25), rs.getString(26) ,rs.getBoolean(27) ,rs.getDate("lanDungCuoi"));
				HoaDonThuePhong hdt = new HoaDonThuePhong(maHoaDon, ngayLap, 0.1, gioVaoPhong, gioRaPhong, p, kh, nv);
				dshd.add(hdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}
	public ArrayList<HoaDonThuePhong> getAllHoaDonDaThanhToan() {
		ArrayList<HoaDonThuePhong> dshd = new ArrayList<HoaDonThuePhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *"
					+ "from HoaDonThuePhong as hd join NhanVien as nv on hd.MaNhanVien = nv.MaNhanVien join KhachHang as kh on hd.MaKhachHang = kh.MaKhachHang where ngayLap is not NULL";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Timestamp gioVaoPhong = rs.getTimestamp(4);
				Timestamp gioRaPhong = rs.getTimestamp(5);
				Phong p = new Phong(rs.getString("maPhong"));
				TaiKhoan tk =  new TaiKhoan(rs.getString("tenTaiKhoan"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"), rs.getString(11), rs.getDate(12), rs.getString(13),
						rs.getBoolean(14), rs.getString(15) , rs.getString("chucVu"), rs.getString("email"),tk,rs.getBoolean(19) );
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"),rs.getString(21),rs.getString(22), rs.getDate(23), rs.getString(24),rs.getBoolean(25), rs.getString(26) ,rs.getBoolean(27) ,rs.getDate("lanDungCuoi"));
				HoaDonThuePhong hdt = new HoaDonThuePhong(maHoaDon, ngayLap, 0.1, gioVaoPhong, gioRaPhong, p, kh, nv);
				dshd.add(hdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}
	public ArrayList<HoaDonThuePhong> getAllHoaDonChuaThanhToan() {
		ArrayList<HoaDonThuePhong> dshd = new ArrayList<HoaDonThuePhong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *"
					+ "from HoaDonThuePhong as hd join NhanVien as nv on hd.MaNhanVien = nv.MaNhanVien join KhachHang as kh on hd.MaKhachHang = kh.MaKhachHang where ngayLap is NULL";

			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHoaDon = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Timestamp gioVaoPhong = rs.getTimestamp(4);
				Timestamp gioRaPhong = rs.getTimestamp(5);
				Phong p = new Phong(rs.getString("maPhong"));
				TaiKhoan tk =  new TaiKhoan(rs.getString("tenTaiKhoan"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"), rs.getString(11), rs.getDate(12), rs.getString(13),
						rs.getBoolean(14), rs.getString(15) , rs.getString("chucVu"), rs.getString("email"),tk,rs.getBoolean(19) );
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"),rs.getString(21),rs.getString(22), rs.getDate(23), rs.getString(24),rs.getBoolean(25), rs.getString(26) ,rs.getBoolean(27) ,rs.getDate("lanDungCuoi"));
				HoaDonThuePhong hdt = new HoaDonThuePhong(maHoaDon, ngayLap, 0.1, gioVaoPhong, gioRaPhong, p, kh, nv);
				dshd.add(hdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}
	public ArrayList<HoaDonThuePhong> getAllMaHoaDon() {
		ArrayList<HoaDonThuePhong> ds = new ArrayList<HoaDonThuePhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select maHoaDon from HoaDonThuePhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ds.add(new HoaDonThuePhong(rs.getString("maHoaDon")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public HoaDonThuePhong getHoaDon(String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		HoaDonThuePhong hoadon = null;
		try {
			String sql = "select * from HoaDonThuePhong where maHoaDon=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Phong p = new Phong(rs.getString("maPhong"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				hoadon = new HoaDonThuePhong(rs.getString("maHoaDon"), rs.getDate("ngayLap"), rs.getFloat("VAT"),
						rs.getTimestamp("gioVaoPhong"), rs.getTimestamp("gioRaPhong"), p, kh, nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoadon;
	}

	public boolean insertHoaDonThuePhong(HoaDonThuePhong hdtp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into HoaDonThuePhong VALUES(?,null,?,?,null,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, hdtp.getMaHoaDon());
			statement.setFloat(2, (float) 0.1);
			statement.setTimestamp(3, hdtp.getGioVaoPhong());
			statement.setString(4, hdtp.getMaPhong().getMaPhong());
			statement.setString(5, hdtp.getMaKhachHang().getMaKhachHang());
			statement.setString(6, hdtp.getMaNhanVien().getMaNhanVien());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public boolean updateThanhToan(Timestamp gioRaPhong, Date ngayLapHoaDon, String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Update HoaDonThuePhong set ngayLap = ?, gioRaPhong= ? where maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setDate(1, ngayLapHoaDon);
			statement.setTimestamp(2, gioRaPhong);
			statement.setString(3, maHoaDon);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public boolean updateHoaDonThuePhong(String maPhongChuyenDen, String maPhongChuyenDi, String maHoaDon) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Update HoaDonThuePhong set maPhong = ? where maPhong = ? and maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhongChuyenDen);
			statement.setString(2, maPhongChuyenDi);
			statement.setString(3, maHoaDon);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}
	public HoaDonThuePhong getMaHoaDonPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		HoaDonThuePhong hoadon = null;
		try {
			String sql = " select * from HoaDonThuePhong where maPhong =? and ngayLap is NULL";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Phong p = new Phong(rs.getString("maPhong"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"));
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				hoadon = new HoaDonThuePhong(rs.getString("maHoaDon"), rs.getDate("ngayLap"), rs.getFloat("VAT"),
						rs.getTimestamp("gioVaoPhong"), rs.getTimestamp("gioRaPhong"), p, kh, nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoadon;
	}

}
