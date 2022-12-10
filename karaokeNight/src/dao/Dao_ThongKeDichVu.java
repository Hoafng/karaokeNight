package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.CTHoaDonThuePhong;
import entity.DichVu;
import entity.LoaiDichVu;

public class Dao_ThongKeDichVu {
	public ArrayList<DichVu> getAllDichVuDaThanhToan() {
		ArrayList<DichVu> dshd = new ArrayList<DichVu>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql = "Select dv.maDichVu,dv.tenDichVu,tenLoaiDichVu,dv.maLoaiDichVu,dv.giaDichVu,soLuongDichVu=sum(soLuongDichVu) from CTHoaDonThuePhong hd join DichVu  dv on hd.maDichVu = dv.maDichVu join LoaiDichVu ldv on dv.maLoaiDichVu=ldv.maLoaiDichVu join HoaDonThuePhong h on h.maHoaDon = hd.maHoaDon\r\n"
					+ "where gioRaPhong is not NULL\r\n"
					+ "group by dv.maDichVu,dv.tenDichVu,tenLoaiDichVu,dv.maLoaiDichVu,dv.giaDichVu,soLuongDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"), rs.getDouble("giaDichVu"),
						rs.getInt("soLuongDichVu"), new LoaiDichVu(rs.getString("maLoaiDichVu")));
				dshd.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;

	}
	public  ArrayList<DichVu> getDichVu() {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from DichVu as dv "
					+ "join LoaiDichVu as l on d.MaLoaiDichVu = l.MaLoaiDichVu "
					+ "full join CTHoaDonThuePhong as hdt on dv.maDichVu = hdt.maDichVu "
					+ "order by soLuongDichVu DESC";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				LoaiDichVu ldv = new LoaiDichVu(rs.getString("maLoaiDichVu"),rs.getString("tenLoaiDichVu"));
				CTHoaDonThuePhong hdt = new CTHoaDonThuePhong(rs.getInt(10));
				DichVu dv = new DichVu(rs.getString("maDichVu"), rs.getString("tenDichVu"),rs.getDouble("giaDichVu") , rs.getInt("soLuongDichVu"),ldv);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	
	}
	public  ArrayList<DichVu> getDichVuDaBan(String tuNgay, String denNgay) {
		ArrayList<DichVu> dsdv = new ArrayList<DichVu>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();	
		PreparedStatement ps = null;
		try {
			String sql = "Select dv.maDichVu,dv.tenDichVu,tenLoaiDichVu,dv.maLoaiDichVu,dv.giaDichVu,soLuongDichVu=sum(soLuongDichVu) from CTHoaDonThuePhong hd join DichVu  dv on hd.maDichVu = dv.maDichVu join LoaiDichVu ldv on dv.maLoaiDichVu=ldv.maLoaiDichVu join HoaDonThuePhong h on h.maHoaDon = hd.maHoaDon\r\n"
					+ "where gioRaPhong is not NULL and ? <= ngayLap and ? >= ngayLap\r\n"
					+ "group by dv.maDichVu,dv.tenDichVu,tenLoaiDichVu,dv.maLoaiDichVu,dv.giaDichVu,soLuongDichVu";
			
		           ps = con.prepareStatement(sql);
		           ps.setString(1, tuNgay);
		           ps.setString(2, denNgay);
		           ResultSet rs = ps.executeQuery();
		                     
			while(rs.next()){
				String maDichVu = rs.getString("maDichVu");
				String tenDichVu = rs.getString("tenDichVu");
				double giaDichVu = rs.getDouble("giaDichVu");
				LoaiDichVu loaiDichVu = new LoaiDichVu(rs.getString("maLoaiDichVu"), rs.getString("tenLoaiDichVu"));
				DichVu dv = new DichVu(maDichVu, tenDichVu, giaDichVu,rs.getInt("soLuongDichVu"), loaiDichVu);
				dsdv.add(dv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	
	}
	
}
