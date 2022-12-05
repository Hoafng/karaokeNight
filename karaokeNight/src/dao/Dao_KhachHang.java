package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;

public class Dao_KhachHang {
	public List<KhachHang> getAllKhachHang() {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		 ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from KhachHang";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
			while(rs.next()){
				dsKhachHang.add(new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"),
						rs.getString("cmnd"),
						rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi")
						));
			}
			
		} catch ( SQLException e){
			e.printStackTrace();
		}
		return dsKhachHang;
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
				kh = new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"),
						rs.getString("cmnd"),
						rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}

	public boolean insertKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into KhachHang VALUES(?,?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, khachHang.getMaKhachHang());
			statement.setString(2, khachHang.getSoDienThoai());
			statement.setString(3, khachHang.getTenKhachHang());
			statement.setDate(4,   khachHang.getNgaySinh());
			statement.setString(5, khachHang.getDiaChi());
			statement.setBoolean(6, khachHang.isGioiTinh());
			statement.setString(7, khachHang.getCmnd());
			statement.setBoolean(8, khachHang.isTonTai());
			statement.setDate(9,   khachHang.getLanDungCuoi());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
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



	public KhachHang getTheoMa(String maKhachHang) {
		KhachHang kh = null;
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KhachHang where maKhachHang = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhachHang);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"),
						rs.getString("cmnd"),
						rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	public List<KhachHang> getNhieuThuocTinh(String maKhachHang,String soDienThoai,String tenKhachHang,String ngaySinh,String gioiTinh,String cmnd) {
		List<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "EXEC	SPGetTheoNhieuThuocTinh @maKhachHang = ? ,@soDienThoai = ?,@tenKhachHang = ?,@ngaySinh = ?,@gioiTinh = ?,@cmnd = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maKhachHang);
			statement.setString(2, soDienThoai);
			statement.setString(3, tenKhachHang);
			statement.setString(4, ngaySinh);
			statement.setString(5, gioiTinh);
			statement.setString(6, cmnd);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("goiTinh"),
						rs.getString("cmnd"),
						rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi"));
				dsKhachHang.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}


	public void updateKhachHang(KhachHang khachHang) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update KhachHang set soDienThoai =?,tenKhachHang=? where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, khachHang.getSoDienThoai());
			stmt.setString(2, khachHang.getTenKhachHang());
			stmt.setString(3, khachHang.getMaKhachHang());
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
			String sql = "select *"
					+ "from HoaDonThuePhong h join KhachHang k on h.maKhachHang = k.maKhachHang "
					+ "where maHoaDon = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maHoaDon);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				kh = new KhachHang(
						rs.getString("maKhachHang"),
						rs.getString("soDienThoai"),
						rs.getString("tenKhachHang"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"),
						rs.getString("cmnd"),
						rs.getBoolean("tonTai"),
						rs.getDate("lanDungCuoi"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	public void updateTonTai(KhachHang khachHang,boolean tonTai) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update KhachHang set tonTai =? where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setBoolean(1, tonTai);
			stmt.setString(2, khachHang.getMaKhachHang());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void updateLanDungCuoi(Date date, String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update KhachHang set lanDungCuoi =? where maKhachHang = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setDate(1, date);
			stmt.setString(2, maKH);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
