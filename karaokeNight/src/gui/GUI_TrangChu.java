package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import dao.Dao_TaiKhoan;
import entity.NhanVien;
import entity.TaiKhoan;

public class GUI_TrangChu extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private TaiKhoan tk;
	private Dao_NhanVien daonv = new Dao_NhanVien();
	private Dao_TaiKhoan dao_TaiKhoan = new Dao_TaiKhoan();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	private JLabel labelClock;

//	@SuppressWarnings("deprecation")
//	public void ClockExample() {
//		setTitle("Đồng hồ trong Java Swing");
//		labelClock = new JLabel();
//		labelClock.setBounds(20, 20, 80, 20);
//		add(labelClock);
//		setSize(400, 200);
//		setLayout(null); // dóng chương trình khi đóng của sổ
//		addWindowListener((WindowListener) new WindowAdapter() {
//
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(1);
//			}
//		});
//		setVisible(true); // thiết lập lại đồng hồ sau mỗi 1 giây try { while (true)
//		try {
//			Calendar calendar = Calendar.getInstance();
//			String hour = (calendar.getTime().getHours() > 9) ? "" + calendar.getTime().getHours() + ""
//					: "0" + calendar.getTime().getHours();
//			String minute = (calendar.getTime().getMinutes() > 9) ? "" + calendar.getTime().getMinutes() + ""
//					: "0" + calendar.getTime().getMinutes();
//			String second = (calendar.getTime().getSeconds() > 9) ? "" + calendar.getTime().getSeconds() + ""
//					: "0" + calendar.getTime().getSeconds();
//			labelClock.setText(hour + ":" + minute + ":" + second);
//			Thread.sleep(1000);
//		} catch (
//
//		InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	public GUI_TrangChu(TaiKhoan taiKhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tk = taiKhoan;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// Menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 1, 377, 20);
		contentPane.add(menuBar);

		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnTrangChu);

		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmTrangChu);

		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmThongTinTaiKhoan);

		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DoiMatKhau(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmDoiMatKhau);

		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		});
		mnTrangChu.add(mntmDangXuat);

		JSeparator separator = new JSeparator();
		mnTrangChu.add(separator);

		JMenu mnDanhMuc = new JMenu("Danh mục");
		menuBar.add(mnDanhMuc);

		JSeparator separator_1 = new JSeparator();
		mnDanhMuc.add(separator_1);

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

		JMenuItem mnXuLi = new JMenuItem(" Xử lí  ");
		mnXuLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_XuLy(tk).setVisible(true);
			}
		});
		mnXuLi.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnXuLi);

		JMenu mnTimKiem = new JMenu("Tìm kiếm");
		menuBar.add(mnTimKiem);

		JSeparator separator_2 = new JSeparator();
		mnTimKiem.add(separator_2);

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

		JMenu mnThongKe = new JMenu("Thống kê");
		menuBar.add(mnThongKe);

		JSeparator separator_3 = new JSeparator();
		mnThongKe.add(separator_3);

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
		mnTroGiup.setFont(UIManager.getFont("MenuBar.font"));
		mnTroGiup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_TroGiup(tk).setVisible(true);
			}
		});
		menuBar.add(mnTroGiup);

		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setForeground(new Color(101, 186, 118));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setBounds(588, 44, 300, 50);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblTrangChu);

		JButton btnThongTinTaiKhoan = new JButton("Thông Tin Tài Khoản");
		btnThongTinTaiKhoan.setBounds(55, 440, 222, 60);
		btnThongTinTaiKhoan.setBackground(new Color(101, 186, 118));
		btnThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		btnThongTinTaiKhoan.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnThongTinTaiKhoan);

		JButton btnDoiMatKhau = new JButton("Đổi Mật Khẩu\r\n");
		btnDoiMatKhau.setBounds(55, 520, 222, 60);
		btnDoiMatKhau.setBackground(new Color(101, 186, 118));
		btnDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DoiMatKhau(tk).setVisible(true);
			}
		});
		btnDoiMatKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnDoiMatKhau);

		JButton btnDangXuat = new JButton("Đăng Xuất\r\n");
		btnDangXuat.setBounds(55, 600, 222, 60);
		btnDangXuat.setBackground(new Color(101, 186, 118));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contentPane.add(btnDangXuat);

		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHinhNen.setBounds(319, 104, 1119, 585);
		lblHinhNen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhNen.setIcon(new ImageIcon("image\\hingnen.png"));
		contentPane.add(lblHinhNen);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\nhanVien.png"));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(1210, 44, 228, 48);
		NhanVien nv = daonv.getNhanVien(tk.getTenTaiKhoan());
		lblNewLabel.setText(nv.getTenNhanVien());
		contentPane.add(lblNewLabel);
	}
}
