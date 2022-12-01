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
						rs.getTimestamp("ngayDatPhong"), rs.getTimestamp("ngayNhanPhong"), p, kh,rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
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
			String sql = "INSERT into PhieuDatPhong VALUES(?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, phieu.getMaPhieuDatPhong());
			statement.setInt(2, phieu.getSoGioDat());
			statement.setTimestamp(3, phieu.getNgayDatPhong());
			statement.setTimestamp(4, phieu.getNgayNhanPhong());
			statement.setString(5, phieu.getMaPhong().getMaPhong());
			statement.setString(6, phieu.getMaKhachHang().getMaKhachHang());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}
}
