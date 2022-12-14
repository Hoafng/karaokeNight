package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;
import entity.TaiKhoan;

public class Dao_NhanVien {
	public NhanVien getNhanVien(String tenTaiKhoan) {
		NhanVien nv = null;
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where tenTaiKhoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTaiKhoan);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("tenTaiKhoan"));
				nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("soDienThoai"),
						rs.getDate("ngaySinh"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"), rs.getString("cmnd"),
						rs.getString("chucVu"), rs.getString("email"), tk,rs.getBoolean("tonTai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public void suaThongTinNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update NhanVien set soDienThoai =?,ngaySinh =?,diaChi = ?,cmnd =?,email =? where maNhanVien = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getSoDienThoai());
			stmt.setDate(2, (Date) nv.getNgaySinh());
			stmt.setString(3, nv.getDiaChi());
			stmt.setString(4, nv.getCmnd());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getMaNhanVien());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<NhanVien> getAllNhanVien() {
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		 ConnectDB.getInstance();
		 Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql); 
			while(rs.next()){
				TaiKhoan taikhoan=new TaiKhoan(rs.getString("tenTaiKhoan"));
				dsNhanVien.add(new NhanVien(
						rs.getString("maNhanVien"),
						rs.getString("tenNhanVien"),
						rs.getString("soDienThoai"),
						rs.getDate("ngaySinh"),
						rs.getString("diaChi"),
						rs.getBoolean("gioiTinh"),
						rs.getString("cmnd"),
						rs.getString("chucVu"),
						rs.getString("email"),
						taikhoan,rs.getBoolean("tonTai") ));
			}
			
		} catch ( SQLException e){
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public NhanVien getNhanVienTheoMa(String maNhanVien) {
		NhanVien nv = null;
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NhanVien where maNhanVien = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, maNhanVien);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("tenTaiKhoan"));
				nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("soDienThoai"),
						rs.getDate("ngaySinh"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"), rs.getString("cmnd"),
						rs.getString("chucVu"), rs.getString("email"), tk,rs.getBoolean("tonTai"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nv;
	}
	public ArrayList<NhanVien> getTheoNhieuThuocTinh(String ma,String ten,String sdt,String ngaySinh,String gioiTinh,String cmnd,String chuVu) {
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		PreparedStatement statement =null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "EXEC	SPGetTheoNhieuThuocTinh @maNhanVien = ? ,@tenNhanVien = ?,@soDienThoai = ?,@ngaySinh = ?,@gioiTinh = ?,@cmnd = ?,@chucVu =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			statement.setString(2, ten);
			statement.setString(3, sdt);
			statement.setString(4, ngaySinh);
			statement.setString(5, gioiTinh);
			statement.setString(6, cmnd);
			statement.setString(7, chuVu);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoan tk = new TaiKhoan(rs.getString("tenTaiKhoan"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getString("soDienThoai"),
						rs.getDate("ngaySinh"), rs.getString("diaChi"), rs.getBoolean("gioiTinh"), rs.getString("cmnd"),
						rs.getString("chucVu"), rs.getString("email"), tk,rs.getBoolean("tonTai"));
					ds.add(nv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean insertNhanVien(NhanVien nhanVien) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into NhanVien VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, nhanVien.getMaNhanVien());
			statement.setString(2, nhanVien.getTenNhanVien());
			statement.setString(3, nhanVien.getSoDienThoai());
			statement.setDate(4, (Date) nhanVien.getNgaySinh());
			statement.setString(5, nhanVien.getDiaChi());
			statement.setBoolean(6, nhanVien.isGioiTinh());
			statement.setString(7, nhanVien.getCmnd());
			statement.setString(8, nhanVien.getChucVu());
			statement.setString(9, nhanVien.getEmail());
			statement.setString(10, nhanVien.getTenTaiKhoan().getTenTaiKhoan());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

	public void deleteNhanVien(String maNhanVien,int a) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Update NhanVien set tonTai=? where maNhanVien=?";
			statement = con.prepareStatement(sql);
			statement.setInt(1,a);
			statement.setString(2, maNhanVien);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateNhanVien(String ten,String sdt, Date ns,String dc, int gt,String cmnd,String cv,String email,String tentk,int tonTai, String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Update NhanVien set tenNhanVien =?,soDienThoai=?,ngaySinh=?,diaChi=?,gioiTinh=?,cmnd=?,chuVu=?,email=?,tenTaiKhoan=?,tonTai=? where maNhanVien = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ten);
			stmt.setString(2, sdt);
			stmt.setDate(3, ns);
			stmt.setString(4, dc);
			stmt.setInt(5, gt);
			stmt.setString(6, cmnd);
			stmt.setString(7, cv);
			stmt.setString(8, email);
			stmt.setString(9, tentk);
			stmt.setInt(10, tonTai);
			stmt.setString(11, ma);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
