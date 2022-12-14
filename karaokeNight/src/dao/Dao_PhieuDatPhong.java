package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;

public class Dao_PhieuDatPhong {
	public ArrayList<PhieuDatPhong> getAllPhieuDatPhong() {
		ArrayList<PhieuDatPhong> ds = new ArrayList<PhieuDatPhong>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from PhieuDatPhong pd join KhachHang kh on kh.maKhachHang=pd.maKhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				Phong p = new Phong(rs.getString("maPhong"));
				ds.add(new PhieuDatPhong(rs.getString("maPhieuDatPhong"), rs.getInt("soGioDat"),
						rs.getTimestamp("ngayDatPhong"), rs.getTimestamp("ngayNhanPhong"), p, kh,
						rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public PhieuDatPhong getPhieuDatPhong(String maPhong) {
		PhieuDatPhong pdp = null;

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = " select * from PhieuDatPhong where maPhong=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"));
				Phong p = new Phong(rs.getString("maPhong"));
				pdp = new PhieuDatPhong(rs.getString("maPhieuDatPhong"), rs.getInt("soGioDat"),
						rs.getTimestamp("ngayDatPhong"), rs.getTimestamp("ngayNhanPhong"), p, kh,
						rs.getBoolean("tonTai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pdp;
	}

	public KhachHang getKhachHang(String maPhong) {
		PhieuDatPhong pdp = null;
		KhachHang kh = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = " select * from PhieuDatPhong p join KhachHang kh on kh.maKhachHang = p.maKhachHang where maPhong=? and DATEDIFF(minute,ngayNhanPhong,getDate()) < 60";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"), rs.getDate("ngaySinh"), rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"), rs.getString("cmnd"), rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	public ArrayList<PhieuDatPhong> getAllMaPhieuDatPhong() {
		ArrayList<PhieuDatPhong> ds = new ArrayList<PhieuDatPhong>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select maPhieuDatPhong from PhieuDatPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				ds.add(new PhieuDatPhong(rs.getString("maPhieuDatPhong")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean insertPhieuDatPhong(PhieuDatPhong phieu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into PhieuDatPhong VALUES(?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, phieu.getMaPhieuDatPhong());
			statement.setInt(2, phieu.getSoGioDat());
			statement.setTimestamp(3, phieu.getNgayDatPhong());
			statement.setTimestamp(4, phieu.getNgayNhanPhong());
			statement.setString(5, phieu.getMaPhong().getMaPhong());
			statement.setString(6, phieu.getMaKhachHang().getMaKhachHang());
			statement.setBoolean(7, phieu.isTonTai());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public void updateTonTai(String maPhong, Timestamp ngayDatPhong, boolean tonTai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update PhieuDatPhong set tonTai =? where ngayNhanPhong = ? and maPhong =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, tonTai);
			stmt.setTimestamp(2, ngayDatPhong);
			stmt.setString(3, maPhong);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
