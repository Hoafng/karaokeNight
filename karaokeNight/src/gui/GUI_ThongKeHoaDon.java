package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.Dao_HoaDon;
import entity.CTHoaDonThuePhong;
import entity.HoaDonThuePhong;
import entity.TaiKhoan;

public class GUI_ThongKeHoaDon extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel modelTkHoaDon;
	private JTable tblTkHoaDon;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JTextField txtTuNgay;
	private JTextField txtDenNgay;
	private TaiKhoan tk;
	private Dao_HoaDon dao_HoaDon = new Dao_HoaDon();
	private JLabel lblKqHoaDon;
	private JLabel lblKqTienCacHoaDon;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_ThongKeHoaDon(TaiKhoan taiKhoan) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,1480,780);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(101, 186, 118));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tk=taiKhoan;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(5, 1, 377, 20);
		contentPane.add(menuBar);

		JMenu mnTrangChu = new JMenu("Trang chủ");
		mnTrangChu.setFont(UIManager.getFont("Menu.font"));
		menuBar.add(mnTrangChu);

		JMenuItem mntmTrangChu = new JMenuItem("Trang chủ");
		mntmTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_TrangChu(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmTrangChu);

		JMenuItem mntmThongTinTaiKhoan = new JMenuItem("Thông tin tài khoản");
		mntmThongTinTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUI_ThongTinTaiKhoan(tk).setVisible(true);
			}
		});
		mnTrangChu.add(mntmThongTinTaiKhoan);

		JMenuItem mntmDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		mntmDoiMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		JPanel pnTop = new JPanel();
		pnTop.setBackground(new Color(101, 186, 118));
		pnTop.setBounds(0, 10, 1466, 52);
		contentPane.add(pnTop);
		
		JLabel lblThongKeHoaDon = new JLabel("Thống kê hóa đơn");
		lblThongKeHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 30));
		pnTop.add(lblThongKeHoaDon);
		

		JPanel pnLeft = new JPanel();
		pnLeft.setBackground(new Color(101, 186, 118));
		pnLeft.setBounds(10, 66, 392, 673);
		contentPane.add(pnLeft);
		pnLeft.setBorder(new TitledBorder("Nhập vào để thống kê"));
		pnLeft.setLayout(null);
		
		JLabel lblTuNgay = new JLabel("Từ ngày :");
		lblTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTuNgay.setBounds(60, 65, 92, 34);
		dateChooser = new JDateChooser();
		dateChooser.getDateEditor().addPropertyChangeListener(
		    new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
		            if ("date".equals(e.getPropertyName())) {
		            	String a = sf.format(e.getNewValue());		   
		            	txtTuNgay.setText(a + "");
		            }
		        }
		    });
		dateChooser.getCalendarButton().setBounds(169, 0, 31, 30);
		dateChooser.setBounds(151, 69, 200, 30);
		pnLeft.add(dateChooser);
		dateChooser.setLayout(null);
		
		txtTuNgay = new JTextField();
		txtTuNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtTuNgay.setBounds(0, 0, 170, 30);
		dateChooser.add(txtTuNgay);
		txtTuNgay.setColumns(10);
		pnLeft.add(lblTuNgay);
		
		
		JLabel lblDenNgay = new JLabel("Đến ngày:");
		lblDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDenNgay.setBounds(60, 142, 84, 30);
		dateChooser_1 = new JDateChooser();
		dateChooser_1.getDateEditor().addPropertyChangeListener(
		    new PropertyChangeListener() {
		        @Override
		        public void propertyChange(PropertyChangeEvent e) {
		        	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");																																																																																																																																																												
		            if ("date".equals(e.getPropertyName())) {
		            	String a = sf.format(e.getNewValue());		   
		            	txtDenNgay.setText(a + "");
		            }
		        }
		    });
		dateChooser_1.getCalendarButton().setBounds(170, 0, 30, 30);
		dateChooser_1.setBounds(151, 142, 200, 30);
		pnLeft.add(dateChooser_1);
		dateChooser_1.setLayout(null);
		
		txtDenNgay = new JTextField();
		txtDenNgay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtDenNgay.setColumns(10);
		txtDenNgay.setBounds(0, 0, 172, 30);
		dateChooser_1.add(txtDenNgay);
		pnLeft.add(lblDenNgay);

	
		
		
		ImageIcon iconLamMoi = new ImageIcon("image//iconButton//Refresh.png");
		JButton btnLamMoiHoaDon = new JButton("Làm mới", iconLamMoi);
		btnLamMoiHoaDon.setBackground(new Color(255, 255, 140));
		btnLamMoiHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLamMoiHoaDon.setBounds(60, 371, 291, 33);
		pnLeft.add(btnLamMoiHoaDon);
		
		ImageIcon iconThongKe = new ImageIcon("image//iconButton//statistical.png");
		JButton btnThongKeHoaDon = new JButton("Thống kê", iconThongKe);
		btnThongKeHoaDon.setBackground(new Color(255, 255, 140));
		btnThongKeHoaDon.setForeground(new Color(0, 0, 0));
		btnThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnThongKeHoaDon.setBounds(60, 301, 291, 33);
		pnLeft.add(btnThongKeHoaDon);
		
		JButton btnInThongKeHoaDon = new JButton("In thống kê", new ImageIcon("image//iconButton//print.png"));
		btnInThongKeHoaDon.setForeground(Color.BLACK);
		Border roundedBorder = new LineBorder(new Color(210,210,210), 1, true);
		btnInThongKeHoaDon.setBorder(new LineBorder(new Color(210, 210, 210), 1, true));
		btnInThongKeHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnInThongKeHoaDon.setBackground(new Color(255, 255, 140));
		btnInThongKeHoaDon.setBounds(60, 445, 291, 33);
		pnLeft.add(btnInThongKeHoaDon);
		

	
		JPanel pnCenter = new JPanel();
		pnCenter.setBackground(new Color(101, 186, 118));
		pnCenter.setBounds(433, 66, 1033, 673);
		contentPane.add(pnCenter);
		String[] cols = { "Mã hóa đơn", "Nhân viên lập hóa đơn", "Ngày lập hóa đơn", "Phòng", "Thành tiền"};
		modelTkHoaDon = new DefaultTableModel(cols, 0);
		pnCenter.setLayout(null);
		tblTkHoaDon = new JTable(modelTkHoaDon);
		JScrollPane scrtbl = new JScrollPane(tblTkHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pnCenter.setBorder(BorderFactory.createTitledBorder("Danh sách hóa đơn"));
		scrtbl.setBounds(10, 25, 1013, 554);
		pnCenter.add(scrtbl);
		
		JLabel lblTongHoaDon = new JLabel("Tổng số hóa đơn : ");
		lblTongHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongHoaDon.setBounds(816, 589, 118, 26);
		pnCenter.add(lblTongHoaDon);
		
		lblKqHoaDon = new JLabel("");
		lblKqHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqHoaDon.setBounds(944, 592, 70, 21);
		pnCenter.add(lblKqHoaDon);
		
		JLabel lblTongTienCacHoaDon = new JLabel("Tổng tiền các hóa đơn:");
		lblTongTienCacHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblTongTienCacHoaDon.setBounds(10, 589, 150, 26);
		pnCenter.add(lblTongTienCacHoaDon);
		
		lblKqTienCacHoaDon = new JLabel("0 VNĐ");
		lblKqTienCacHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblKqTienCacHoaDon.setBounds(170, 592, 143, 21);
		pnCenter.add(lblKqTienCacHoaDon);
		DocDuLieuDatabaseVaoTable();
	}
	public void DocDuLieuDatabaseVaoTable() {
		ArrayList<HoaDonThuePhong> listHoaDon = dao_HoaDon.getAllHoaDon();
		for (HoaDonThuePhong hd : listHoaDon) {
			modelTkHoaDon.addRow(new Object[] {hd.getMaHoaDon(),hd.getMaNhanVien().getMaNhanVien(),hd.getNgayLap(),hd.getMaPhong().getMaPhong()});
		}
		int sum = listHoaDon.size();
		lblKqHoaDon.setText(""+ sum);
	}
}
