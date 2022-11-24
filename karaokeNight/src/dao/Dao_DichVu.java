package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;

public class Dao_DichVu {
	private ArrayList<DichVu> dsdv;

	public ArrayList<DichVu> getAllDichVu() {

		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select *" + "from DichVu as d join LoaiDichVu as l on d.MaLoaiDichVu = l.MaLoaiDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDichVu = rs.getString(1);
				String tenDichVu = rs.getString(2);
				double giaDichVu = rs.getDouble(3);
				int soLuong = rs.getInt(4);

				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString(5), rs.getString(7));

				DichVu dv = new DichVu(maDichVu, tenDichVu, giaDichVu, soLuong, loaiDichVu);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	}

	public ArrayList<DichVu> getAllDichVuTuMaPhong(String maPhong) {
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select d.maDichVu, d.tenDichVu, d.giaDichVu, c.soLuongDichVu,d.maLoaiDichVu "
					+ "from DichVu d  join CTHoaDonThuePhong c on d.maDichVu = c.maDichVu join LoaiDichVu as l on d.MaLoaiDichVu = l.MaLoaiDichVu "
					+ "where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiDichVu dv = new LoaiDichVu(rs.getString("maLoaiDichVu"));
				dsDichVu.add(new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuongDichVu"), dv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDichVu;
	}

	public ArrayList<DichVu> getAllDichVu(String maPhong) {
		ArrayList<DichVu> dsDichVu = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select d.maDichVu, d.tenDichVu, d.giaDichVu, c.soLuongDichVu,d.maLoaiDichVu "
					+ "from DichVu d  join CTHoaDonThuePhong c on d.maDichVu = c.maDichVu join HoaDonThuePhong h on h.maHoaDon = c.maHoaDon "
					+ "where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiDichVu dv = new LoaiDichVu(rs.getString("maLoaiDichVu"));
				dsDichVu.add(new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuongDichVu"), dv));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDichVu;
	}

	public ArrayList<DichVu> TimDichVu(String column, String key) {
		dsdv = new ArrayList<DichVu>();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiDichVu  where " + column + " like " + "'%" + key + "%'";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DichVu dv = new DichVu();
				dsdv.add(dv);
			}
			return dsdv;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
	}

	public DichVu getDichVuTheoMa(String maDichVu) {
		DichVu dv = null;
		PreparedStatement statement = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from DichVu where maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDichVu);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString("maLoaiDichVu"));
				dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuong"), loaiDichVu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dv;
	}

	public boolean insertDichVu(DichVu dichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into DichVu VALUES(?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, dichVu.getMaDichVu());
			statement.setString(2, dichVu.getTenDichVu());
			statement.setDouble(3, dichVu.getGiaDichVu());
			statement.setInt(4, dichVu.getSoLuong());
			statement.setString(5, dichVu.getMaLoaiDichVu().getMaLoaiDichVu());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public void deleteDichVu(String maDichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Delete from DichVu Where maDichVu = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maDichVu);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDichVu(DichVu dichVu) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update DichVu set tenDichVu =?,giaDichVu=?,soLuong=?,maLoaiDichVu=? where maDichVu = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, dichVu.getTenDichVu());
			stmt.setDouble(2, dichVu.getGiaDichVu());
			stmt.setInt(3, dichVu.getSoLuong());
			stmt.setString(4, dichVu.getMaLoaiDichVu().getMaLoaiDichVu());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
