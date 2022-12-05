package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_HoaDon;
import dao.Dao_KhachHang;
import dao.Dao_NhanVien;
import dao.Dao_Phong;
import entity.HoaDonThuePhong;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_ThuePhong extends JFrame{

	private JPanel contentPane;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKhachHang;
	private JTextField txtMaNhanVien;
	private JTextField txtLoaiPhong;
	private JTextField txtSoLuongNguoi;
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private JTextField txtGioVaoPhong;
	private JTextField txtPhutVaoPhong;
	private JLabel lblThongBaoSDT;
	private JLabel lblThongBaoTenKhachHang;
	private Phong phong;
	private NhanVien nhanvien;
	private TaiKhoan taikhoan;
	private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_ThuePhong(Phong p,TaiKhoan tk) {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 556);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));
		
		JLabel lblThuePhong = new JLabel("Thuê phòng");
		lblThuePhong.setBounds(344, 10, 158, 48);
		lblThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblThuePhong);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(60, 68, 120, 40);
		contentPane.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(165, 68, 158, 40);
		txtSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String sdt = txtSoDienThoai.getText();
				KhachHang kh = dao_KhachHang.getKhachHang(sdt);
				if (kh != null) {
					txtTenKhachHang.setText(kh.getTenKhachHang());
					txtTenKhachHang.setEditable(false);
				}
			}
		});
		contentPane.add(txtSoDienThoai);
		
	    lblThongBaoTenKhachHang = new JLabel();
	    lblThongBaoTenKhachHang.setForeground(Color.RED);
	    lblThongBaoTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    lblThongBaoTenKhachHang.setBounds(630, 106, 158, 40);
		contentPane.add(lblThongBaoTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(630, 68, 158, 40);
		contentPane.add(txtTenKhachHang);
		
		lblThongBaoSDT = new JLabel();
		lblThongBaoSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoSDT.setForeground(Color.red);
		lblThongBaoSDT.setBounds(31, 106, 389, 40);
		contentPane.add(lblThongBaoSDT);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTenKhachHang.setBounds(506, 68, 120, 40);
		contentPane.add(lblTenKhachHang);
		
		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaNhanVien.setBounds(58, 162, 120, 40);
		contentPane.add(lblMaNhanVien);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(504, 162, 120, 40);
		contentPane.add(lblMaPhong);
		
		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(58, 238, 120, 40);
		contentPane.add(lblLoaiPhong);
		
		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(504, 238, 120, 40);
		contentPane.add(lblGiaPhong);
		
		JLabel lblSucChua = new JLabel("Sos lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(58, 308, 120, 40);
		contentPane.add(lblSucChua);
		
		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(504, 308, 120, 40);
		contentPane.add(lblGioVaoPhong);
		
//		String[] hour = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
//		JComboBox comboBox_Gio = new JComboBox(hour);
//		comboBox_Gio.setBounds(609, 308, 54, 40);
//		contentPane.add(comboBox_Gio);
//		
		JLabel lblGio = new JLabel("Giờ");
		lblGio.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGio.setBounds(688, 308, 40, 40);
		contentPane.add(lblGio);
		
		JLabel lblPhut = new JLabel("Phút");
		lblPhut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhut.setBounds(785, 308, 40, 40);
		contentPane.add(lblPhut);
		
		SimpleDateFormat sf = new SimpleDateFormat("hh");
		Date date1 = new Date(System.currentTimeMillis());
		String hour1 = sf.format(date1);
		txtGioVaoPhong = new JTextField(hour1);
		txtGioVaoPhong.setEditable(false);
		txtGioVaoPhong.setBounds(630, 308, 54, 40);
		contentPane.add(txtGioVaoPhong);
		
		SimpleDateFormat sf1 = new SimpleDateFormat("mm");
		String minute1 = sf1.format(date1);
		txtPhutVaoPhong = new JTextField(minute1);
		txtPhutVaoPhong.setEditable(false);
		txtPhutVaoPhong.setBounds(727, 308, 54, 40);
		contentPane.add(txtPhutVaoPhong);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(163, 162, 158, 40);
		contentPane.add(txtMaNhanVien);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(163, 238, 158, 40);
		contentPane.add(txtLoaiPhong);
		
		txtSoLuongNguoi = new JTextField();
		txtSoLuongNguoi.setEditable(false);
		txtSoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuongNguoi.setColumns(10);
		txtSoLuongNguoi.setBounds(163, 308, 158, 40);
		contentPane.add(txtSoLuongNguoi);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(628, 162, 158, 40);
		contentPane.add(txtMaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(628, 238, 158, 40);
		contentPane.add(txtGiaPhong);
		
		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(259, 412, 123, 40);
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTraDuLieu() == true) {
					InsertData();
					dispose();
					new GUI_XuLy(tk).setVisible(true);
				}
			}
		});
		contentPane.add(btnXacNhan);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(483, 412, 123, 40);
		contentPane.add(btnHuy);
		
		

		taikhoan =tk;
		phong =p;
		docDuLieuTuSQL();
	}
	private void docDuLieuTuSQL() {
		txtMaPhong.setText(phong.getMaPhong());
		txtLoaiPhong.setText(phong.getMaLoaiPhong().getTenLoaiPhong());	
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		txtSoLuongNguoi.setText(String.valueOf(phong.getSoLuongNguoi()));
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		NhanVien nv = dao_nv.getNhanVien(taikhoan.getTenTaiKhoan());	
		txtMaNhanVien.setText(nv.getMaNhanVien());
	
	
	}
	
	protected boolean kiemTraDuLieu() {
	String soDienThoai = txtSoDienThoai.getText();
	String tenKhachHang = txtTenKhachHang.getText();
	if (soDienThoai.equals("") || !(soDienThoai.matches("^(0){1}[0-9]{9}$"))) {
		lblThongBaoSDT.setText("Nhập số điện thoại 10 số và bắt đầu bằng 0");
		txtSoDienThoai.requestFocus();
		return false;
	} else
		lblThongBaoSDT.setText("");
	if (!(tenKhachHang.length() > 0)) {
		lblThongBaoTenKhachHang.setText("Nhập tên khách hàng");
		txtTenKhachHang.requestFocus();
		return false;
	} else
		lblThongBaoTenKhachHang.setText("");
	return true;
	}
	
	protected void InsertData() {
		Dao_KhachHang dao_kh = new Dao_KhachHang();
		String sdt = txtSoDienThoai.getText();
		KhachHang khachHang = dao_kh.getKhachHang(sdt);

		
		
		if (khachHang == null) {
			int i = 1;
			String maKH = null;
			boolean constrain1;
			do {
				if(i<10)
					maKH="KH00"+i;
				else if(i<100)
					maKH="KH0"+i;
				else maKH ="KH"+i;
				khachHang = new KhachHang(maKH, sdt, txtTenKhachHang.getText(),true,null);
				constrain1 = dao_kh.getAllKhachHang().contains(khachHang);
				i++;
			} while (constrain1 == true);
			dao_kh.insertKhachHang(khachHang);
		}
		String maNhanVien = txtMaNhanVien.getText();
		String maPhong = txtMaPhong.getText();
		Date date = new Date(System.currentTimeMillis());

	
		Date ngayLap = date;
		long gioVaoP = date.getTime();
		Timestamp gioVaoPhong = new Timestamp(gioVaoP);
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		Dao_Phong dao_phong = new Dao_Phong();
		Date ngayLap1=null;
		Timestamp gioRaPhong =null;
		Phong phonG = new Phong(maPhong);
		NhanVien nv = new NhanVien(maNhanVien);
		String maHoaDon = null;
		HoaDonThuePhong hdtp;
		HoaDonThuePhong hoadon = dao_hd.getHoaDon(maHoaDon);
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		if(hoadon ==null) {
			int x=1;
			maHoaDon = null;
			boolean constrain = false;
			do {
				if(x<10)
					maHoaDon = maNhanVien + sf.format(ngayLap) + "000" + x ;
				else if(x<100)
					maHoaDon = maNhanVien + sf.format(ngayLap) + "00" + x ;
				else maHoaDon = maNhanVien + sf.format(ngayLap) + "0" + x ;
				hdtp= new HoaDonThuePhong(maHoaDon,ngayLap1,0.1,gioVaoPhong,gioRaPhong,phonG,khachHang, nv);
				hoadon = new HoaDonThuePhong(maHoaDon);
				constrain = dao_hd.getAllMaHoaDon().contains(hoadon);
				x++;
			}while(constrain == true);
			if (dao_hd.insertHoaDonThuePhong(hdtp) == false)
				JOptionPane.showMessageDialog(this, "Thuê phòng thất bại");
			else {
				dao_hd.insertHoaDonThuePhong(hdtp);
				dao_phong.updateTinhTrang(maPhong, "Đang sử dụng");
				JOptionPane.showMessageDialog(this, "Thuê phòng thành công");
			}
		}	
	}


}