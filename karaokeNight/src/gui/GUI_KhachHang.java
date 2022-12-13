package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.Dao_KhachHang;
import entity.KhachHang;
import entity.Phong;
import entity.TaiKhoan;

@SuppressWarnings("serial")
public class GUI_KhachHang extends JFrame {

	private JPanel contentPane;

	private JTextField txtSoDienThoai;
	private JTextField txtTen;
	private JTextField txtmaKhachHang;
	private JTable table;
	private JScrollPane cpKhachHang;
	private Dao_KhachHang daoKhachHang;
	private DefaultTableModel modelKhachHang;
	private JTextField txtTenTim;
	private JTextField txtSDTTim;
	private JComboBox<String> cbxMa;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnTimKiem;
	private JDateChooser dateChooser;
	private JTextField txtNgaySinh;
	private JTextField txtDiaChi;
	private JCheckBox chkcbxGioiTinh;
	private JTextField txtCMND;

	private JDateChooser dateChooser_1;
	private JTextField txtNgaySinhTim;
	private JTextField txtCMNDTim;
	private JCheckBox chkcbxNamTim;
	private JCheckBox chckbxNuTim;
	private TaiKhoan tk;
	private Date date;
	private Phong phong;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI_KhachHang(TaiKhoan taiKhoan,Phong p) {
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

		tk = taiKhoan;
		phong =p;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		mntmDanhMucKhachHang.setSelected(true);
		mntmDanhMucKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new GUI_KhachHang(tk,phong).setVisible(true);
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

		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setBounds(599, 29, 232, 45);
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblKhachHang);

		JPanel pnlDanhSachKhachHang = new JPanel();
		pnlDanhSachKhachHang.setBorder(new LineBorder(Color.CYAN, 2));
		pnlDanhSachKhachHang.setBounds(397, 277, 1010, 440);
		contentPane.add(pnlDanhSachKhachHang);

		String[] colHeader = { "Mã Khách Hàng", "số Điện Thoại", "Tên Khách Hàng ", "Giới tính ", "Ngày Sinh ", "CMND ",
				"Địa Chỉ ", "Lần dùng gần nhất " };
		modelKhachHang = new DefaultTableModel(colHeader, 0);
		pnlDanhSachKhachHang.setLayout(null);
		table = new JTable(modelKhachHang);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		table.setBounds(0, 295, 1480, 462);
		cpKhachHang = new JScrollPane(table);
		cpKhachHang.setBounds(5, 5, 1000, 430);
		cpKhachHang.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnlDanhSachKhachHang.add(cpKhachHang);
		table.setRowHeight(25);
		docDuLieuTuSQL();

		JPanel pnlThongTinKhachHang = new JPanel();
		pnlThongTinKhachHang.setBorder(new LineBorder(Color.CYAN, 2));
		pnlThongTinKhachHang.setBounds(397, 84, 1010, 175);
		contentPane.add(pnlThongTinKhachHang);
		pnlThongTinKhachHang.setLayout(null);

		JLabel lblmaKhachHang = new JLabel("Mã Khách Hàng");
		lblmaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblmaKhachHang.setBounds(10, 10, 147, 25);
		pnlThongTinKhachHang.add(lblmaKhachHang);

