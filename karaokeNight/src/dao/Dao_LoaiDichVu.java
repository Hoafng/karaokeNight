package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiDichVu;

public class Dao_LoaiDichVu {
public  ArrayList<LoaiDichVu> getAllLoaiDichVu() {
		
		ArrayList<LoaiDichVu> loaiDichVu = new ArrayList<LoaiDichVu>();		
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();			
		try {
			String sql = "Select * from LoaiDichVu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				String maLoaiDichVu = rs.getString(1);
				String tenLoaiDichVu = rs.getString(2);
				LoaiDichVu lDV =new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
				loaiDichVu.add(lDV);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loaiDichVu;
	}

}
