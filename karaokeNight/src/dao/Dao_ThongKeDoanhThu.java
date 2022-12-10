package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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


public class Dao_ThongKeDoanhThu {
	public  ArrayList<HoaDonThuePhong> getAllHoaDon() {
		ArrayList<HoaDonThuePhong> dshd = new ArrayList<HoaDonThuePhong>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select* from HoaDonThuePhong as hd "
					+ "join Phong as p on hd.MaPhong = p.MaPhong "
					+ "join NhanVien as nv on hd.MaNhanVien = nv.MaNhanVien "
					+ "join KhachHang as kh on hd.MaKhachHang = kh.MaKhachHang "
					+ "join CTHoaDonThuePhong as cthd on hd.maHoaDon = cthd.maHoaDon "
					+ "join DichVu as dv on dv.maDichVu = cthd.maDichVu"
					;
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				String maHoaDon = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Timestamp gioVaoPhong = rs.getTimestamp(4);
				Timestamp gioRaPhong = rs.getTimestamp(5);
				Phong p = new Phong(rs.getString("maPhong"));
				TaiKhoan tk =  new TaiKhoan(rs.getString("tenTaiKhoan"));
				LoaiDichVu ldv = new LoaiDichVu(rs.getString("maLoaiDichVu"));
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"),rs.getDouble("giaDichVu") , rs.getInt("soLuongDichVu"),ldv);
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"), rs.getString(17), rs.getDate(18), rs.getString(19),
						rs.getBoolean(20), rs.getString(21) , rs.getString("chucVu"), rs.getString("email"),tk,rs.getBoolean(25) );
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"),rs.getString(27),rs.getString(28), rs.getDate(29), rs.getString(30),rs.getBoolean(31), rs.getString(32) ,rs.getBoolean(33) ,rs.getDate("lanDungCuoi"));
				HoaDonThuePhong hdt = new HoaDonThuePhong(maHoaDon, ngayLap, 0.1, gioVaoPhong, gioRaPhong, p, kh, nv);
				CTHoaDonThuePhong cthdt = new CTHoaDonThuePhong(hdt,dv, rs.getInt("soLuongDichVu"));
				dshd.add(hdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
		
	}
	public  ArrayList<HoaDonThuePhong> getHoaDonDalap(String tuNgay, String denNgay) {
		ArrayList<HoaDonThuePhong> dshd = new ArrayList<HoaDonThuePhong>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		PreparedStatement ps = null;
		try {
			String sql = "Select* from HoaDonThuePhong as hd "
					+ "join Phong as p on hd.MaPhong = p.MaPhong "
					+ "join NhanVien as nv on hd.MaNhanVien = nv.MaNhanVien "
					+ "join KhachHang as kh on hd.MaKhachHang = kh.MaKhachHang "
					+ "WHERE  ? <= hd.ngayLap and ? >= hd.ngayLap";
			
		           ps = con.prepareStatement(sql);
		           ps.setString(1, tuNgay);
		           ps.setString(2, denNgay);
		           ResultSet rs = ps.executeQuery();
		                     
			while(rs.next()){
				String maHoaDon = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Timestamp gioVaoPhong = rs.getTimestamp(4);
				Timestamp gioRaPhong = rs.getTimestamp(5);
				Phong p = new Phong(rs.getString("maPhong"));
				TaiKhoan tk =  new TaiKhoan(rs.getString("tenTaiKhoan"));
				NhanVien nv = new NhanVien(rs.getString("maNhanVien"),rs.getString("tenNhanVien"), rs.getString(17), rs.getDate(18), rs.getString(19),
						rs.getBoolean(20), rs.getString(21) , rs.getString("chucVu"), rs.getString("email"),tk,rs.getBoolean(25) );
				KhachHang kh = new KhachHang(rs.getString("maKhachHang"),rs.getString(27),rs.getString(28), rs.getDate(29), rs.getString(30),rs.getBoolean(31), rs.getString(32) ,rs.getBoolean(33) ,rs.getDate("lanDungCuoi"));
				HoaDonThuePhong hdt = new HoaDonThuePhong(maHoaDon, ngayLap, 0.1, gioVaoPhong, gioRaPhong, p, kh, nv);
				dshd.add(hdt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	
	}
}
