package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import dao.Dao_KhachHang;
import dao.Dao_PhieuDatPhong;
import dao.Dao_Phong;
import entity.KhachHang;
import entity.PhieuDatPhong;
import entity.Phong;
import entity.TaiKhoan;

public class GUI_DatPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaPhieuDatPhong;
	private JTextField txtMaPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKhachHang;
	private JTextField txtNgayDatPhong;
	private JTextField txtNgayNhanPhong;
	private JComboBox<Integer> cbGioGioNhanPhong;
	private JComboBox<Integer> cbPhutGioNhanPhong;
	private JComboBox<Integer> cbSoGioDat;
	private JComboBox<Integer> cbSoPhutDat;
	private Phong phong;
	private Dao_PhieuDatPhong dao_PhieuDatPhong;
	private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
	private Dao_Phong dao_Phong= new Dao_Phong();
	private TaiKhoan tk;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_DatPhong frame = new GUI_DatPhong();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	private JDateChooser dateChooser;
	private JLabel lblThongBaoSDT;
	private JLabel lblPhiutPhng_1;
	private JLabel lblThongBaoNgayNhanPhong;
	private JLabel lblThongBaoTenKhachHang;
	private JLabel lblThongBaoSoGioDat;

	/**
	 * Create the frame.
	 */
	public GUI_DatPhong(Phong p,TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tk=taiKhoan;
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(275, 200, 350, 30);
		contentPane.add(panel_1);

		JLabel lblMaPhieuDatPhong = new JLabel("Mã phiếu đặt phòng");
		lblMaPhieuDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhieuDatPhong.setBounds(0, 0, 150, 30);
		panel_1.add(lblMaPhieuDatPhong);

		txtMaPhieuDatPhong = new JTextField();
		txtMaPhieuDatPhong.setEditable(false);
		txtMaPhieuDatPhong.setColumns(10);
		txtMaPhieuDatPhong.setBounds(150, 0, 200, 30);
		panel_1.add(txtMaPhieuDatPhong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(855, 200, 350, 30);
		contentPane.add(panel_1_1);

		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(0, 0, 90, 30);
		panel_1_1.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(150, 0, 200, 30);
		panel_1_1.add(txtMaPhong);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(275, 280, 350, 30);
		contentPane.add(panel_1_2);

		JLabel lblLoaiPhong = new JLabel("Loai phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(0, 0, 90, 30);
		panel_1_2.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(150, 0, 200, 30);
		panel_1_2.add(txtLoaiPhong);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(855, 280, 350, 30);
		contentPane.add(panel_1_2_1);

		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaPhong.setBounds(0, 0, 90, 30);
		panel_1_2_1.add(lblGiaPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(150, 0, 200, 30);
		panel_1_2_1.add(txtGiaPhong);

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBounds(275, 360, 350, 30);
		contentPane.add(panel_1_2_2);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(0, 0, 140, 30);
		panel_1_2_2.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
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
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(150, 0, 200, 30);
		panel_1_2_2.add(txtSoDienThoai);

		JPanel panel_1_2_2_1 = new JPanel();
		panel_1_2_2_1.setLayout(null);
		panel_1_2_2_1.setBounds(855, 360, 350, 30);
		contentPane.add(panel_1_2_2_1);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(0, 0, 140, 30);
		panel_1_2_2_1.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(150, 0, 200, 30);
		panel_1_2_2_1.add(txtTenKhachHang);

		JPanel lblNgayDatPhong = new JPanel();
		lblNgayDatPhong.setLayout(null);
		lblNgayDatPhong.setBounds(275, 440, 350, 30);
		contentPane.add(lblNgayDatPhong);

		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Ngày đặt phòng");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2.setBounds(0, 0, 121, 30);
		lblNgayDatPhong.add(lblNewLabel_1_1_2_2_2);

		txtNgayDatPhong = new JTextField();
		txtNgayDatPhong.setEditable(false);
		txtNgayDatPhong.setColumns(10);
		txtNgayDatPhong.setBounds(150, 0, 200, 30);
		lblNgayDatPhong.add(txtNgayDatPhong);

		JPanel panel_1_2_2_2_1 = new JPanel();
		panel_1_2_2_2_1.setLayout(null);
		panel_1_2_2_2_1.setBounds(275, 520, 350, 30);
		contentPane.add(panel_1_2_2_2_1);

		JLabel lblGioNhanPhong = new JLabel("Giờ nhận phòng");
		lblGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(0, 0, 126, 30);
		panel_1_2_2_2_1.add(lblGioNhanPhong);

		cbGioGioNhanPhong = new JComboBox<Integer>();
		cbGioGioNhanPhong.setBounds(150, 0, 50, 30);
		for (int i = 0; i < 24; i++) {
			cbGioGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbGioGioNhanPhong);

		JLabel lblGioGioNhanPhong = new JLabel("Giờ");
		lblGioGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioGioNhanPhong.setBounds(200, 0, 50, 30);
		panel_1_2_2_2_1.add(lblGioGioNhanPhong);

		cbPhutGioNhanPhong = new JComboBox<Integer>();
		cbPhutGioNhanPhong.setBounds(250, 0, 50, 30);
		for (int i = 0; i < 60; i++) {
			cbPhutGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbPhutGioNhanPhong);

		JLabel lblPhutGioNhanPhong = new JLabel("Phút");
		lblPhutGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhutGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhutGioNhanPhong.setBounds(300, 0, 50, 30);
		panel_1_2_2_2_1.add(lblPhutGioNhanPhong);

		JPanel pnNgayNhanPhong = new JPanel();
		pnNgayNhanPhong.setLayout(null);
		pnNgayNhanPhong.setBounds(855, 440, 350, 30);
		contentPane.add(pnNgayNhanPhong);

		JLabel lblNgayNhanPhong = new JLabel("Ngày nhận phòng");
		lblNgayNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgayNhanPhong.setBounds(0, 0, 128, 30);
		pnNgayNhanPhong.add(lblNgayNhanPhong);

		txtNgayNhanPhong = new JTextField();
		txtNgayNhanPhong.setColumns(10);
		txtNgayNhanPhong.setBounds(150, 0, 170, 30);
		pnNgayNhanPhong.add(txtNgayNhanPhong);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/YYYY");
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(150, 0, 200, 30);
		pnNgayNhanPhong.add(dateChooser);
		dateChooser.setLayout(null);

		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgayNhanPhong.setText(a);
				}
			}
		});

		JPanel panel_1_2_2_2_1_2 = new JPanel();
		panel_1_2_2_2_1_2.setLayout(null);
		panel_1_2_2_2_1_2.setBounds(855, 520, 245, 30);
		contentPane.add(panel_1_2_2_2_1_2);

		JLabel lblSoGioDat = new JLabel("Số giờ đặt");
		lblSoGioDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoGioDat.setBounds(0, 0, 90, 30);
		panel_1_2_2_2_1_2.add(lblSoGioDat);

		cbSoGioDat = new JComboBox<Integer>();
		cbSoGioDat.setBounds(150, 0, 50, 30);
		for (int i = 0; i < 24; i++) {
			cbSoGioDat.addItem(i);
		}
		panel_1_2_2_2_1_2.add(cbSoGioDat);

		JLabel lblNewLabel_1 = new JLabel("Giờ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(200, 0, 50, 30);
		panel_1_2_2_2_1_2.add(lblNewLabel_1);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTraDuLieu() == true) {
					themPhieuDatPhong();
					dispose();
					new GUI_XuLy(tk).setVisible(true);
				}
			}
		});
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(585, 631, 120, 30);
		contentPane.add(btnXacNhan);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(795, 631, 120, 30);
		contentPane.add(btnHuy);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 140));
		panel.setBounds(275, 20, 930, 110);
		contentPane.add(panel);
		panel.setLayout(null);

		lblPhiutPhng_1 = new JLabel("Phiếu đặt phòng");
		lblPhiutPhng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiutPhng_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPhiutPhng_1.setBounds(315, 25, 300, 60);
		panel.add(lblPhiutPhng_1);

		lblThongBaoSDT = new JLabel("");
		lblThongBaoSDT.setForeground(new Color(255, 0, 0));
		lblThongBaoSDT.setBounds(365, 400, 260, 13);
		contentPane.add(lblThongBaoSDT);

		lblThongBaoNgayNhanPhong = new JLabel("");
		lblThongBaoNgayNhanPhong.setForeground(Color.RED);
		lblThongBaoNgayNhanPhong.setBounds(945, 479, 260, 13);
		contentPane.add(lblThongBaoNgayNhanPhong);

		lblThongBaoTenKhachHang = new JLabel("");
		lblThongBaoTenKhachHang.setForeground(Color.RED);
		lblThongBaoTenKhachHang.setBounds(945, 400, 260, 13);
		contentPane.add(lblThongBaoTenKhachHang);

		lblThongBaoSoGioDat = new JLabel("");
		lblThongBaoSoGioDat.setForeground(Color.RED);
		lblThongBaoSoGioDat.setBounds(945, 560, 260, 13);
		contentPane.add(lblThongBaoSoGioDat);
		phong = p;
		docDuLieuTuSQL();
	}

	protected void themPhieuDatPhong() {
		String maPhieuDatPhong = txtMaPhieuDatPhong.getText();
		int soGioDat = (int) cbSoGioDat.getSelectedItem();
		Timestamp ngayDatPhong = Timestamp.valueOf(txtNgayDatPhong.getText());
		Date date = new Date(System.currentTimeMillis());
		String time = cbGioGioNhanPhong.getSelectedItem().toString() +":"+cbPhutGioNhanPhong.getSelectedItem().toString()+":00.000";
		Timestamp ngayNhanPhong = Timestamp.valueOf(txtNgayNhanPhong.getText()+" "+time);
		String maPhong = txtMaPhong.getText();
		String sdt = txtSoDienThoai.getText();
		KhachHang khachHang = dao_KhachHang.getKhachHang(sdt);
		if (khachHang == null) {
			int i = 1;
			String maKH = null;
			boolean constrain;
			do {
				if(i<10)
					maKH="KH00"+i;
				else if(i<100)
					maKH="KH0"+i;
				else maKH ="KH"+i;
				khachHang = new KhachHang(maKH, sdt, txtTenKhachHang.getText(),true,date);
				constrain = dao_KhachHang.getAllKhachHang().contains(khachHang);
				i++;
			} while (constrain == true);
			dao_KhachHang.insertKhachHang(khachHang);
		}
		Phong p = new Phong(maPhong);
		PhieuDatPhong pdp= new PhieuDatPhong(maPhieuDatPhong, soGioDat, ngayDatPhong, ngayNhanPhong, p, khachHang,true);
		if (this.dao_PhieuDatPhong.insertPhieuDatPhong(pdp) == false)
			JOptionPane.showMessageDialog(this, "Thất bại");
		else {
			this.dao_PhieuDatPhong.insertPhieuDatPhong(pdp);
			this.dao_Phong.updateTinhTrang(maPhong, "Đã đặt");
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
		}
	}

	protected boolean kiemTraDuLieu() {
		String soDienThoai = txtSoDienThoai.getText();
		String tenKhachHang = txtTenKhachHang.getText();
		String ngayNhanPhong = txtNgayNhanPhong.getText();
		Date ns=null;
		Date date = new Date(System.currentTimeMillis());
		int soGioHat = (int) cbSoGioDat.getSelectedItem();
		if (soDienThoai.equals("") || !(soDienThoai.matches("^(0){1}[0-9]{9}$"))) {
			lblThongBaoSDT.setText("Nhập số điện thoại 10 số");
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
		if (ngayNhanPhong.equals("")) {
			lblThongBaoNgayNhanPhong.setText("Chọn ngày nhận phòng");
			dateChooser.requestFocus();
			return false;
		} else {
			ns = Date.valueOf(txtNgayNhanPhong.getText());
			if ((ns.getTime()+24*60*60*1000) <= date.getTime()) {
				lblThongBaoNgayNhanPhong.setText("Thời gian nhận phòng sau thời gian hiện tại");
				txtNgayNhanPhong.setText("");
				return false;
			} else
				lblThongBaoNgayNhanPhong.setText("");
		}
		if (soGioHat <= 0) {
			lblThongBaoSoGioDat.setText("Chọn số giờ đặt phòng");
			cbSoGioDat.requestFocus();
			return false;
		} else
			lblThongBaoSoGioDat.setText("");
		return true;
	}

	private void docDuLieuTuSQL() {
		int i = 1;
		String maPhieu = null;
		boolean constrain;
		dao_PhieuDatPhong = new Dao_PhieuDatPhong();
		PhieuDatPhong pdp;
		do {
			maPhieu = (i < 10) ? "MPDP0" + i : "MPDP" + i;
			pdp = new PhieuDatPhong(maPhieu);
			constrain = dao_PhieuDatPhong.getAllMaPhieuDatPhong().contains(pdp);
			i++;
		} while (constrain == true);
		txtMaPhieuDatPhong.setText(maPhieu);
		txtMaPhong.setText(phong.getMaPhong());
		txtLoaiPhong.setText(phong.getMaLoaiPhong().getTenLoaiPhong());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		Timestamp d = new Timestamp(System.currentTimeMillis());
		txtNgayDatPhong.setText(sf.format(d));
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		
		
	}
}
