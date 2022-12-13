package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.Dao_NhanVien;
import entity.NhanVien;
import entity.TaiKhoan;

@SuppressWarnings("serial")
public class GUI_TrangChu extends JFrame {

	private JPanel contentPane;
	private TaiKhoan tk;
	private Dao_NhanVien daonv = new Dao_NhanVien();


	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	private JLabel lblThongTinNhanVien;

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
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(5, 1, 420, 20);
		contentPane.add(menuBar);
		
		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ  ");
		mntmTrangChu.setSelected(true);
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
				new GUI_KhachHang(tk,null).setVisible(true);
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

		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setForeground(new Color(101, 186, 118));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setBounds(587, 10, 300, 50);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 45));
		contentPane.add(lblTrangChu);

		JLabel lblHinhNen = new JLabel("");
		lblHinhNen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblHinhNen.setBounds(0, 64, 1480, 688);
		lblHinhNen.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon hinhNen = new ImageIcon("image\\hingnen.png");
	
		Image im = hinhNen.getImage().getScaledInstance(1480, 688, Image.SCALE_SMOOTH);
		ImageIcon hinhNen2 = new ImageIcon(im);
		lblHinhNen.setIcon(hinhNen2);
		contentPane.add(lblHinhNen);

		lblThongTinNhanVien = new JLabel("");
		lblThongTinNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThongTinNhanVien.setBounds(1209, 10, 228, 48);
		NhanVien nv=daonv.getNhanVien(tk.getTenTaiKhoan());
		lblThongTinNhanVien.setText(nv.getTenNhanVien());
		contentPane.add(lblThongTinNhanVien);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBorderPainted(false);
		menuBar_1.setBackground(new Color(255, 255, 140));
		menuBar_1.setBounds(1150, 10, 60, 48);
		contentPane.add(menuBar_1);

		
		JMenu mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon("image\\nhanVien.png"));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mnNewMenu.add(mntmThongTinTaiKhoan);
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		
		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mnNewMenu.add(mntmDoiMatKhau);
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DoiMatKhau(tk).setVisible(true);
			}
		});
		
		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mnNewMenu.add(mntmDangXuat);
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_DangNhap().setVisible(true);
			}
		});
	}
}
