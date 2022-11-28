package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;
import java.awt.Color;

public class GUI_ThongTinTaiKhoan extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtSoDienThoai;
	private JTextField txtTenNhanVien;
	private JTextField txtcmnd;
	private JTextField txtChucVu;
	private JTextField txtDiaChi;
	private Dao_NhanVien dao_NhanVien;
	private Dao_TaiKhoan dao_TaiKhoan = new Dao_TaiKhoan();

	/**
	 * Launch the application.
	 */
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private ButtonGroup bgGioiTinh;
	private JDateChooser dateChooser;
	private JButton btnHuy;
	private TaiKhoan tk;

	/**
	 * Create the frame.
	 */
	public GUI_ThongTinTaiKhoan(TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tk = taiKhoan;
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 128));
		panel.setBounds(270, 188, 330, 30);
		contentPane.add(panel);
		panel.setLayout(null);

		// Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(5, 1, 420, 20);
		contentPane.add(menuBar);
		
		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ  ");
		mntmTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mntmTrangChu.setFont(UIManager.getFont("MenuBar.font"));
		menuBar.add(mntmTrangChu);


		JMenu mnDanhMuc = new JMenu("  Danh mục");
		mnDanhMuc.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnDanhMuc);

		JMenuItem mntmDanhMucDichVu = new JMenuItem("Dịch vụ");
		mntmDanhMucDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DichVu(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucDichVu);

		JMenuItem mntmDanhMucKhachHang = new JMenuItem("Khách hàng");
		mntmDanhMucKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_KhachHang(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucKhachHang);

		JMenuItem mntmDanhMucPhong = new JMenuItem("Phòng");
		mntmDanhMucPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_Phong(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucPhong);

		JMenuItem mntmDanhMucNhanVien = new JMenuItem("Nhân viên");
		mntmDanhMucNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_NhanVien(tk).setVisible(true);
			}
		});
		mnDanhMuc.add(mntmDanhMucNhanVien);

		JMenuItem mnXuLi = new JMenuItem("Xử lí");
		mnXuLi.setHorizontalAlignment(SwingConstants.CENTER);
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("MenuBar.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm ");
		mnTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnTimKiem);

		JMenuItem mntmTimKiemDichVu = new JMenuItem("Dịch vụ");
		mntmTimKiemDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemDichVu(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemDichVu);

		JMenuItem mntmTimKiemHoaDon = new JMenuItem("Hóa đơn");
		mntmTimKiemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TimKiemHoaDon(tk).setVisible(true);
			}
		});
		mnTimKiem.add(mntmTimKiemHoaDon);

		JMenu mnThongKe = new JMenu(" Thống kê ");
		mnThongKe.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnThongKe);

		JMenuItem mntmThongKeDoanhThu = new JMenuItem("Doanh thu");
		mntmThongKeDoanhThu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeHoaDon(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDoanhThu);

		JMenuItem mntmThongKeDichVu = new JMenuItem("Dịch vụ");
		mntmThongKeDichVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongKeDichVu(tk).setVisible(true);
			}
		});
		mnThongKe.add(mntmThongKeDichVu);

		JMenuItem mnTroGiup = new JMenuItem("Trợ giúp ");
		mnTroGiup.setHorizontalAlignment(SwingConstants.CENTER);
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JLabel lblMaNhanVien = new JLabel("Mã nhân viên");
		lblMaNhanVien.setBackground(new Color(255, 255, 128));
		lblMaNhanVien.setBounds(30, 0, 90, 30);
		lblMaNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel.add(lblMaNhanVien);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(130, 0, 200, 30);
		panel.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setLayout(null);
		panel_1.setBounds(270, 288, 330, 30);
		contentPane.add(panel_1);

		JLabel lblSoDienThoai = new JLabel("Số điện thoại");
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSoDienThoai.setBounds(30, 0, 90, 30);
		panel_1.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(130, 0, 200, 30);
		panel_1.add(txtSoDienThoai);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 128));
		panel_2.setLayout(null);
		panel_2.setBounds(880, 188, 330, 30);
		contentPane.add(panel_2);

		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTenNhanVien.setBounds(30, 0, 90, 30);
		panel_2.add(lblTenNhanVien);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setEditable(false);
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(130, 0, 200, 30);
		panel_2.add(txtTenNhanVien);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 128));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(880, 288, 330, 30);
		contentPane.add(panel_1_1);

		JLabel lblcmnd = new JLabel("CMND");
		lblcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblcmnd.setBounds(30, 0, 90, 30);
		panel_1_1.add(lblcmnd);

		txtcmnd = new JTextField();
		txtcmnd.setEditable(false);
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(130, 0, 200, 30);
		panel_1_1.add(txtcmnd);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(255, 255, 128));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(270, 388, 330, 30);
		contentPane.add(panel_1_2);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblGioiTinh.setBounds(30, 0, 90, 30);
		panel_1_2.add(lblGioiTinh);

		rdNam = new JRadioButton("Nam");
		rdNam.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdNam.setBounds(130, 0, 100, 30);
		panel_1_2.add(rdNam);
		rdNam.setEnabled(false);

		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdNu.setBounds(230, 0, 100, 30);
		panel_1_2.add(rdNu);
		rdNu.setEnabled(false);

		bgGioiTinh = new ButtonGroup();
		bgGioiTinh.add(rdNam);
		bgGioiTinh.add(rdNu);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(255, 255, 128));
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(880, 388, 330, 30);
		contentPane.add(panel_1_1_1);

		JLabel lblChucVu = new JLabel("Chức vụ");
		lblChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblChucVu.setBounds(30, 0, 90, 30);
		panel_1_1_1.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(130, 0, 200, 30);
		panel_1_1_1.add(txtChucVu);

		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBackground(new Color(255, 255, 128));
		panel_1_3.setLayout(null);
		panel_1_3.setBounds(270, 588, 510, 30);
		contentPane.add(panel_1_3);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiaChi.setBounds(30, 0, 90, 30);
		panel_1_3.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(130, 0, 380, 30);
		panel_1_3.add(txtDiaChi);

		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSoDienThoai.isEditable() == false) {
					moKhoaTextField();
					btnSua.setEnabled(true);
				} else {
					suaThongTin();
					khoaTextField();
				}

			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSua.setBounds(880, 588, 100, 30);
		contentPane.add(btnSua);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				khoaTextField();
				docDuLieuTuSQL();
			}
		});
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnHuy.setBounds(1026, 588, 100, 30);
		contentPane.add(btnHuy);

		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setBackground(new Color(255, 255, 128));
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(270, 488, 330, 30);
		contentPane.add(panel_1_1_2);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgaySinh.setBounds(30, 0, 90, 30);
		panel_1_1_2.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(130, 0, 170, 30);
		panel_1_1_2.add(txtNgaySinh);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/YYYY");
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(130, 0, 200, 30);
		panel_1_1_2.add(dateChooser);
		dateChooser.setLayout(null);

		JPanel pnEmail = new JPanel();
		pnEmail.setBackground(new Color(255, 255, 128));
		pnEmail.setLayout(null);
		pnEmail.setBounds(880, 488, 330, 30);
		contentPane.add(pnEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEmail.setBounds(30, 0, 90, 30);
		pnEmail.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(130, 0, 200, 30);
		pnEmail.add(txtEmail);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 140));
		panel_3.setBounds(270, 69, 940, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblThongTinTaiKhoan = new JLabel("Thông tin tài khoản");
		lblThongTinTaiKhoan.setBounds(344, 15, 257, 35);
		panel_3.add(lblThongTinTaiKhoan);
		lblThongTinTaiKhoan.setBackground(new Color(255, 255, 140));
		lblThongTinTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblThongTinTaiKhoan.setHorizontalAlignment(SwingConstants.CENTER);

		docDuLieuTuSQL();
	}

	protected void suaThongTin() {
		String maNV = txtMaNhanVien.getText().toString();
		String tenNV = txtTenNhanVien.getText().toString();
		String sDT = txtSoDienThoai.getText().toString();
		String dC = txtDiaChi.getText().toString();
		String eM = txtEmail.getText().toString();
		String cmnd = txtcmnd.getText().toString();
		String cv = txtChucVu.getText().toString();
		Date ns = Date.valueOf(txtNgaySinh.getText());
		Boolean gt = rdNam.isSelected() ? true : false;
		NhanVien nv = new NhanVien(maNV, tenNV, sDT, ns, dC, gt, cmnd, cv, eM, tk,true);
		if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa?", "Cảnh báo",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			dao_NhanVien.suaThongTinNhanVien(nv);
		}
	}

	protected void moKhoaTextField() {
		txtSoDienThoai.setEditable(true);
		txtNgaySinh.setEditable(true);
		txtDiaChi.setEditable(true);
		txtEmail.setEditable(true);
		txtcmnd.setEditable(true);
		btnHuy.setEnabled(true);
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgaySinh.setText(a + "");
				}
			}
		});
	}

	protected void khoaTextField() {
		txtSoDienThoai.setEditable(false);
		txtNgaySinh.setEditable(false);
		txtDiaChi.setEditable(false);
		txtEmail.setEditable(false);
		txtcmnd.setEditable(false);
		btnHuy.setEnabled(false);
		dateChooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgaySinh.setText(a + "");
				}
			}
		});
		dateChooser.getDateEditor().removePropertyChangeListener(dateChooser);
	}

	private void docDuLieuTuSQL() {
		dao_NhanVien = new Dao_NhanVien();
		NhanVien nv = dao_NhanVien.getNhanVien(tk.getTenTaiKhoan());
		txtMaNhanVien.setText(nv.getMaNhanVien());
		txtTenNhanVien.setText(nv.getTenNhanVien());
		txtSoDienThoai.setText(nv.getSoDienThoai());
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String ns = sf.format(nv.getNgaySinh());
		txtNgaySinh.setText(ns);
		txtDiaChi.setText(nv.getDiaChi());
		txtcmnd.setText(nv.getCmnd());
		txtEmail.setText(nv.getEmail());
		txtChucVu.setText(nv.getChucVu());
		if (nv.isGioiTinh())
			rdNam.setSelected(true);
		else
			rdNu.setSelected(true);
	}
}
