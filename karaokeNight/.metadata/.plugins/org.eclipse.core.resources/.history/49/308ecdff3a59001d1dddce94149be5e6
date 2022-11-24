package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.Dao_KhachHang;
import entity.KhachHang;
import entity.TaiKhoan;

public class GUI_KhachHang extends JFrame {

	private JPanel contentPane;
	private JTable tableKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtTen;
	private JTextField txtmaKhachHang;
	private JTable table;
	private JScrollPane cpKhachHang;
	private Dao_KhachHang daoKhachHang;
	private DefaultTableModel modelKhachHang;
	private JTextField txtTenTim;
	private JTextField txtSDTTim;
	private JComboBox cbxMa;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnTimKiem;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_KhachHang(TaiKhoan taiKhoan) {
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 780);
		setLocationRelativeTo(null);
		
		tk=taiKhoan;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

		JLabel lblTrangChu = new JLabel("Trang Chủ");
		lblTrangChu.setForeground(new Color(101, 186, 118));
		lblTrangChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangChu.setBounds(588, 44, 300, 50);
		lblTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 40));
		contentPane.add(lblTrangChu);
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setBounds(602, 44, 232, 45);
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblKhachHang);
		
		JPanel pnlDanhSachKhachHang = new JPanel();
		pnlDanhSachKhachHang.setBounds(442, 277, 965, 418);
		contentPane.add(pnlDanhSachKhachHang);
		
		String[] colHeader = { "Mã Khách Hàng", "số Điện Thoại", "Tên Khách Hàng "};
		modelKhachHang = new DefaultTableModel(colHeader, 0);
		pnlDanhSachKhachHang.setLayout(null);
		table = new JTable(modelKhachHang);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(0, 295, 1480, 462);
		cpKhachHang = new JScrollPane(table);
		cpKhachHang.setBounds(0, 0, 965, 418);
		cpKhachHang.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlDanhSachKhachHang.add(cpKhachHang);
		table.setRowHeight(15);
		docDuLieuTuSQL();
		
		JPanel pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBounds(60, 86, 1347, 175);
		contentPane.add(pnlThongTinKhachHang);
		pnlThongTinKhachHang.setLayout(null);
		
		JLabel lblmaKhachHang = new JLabel("Mã Khách Hàng");
		lblmaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblmaKhachHang.setBounds(66, 52, 154, 30);
		pnlThongTinKhachHang.add(lblmaKhachHang);
		
		txtmaKhachHang = new JTextField();
		txtmaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtmaKhachHang.setColumns(10);
		txtmaKhachHang.setBounds(242, 55, 148, 30);
		pnlThongTinKhachHang.add(txtmaKhachHang);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(398, 52, 154, 30);
		pnlThongTinKhachHang.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(562, 55, 190, 30);
		pnlThongTinKhachHang.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblTen = new JLabel("Họ và Tên ");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(762, 52, 125, 30);
		pnlThongTinKhachHang.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(910, 55, 371, 30);
		pnlThongTinKhachHang.add(txtTen);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(285, 117, 125, 32);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang kh=new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(),txtTen.getText());
				daoKhachHang.insertKhachHang(kh);
				if(daoKhachHang.insertKhachHang(kh)==true) {
				JOptionPane.showInputDialog(this,"Thêm Thành Công");
				}
			}
		});
		pnlThongTinKhachHang.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(557, 117, 125, 32);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoKhachHang.getTheoMa(txtmaKhachHang.getText())!=null) {
					daoKhachHang.deleteKhacHang(txtmaKhachHang.getText());
					JOptionPane.showInputDialog(this,"Xoá Thành Công");
					}
			}
		});
		pnlThongTinKhachHang.add(btnXoa);
		
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(776, 117, 125, 32);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoKhachHang.getTheoMa(txtmaKhachHang.getText())!=null) {
				KhachHang kh=new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(),txtTen.getText());
				daoKhachHang.updateKhachHang(kh);
				JOptionPane.showInputDialog(this,"Sửa Thành Công");
				}
			}
		});
		pnlThongTinKhachHang.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(1035, 117, 125, 32);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlThongTinKhachHang.add(btnLuu);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 277, 371, 418);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNhieuThuocTinh();
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTimKiem.setBounds(111, 336, 125, 32);
		panel.add(btnTimKiem);
		
		JLabel lblmaKhachHangTim = new JLabel("Mã Khách Hàng");
		lblmaKhachHangTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaKhachHangTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblmaKhachHangTim.setBounds(101, 20, 154, 30);
		panel.add(lblmaKhachHangTim);
		
		JLabel lblSoDienThoaiTim = new JLabel("Số Điện Thoại");
		lblSoDienThoaiTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoDienThoaiTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoaiTim.setBounds(101, 128, 154, 30);
		panel.add(lblSoDienThoaiTim);
		
		JLabel lblTenTim = new JLabel("Họ và Tên ");
		lblTenTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenTim.setBounds(125, 239, 125, 30);
		panel.add(lblTenTim);
		
		txtTenTim = new JTextField();
		txtTenTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenTim.setColumns(10);
		txtTenTim.setBounds(20, 282, 328, 30);
		panel.add(txtTenTim);
		
		txtSDTTim = new JTextField();
		txtSDTTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDTTim.setColumns(10);
		txtSDTTim.setBounds(72, 180, 212, 30);
		panel.add(txtSDTTim);
		
		cbxMa = new JComboBox<String>();
		cbxMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxMa.setBounds(101, 66, 161, 32);
		panel.add(cbxMa);
		cbxMa.setEditable(true);		
		List<KhachHang> dsKH= daoKhachHang.getAllKhachHang();
		for (KhachHang kh : dsKH) {
			cbxMa.addItem(kh.getMaKhachHang());
		}
		panel.add(cbxMa);
		
	}

	private void docDuLieuTuSQL() {
		// TODO Auto-generated method stub
		daoKhachHang = new Dao_KhachHang();
		for (KhachHang kh : daoKhachHang.getAllKhachHang()) {
			modelKhachHang.addRow(new Object[] {kh.getMaKhachHang(),kh.getSoDienThoai(),kh.getTenKhachHang()});
		
	}
	}
	private void timKiemNhieuThuocTinh() {
		// TODO Auto-generated method stub
		String ma=cbxMa.getSelectedItem().toString();
		String sdt=txtSDTTim.getText();
		String ten=txtTenTim.getText();
		if(cbxMa.getSelectedIndex()==0) {
			ma="";
		}
		if (txtTenTim.getText().trim().equalsIgnoreCase("")) {
			ten="";
		}
		if(txtSDTTim.getText().trim().equals("")) {
			sdt="";
		}
		daoKhachHang.getNhieuThuocTinh(ma, sdt, ten);
	}
}
