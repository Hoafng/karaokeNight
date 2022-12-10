package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_HoaDon;
import dao.Dao_Phong;
import entity.HoaDonThuePhong;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ChuyenPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaPhongChuyenDititle,txtMaPhongChuyenDi;
	private JLabel lbl_iconhome;
	private JLabel lbl_iconhome1;
	private JLabel lbl_icon_rightsmall;
	private JLabel lblMaPhong;
	private JComboBox comboBox_MaPhongChuyenDi;
	private JTextField txtMaPhongChuyenDen;
	private JLabel lblLoaiPhong;
	private JTextField txtLoaiPhong;
	private JLabel lblSucChua;
	private JTextField txtSoLuongNguoi;
	private JLabel lblGiaPhong;
	private JTextField txtGiaPhong;
	private JLabel lblMaPhong_1;
	private JComboBox comboBox_MaPhongChuyenDen;
	private JLabel lblLoaiPhong_1;
	private JTextField txtLoaiPhong1;
	private JLabel lblSucChua_1;
	private JTextField txtSoLuongNguoi1;
	private JLabel lblGiaPhong_1;
	private JTextField txtGiaPhong1;
	private JLabel lbl_icon_rightbig;
	private JButton btnXacNhan;
	private JButton btnHuy;
	private Phong phong;
	private Dao_Phong dao_phong = new Dao_Phong();
	private Dao_HoaDon dao_hoadon = new Dao_HoaDon();
	private JTextField txtGioVaoPhong;
	private JTextField txtGioHienTai;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ChuyenPhong frame = new GUI_ChuyenPhong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/


	/**
	 * Create the frame.
	 */
	public GUI_ChuyenPhong(Phong p,TaiKhoan tk) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720,572);

		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		
		JLabel lblChuyenphong = new JLabel("Chuyển Phòng");
		lblChuyenphong.setBounds(258, 10, 190, 46);
		lblChuyenphong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblChuyenphong);
		
		txtMaPhongChuyenDititle = new JTextField();
		txtMaPhongChuyenDititle.setEditable(false);
		txtMaPhongChuyenDititle.setBounds(155, 77, 131, 33);
		contentPane.add(txtMaPhongChuyenDititle);
		txtMaPhongChuyenDititle.setColumns(10);
		
		lbl_iconhome = new JLabel("");
		lbl_iconhome.setIcon(new ImageIcon("image\\home.png"));
		lbl_iconhome.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconhome.setBounds(49, 50, 65, 60);
		contentPane.add(lbl_iconhome);
		
		lbl_iconhome1 = new JLabel("");
		lbl_iconhome1.setIcon(new ImageIcon("image\\home.png"));
		lbl_iconhome1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_iconhome1.setBounds(590, 50, 65, 60);
		contentPane.add(lbl_iconhome1);
		
		lbl_icon_rightsmall = new JLabel("");
		lbl_icon_rightsmall.setIcon(new ImageIcon("image\\right_small.png"));
		lbl_icon_rightsmall.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_icon_rightsmall.setBounds(337, 62, 65, 60);
		contentPane.add(lbl_icon_rightsmall);
		
		lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(49, 139, 120, 40);
		contentPane.add(lblMaPhong);
		
		txtMaPhongChuyenDi = new JTextField();
		txtMaPhongChuyenDi.setEditable(false);
		txtMaPhongChuyenDi.setBounds(155, 141, 131, 40);
		contentPane.add(txtMaPhongChuyenDi);
		
		txtMaPhongChuyenDen = new JTextField();
		txtMaPhongChuyenDen.setEditable(false);
		txtMaPhongChuyenDen.setColumns(10);
		txtMaPhongChuyenDen.setBounds(412, 77, 131, 33);
		contentPane.add(txtMaPhongChuyenDen);
		
		lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(49, 201, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(155, 201, 131, 40);
		contentPane.add(txtLoaiPhong);
		
		lblSucChua = new JLabel("Số lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(49, 261, 120, 40);
		contentPane.add(lblSucChua);
		
		txtSoLuongNguoi = new JTextField();
		txtSoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuongNguoi.setEditable(false);
		txtSoLuongNguoi.setColumns(10);
		txtSoLuongNguoi.setBounds(155, 261, 131, 40);
		contentPane.add(txtSoLuongNguoi);
		
		lblGiaPhong = new JLabel("Giá Phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(49, 321, 120, 40);
		contentPane.add(lblGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(155, 321, 131, 40);
		contentPane.add(txtGiaPhong);
		
		lblMaPhong_1 = new JLabel("Mã Phòng");
		lblMaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong_1.setBounds(412, 139, 120, 40);
		contentPane.add(lblMaPhong_1);
		
		comboBox_MaPhongChuyenDen = new JComboBox();
		comboBox_MaPhongChuyenDen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String maPhong = comboBox_MaPhongChuyenDen.getSelectedItem().toString();
				txtMaPhongChuyenDen.setText(maPhong);
				Dao_Phong dao_phong2 = new Dao_Phong();
				Phong p2 = dao_phong2.getPhong(maPhong);
				txtMaPhongChuyenDen.setText(p2.getMaPhong());
				txtLoaiPhong1.setText(p2.getMaLoaiPhong().getTenLoaiPhong());
				txtGiaPhong1.setText(String.valueOf(p2.getGiaPhong()));
				txtSoLuongNguoi1.setText(String.valueOf(p2.getSoLuongNguoi()));
			}
		});
		comboBox_MaPhongChuyenDen.setBounds(524, 140, 131, 40);
		contentPane.add(comboBox_MaPhongChuyenDen);
		
		lblLoaiPhong_1 = new JLabel("Loại Phòng");
		lblLoaiPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong_1.setBounds(412, 201, 120, 40);
		contentPane.add(lblLoaiPhong_1);
		
		txtLoaiPhong1 = new JTextField();
		txtLoaiPhong1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLoaiPhong1.setEditable(false);
		txtLoaiPhong1.setColumns(10);
		txtLoaiPhong1.setBounds(524, 201, 131, 40);
		contentPane.add(txtLoaiPhong1);
		
		lblSucChua_1 = new JLabel("Số lượng người");
		lblSucChua_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua_1.setBounds(412, 261, 120, 40);
		contentPane.add(lblSucChua_1);
		
		txtSoLuongNguoi1 = new JTextField();
		txtSoLuongNguoi1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuongNguoi1.setEditable(false);
		txtSoLuongNguoi1.setColumns(10);
		txtSoLuongNguoi1.setBounds(524, 261, 131, 40);
		contentPane.add(txtSoLuongNguoi1);
		
		lblGiaPhong_1 = new JLabel("Giá Phòng");
		lblGiaPhong_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong_1.setBounds(412, 321, 120, 40);
		contentPane.add(lblGiaPhong_1);
		
		txtGiaPhong1 = new JTextField();
		txtGiaPhong1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong1.setEditable(false);
		txtGiaPhong1.setColumns(10);
		txtGiaPhong1.setBounds(524, 321, 131, 40);
		contentPane.add(txtGiaPhong1);
		
		lbl_icon_rightbig = new JLabel("");
		lbl_icon_rightbig.setIcon(new ImageIcon("image\\right_big.png"));
		lbl_icon_rightbig.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lbl_icon_rightbig.setBounds(296, 251, 85, 60);
		contentPane.add(lbl_icon_rightbig);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateData();
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
	
		});
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(200, 460, 123, 40);
		contentPane.add(btnXacNhan);
		
		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(387, 460, 123, 40);
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			
			}
		});
		contentPane.add(btnHuy);
		
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(49, 381, 120, 40);
		contentPane.add(lblGioVaoPhong);
		
		txtGioVaoPhong = new JTextField();
		txtGioVaoPhong.setText("0.0");
		txtGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioVaoPhong.setEditable(false);
		txtGioVaoPhong.setColumns(10);
		txtGioVaoPhong.setBounds(155, 381, 131, 40);
		contentPane.add(txtGioVaoPhong);
		
		JLabel lblGiHinTi = new JLabel("Giờ hiện tại");
		lblGiHinTi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiHinTi.setBounds(412, 381, 120, 40);
		contentPane.add(lblGiHinTi);
		
		txtGioHienTai = new JTextField();
		txtGioHienTai.setText("0.0");
		txtGioHienTai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGioHienTai.setEditable(false);
		txtGioHienTai.setColumns(10);
		txtGioHienTai.setBounds(524, 381, 131, 40);
		contentPane.add(txtGioHienTai);
		String maPhongChuyenDen;
		for (Phong p1 : dao_phong.getPhongTheoTinhTrang("Trống")) {
			maPhongChuyenDen = p1.getMaPhong();	
			comboBox_MaPhongChuyenDen.addItem(maPhongChuyenDen);

		}
		
		phong =p;
		docDuLieuTuSQL();
	}
	private void docDuLieuTuSQL() {
		//Phòng chuyển đi
		txtMaPhongChuyenDititle.setText(phong.getMaPhong());
		txtMaPhongChuyenDi.setText(phong.getMaPhong());
		txtLoaiPhong.setText(phong.getMaLoaiPhong().getTenLoaiPhong());	
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		txtSoLuongNguoi.setText(String.valueOf(phong.getSoLuongNguoi()));
		SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Timestamp date1 = new Timestamp(System.currentTimeMillis());
		txtGioHienTai.setText(sf.format(date1));
		txtGioVaoPhong.setText(sf.format(dao_hoadon.getMaHoaDonPhong(phong.getMaPhong()).getGioVaoPhong()));
	}
	
	private void UpdateData() {
		String maPhongChuyenDi = txtMaPhongChuyenDi.getText();
		String maPhongChuyenDen = txtMaPhongChuyenDen.getText();
		HoaDonThuePhong hd = dao_hoadon.getMaHoaDon(maPhongChuyenDi);
		String maHoaDon = hd.getMaHoaDon();
		if (dao_hoadon.updateHoaDonThuePhong(maPhongChuyenDen, maPhongChuyenDi, maHoaDon) == true) {
			dao_phong.updateTinhTrang(maPhongChuyenDen, "Đang sử dụng");
			dao_phong.updateTinhTrang(maPhongChuyenDi, "Trống");
			JOptionPane.showMessageDialog(this, "Chuyển phòng thành công");
		} else
			JOptionPane.showMessageDialog(this, "Chuyển phòng thất bại");
	}
}


