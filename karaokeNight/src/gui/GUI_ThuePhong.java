package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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

public class GUI_ThuePhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtSoDienThoai;
	private JTextField txtTenKhachHang;
	private JTextField txtMaNhanVien;
	private JTextField txtLoaiPhong;
	private JTextField txtSoLuongNguoi;
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private JTextField txtGioVaoPhong;
	private JLabel lblThongBaoSDT;
	private JLabel lblThongBaoTenKhachHang;
	private Phong phong;
	private NhanVien nhanvien;
	private TaiKhoan taikhoan;
	private Dao_KhachHang dao_KhachHang = new Dao_KhachHang();
	private GUI_KhachHang guiKh;
	private KhachHang khachHang;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public GUI_ThuePhong(Phong p, TaiKhoan tk, KhachHang kh) {

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
		taikhoan = tk;
		phong = p;
		khachHang = kh;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(101, 186, 118));

		JLabel lblThuePhong = new JLabel("Thuê phòng");
		lblThuePhong.setBounds(344, 10, 158, 48);
		lblThuePhong.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblThuePhong);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSoDienThoai.setBounds(60, 70, 120, 40);
		contentPane.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(165, 70, 158, 40);
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
		contentPane.add(txtSoDienThoai);

		lblThongBaoTenKhachHang = new JLabel();
		lblThongBaoTenKhachHang.setForeground(Color.RED);
		lblThongBaoTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblThongBaoTenKhachHang.setBounds(630, 106, 158, 40);
		contentPane.add(lblThongBaoTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(630, 70, 158, 40);
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
		lblMaNhanVien.setBounds(58, 150, 120, 40);
		contentPane.add(lblMaNhanVien);

		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMaPhong.setBounds(504, 150, 120, 40);
		contentPane.add(lblMaPhong);

		JLabel lblLoaiPhong = new JLabel("Loại phòng");
		lblLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLoaiPhong.setBounds(58, 230, 120, 40);
		contentPane.add(lblLoaiPhong);

		JLabel lblGiaPhong = new JLabel("Giá phòng");
		lblGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGiaPhong.setBounds(504, 230, 120, 40);
		contentPane.add(lblGiaPhong);

		JLabel lblSucChua = new JLabel("Số lượng người");
		lblSucChua.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblSucChua.setBounds(58, 310, 120, 40);
		contentPane.add(lblSucChua);

		JLabel lblGioVaoPhong = new JLabel("Giờ vào phòng");
		lblGioVaoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblGioVaoPhong.setBounds(504, 310, 120, 40);
		contentPane.add(lblGioVaoPhong);

		txtGioVaoPhong = new JTextField();
		txtGioVaoPhong.setEditable(false);
		txtGioVaoPhong.setBounds(630, 310, 158, 40);
		contentPane.add(txtGioVaoPhong);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(163, 150, 158, 40);
		contentPane.add(txtMaNhanVien);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(163, 230, 158, 40);
		contentPane.add(txtLoaiPhong);

		txtSoLuongNguoi = new JTextField();
		txtSoLuongNguoi.setEditable(false);
		txtSoLuongNguoi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtSoLuongNguoi.setColumns(10);
		txtSoLuongNguoi.setBounds(163, 310, 158, 40);
		contentPane.add(txtSoLuongNguoi);

		txtMaPhong = new JTextField();
		txtMaPhong.setEditable(false);
		txtMaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(628, 150, 158, 40);
		contentPane.add(txtMaPhong);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(628, 230, 158, 40);
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

		JButton btnThemKhachHang = new JButton("");
		btnThemKhachHang.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				guiKh = new GUI_KhachHang(tk, phong);
				guiKh.setVisible(true);
			}
		});
		btnThemKhachHang.setIcon(new ImageIcon("image\\add.png"));
		btnThemKhachHang.setBounds(333, 70, 40, 40);
		contentPane.add(btnThemKhachHang);
		docDuLieuTuSQL();
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	private void docDuLieuTuSQL() {
		txtMaPhong.setText(phong.getMaPhong());
		txtLoaiPhong.setText(phong.getMaLoaiPhong().getTenLoaiPhong());
		txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
		txtSoLuongNguoi.setText(String.valueOf(phong.getSoLuongNguoi()));
		Dao_NhanVien dao_nv = new Dao_NhanVien();
		NhanVien nv = dao_nv.getNhanVien(taikhoan.getTenTaiKhoan());
		txtMaNhanVien.setText(nv.getMaNhanVien());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		Timestamp date1 = new Timestamp(System.currentTimeMillis());
		txtGioVaoPhong.setText(sf.format(date1));
		if (khachHang != null) {
			txtTenKhachHang.setText(khachHang.getTenKhachHang());
			txtSoDienThoai.setText(khachHang.getSoDienThoai());
			txtTenKhachHang.setEditable(false);
		} else {
			txtSoDienThoai.setText("");
			txtTenKhachHang.setText("");
		}
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
		Date date = new Date(System.currentTimeMillis());

		if (khachHang == null) {
			int i = 1;
			String maKH = null;
			boolean constrain1;
			do {
				if (i < 10)
					maKH = "KH00" + i;
				else if (i < 100)
					maKH = "KH0" + i;
				else
					maKH = "KH" + i;
				khachHang = new KhachHang(maKH, sdt, txtTenKhachHang.getText(), true, date);
				constrain1 = dao_kh.getAllKhachHang().contains(khachHang);
				i++;
			} while (constrain1 == true);
			dao_kh.insertKhachHang(khachHang);
		}
		String maNhanVien = txtMaNhanVien.getText();
		String maPhong = txtMaPhong.getText();
		

		Date ngayLap = date;
		long gioVaoP = date.getTime();
		Timestamp gioVaoPhong = new Timestamp(gioVaoP);
		Dao_HoaDon dao_hd = new Dao_HoaDon();
		Dao_Phong dao_phong = new Dao_Phong();
		Date ngayLap1 = null;
		Timestamp gioRaPhong = null;
		Phong phonG = new Phong(maPhong);
		NhanVien nv = new NhanVien(maNhanVien);
		String maHoaDon = null;
		HoaDonThuePhong hdtp;
		HoaDonThuePhong hoadon = dao_hd.getHoaDon(maHoaDon);
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
		if (hoadon == null) {
			int x = 1;
			maHoaDon = null;
			boolean constrain = false;
			do {
				if (x < 10)
					maHoaDon = maNhanVien + sf.format(ngayLap) + "000" + x;
				else if (x < 100)
					maHoaDon = maNhanVien + sf.format(ngayLap) + "00" + x;
				else
					maHoaDon = maNhanVien + sf.format(ngayLap) + "0" + x;
				hdtp = new HoaDonThuePhong(maHoaDon, ngayLap1, 0.1, gioVaoPhong, gioRaPhong, phonG, khachHang, nv);
				hoadon = new HoaDonThuePhong(maHoaDon);
				constrain = dao_hd.getAllMaHoaDon().contains(hoadon);
				x++;
			} while (constrain == true);
			if (dao_hd.insertHoaDonThuePhong(hdtp) == false)
				JOptionPane.showMessageDialog(this, "Thuê phòng thất bại");
			else {
				dao_hd.insertHoaDonThuePhong(hdtp);
				dao_phong.updateTinhTrang(maPhong, "Đang sử dụng");
				JOptionPane.showMessageDialog(this, "Thuê phòng thành công");
			}
		}
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}