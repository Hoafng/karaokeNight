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
import dao.Dao_DichVu;
import dao.Dao_LoaiDichVu;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.TaiKhoan;

public class GUI_DichVu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaDichVu;
	private JTextField txtTenDichVu;
	private JTextField txtGiaDichVu;
	private JTextField txtSoLuong;
	private Dao_DichVu daoDichVu;
	private Dao_LoaiDichVu daoLoaiDichVu;
	private DefaultTableModel modelDichVu;
	private JScrollPane cpDichVu;
	private JComboBox<String> cbxMaLoaiDichVu;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnXuat;
	private TaiKhoan tk;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUI_DichVu(TaiKhoan taiKhoan) {
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
		
		JLabel lblDichVu = new JLabel("Dịch Vụ");
		lblDichVu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDichVu.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDichVu.setBounds(641, 24, 186, 42);
		contentPane.add(lblDichVu);
		JPanel pnlDanhSachDichVu = new JPanel();
		pnlDanhSachDichVu.setBounds(60, 279, 1347, 418);
		contentPane.add(pnlDanhSachDichVu);
		
		String[] colHeader = { "Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Dịch Vụ", "Số Lượng ","mã Loại Dịch Vụ"};
		modelDichVu = new DefaultTableModel(colHeader, 0);
		pnlDanhSachDichVu.setLayout(null);
		table = new JTable(modelDichVu);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(0, 295, 1480, 462);
		cpDichVu = new JScrollPane(table);
		cpDichVu.setBounds(10, 10, 1290, 343);
		cpDichVu.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlDanhSachDichVu.add(cpDichVu);
		table.setRowHeight(15);
		docDuLieuTuSQL();
		
		btnXuat = new JButton("Xuất");
		btnXuat.setBounds(1172, 363, 125, 32);
		btnXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXuat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		pnlDanhSachDichVu.add(btnXuat);
		
		JPanel pnlThongTinDichVu = new JPanel();
		pnlThongTinDichVu.setBounds(260, 76, 965, 185);
		contentPane.add(pnlThongTinDichVu);
		pnlThongTinDichVu.setLayout(null);
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
				DichVu dv=new DichVu(txtMaDichVu.getText(), txtTenDichVu.getText(), Double.parseDouble(txtGiaDichVu.getText()),Integer.parseInt(txtSoLuong.getText()),new LoaiDichVu(cbxMaLoaiDichVu.getSelectedItem().toString()));
				daoDichVu.insertDichVu(dv);
				JOptionPane.showInputDialog(this,"Thêm Thành Công");
				}
			}
		});
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(163, 132, 125, 32);
		pnlThongTinDichVu.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
					daoDichVu.deleteDichVu(txtMaDichVu.getText());
					JOptionPane.showInputDialog(this,"Xoá Thành Công");
					}
			}
		});
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(340, 132, 125, 32);
		pnlThongTinDichVu.add(btnXoa);
		
		JLabel lblMaDichVu = new JLabel("MaDichVu");
		lblMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaDichVu.setBounds(90, 20, 98, 25);
		pnlThongTinDichVu.add(lblMaDichVu);

		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(daoDichVu.getDichVuTheoMa(txtMaDichVu.getText())!=null) {
					DichVu dv=new DichVu(txtMaDichVu.getText(), txtTenDichVu.getText(), Double.parseDouble(txtGiaDichVu.getText()),Integer.parseInt(txtSoLuong.getText()),new LoaiDichVu(cbxMaLoaiDichVu.getSelectedItem().toString()));
					daoDichVu.updateDichVu(dv);
					JOptionPane.showInputDialog(this,"Sửa Thành Công");
					}	
			}
		});
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(517, 132, 125, 32);
		pnlThongTinDichVu.add(btnSua);
		
		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				
			}
		});
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(708, 132, 125, 32);
		pnlThongTinDichVu.add(btnLuu);
		
		JLabel lblTenDichVu = new JLabel("TenDichVu");
		lblTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenDichVu.setBounds(426, 20, 104, 25);
		pnlThongTinDichVu.add(lblTenDichVu);
		
		JLabel lblGiaDichVu = new JLabel("Giá Dịch Vụ");
		lblGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGiaDichVu.setBounds(54, 75, 110, 25);
		pnlThongTinDichVu.add(lblGiaDichVu);
		
		JLabel lblSoLuong = new JLabel("Số Lượng Tồn");
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuong.setBounds(393, 75, 125, 25);
		pnlThongTinDichVu.add(lblSoLuong);
		
		txtMaDichVu = new JTextField();
		txtMaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtMaDichVu.setBounds(198, 19, 202, 25);
		pnlThongTinDichVu.add(txtMaDichVu);
		txtMaDichVu.setColumns(10);
		
		txtTenDichVu = new JTextField();
		txtTenDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenDichVu.setColumns(10);
		txtTenDichVu.setBounds(540, 19, 255, 25);
		pnlThongTinDichVu.add(txtTenDichVu);
		
		txtGiaDichVu = new JTextField();
		txtGiaDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtGiaDichVu.setColumns(10);
		txtGiaDichVu.setBounds(163, 74, 202, 25);
		pnlThongTinDichVu.add(txtGiaDichVu);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(517, 74, 59, 25);
		pnlThongTinDichVu.add(txtSoLuong);
		
		JLabel lblMaLoaiDichVu = new JLabel("Mã Loại Dịch vụ");
		lblMaLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMaLoaiDichVu.setBounds(598, 75, 149, 25);
		pnlThongTinDichVu.add(lblMaLoaiDichVu);
		
		cbxMaLoaiDichVu = new JComboBox<String>();
		cbxMaLoaiDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxMaLoaiDichVu.setBounds(757, 75, 77, 25);
		cbxMaLoaiDichVu.setEditable(true);		
		List<LoaiDichVu> dsLoaiDichVu = daoLoaiDichVu.getAllLoaiDichVu();
		for (LoaiDichVu ldv : dsLoaiDichVu) {
			cbxMaLoaiDichVu.addItem(ldv.getMaLoaiDichVu());
		}
		
		pnlThongTinDichVu.add(cbxMaLoaiDichVu);
	}

	private void docDuLieuTuSQL() {
		// TODO Auto-generated method stub
		daoDichVu = new Dao_DichVu();
		for (DichVu dv : daoDichVu.getAllDichVu()) {
			Object[] rowData = { dv.getMaDichVu(), dv.getTenDichVu(),dv.getGiaDichVu(),dv.getSoLuong(),dv.getMaLoaiDichVu()};
			modelDichVu.addRow(rowData);
		
	}
	}
}