		txtmaKhachHang = new JTextField();
		txtmaKhachHang.setEditable(false);
		txtmaKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtmaKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		txtmaKhachHang.setColumns(10);
		txtmaKhachHang.setBounds(158, 10, 84, 25);
		pnlThongTinKhachHang.add(txtmaKhachHang);

		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại");
		lblSoDienThoai.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoai.setBounds(252, 10, 147, 25);
		pnlThongTinKhachHang.add(lblSoDienThoai);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoDienThoai.setBounds(409, 10, 139, 25);
		pnlThongTinKhachHang.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);

		JLabel lblTen = new JLabel("Họ và Tên ");
		lblTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTen.setBounds(558, 10, 112, 25);
		pnlThongTinKhachHang.add(lblTen);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTen.setColumns(10);
		txtTen.setBounds(672, 10, 309, 25);
		pnlThongTinKhachHang.add(txtTen);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(80, 117, 125, 32);
		btnThem.addActionListener(new ActionListener() {
			private KhachHang khachHang;

			public void actionPerformed(ActionEvent e) {
				daoKhachHang = new Dao_KhachHang();
				Date date = new Date(System.currentTimeMillis());
				String maKH;
				int i = 1;
				boolean constrain1 = true;
				do {
					if (i < 10)
						maKH = "KH00" + i;
					else if (i < 100)
						maKH = "KH0" + i;
					else
						maKH = "KH" + i;
					khachHang = new KhachHang(maKH, "", "", true, null);
					if (daoKhachHang.getTheoMa(maKH) == null)
						constrain1 = false;
					i++;
				} while (constrain1 == true);
				KhachHang kh = new KhachHang(maKH, txtSoDienThoai.getText(), txtTen.getText(),
						Date.valueOf(txtNgaySinh.getText()), txtDiaChi.getText(), chkcbxGioiTinh.isSelected(),
						txtCMND.getText(), true, date);
				if (daoKhachHang.insertKhachHang(kh) == true) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					docDuLieuTuSQL();
				} else
					JOptionPane.showMessageDialog(null, "Thêm ngu công");
			}
		});
		pnlThongTinKhachHang.add(btnThem);

		btnXoa = new JButton("Hủy");
		btnXoa.setEnabled(false);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(409, 117, 125, 32);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (daoKhachHang.getTheoMa(txtmaKhachHang.getText()) != null) {
					Date date = new Date(System.currentTimeMillis());
					KhachHang kh = new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(), txtTen.getText(),
							Date.valueOf(txtNgaySinh.getText()), txtDiaChi.getText(), chkcbxGioiTinh.isSelected(),
							txtCMND.getText(), false, date);
					daoKhachHang.updateKhachHang(kh);
					JOptionPane.showMessageDialog(null, "Xoá Thành Công");
					docDuLieuTuSQL();
				}
			}
		});
		pnlThongTinKhachHang.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(241, 117, 125, 32);
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (daoKhachHang.getTheoMa(txtmaKhachHang.getText()) != null) {
					Date date = new Date(System.currentTimeMillis());
					KhachHang kh = new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(), txtTen.getText(),
							Date.valueOf(txtNgaySinh.getText()), txtDiaChi.getText(), chkcbxGioiTinh.isSelected(),
							txtCMND.getText(), true, date);
					daoKhachHang.updateKhachHang(kh);
					JOptionPane.showMessageDialog(null, "Sửa Thành Công");
					docDuLieuTuSQL();
				}
			}
		});
		pnlThongTinKhachHang.add(btnSua);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnLuu.setBounds(580, 117, 125, 32);
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlThongTinKhachHang.add(btnLuu);

		JLabel lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setBounds(113, 45, 87, 25);
		lblNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinKhachHang.add(lblNgaySinh);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(210, 45, 156, 25);
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgaySinh.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(0, 0, 129, 26);
		dateChooser.add(txtNgaySinh);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateChooser.getDateEditor().addPropertyChangeListener((PropertyChangeListener) new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgaySinh.setText(a + "");
				}
			}
		});
		dateChooser.getCalendarButton().setBounds(128, 0, 28, 26);
		pnlThongTinKhachHang.add(dateChooser);
		dateChooser.setLayout(null);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDiaChi.setBounds(166, 82, 97, 25);
		pnlThongTinKhachHang.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(273, 82, 560, 25);
		pnlThongTinKhachHang.add(txtDiaChi);

		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinh.setBounds(394, 45, 112, 25);
		pnlThongTinKhachHang.add(lblGioiTinh);

		chkcbxGioiTinh = new JCheckBox("Nam");
		chkcbxGioiTinh.setBounds(515, 45, 110, 25);
		chkcbxGioiTinh.setHorizontalAlignment(SwingConstants.CENTER);
		chkcbxGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		pnlThongTinKhachHang.add(chkcbxGioiTinh);

		JLabel lblCmnd = new JLabel("CMND");
		lblCmnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmnd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCmnd.setBounds(644, 45, 104, 25);
		pnlThongTinKhachHang.add(lblCmnd);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCMND.setColumns(10);
		txtCMND.setBounds(758, 45, 125, 25);
		pnlThongTinKhachHang.add(txtCMND);

		JButton btnThue = new JButton("Thuê");
		if (p == null)
			btnThue.setEnabled(false);
		else
			btnThue.setEnabled(true);
		btnThue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				KhachHang kh = new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(), txtTen.getText(), true, null);
				new GUI_ThuePhong(p, tk,kh).setVisible(true);
			}
		});
		btnThue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThue.setBounds(812, 117, 71, 32);
		pnlThongTinKhachHang.add(btnThue);

		JButton btnDat = new JButton("Đặt");
		if (p == null)
			btnDat.setEnabled(false);
		else
			btnDat.setEnabled(true);
		btnDat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				KhachHang kh = new KhachHang(txtmaKhachHang.getText(), txtSoDienThoai.getText(), txtTen.getText(), true, null);
				new GUI_DatPhong(p, tk,kh).setVisible(true);
			}
		});
		btnDat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnDat.setBounds(910, 117, 71, 32);
		pnlThongTinKhachHang.add(btnDat);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.CYAN, 2));
		panel.setBounds(51, 84, 326, 631);
		contentPane.add(panel);
		panel.setLayout(null);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiemNhieuThuocTinh();
			}
		});
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnTimKiem.setBounds(102, 571, 125, 36);
		panel.add(btnTimKiem);

		JLabel lblmaKhachHangTim = new JLabel("Mã Khách Hàng");
		lblmaKhachHangTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaKhachHangTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblmaKhachHangTim.setBounds(90, 74, 154, 25);
		panel.add(lblmaKhachHangTim);

		JLabel lblSoDienThoaiTim = new JLabel("Số Điện Thoại");
		lblSoDienThoaiTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblSoDienThoaiTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoDienThoaiTim.setBounds(90, 153, 154, 25);
		panel.add(lblSoDienThoaiTim);

		JLabel lblTenTim = new JLabel("Họ và Tên ");
		lblTenTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenTim.setBounds(112, 229, 115, 25);
		panel.add(lblTenTim);

		txtTenTim = new JTextField();
		txtTenTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtTenTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtTenTim.setColumns(10);
		txtTenTim.setBounds(22, 266, 278, 27);
		panel.add(txtTenTim);

		txtSDTTim = new JTextField();
		txtSDTTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSDTTim.setColumns(10);
		txtSDTTim.setBounds(73, 188, 196, 27);
		panel.add(txtSDTTim);

		cbxMa = new JComboBox<String>();
		cbxMa.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		cbxMa.setBounds(92, 109, 144, 27);
		panel.add(cbxMa);
		cbxMa.setEditable(true);
		List<KhachHang> dsKH = daoKhachHang.getAllKhachHang();
		date = new Date(System.currentTimeMillis());
		long a = 31536000000L;
		for (KhachHang kh : dsKH) {
			if (date.getTime() - kh.getLanDungCuoi().getTime() < a && kh.isTonTai() == true) {
				cbxMa.addItem(kh.getMaKhachHang());
			}
		}
		panel.add(cbxMa);

		JLabel lblNgaySinhTim = new JLabel("Ngày Sinh");
		lblNgaySinhTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNgaySinhTim.setBounds(123, 314, 87, 25);
		panel.add(lblNgaySinhTim);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(85, 350, 156, 25);
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser_1.getCalendarButton().setFont(new Font("Times New Roman", Font.PLAIN, 20));
		dateChooser_1.getDateEditor().addPropertyChangeListener((PropertyChangeListener) new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent e) {
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				if ("date".equals(e.getPropertyName())) {
					String a = sf.format(e.getNewValue());
					txtNgaySinhTim.setText(a + "");
				}
			}
		});
		dateChooser_1.getCalendarButton().setBounds(128, 0, 28, 26);
		panel.add(dateChooser_1);
		dateChooser_1.setLayout(null);

		txtNgaySinhTim = new JTextField();
		txtNgaySinhTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtNgaySinhTim.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgaySinhTim.setColumns(10);
		txtNgaySinhTim.setBounds(0, 0, 129, 26);
		dateChooser_1.add(txtNgaySinhTim);

		JLabel lblNewLabel = new JLabel("Tìm Kiếm Khách Hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(22, 25, 278, 39);
		panel.add(lblNewLabel);

		JLabel lblCmndTim = new JLabel("CMND");
		lblCmndTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblCmndTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCmndTim.setBounds(113, 470, 104, 25);
		panel.add(lblCmndTim);

		txtCMNDTim = new JTextField();
		txtCMNDTim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtCMNDTim.setColumns(10);
		txtCMNDTim.setBounds(102, 505, 125, 27);
		panel.add(txtCMNDTim);

		JLabel lblGioiTinhTim = new JLabel("Giới Tính");
		lblGioiTinhTim.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioiTinhTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblGioiTinhTim.setBounds(112, 397, 112, 25);
		panel.add(lblGioiTinhTim);

		chkcbxNamTim = new JCheckBox("Nam");
		chkcbxNamTim.setHorizontalAlignment(SwingConstants.CENTER);
		chkcbxNamTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chkcbxNamTim.setBounds(86, 428, 76, 25);
		panel.add(chkcbxNamTim);

		chckbxNuTim = new JCheckBox("Nữ");
		chckbxNuTim.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNuTim.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		chckbxNuTim.setBounds(164, 428, 80, 25);
		panel.add(chckbxNuTim);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				int row = table.getSelectedRow();
				txtmaKhachHang.setText(table.getValueAt(row, 0).toString());
				txtSoDienThoai.setText(table.getValueAt(row, 1).toString());
				txtTen.setText(table.getValueAt(row, 2).toString());
				txtNgaySinh.setText(table.getValueAt(row, 4).toString());

				txtDiaChi.setText(table.getValueAt(row, 6).toString());
				txtCMND.setText(table.getValueAt(row, 5).toString());
				if (table.getValueAt(row, 3).equals("Nam"))
					chkcbxGioiTinh.setSelected(true);
				else
					chkcbxGioiTinh.setSelected(false);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void docDuLieuTuSQL() {
		modelKhachHang.getDataVector().removeAllElements();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		date = new Date(System.currentTimeMillis());
		daoKhachHang = new Dao_KhachHang();
		long a = 31536000000L;
		for (KhachHang kh : daoKhachHang.getAllKhachHang()) {
			String gioiTinh = kh.isGioiTinh() ? "Nam" : "Nữ";
			if (kh.isTonTai() == true && (date.getTime() - kh.getLanDungCuoi().getTime()) < a) {
				modelKhachHang.addRow(new Object[] { kh.getMaKhachHang(), kh.getSoDienThoai(), kh.getTenKhachHang(),
						gioiTinh, sf.format(kh.getNgaySinh()), kh.getCmnd(), kh.getDiaChi(),
						sf.format(kh.getLanDungCuoi()) });
			} else if ((date.getTime() - kh.getLanDungCuoi().getTime()) > a)
				daoKhachHang.updateTonTai(kh, false);
		}
	}

	private void timKiemNhieuThuocTinh() {
		// TODO Auto-generated method stub
		daoKhachHang = new Dao_KhachHang();
		String ma = cbxMa.getSelectedItem().toString();
		String sdt = txtSDTTim.getText();
		String ten = txtTenTim.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		String ngaySinh = sdf.format(dateChooser_1).toString();
		String gioiTinh = "";
		String cmnd = txtCMNDTim.getText();
		date = new Date(System.currentTimeMillis());
		long a = 31536000000L;
		if (cbxMa.getSelectedIndex() == 0) {
			ma = "";
		}
		if (txtTenTim.getText().trim().equalsIgnoreCase("")) {
			ten = "";
		}
		if (txtSDTTim.getText().trim().equals("")) {
			sdt = "";
		}
		if (sdf.format(dateChooser_1).toString().trim().equalsIgnoreCase("")) {
			ngaySinh = "";
		}
		if (chkcbxNamTim.isSelected() == true && chckbxNuTim.isSelected() == true) {
			gioiTinh = "";
		}
		if (chkcbxNamTim.isSelected() == true && chckbxNuTim.isSelected() == false) {
			gioiTinh = "1";
		}
		if (chkcbxNamTim.isSelected() == false && chckbxNuTim.isSelected() == true) {
			gioiTinh = "0";
		}
		if (txtCMNDTim.getText().trim().equalsIgnoreCase("")) {
			cmnd = "";
		}

		for (KhachHang kh : daoKhachHang.getNhieuThuocTinh(ma, sdt, ten, ngaySinh, gioiTinh, cmnd)) {
			String gT = kh.isGioiTinh() ? "Nam" : "Nữ";
			if (kh.isTonTai() == true && (date.getTime() - kh.getLanDungCuoi().getTime()) < a) {
				modelKhachHang.addRow(new Object[] { kh.getMaKhachHang(), kh.getSoDienThoai(), kh.getTenKhachHang(), gT,
						sf.format(kh.getNgaySinh()), kh.getCmnd(), kh.getDiaChi(), sf.format(kh.getLanDungCuoi()) });
			}
		}
	}
}
