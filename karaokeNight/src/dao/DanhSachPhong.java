package dao;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import entity.Phong;
import gui.GUI_XuLy;

public class DanhSachPhong {
	JPanel pnDanhSachPhong, pnPhongDS;
	Dao_Phong dao_Phong = new Dao_Phong();
	ArrayList<Phong> danhSachPhong;
	public interface Event {

		public abstract void onChange(Phong p);
	}

	public DanhSachPhong() {

	}
	public JPanel themPhong(Phong p) {
		JPanel pn = new JPanel();
		pn.setBackground(new Color(255, 255, 140));
		
		JLabel lblIconPhong = new JLabel("");
		lblIconPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconPhong.setVerticalAlignment(SwingConstants.CENTER);
		if(p.getTinhTrang().equals("Trống"))
			lblIconPhong.setIcon(new ImageIcon("image\\home-icon-trong.png"));
		else if(p.getTinhTrang().equals("Đã đặt"))
			lblIconPhong.setIcon(new ImageIcon("image\\home-icon-dadat.png"));
		else if(p.getTinhTrang().equals("Đang chờ"))
			lblIconPhong.setIcon(new ImageIcon("image\\home-icon-dangcho.png"));
		else if(p.getTinhTrang().equals("Đang sử dụng"))
			lblIconPhong.setIcon(new ImageIcon("image\\home-icon-dangsudung.png"));

		JLabel lblSoPhong = new JLabel();
		lblSoPhong.setText(p.getMaPhong());
		lblSoPhong.setPreferredSize(new Dimension(140, 20));
		lblSoPhong.setName("");
		lblSoPhong.setFont(new Font("Segoe UI", Font.BOLD, 12));

		JLabel lblSoLuongNguoi = new JLabel();
		lblSoLuongNguoi.setText("Số lượng người :" + String.valueOf(p.getSoLuongNguoi()));
		lblSoLuongNguoi.setFont(new Font("Segoe UI", Font.BOLD, 12));

		GroupLayout gl_pnPhong = new GroupLayout(pn);
		gl_pnPhong.setHorizontalGroup(gl_pnPhong.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnPhong.createSequentialGroup().addGap(54)
						.addComponent(lblSoPhong, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE).addGap(55))
				.addGroup(gl_pnPhong.createSequentialGroup().addGap(10)
						.addComponent(lblIconPhong, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE).addGap(10))
				.addGroup(Alignment.LEADING,
						gl_pnPhong
								.createSequentialGroup().addGap(29).addComponent(lblSoLuongNguoi,
										GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(28, Short.MAX_VALUE)));
		gl_pnPhong.setVerticalGroup(gl_pnPhong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPhong.createSequentialGroup().addContainerGap()
						.addComponent(lblIconPhong, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSoPhong, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
						.addComponent(lblSoLuongNguoi, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		gl_pnPhong.setHonorsVisibility(false);
		pn.setLayout(gl_pnPhong);
		pn.setFocusable(true);
		return pn;
	}
	public void docDuLieuTuSQL(Event event) {
		for (Phong p : dao_Phong.getAllPhong()) {
			pnPhongDS = themPhong(p);
			pnDanhSachPhong.add(pnPhongDS);
			pnPhongDS.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					 event.onChange(p);
				}
			});
		}
		pnDanhSachPhong.updateUI();
	}
	public void docDuLieuTimKiem(Event event,ArrayList<Phong> ds) {
		for (Phong p : ds) {
			pnPhongDS = themPhong(p);
			pnDanhSachPhong.add(pnPhongDS);
			pnPhongDS.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					 event.onChange(p);
				}
			});
		}
		pnDanhSachPhong.updateUI();
	}
	public JPanel getPnDanhSachPhong() {
		return pnDanhSachPhong;
	}
	public void setPnDanhSachPhong(JPanel pnDanhSachPhong) {
		this.pnDanhSachPhong = pnDanhSachPhong;
	}
	public JPanel getPnPhong() {
		return pnPhongDS;
	}
	public void setPnPhong(JPanel pnPhong) {
		this.pnPhongDS = pnPhong;
	}
	public void changeBorder(){
		pnPhongDS.setBackground(Color.RED);
	}
}
