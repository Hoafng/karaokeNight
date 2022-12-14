package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class Dao_TaiKhoan {
	public TaiKhoan getTaiKhoan(String tenTaiKhoan,String matKhau) {
		TaiKhoan tk=null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * From TaiKhoan where tenTaiKhoan = ? and matKhau = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTaiKhoan);
			statement.setString(2, matKhau);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				tk=new TaiKhoan(rs.getString("tenTaiKhoan"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	public ArrayList<TaiKhoan> getAllTaiKhoan() {
		ArrayList<TaiKhoan> dsTaiKhoan = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * From TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsTaiKhoan.add(new TaiKhoan(rs.getString("tenTaiKhoan"), rs.getString("matKhau")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTaiKhoan;
	}

	public boolean updateTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "update TaiKhoan set matKhau =? where tenTaiKhoan = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tk.getMatKhau());
			stmt.setString(2, tk.getTenTaiKhoan());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public TaiKhoan getTaiKhoan(String tenTaiKhoan) {
		TaiKhoan tk=null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * From TaiKhoan where tenTaiKhoan = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, tenTaiKhoan);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				tk=new TaiKhoan(rs.getString("tenTaiKhoan"), rs.getString("matKhau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	public boolean insertTaiKhoan(TaiKhoan tk) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "INSERT into TaiKhoan VALUES(?,?)";
			statement = con.prepareStatement(sql);
			statement.setString(1, tk.getTenTaiKhoan());
			statement.setString(2, tk.getMatKhau());
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			// e.printStackTrace();
			return false;
		}
	}

}
