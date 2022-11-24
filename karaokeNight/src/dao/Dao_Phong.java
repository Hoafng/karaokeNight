package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class Dao_Phong {
	public ArrayList<Phong> getAllPhong() {
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong,p.tonTai from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"), rs.getString("tenLoaiPhong"));
				dsPhong.add(new Phong(rs.getString("maPhong"), rs.getString("tinhTrang"), rs.getDouble("giaPhong"),
						rs.getInt("soLuongNguoi"), loaiPhong,rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhong;
	}

	public ArrayList<Phong> getPhongTheoTinhTrang(String tinhTrang) {
		ArrayList<Phong> dsPhongTheoTinhTrang = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong,p.tonTai from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where tinhTrang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tinhTrang);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"), rs.getString("tenLoaiPhong"));
				dsPhongTheoTinhTrang.add(new Phong(rs.getString("maPhong"), rs.getString("tinhTrang"),
						rs.getDouble("giaPhong"), rs.getInt("soLuongNguoi"), loaiPhong,rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTheoTinhTrang;
	}

	public ArrayList<Phong> getPhongTheoLoaiPhong(String maLoaiPhong) {
		ArrayList<Phong> dsPhongTheoTinhTrang = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong,p.tonTai from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where lp.maLoaiPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maLoaiPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"), rs.getString("tenLoaiPhong"));
				dsPhongTheoTinhTrang.add(new Phong(rs.getString("maPhong"), rs.getString("tinhTrang"),
						rs.getDouble("giaPhong"), rs.getInt("soLuongNguoi"), loaiPhong,rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTheoTinhTrang;
	}

	public ArrayList<Phong> getPhongTheoMaPhong(String maPhong) {
		ArrayList<Phong> dsPhongTheoTinhTrang = new ArrayList<Phong>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong,p.tonTai from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"), rs.getString("tenLoaiPhong"));
				dsPhongTheoTinhTrang.add(new Phong(rs.getString("maPhong"), rs.getString("tinhTrang"),
						rs.getDouble("giaPhong"), rs.getInt("soLuongNguoi"), loaiPhong,rs.getBoolean("tonTai")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhongTheoTinhTrang;
	}

	public boolean insertPhong(Phong phong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into Phong VALUES(?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, phong.getMaPhong());
			statement.setString(2, phong.getTinhTrang());
			statement.setDouble(3, phong.getGiaPhong());
			statement.setInt(4, phong.getSoLuongNguoi());
			statement.setString(5, phong.getMaLoaiPhong().getMaLoaiPhong());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public Phong getPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		Phong p = null;
		try {
			String sql = "select maPhong,tinhTrang,giaPhong,soLuongNguoi,p.maLoaiPhong,tenLoaiPhong,p.tonTai from Phong p\r\n"
					+ "join LoaiPhong lp on p.maLoaiPhong = lp.maLoaiPhong where maPhong = ?" ;
			statement = con.prepareStatement(sql);
			statement.setString(1, maPhong);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				LoaiPhong loaiPhong = new LoaiPhong(rs.getString("maLoaiPhong"),rs.getString("tenLoaiPhong"));
				p=new Phong(rs.getString("maPhong"),rs.getString("tinhTrang"),rs.getDouble("giaPhong"), rs.getInt("soLuongNguoi"),loaiPhong,rs.getBoolean("tonTai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void deletePhong(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Delete From Phong Where maPhong = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, p.getMaPhong());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updatePhong(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update Phong set soLuongNguoi =?,giaPhong =? where maPhong = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, p.getSoLuongNguoi());
			stmt.setDouble(2, p.getGiaPhong());
			stmt.setString(3, p.getMaPhong());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateTonTai(Phong p,boolean tonTai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update Phong set tonTai =? where maPhong = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, tonTai);
			stmt.setString(2, p.getMaPhong());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void updateTinhTrang(String maPhong,String tinhTrang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update Phong set tinhTrang =? where maPhong = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tinhTrang);
			stmt.setString(2, maPhong);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
