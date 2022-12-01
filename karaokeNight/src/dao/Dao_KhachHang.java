package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.PhieuDatPhong;
import entity.Phong;

public class Dao_KhachHang {
	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ds.add(new KhachHang(rs.getString("maKhachHang"), rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),rs.getString("diaChi"),rs.getBoolean("gioiTinh"),rs.getString("cmnd"),rs.getBoolean("tonTai"),rs.getDate("lanDungCuoi")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public KhachHang getKhachHang(String soDienThoai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		KhachHang kh = null;
		try {
			String sql = "select * from KhachHang where soDienThoai=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, soDienThoai);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	public boolean insertKhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into KhachHang VALUES(?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, kh.getMaKhachHang());
			statement.setString(2, kh.getSoDienThoai());
			statement.setString(3, kh.getTenKhachHang());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public KhachHang getTheoMa(String maKhachHang) {
		KhachHang kh = null;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhachHang);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	public ArrayList<KhachHang> getNhieuThuocTinh(String maKhachHang,String soDienThoai,String tenKhachHang) {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "EXEC	SPGetTheoNhieuThuocTinh @maKhachHang = ? ,@soDienThoai = ?,@tenKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhachHang);
			statement.setString(2, soDienThoai);
			statement.setString(3, tenKhachHang);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"));
				dsKhachHang.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}


	public void deleteKhacHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Delete from KhachHang Where maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhachHang);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update KhachHang set soDienThoai =?,tenKhachHang=? where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, khachHang.getSoDienThoai());
			stmt.setString(2, khachHang.getTenKhachHang());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public KhachHang getKhachHangTuHoaDon(String maHoaDon) {
		KhachHang kh = new KhachHang();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select k.maKhachHang, k.tenKhachHang,k.soDienThoai "
					+ "from HoaDonThuePhong h join KhachHang k on h.maKhachHang = k.maKhachHang "
					+ "where maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

}
