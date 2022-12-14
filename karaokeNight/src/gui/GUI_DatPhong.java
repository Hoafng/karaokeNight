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

import javax.swing.ImageIcon;
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

import dao.Dao_HoaDon;
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
	private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
	private Dao_PhieuDatPhong dao_PhieuDatPhong = new Dao_PhieuDatPhong();
	private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
	private Dao_Phong dao_Phong = new Dao_Phong();
	private TaiKhoan tk;
	private KhachHang khachHang;
	private GUI_KhachHang guiKh;
	private JDateChooser dateChooser;
	private JLabel lblThongBaoSDT;
	private JLabel lblPhiutPhng_1;
	private JLabel lblThongBaoNgayNhanPhong;
	private JLabel lblThongBaoTenKhachHang;
	private JLabel lblThongBaoSoGioDat;
	private JButton btnThemKhachHang;
	private JLabel lblThongBaoGioNhaPhong;

	public GUI_DatPhong(Phong p, TaiKhoan taiKhoan, KhachHang kh) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 919, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tk = taiKhoan;
		khachHang = kh;
		phong = dao_Phong.getPhong(p.getMaPhong());
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(89, 150, 280, 30);
		contentPane.add(panel_1);

		JLabel lblMaPhieuDatPhong = new JLabel("Mã phiếu đặt phòng");
		lblMaPhieuDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhieuDatPhong.setBounds(0, 0, 140, 30);
		panel_1.add(lblMaPhieuDatPhong);

		txtMaPhieuDatPhong = new JTextField();
		txtMaPhieuDatPhong.setEditable(false);
		txtMaPhieuDatPhong.setColumns(10);
		txtMaPhieuDatPhong.setBounds(140, 0, 140, 30);
		panel_1.add(txtMaPhieuDatPhong);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(540, 150, 280, 30);
		contentPane.add(panel_1_1);

		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMaPhong.setBounds(40, 0, 90, 30);
		panel_1_1.add(lblMaPhong);

		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(140, 0, 140, 30);
		panel_1_1.add(txtMaPhong);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(89, 210, 280, 30);
		contentPane.add(panel_1_2);

		JLabel lblLoaiPhong = new JLabel("Loai phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblLoaiPhong.setBounds(0, 0, 90, 30);
		panel_1_2.add(lblLoaiPhong);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(140, 0, 140, 30);
		panel_1_2.add(txtLoaiPhong);

		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(null);
		panel_1_2_1.setBounds(540, 210, 280, 30);
		contentPane.add(panel_1_2_1);

		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGiaPhong.setBounds(0, 0, 90, 30);
		panel_1_2_1.add(lblGiaPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(140, 0, 140, 30);
		panel_1_2_1.add(txtGiaPhong);

		JPanel panel_1_2_2 = new JPanel();
		panel_1_2_2.setLayout(null);
		panel_1_2_2.setBounds(89, 270, 280, 30);
		contentPane.add(panel_1_2_2);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(0, 0, 140, 30);
		panel_1_2_2.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent evt) {
				KhachHang kh = null;
				if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
					kh = dao_KhachHang.getKhachHang(txtSoDienThoai.getText());
					if (kh != null) {
						txtTenKhachHang.setText(kh.getTenKhachHang());
						txtTenKhachHang.setEditable(false);
					} else {
						txtTenKhachHang.setText("");
						txtTenKhachHang.setEditable(true);
					}
				} else {
					String to_check = txtSoDienThoai.getText();
					int to_check_len = to_check.length();
					for (KhachHang data : dao_KhachHang.getAllKhachHang()) {
						String check_from_data = "";
						for (int i = 0; i < to_check_len; i++) {
							if (to_check_len <= data.getSoDienThoai().length()) {
								check_from_data = check_from_data + data.getSoDienThoai().charAt(i);
							}
						}
						if (check_from_data.equals(to_check)) {
							// System.out.print("Found");
							txtSoDienThoai.setText(data.getSoDienThoai());
							txtSoDienThoai.setSelectionStart(to_check_len);
							txtSoDienThoai.setSelectionEnd(data.getSoDienThoai().length());
							kh = dao_KhachHang.getKhachHang(txtSoDienThoai.getText());
							if (kh != null) {
								txtTenKhachHang.setText(kh.getTenKhachHang());
								txtTenKhachHang.setEditable(false);
							}
							break;
						} else {
							txtTenKhachHang.setText("");
							txtTenKhachHang.setEditable(true);
						}
					}
				}
			}
		});
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(140, 0, 140, 30);
		panel_1_2_2.add(txtSoDienThoai);

		JPanel panel_1_2_2_1 = new JPanel();
		panel_1_2_2_1.setLayout(null);
		panel_1_2_2_1.setBounds(540, 270, 280, 30);
		contentPane.add(panel_1_2_2_1);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng");
		lblTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenKhachHang.setBounds(0, 0, 140, 30);
		panel_1_2_2_1.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(140, 0, 140, 30);
		panel_1_2_2_1.add(txtTenKhachHang);

		JPanel lblNgayDatPhong = new JPanel();
		lblNgayDatPhong.setLayout(null);
		lblNgayDatPhong.setBounds(89, 330, 280, 30);
		contentPane.add(lblNgayDatPhong);

		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("Ngày đặt phòng");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2_2_2.setBounds(0, 0, 121, 30);
		lblNgayDatPhong.add(lblNewLabel_1_1_2_2_2);

		txtNgayDatPhong = new JTextField();
		txtNgayDatPhong.setEditable(false);
		txtNgayDatPhong.setColumns(10);
		txtNgayDatPhong.setBounds(140, 0, 140, 30);
		lblNgayDatPhong.add(txtNgayDatPhong);

		JPanel panel_1_2_2_2_1 = new JPanel();
		panel_1_2_2_2_1.setLayout(null);
		panel_1_2_2_2_1.setBounds(89, 390, 300, 30);
		contentPane.add(panel_1_2_2_2_1);

		JLabel lblGioNhanPhong = new JLabel("Giờ nhận phòng");
		lblGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioNhanPhong.setBounds(0, 0, 126, 30);
		panel_1_2_2_2_1.add(lblGioNhanPhong);

		cbGioGioNhanPhong = new JComboBox<Integer>();
		cbGioGioNhanPhong.setBounds(140, 0, 40, 30);
		for (int i = 0; i < 24; i++) {
			cbGioGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbGioGioNhanPhong);

		JLabel lblGioGioNhanPhong = new JLabel("Giờ");
		lblGioGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioGioNhanPhong.setBounds(180, 0, 30, 30);
		panel_1_2_2_2_1.add(lblGioGioNhanPhong);

		cbPhutGioNhanPhong = new JComboBox<Integer>();
		cbPhutGioNhanPhong.setBounds(220, 0, 40, 30);
		for (int i = 0; i < 60; i += 5) {
			cbPhutGioNhanPhong.addItem(i);
		}
		panel_1_2_2_2_1.add(cbPhutGioNhanPhong);

		JLabel lblPhutGioNhanPhong = new JLabel("Phút");
		lblPhutGioNhanPhong.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhutGioNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPhutGioNhanPhong.setBounds(260, 0, 30, 30);
		panel_1_2_2_2_1.add(lblPhutGioNhanPhong);

		JPanel pnNgayNhanPhong = new JPanel();
		pnNgayNhanPhong.setLayout(null);
		pnNgayNhanPhong.setBounds(540, 330, 280, 30);
		contentPane.add(pnNgayNhanPhong);

		JLabel lblNgayNhanPhong = new JLabel("Ngày nhận phòng");
		lblNgayNhanPhong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgayNhanPhong.setBounds(0, 0, 128, 30);
		pnNgayNhanPhong.add(lblNgayNhanPhong);

		txtNgayNhanPhong = new JTextField();
		txtNgayNhanPhong.setColumns(10);
		txtNgayNhanPhong.setBounds(140, 0, 110, 30);
		pnNgayNhanPhong.add(txtNgayNhanPhong);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/YYYY");
		dateChooser.getCalendarButton().setBounds(109, 0, 31, 30);
		dateChooser.setBounds(140, 0, 140, 30);
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
		panel_1_2_2_2_1_2.setBounds(540, 390, 235, 30);
		contentPane.add(panel_1_2_2_2_1_2);

		JLabel lblSoGioDat = new JLabel("Số giờ đặt");
		lblSoGioDat.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoGioDat.setBounds(0, 0, 90, 30);
		panel_1_2_2_2_1_2.add(lblSoGioDat);

		cbSoGioDat = new JComboBox<Integer>();
		cbSoGioDat.setBounds(140, 0, 50, 30);
		for (int i = 0; i < 24; i++) {
			cbSoGioDat.addItem(i);
		}
		panel_1_2_2_2_1_2.add(cbSoGioDat);

		JLabel lblNewLabel_1 = new JLabel("Giờ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(190, 0, 40, 30);
		panel_1_2_2_2_1_2.add(lblNewLabel_1);

		lblThongBaoSoGioDat = new JLabel("");
		lblThongBaoSoGioDat.setBounds(0, 37, 260, 13);
		panel_1_2_2_2_1_2.add(lblThongBaoSoGioDat);
		lblThongBaoSoGioDat.setForeground(Color.RED);

		JButton btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTraDuLieu() == true) {
					if (themPhieuDatPhong() == true)
						dispose();
					new GUI_XuLy(tk).setVisible(true);
				}
			}
		});
		btnXacNhan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnXacNhan.setBounds(470, 462, 120, 30);
		contentPane.add(btnXacNhan);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(637, 462, 120, 30);
		contentPane.add(btnHuy);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 140));
		panel.setBounds(0, 0, 905, 104);
		contentPane.add(panel);
		panel.setLayout(null);

		lblPhiutPhng_1 = new JLabel("Phiếu đặt phòng");
		lblPhiutPhng_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhiutPhng_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPhiutPhng_1.setBounds(315, 25, 300, 60);
		panel.add(lblPhiutPhng_1);

		lblThongBaoSDT = new JLabel("");
		lblThongBaoSDT.setForeground(new Color(255, 0, 0));
		lblThongBaoSDT.setBounds(89, 307, 260, 13);
		contentPane.add(lblThongBaoSDT);

		lblThongBaoNgayNhanPhong = new JLabel("");
		lblThongBaoNgayNhanPhong.setForeground(Color.RED);
		lblThongBaoNgayNhanPhong.setBounds(540, 367, 260, 13);
		contentPane.add(lblThongBaoNgayNhanPhong);

		lblThongBaoTenKhachHang = new JLabel("");
		lblThongBaoTenKhachHang.setForeground(Color.RED);
		lblThongBaoTenKhachHang.setBounds(540, 307, 260, 13);
		contentPane.add(lblThongBaoTenKhachHang);

		btnThemKhachHang = new JButton("");
		btnThemKhachHang.setBounds(379, 270, 30, 30);
		btnThemKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				guiKh = new GUI_KhachHang(tk, phong);
				guiKh.setVisible(true);
			}
		});
		btnThemKhachHang.setIcon(new ImageIcon("image\\add.png"));
		contentPane.add(btnThemKhachHang);

		JButton btnLichDat = new JButton("Lịch đặt");
		btnLichDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_LichDatPhong(tk,p,kh).setVisible(true);
			}
		});
		btnLichDat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLichDat.setBounds(790, 390, 88, 30);
		contentPane.add(btnLichDat);

		lblThongBaoGioNhaPhong = new JLabel("");
		lblThongBaoGioNhaPhong.setForeground(Color.RED);
		lblThongBaoGioNhaPhong.setBounds(89, 430, 260, 13);
		contentPane.add(lblThongBaoGioNhaPhong);
		docDuLieuTuSQL();
	}

	protected boolean themPhieuDatPhong() {
		String maPhieuDatPhong = txtMaPhieuDatPhong.getText();
		int soGioDat = (int) cbSoGioDat.getSelectedItem();
		Timestamp ngayDatPhong = Timestamp.valueOf(txtNgayDatPhong.getText());
		Date date = new Date(System.currentTimeMillis());
		String time = cbGioGioNhanPhong.getSelectedItem().toString() + ":"
				+ cbPhutGioNhanPhong.getSelectedItem().toString() + ":00.000";
		Timestamp ngayNhanPhong = Timestamp.valueOf(txtNgayNhanPhong.getText() + " " + time);
		String maPhong = txtMaPhong.getText();
		String sdt = txtSoDienThoai.getText();
		KhachHang khachHang = dao_KhachHang.getKhachHang(sdt);
		if (khachHang == null) {
			int i = 1;
			String maKH = null;
			boolean constrain;
			do {
				if (i < 10)
					maKH = "KH00" + i;
				else if (i < 100)
					maKH = "KH0" + i;
				else
					maKH = "KH" + i;
				khachHang = new KhachHang(maKH, sdt, txtTenKhachHang.getText(), true, date);
				constrain = dao_KhachHang.getAllKhachHang().contains(khachHang);
				i++;
			} while (constrain == true);
			dao_KhachHang.insertKhachHang(khachHang);
		}
		Phong p = new Phong(maPhong);
		PhieuDatPhong pdp = new PhieuDatPhong(maPhieuDatPhong, soGioDat, ngayDatPhong, ngayNhanPhong, p, khachHang,
				true);
		if (this.dao_PhieuDatPhong.insertPhieuDatPhong(pdp) == false) {
			JOptionPane.showMessageDialog(this, "Thất bại");
			return false;
		} else {
			this.dao_Phong.updateTinhTrang(maPhong, "Đã đặt");
			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
			return true;
		}
	}

	protected boolean kiemTraDuLieu() {
		String soDienThoai = txtSoDienThoai.getText();
		String tenKhachHang = txtTenKhachHang.getText();
		String ngayNhanPhong = txtNgayNhanPhong.getText();
		Date ns = null;

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
			if ((ns.getTime() + 24 * 60 * 60 * 1000) <= date.getTime()) {
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
		for (PhieuDatPhong pdp : dao_PhieuDatPhong.getAllPhieuDatPhong()) {
			if (pdp.isTonTai() == true && pdp.getMaPhong().getMaPhong().equals(txtMaPhong.getText())) {
				Timestamp ts = Timestamp.valueOf(txtNgayNhanPhong.getText() + " " + cbGioGioNhanPhong.getSelectedItem()
						+ ":" + cbPhutGioNhanPhong.getSelectedItem() + ":00.000");
				long timeDat = ts.getTime();
				long timePhong = pdp.getNgayDatPhong().getTime();
				long timeDat2 = timeDat + (int) cbSoGioDat.getSelectedItem() * 60 * 60 * 1000;
				long timePhong2 = pdp.getNgayDatPhong().getTime() + pdp.getSoGioDat() * 60 * 60 * 1000;
				if (timeDat > timePhong && timeDat < timePhong2) {
					lblThongBaoGioNhaPhong.setText("Giờ nhận phòng bị trùng");
					cbGioGioNhanPhong.requestFocus();
					return false;
				} else
					lblThongBaoGioNhaPhong.setText("");
				if (timeDat2 > timePhong && timeDat2 < timePhong2) {
					lblThongBaoSoGioDat.setText("Số giờ hát bị trùng");
					cbSoGioDat.requestFocus();
					return false;
				} else
					lblThongBaoSoGioDat.setText("");
			}
		}
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
		if (khachHang != null) {
			txtTenKhachHang.setText(khachHang.getTenKhachHang());
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
			txtTenKhachHang.setEditable(false);
		} else {
			txtSoDienThoai.setText("");
			txtTenKhachHang.setText("");
		}

	}
}
